package cz.cvut.fel.omo.items.device.fridge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fel.omo.items.device.fridge.FridgeState.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"state, isOpen, items"})
public class FridgeImpl extends Device implements Fridge {

    private FridgeState state;
    private boolean isOpen;

    /**
     * Items inside fridge. Max. 30 items
     */
    private List<String> items;

    public FridgeImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        items = new ArrayList<>(30);
        setState(EMPTYFRIDGE);
        isOpen = false;
    }

    public FridgeImpl() {}

    public void updateFridgeState(){
        if (items.size() == 0){
            setState(EMPTYFRIDGE);
        } else if (items.size() == 30){
            setState(FULLFRIDGE);
        } else {
            setState(SOMEITEMSINSIDEFRIDGE);
        }
    }

    @Override
    public void openFridge() {
        if (!isOpen()){
            setOpen(true);
        }
    }

    @Override
    public void closeFridge() {
        if (isOpen()){
            setOpen(false);
        }
    }

    @Override
    public void addItemToFridge(String item) {
        if (state == FULLFRIDGE){
            throw new RuntimeException("Fridge is full");
        }
        items.add(item);
        updateFridgeState();
    }

    @Override
    public void removeItemFromFridge(String item) {
        if (state == EMPTYFRIDGE){
            throw new RuntimeException("Fridge is empty");
        }
        items.remove(item);
        updateFridgeState();
    }


    // GETTERS AND SETTERS -------------------------------
    public FridgeState getState() {
        return state;
    }

    public void setState(FridgeState state) {
        this.state = state;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(4);
        switch (tmp) {
            case 0:
                openFridge();
                minusFunctionality();
                break;
            case 1:
                closeFridge();
                minusFunctionality();
                break;
            case 2:
                addItemToFridge("yoghurt");
                minusFunctionality();
                break;
            case 3:
                removeItemFromFridge("yoghurt");
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
