package cz.cvut.fel.omo.events;

import cz.cvut.fel.omo.items.device.Device;

/**
 * Class derived from basic Event, adds item that needs to be fixed
 */
public class BrokenItemEvent extends Event {

    private final Device item;

    public BrokenItemEvent(String source, String cause, Device item) {
        super(source, cause);
        this.item = item;
    }

    public Device getItem() {
        return item;
    }
}
