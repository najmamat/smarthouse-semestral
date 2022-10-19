package cz.cvut.fel.omo;

import cz.cvut.fel.omo.action.Action;
import cz.cvut.fel.omo.action.Duty;
import cz.cvut.fel.omo.action.Fix;
import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.Device;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

/**
 * Class representing the simulation itself, making iterations
 */
public class Simulation {

    private final ObjectPool<HouseItem> houseItems;
    private final ObjectPool<Being> beings;
    private final List<Room> rooms;
    private final List<Action> actions = new ArrayList<>();

    public Simulation(House house) {
        this.houseItems = new ObjectPool<>(house.getHouseItems());
        this.beings = new ObjectPool<>(house.getCreatures());
        this.rooms = house.getRooms();

        newLog();
    }

    /**
     * Iterates the whole simulation
     */
    public void iterate() {
        generateRoomEvents();
        addNewDuties();
        iterateActions();
        finishActions();
        resolvePowerConsumption();
    }

    private void newLog() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt", false));
            writer.close();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void generateRoomEvents() {
        for (Room room : rooms)
            room.generateEvent();
    }

    public void iterateActions() {
        for (Action action : actions)
            action.iterate();
    }

    public void finishActions() {
        for (int i = 0; i < actions.size(); i++) {
            Action tmp = actions.get(i);
            if (tmp.isFinished()) {
                houseItems.unlock(tmp.getItem());
                beings.unlock(tmp.getBeing());
                actions.remove(tmp);
                i--;
            }
        }
    }

    private void addNewDuties() {
        while (beings.hasUnlocked()) {
            Being being = beings.lockFirst();
            Action duty = this.getDutyForBeing(being);
            if (!Objects.isNull(duty)) {
                houseItems.lockItem(duty.getItem());
                duty.getItem().getFixed();
                actions.add(duty);
            } else {
                Action newAction = createNewDuty(being);
                if (Objects.isNull(newAction)) {
                    beings.unlock(being);
                    break;
                }
                actions.add(newAction);
            }
        }
    }

    private Action createNewDuty(Being being) {
        HouseItem item = houseItems.lockRandom();
        if (item == null)
            return null;
        if (item.isBroken()) {
            houseItems.lockItem(item);
            item = getFirstNotBroken();
            if (item == null)
                return null;
        }
        Random random = new Random();
        return new Action(being, (Device) item, random.nextInt(5) + 1);
    }

    private HouseItem getFirstNotBroken() {
        int size = houseItems.getUnlockedSize();
        List<HouseItem> putBack = new ArrayList<>();
        HouseItem tmp = null;
        for (int i = 0; i < size; i++) {
            tmp = houseItems.lockRandom();
            if (!tmp.isBroken())
                break;
            else {
                putBack.add(tmp);
                tmp = null;
            }
        }
        for (HouseItem item : putBack)
            houseItems.unlock(item);
        return tmp;
    }

    private Action getDutyForBeing(Being being) {
        Duty duty = null;
        List<Duty> putBack = new ArrayList<>();
        while (!being.getDuties().isEmpty() && duty == null) {
            duty = being.getFirstDuty();
            if (!duty.getItem().isBroken())
                duty = null;
            else if(houseItems.isUsed(duty.getItem())) {
                putBack.add(duty);
                duty = null;
            }
        }
        for (Duty action : putBack)
            being.getDuties().add(action);
        if (duty == null)
            return null;
        return new Fix(duty);
    }

    public void resolvePowerConsumption() {
        for (HouseItem item : houseItems.getAllItems()) {
            if (item instanceof Device) {
                if (((Device) item).isON()) {
                    ((Device) item).setWholePS(((Device) item).getWholePS() + ((Device) item).getPSActive());
                } else {
                    ((Device) item).setWholePS(((Device) item).getWholePS() + ((Device) item).getPSIdle());
                }
            }
        }
    }
}
