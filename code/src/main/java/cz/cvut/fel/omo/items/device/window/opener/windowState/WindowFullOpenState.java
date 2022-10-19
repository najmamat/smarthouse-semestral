package cz.cvut.fel.omo.items.device.window.opener.windowState;

import cz.cvut.fel.omo.items.device.window.opener.WindowOpenerImpl;

public class WindowFullOpenState implements WindowState{
    @Override
    public void openFull(WindowOpenerImpl windowOpener) {
        System.out.println("window is already open full");
    }

    @Override
    public void openTop(WindowOpenerImpl windowOpener) {
        System.out.println("window needs to be closed, before top opened");
    }

    @Override
    public void closedWindow(WindowOpenerImpl windowOpener) {
        windowOpener.setState(new WindowClosedState());
    }

    @Override
    public void printStatus() {
        System.out.println("window is open full");
    }
}
