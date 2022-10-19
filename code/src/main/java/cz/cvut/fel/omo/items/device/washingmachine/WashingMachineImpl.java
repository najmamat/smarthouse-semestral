package cz.cvut.fel.omo.items.device.washingmachine;

import cz.cvut.fel.omo.items.device.Device;

public class WashingMachineImpl extends Device implements WashingMachine{

    public WashingMachineImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
    }

    public WashingMachineImpl() {
    }

    @Override
    public void washClothes() {}

    @Override
    public void doRandomMethod() {
        washClothes();
        minusFunctionality();
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
