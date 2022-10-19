package cz.cvut.fel.omo.items.device.coffeemachine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.device.coffeemachine.state.CoffeeMachineState;
import cz.cvut.fel.omo.items.device.coffeemachine.state.WaitingForOrderState;
import cz.cvut.fel.omo.util.Util;
import lombok.NoArgsConstructor;

import java.util.Random;

@JsonIgnoreProperties({"currPS, wholePS, state"})
public class CoffeeMachineImpl extends Device implements CoffeeMachine {

    private CoffeeMachineState state;

    //WS = water consumption, in L
    private double wholeWS;

    public CoffeeMachineImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        wholeWS = 0;
        state = new WaitingForOrderState();
    }

    public CoffeeMachineImpl() {
    }

    @Override
    public void makeCoffee() {
        //starts coffee preparation
        nextState();
        wholeWS += 0.2;
        //coffee waiting for pickup
        nextState();
        //coffee picked up
        nextState();
    }

    @Override
    public void boilWater() {
        //water coffee preparation
        nextState();
        wholeWS += 0.2;
        //water waiting for pickup
        nextState();
        //water picked up
        nextState();
    }

    //State machine ------------------
    public void previousState(){
        state.previous(this);
    }
    public void nextState(){
        state.next(this);
    }
    public void printStatus(){
        state.printStatus();
    }
    //--------------------------

    //GETTERS AND SETTERS

    public CoffeeMachineState getState() {
        return state;
    }

    public void setState(CoffeeMachineState state) {
        this.state = state;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(2);
        switch (tmp) {
            case 0:
                makeCoffee();
                minusFunctionality();
                break;
            case 1:
                boilWater();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        setFunctionalityPercentage(100);
    }
}
