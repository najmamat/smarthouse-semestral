package cz.cvut.fel.omo.items.device.door;

import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface DoorOpener extends DeviceAPI {

    void openDoor();

    void closeDoor();
}
