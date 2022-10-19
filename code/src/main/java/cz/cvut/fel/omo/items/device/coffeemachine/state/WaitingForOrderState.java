package cz.cvut.fel.omo.items.device.coffeemachine.state;

import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachine;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;

public class WaitingForOrderState implements CoffeeMachineState{

    @Override
    public void next(CoffeeMachineImpl cfm) {
        cfm.setState(new PreparingOrderState());
    }

    @Override
    public void previous(CoffeeMachineImpl cfm) {
        System.out.println("Coffee machine is waiting for order, cant go back");
    }

    @Override
    public void printStatus() {
        System.out.println("Coffee machine is waiting for order");
    }
}
