package cz.cvut.fel.omo.items.device.window.blinds;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.device.window.blinds.state.BlindsState;
import cz.cvut.fel.omo.util.Util;

public class WindowBlindsImpl extends Device implements WindowBlinds{

    private BlindsState state;
    private boolean isOpen;

    public WindowBlindsImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        isOpen = false;
    }

    public WindowBlindsImpl() {}

    @Override
    public void close() {
        isOpen = false;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void rollUp() {
        rollUpState();
    }

    @Override
    public void rollMiddle() {
        rollMiddleState();
    }

    @Override
    public void rollDown() {
        rollDownState();
    }

    //State machine ------------------
    public void rollUpState(){
        state.rollUp(this);
    }
    public void rollDownState(){
        state.rollDown(this);
    }
    public void rollMiddleState(){
        state.rollMiddle(this);
    }
    //--------------------------

    //GETTERS AND SETTERS
    public BlindsState getState() {
        return state;
    }

    public void setState(BlindsState state) {
        this.state = state;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(5);
        switch (tmp) {
            case 0:
                close();
                minusFunctionality();
                break;
            case 1:
                open();
                minusFunctionality();
                break;
            case 2:
                rollUp();
                minusFunctionality();
                break;
            case 3:
                rollMiddle();
                minusFunctionality();
                break;
            case 4:
                rollDown();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
