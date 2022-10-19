package cz.cvut.fel.omo.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.events.Event;
import cz.cvut.fel.omo.events.HighTemperatureEvent;
import cz.cvut.fel.omo.events.LightsOutEvent;
import cz.cvut.fel.omo.events.LowTemperatureEvent;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.sportitem.SportItem;
import cz.cvut.fel.omo.observer.Observable;
import cz.cvut.fel.omo.observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Class representing Room in simulation.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"observers"})
public class Room implements Observable {

    private RoomType type;
    private String name;
    private int temperature;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private final List<HouseItem> items = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();


    public Room() {}

    public List<HouseItem> getItems() {
        return items;
    }

    public void addItem(HouseItem item) {
        items.add(item);
    }

    public void removeItem(HouseItem item) {
        items.remove(item);
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void generateEvent() {
        Random rand = new Random();
        int value = rand.nextInt(50);
        switch (value) {
            case 1:
                notifyAll(new LightsOutEvent(type.name() + " " + getName(), "Lights out"));
                break;
            case 2:
                notifyAll(new HighTemperatureEvent(type.name() + " " + getName(), "High temperature"));
                break;
            case 3:
                notifyAll(new LowTemperatureEvent(type.name() + " " + getName(), "Low temperature"));
                break;
        }
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(Event event) {
        observers.forEach(observer -> {
            try {
                observer.update(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
