package cz.cvut.fel.omo.items.device.heater.state;

import cz.cvut.fel.omo.items.device.heater.HeaterImpl;

import java.sql.SQLOutput;

public class HeatUntilDesiredTempState implements HeaterState{
    @Override
    public void changeIdle(HeaterImpl heater) {
        heater.setState(new IdleHeaterState());
    }

    @Override
    public void changeKeepTemp(HeaterImpl heater) {
        heater.setState(new KeepingChosenTempState());
    }

    @Override
    public void changeHeatUp(HeaterImpl heater) {
        System.out.println("Heater is already in state, to heat up until desired temp");
    }

    @Override
    public void changeEmpty(HeaterImpl heater) {
        heater.setState(new EmptyHeaterState());
    }

    @Override
    public void printStatus() {
        System.out.println("Heater is heating up, until desired temperature reached");
    }
}
