package cz.cvut.fel.omo.items.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.items.device.coffeemachine.CoffeeMachineImpl;
import cz.cvut.fel.omo.items.device.door.DoorOpenerImpl;
import cz.cvut.fel.omo.items.device.fridge.FridgeImpl;
import cz.cvut.fel.omo.items.device.heater.HeaterImpl;
import cz.cvut.fel.omo.items.device.light.LightImpl;
import cz.cvut.fel.omo.items.device.stove.StoveImpl;
import cz.cvut.fel.omo.items.device.toilet.ToiletImpl;
import cz.cvut.fel.omo.items.device.tv.TVImpl;
import cz.cvut.fel.omo.items.device.washingmachine.WashingMachineImpl;
import cz.cvut.fel.omo.items.device.window.blinds.WindowBlindsImpl;


/**
 * Abstract Class Device, all Devices extend this class.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoffeeMachineImpl.class, name = "CoffeeMachine"),
        @JsonSubTypes.Type(value = FridgeImpl.class, name = "Fridge"),
        @JsonSubTypes.Type(value = DoorOpenerImpl.class, name = "DoorOpener"),
        @JsonSubTypes.Type(value = LightImpl.class, name = "Light"),
        @JsonSubTypes.Type(value = StoveImpl.class, name = "Stove"),
        @JsonSubTypes.Type(value = ToiletImpl.class, name = "Toilet"),
        @JsonSubTypes.Type(value = TVImpl.class, name = "TV"),
        @JsonSubTypes.Type(value = WashingMachineImpl.class, name = "WashingMachine"),
        @JsonSubTypes.Type(value = HeaterImpl.class, name = "Heater"),
        @JsonSubTypes.Type(value = WindowBlindsImpl.class, name = "Blinds")
})
@JsonIgnoreProperties({"currPS, wholePS", "manual"})
public abstract class Device implements DeviceAPI {
    private String name;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private boolean isON;
    private float functionalityPercentage;

    //PS = Power Consumption
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private int PSActive;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private int PSIdle;
    private int currPS;
    private int wholePS;

    private final String manual = "How to repair this";

    public Device(String name, int PSActive, int PSIdle) {
        this.PSActive = PSActive;
        this.PSIdle = PSIdle;
        this.name = name;
        wholePS = 0;
        this.functionalityPercentage = 100;
        this.setON(false);
        this.setCurrPS(this.getPSIdle());
    }

    public Device() {}

    @Override
    public void turnOn() {
        if (!this.isON()){
            this.setON(true);
            this.setCurrPS(this.getPSActive());
        }
    }

    @Override
    public void turnOff() {
        if (this.isON()){
            this.setON(false);
            this.setCurrPS(this.getPSIdle());
        }
    }

    @Override
    public int getConsumption() {
        return this.getWholePS();
    }

    @Override
    public String getName() {
        return name;
    }

    public void minusFunctionality(){
        functionalityPercentage -= 0.1;
    }

    public boolean isON() {
        return isON;
    }

    public void setON(boolean ON) {
        isON = ON;
    }

    public boolean isBroken() {
        return functionalityPercentage == 0;
    }

    public int getPSActive() {
        return PSActive;
    }

    public int getPSIdle() {
        return PSIdle;
    }

    public int getCurrPS() {
        return currPS;
    }

    public void setCurrPS(int currPS) {
        this.currPS = currPS;
    }

    public int getWholePS() {
        return wholePS;
    }

    public void setWholePS(int wholePS) {
        this.wholePS = wholePS;
    }

    public float getFunctionalityPercentage() {
        return functionalityPercentage;
    }

    public void setFunctionalityPercentage(float functionalityPercentage) {
        this.functionalityPercentage = functionalityPercentage;
    }

    public String getManual() {
        return manual;
    }
}
