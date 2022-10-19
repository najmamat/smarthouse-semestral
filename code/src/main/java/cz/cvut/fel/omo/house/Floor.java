package cz.cvut.fel.omo.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Class representing Floor in simulation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class Floor {

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private List<Room> rooms = new ArrayList<>();
    private int level;

    public Floor(List<Room> rooms, int level) {
        this.rooms = rooms;
        this.level = level;
    }

    public Floor(int level) {
        this.rooms = new ArrayList<>();
        this.level = level;
    }

    public Floor() {}

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
