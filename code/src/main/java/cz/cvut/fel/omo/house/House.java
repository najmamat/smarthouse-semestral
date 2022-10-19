package cz.cvut.fel.omo.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.beings.PersonalInfo;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.Device;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the whole hosue used in simulation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"atHomeBeings"})
public class House {

    private static House INSTANCE;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private List<Floor> floors;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private List<Being> beings;
    private List<PersonalInfo> atHomePersonalInfos;

    private House() {
    }

    public synchronized static House getInstance(){
        if (INSTANCE == null){
            INSTANCE = new House();
        }


        return INSTANCE;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Being> getCreatures() {
        return beings;
    }

    public void setCreatures(List<Being> beings) {
        this.beings = beings;
    }

    public List<PersonalInfo> getAtHomeCreatures() {
        return atHomePersonalInfos;
    }

    public void setAtHomeCreatures(List<PersonalInfo> atHomePersonalInfos) {
        this.atHomePersonalInfos = atHomePersonalInfos;
    }

    public void creatureEnteredHome(PersonalInfo personalInfo) {
        this.atHomePersonalInfos.add(personalInfo);
    }

    public List<HouseItem> getHouseItems() {
        List<HouseItem> result = new ArrayList<>();
        List<Room> rooms = getRooms();
        for (Room room : rooms){
            result.addAll(room.getItems());
        }
        return result;
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        for (Floor floor : floors) {
            rooms.addAll(floor.getRooms());
        }
        return  rooms;
    }

    public List<Device> getDevices(){
        List<HouseItem> houseItems = getHouseItems();
        List<Device> result = new ArrayList<>();
        for (HouseItem item : houseItems){
            if (item instanceof Device){
                result.add((Device) item);
            }
        }
        return result;
    }

    public static House loadFromJson(String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(file), House.class);
    }
}
