package cz.cvut.fel.omo.items.device.door;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

public class DoorOpenerImpl extends Device implements DoorOpener{
    private boolean isOpen;

    public DoorOpenerImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        isOpen = true;
    }

    public DoorOpenerImpl() {}

    @Override
    public void openDoor() {
        if (!isOpen){
            isOpen = true;
        }
    }

    @Override
    public void closeDoor() {
        if (isOpen){
            isOpen = false;
        }
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(2);
        switch (tmp) {
            case 0:
                openDoor();
                minusFunctionality();
                break;
            case 1:
                closeDoor();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
