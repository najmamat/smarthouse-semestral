package cz.cvut.fel.omo.items.device.window.opener.windowState;

import cz.cvut.fel.omo.items.device.window.opener.WindowOpenerImpl;

public class WindowClosedState implements WindowState{
    @Override
    public void openFull(WindowOpenerImpl windowOpener) {
        windowOpener.setState(new WindowFullOpenState());
    }

    @Override
    public void openTop(WindowOpenerImpl windowOpener) {
        windowOpener.setState(new WindowTopOpenState());
    }

    @Override
    public void closedWindow(WindowOpenerImpl windowOpener) {
        System.out.println("window is already closed");
    }

    @Override
    public void printStatus() {
        System.out.println("window is closed");
    }
}
