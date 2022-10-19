package cz.cvut.fel.omo.items.device.coffeemachine.state;

import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachine;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;

public class PreparingOrderState implements CoffeeMachineState{
    @Override
    public void next(CoffeeMachineImpl cfm) {
        cfm.setState(new OrderWaitingForPickUpState());
    }

    @Override
    public void previous(CoffeeMachineImpl cfm) {
        System.out.println("Coffee is already being prepared, you can order another one after pickup");
    }

    @Override
    public void printStatus() {
        System.out.println("Coffee is being prepared");
    }
}
