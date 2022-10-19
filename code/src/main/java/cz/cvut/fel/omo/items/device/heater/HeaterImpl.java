package cz.cvut.fel.omo.items.device.heater;

import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.device.heater.state.HeaterState;
import cz.cvut.fel.omo.util.Util;

public class HeaterImpl extends Device implements Heater {

    private HeaterState state;

    private int kgOfFuel;

    private int fuelBurned;

    public HeaterImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        kgOfFuel = 0;
        fuelBurned = -15;
    }

    public HeaterImpl() {
    }

    @Override
    public void heatUpHouse(int temperature) {
        heatUp();
    }

    @Override
    public void keepSameTempInHouse(int temperature) {
        keepTemp();
    }

    @Override
    public void goIdle() {
        idleState();
    }

    @Override
    public void refillHeater() {
    }



    //State machine ------------------
    public void idleState(){
        state.changeIdle(this);
    }
    public void keepTemp(){
        state.changeKeepTemp(this);
    }
    public void heatUp(){
        state.changeHeatUp(this);
    }
    public void emptyState(){
        state.changeEmpty(this);
    }
    public void printStatus(){
        state.printStatus();
    }
    //--------------------------

    //GETTERS AND SETTERS

    public HeaterState getState() {
        return state;
    }

    public void setState(HeaterState state) {
        this.state = state;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(4);
        switch (tmp) {
            case 0:
                heatUpHouse(util.getRandomNum(23));
                minusFunctionality();
                break;
            case 1:
                keepSameTempInHouse(util.getRandomNum(23));
                minusFunctionality();
                break;
            case 2:
                goIdle();
                minusFunctionality();
                break;
            case 3:
                refillHeater();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
