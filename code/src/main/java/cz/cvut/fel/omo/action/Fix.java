package cz.cvut.fel.omo.action;

import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.items.device.Device;

/**
 * Derived from Action, represents Duty to fix certain Device
 */
public class Fix extends Action {

    public Fix(Being being, Device item, int time) {
        super(being, item, time);
    }

    public Fix(Duty duty) {
        super(duty);
    }

    @Override
    public void iterate() {
        this.currentIter++;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fix: " + being + " is fixing " + item + " for " + time + " iterations. Current iteration: " + currentIter + ".";
    }
}
