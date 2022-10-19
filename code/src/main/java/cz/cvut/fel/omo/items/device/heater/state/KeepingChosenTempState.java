package cz.cvut.fel.omo.items.device.heater.state;

import cz.cvut.fel.omo.items.device.heater.HeaterImpl;

public class KeepingChosenTempState implements HeaterState{
    @Override
    public void changeIdle(HeaterImpl heater) {
        heater.setState(new IdleHeaterState());
    }

    @Override
    public void changeKeepTemp(HeaterImpl heater) {
        System.out.println("Heater is already keeping the same temperature");
    }

    @Override
    public void changeHeatUp(HeaterImpl heater) {
        heater.setState(new HeatUntilDesiredTempState());
    }

    @Override
    public void changeEmpty(HeaterImpl heater) {
        heater.setState(new EmptyHeaterState());
    }

    @Override
    public void printStatus() {
        System.out.println("Heater is keeping desired temperature until given time");
    }
}
