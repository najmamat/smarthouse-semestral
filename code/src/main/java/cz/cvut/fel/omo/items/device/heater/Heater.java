package cz.cvut.fel.omo.items.device.heater;

import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface Heater extends DeviceAPI {

    void heatUpHouse(int temperature);

    void keepSameTempInHouse(int temperature);

    void goIdle();

    void refillHeater();
}
