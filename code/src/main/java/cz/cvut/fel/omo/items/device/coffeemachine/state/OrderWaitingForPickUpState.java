package cz.cvut.fel.omo.items.device.coffeemachine.state;

import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachine;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;

public class OrderWaitingForPickUpState implements CoffeeMachineState{
    @Override
    public void next(CoffeeMachineImpl cfm) {
        cfm.setState(new WaitingForOrderState());
    }

    @Override
    public void previous(CoffeeMachineImpl cfm) {
        System.out.println("Cant prepare another order before pickup");
    }

    @Override
    public void printStatus() {
        System.out.println("Order preparation finished, please pick up your order");
    }
}
