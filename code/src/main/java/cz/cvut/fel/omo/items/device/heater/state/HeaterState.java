package cz.cvut.fel.omo.items.device.heater.state;

import cz.cvut.fel.omo.items.device.heater.HeaterImpl;

public interface HeaterState {

    void changeIdle(HeaterImpl heater);
    void changeKeepTemp(HeaterImpl heater);
    void changeHeatUp(HeaterImpl heater);
    void changeEmpty(HeaterImpl heater);
    void printStatus();
}
