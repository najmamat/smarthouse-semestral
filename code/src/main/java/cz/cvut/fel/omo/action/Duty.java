package cz.cvut.fel.omo.action;

import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.items.device.Device;

/**
 * Class representing Being's Duty to do with specified Device
 */
public class Duty {

    private final Being being;
    private final Device item;
    private final int time;

    public Duty(Being being, Device item, int time) {
        this.being = being;
        this.item = item;
        this.time = time;
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
}
