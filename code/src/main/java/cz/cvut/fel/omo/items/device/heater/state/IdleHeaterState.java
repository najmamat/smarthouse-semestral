package cz.cvut.fel.omo.items.device.heater.state;

import cz.cvut.fel.omo.items.device.heater.HeaterImpl;

public class IdleHeaterState implements HeaterState{
    @Override
    public void changeIdle(HeaterImpl heater) {
        System.out.println("state is already idle");
    }

    @Override
    public void changeKeepTemp(HeaterImpl heater) {
        heater.setState(new KeepingChosenTempState());
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
        System.out.println("Heater is now idle");
    }
}
