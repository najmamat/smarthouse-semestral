package cz.cvut.fel.omo.items.device.coffeemachine;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface CoffeeMachine extends DeviceAPI {

    void makeCoffee();
    void boilWater();
}
