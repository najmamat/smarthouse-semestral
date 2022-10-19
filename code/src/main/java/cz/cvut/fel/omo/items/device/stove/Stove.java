package cz.cvut.fel.omo.items.device.stove;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface Stove extends DeviceAPI {

    /**
     * Starts specified part of the stove (1-4).
     */
    void startPartOfTheStove(int stovePart);

    /**
     * Stops specified part of the stove (1-4).
     */
    void stopPartOfTheStove(int stovePart);

}
