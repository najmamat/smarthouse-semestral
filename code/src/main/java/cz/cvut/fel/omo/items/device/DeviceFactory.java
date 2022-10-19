package cz.cvut.fel.omo.items.device;

import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;
import cz.cvut.fel.omo.items.device.door.DoorOpener;
import cz.cvut.fel.omo.items.device.door.DoorOpenerImpl;
import cz.cvut.fel.omo.items.device.fridge.Fridge;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachine;
import cz.cvut.fel.omo.items.device.fridge.FridgeImpl;
import cz.cvut.fel.omo.items.device.heater.HeaterImpl;
import cz.cvut.fel.omo.items.device.light.Light;
import cz.cvut.fel.omo.items.device.heater.Heater;
import cz.cvut.fel.omo.items.device.light.LightImpl;
import cz.cvut.fel.omo.items.device.stove.Stove;
import cz.cvut.fel.omo.items.device.stove.StoveImpl;
import cz.cvut.fel.omo.items.device.toilet.Toilet;
import cz.cvut.fel.omo.items.device.toilet.ToiletImpl;
import cz.cvut.fel.omo.items.device.tv.TV;
import cz.cvut.fel.omo.items.device.tv.TVImpl;
import cz.cvut.fel.omo.items.device.washingmachine.WashingMachine;
import cz.cvut.fel.omo.items.device.washingmachine.WashingMachineImpl;
import cz.cvut.fel.omo.items.device.window.blinds.WindowBlinds;
import cz.cvut.fel.omo.items.device.window.blinds.WindowBlindsImpl;
import cz.cvut.fel.omo.items.device.window.opener.WindowOpener;
import cz.cvut.fel.omo.items.device.window.opener.WindowOpenerImpl;

/**
 * Class used to create devices. Devices are designed, so that for example more types of Coffee Machine can be added.
 * If so, please add function to create different type of CoffeeMachine.
 */
public class DeviceFactory {

    public DoorOpener makeDoorOpener(String name, int PSidle, int PSactive){
        return new DoorOpenerImpl(name,PSactive, PSidle);
    }
    public Fridge makeFridge(String name, int PSidle, int PSactive){
        return new FridgeImpl(name, PSactive, PSidle);
    }
    public CoffeeMachine makeCoffeeMachine(String name, int PSidle, int PSactive){
        return new CoffeeMachineImpl(name, PSactive, PSidle);
    }
    public Light makeLight(String name, int PSidle, int PSactive){
        return new LightImpl(name, PSactive, PSidle);
    }
    public Heater makeHeater(String name, int PSidle, int PSactive){
        return new HeaterImpl(name, PSactive, PSidle);
    }
    public Stove makeStove(String name, int PSidle, int PSactive){
        return new StoveImpl(name, PSactive, PSidle);
    }
    public Toilet makeToilet(String name, int PSidle, int PSactive){
        return new ToiletImpl(name, PSactive, PSidle);
    }
    public TV makeTV(String name, int PSidle, int PSactive){
        return new TVImpl(name, PSactive, PSidle);
    }
    public WashingMachine makeWashingMachine(String name, int PSidle, int PSactive){
        return new WashingMachineImpl(name, PSactive, PSidle);
    }
    public WindowBlinds makeWindowBlinds(String name, int PSidle, int PSactive){
        return new WindowBlindsImpl(name, PSactive, PSidle);
    }
    public WindowOpener makeWindowOpener(String name, int PSidle, int PSactive){
        return new WindowOpenerImpl(name, PSactive, PSidle);
    }
}
