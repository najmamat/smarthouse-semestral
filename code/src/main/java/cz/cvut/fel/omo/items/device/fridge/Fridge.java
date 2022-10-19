package cz.cvut.fel.omo.items.device.fridge;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface Fridge extends DeviceAPI {

    void openFridge();

    void closeFridge();

    /**
     * Adds item to fridge
     * @param item
     */
    void addItemToFridge(String item);


    /**
     * Removes items from fridge.
     * @param item
     */
    void removeItemFromFridge(String item);

}
