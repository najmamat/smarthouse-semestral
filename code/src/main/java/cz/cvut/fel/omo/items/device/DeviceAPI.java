package cz.cvut.fel.omo.items.device;

import cz.cvut.fel.omo.items.HouseItem;


/**
 * Default API, every device has these functions.
 */
public interface DeviceAPI extends HouseItem {

    /**
     *  -> ON
     */
    void turnOn();

    /**
     *  -> OFF
     */
    void turnOff();

    /**
     *  @return Summed up consumption
     */
    int getConsumption();

    /**
     * Does random method.
     */
    void doRandomMethod();

}
