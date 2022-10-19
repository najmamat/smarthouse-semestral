package cz.cvut.fel.omo.items.device.window.opener;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.device.window.opener.windowState.WindowState;
import cz.cvut.fel.omo.util.Util;

public class WindowOpenerImpl extends Device implements WindowOpener{

    private WindowState state;

    public WindowOpenerImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
    }

    @Override
    public void openWindowFull() {
        openWindowFullState();
    }

    @Override
    public void openWindowTop() {
        openWindowTopState();
    }


    @Override
    public void closeWindow() {
        closedWindowState();
    }

    //State machine ------------------
    public void openWindowFullState(){
        state.openFull(this);
    }
    public void openWindowTopState(){
        state.openTop(this);
    }
    public void closedWindowState(){
        state.closedWindow(this);
    }
    public void printStatus(){
        state.printStatus();
    }
    //--------------------------


    //GETTERS AND SETTERS
    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) {
        this.state = state;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(3);
        switch (tmp) {
            case 0:
                openWindowFull();
                minusFunctionality();
                break;
            case 1:
                openWindowTop();
                minusFunctionality();
                break;
            case 2:
                closeWindow();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
