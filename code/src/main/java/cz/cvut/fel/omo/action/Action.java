package cz.cvut.fel.omo.action;

import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.Device;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing interaction between a Being and a Device or SportItem
 */
public class Action {

    protected final Being being;
    protected final Device item;
    protected int time;
    protected int currentIter;
    private static final Map<Being, Map<HouseItem, Integer>> statistics = new HashMap<>();

    public Action(Being being, Device item, int time) {
        this.being = being;
        this.item = item;
        this.time = time;
        this.currentIter = 0;
        update();
    }

    public Action(Duty duty) {
        this.being = duty.getBeing();
        this.item = duty.getItem();
        this.time = duty.getTime();
    }

    /**
     * Sets Device's state to on of off and thus changing its actual power consumption
     */
    public void iterate() {
        if (this.currentIter == 0)
            item.turnOn();
        if (this.currentIter == time)
            item.turnOff();
        this.currentIter++;
        if (this.item.isBroken())
            this.currentIter = time;
        System.out.println(this);
    }

    public boolean isFinished() {
        return currentIter >= time;
    }

    public Being getBeing() {
        return being;
    }

    public Device getItem() {
        return item;
    }

    public int getTime() {
        return time;
    }

    public int getCurrentIter() {
        return currentIter;
    }

    /**
     * Records Device's usage
     */
    private void update() {
        Map<HouseItem, Integer> usage;

        if (statistics.containsKey(being)) {
            usage = statistics.get(being);
            if (usage.containsKey(item))
                usage.put(item, usage.get(item) + 1);
            else
                usage.put(item, 1);
        } else {
            usage = new HashMap<>();
            usage.put(item, 1);
        }
        statistics.put(being, usage);
    }

    /**
     * Exports ActivityAndUsage report into .txt file
     * @throws IOException
     */
    public static void export() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("ActivityAndUsage.txt", false));
        for (Map.Entry<Being, Map<HouseItem, Integer>> entry : statistics.entrySet()) {
            Being being = entry.getKey();
            Map<HouseItem, Integer> value = entry.getValue();
            writer.append(being.toString()).append(" usage:").append("\n");
            for (Map.Entry<HouseItem, Integer> usage : value.entrySet()) {
                HouseItem item = usage.getKey();
                Integer times = usage.getValue();
                writer.append("\t").append(item.getName()).append(" -- ").append(times.toString()).append(" times.").append("\n");

            }
            writer.append("\n");
        }
        writer.close();
    }

    @Override
    public String toString() {
        return "Action{" +
                "being=" + being +
                ", item=" + item +
                ", time=" + time +
                ", currentIter=" + currentIter +
                '}';
    }
}
