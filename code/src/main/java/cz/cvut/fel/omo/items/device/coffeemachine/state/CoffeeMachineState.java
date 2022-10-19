package cz.cvut.fel.omo.items.device.coffeemachine.state;

import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachine;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;

public interface CoffeeMachineState {
    void next(CoffeeMachineImpl cfm);
    void previous(CoffeeMachineImpl cfm);
    void printStatus();
}
