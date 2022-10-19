package cz.cvut.fel.omo.items.device.heater.state;

import cz.cvut.fel.omo.items.device.heater.HeaterImpl;

public class EmptyHeaterState implements HeaterState{
    @Override
    public void changeIdle(HeaterImpl heater) {
        heater.setState(new IdleHeaterState());
    }

    @Override
    public void changeKeepTemp(HeaterImpl heater) {
        System.out.println("heater needs to be refilled, then goes to idle state");
    }

    @Override
    public void changeHeatUp(HeaterImpl heater) {
        System.out.println("heater needs to be refilled, then goes to idle state");
    }

    @Override
    public void changeEmpty(HeaterImpl heater) {
        System.out.println("Heater is already empty");
    }

    @Override
    public void printStatus() {
        System.out.println("Heater is empty");
    }
}
