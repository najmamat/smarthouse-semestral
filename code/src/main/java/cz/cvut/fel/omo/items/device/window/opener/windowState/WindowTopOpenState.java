package cz.cvut.fel.omo.items.device.window.opener.windowState;

import cz.cvut.fel.omo.items.device.window.opener.WindowOpenerImpl;

public class WindowTopOpenState implements WindowState{
    @Override
    public void openFull(WindowOpenerImpl windowOpener) {
        System.out.println("window needs to be closed, before opened full");
    }

    @Override
    public void openTop(WindowOpenerImpl windowOpener) {
        System.out.println("window is already opened top");
    }

    @Override
    public void closedWindow(WindowOpenerImpl windowOpener) {
        windowOpener.setState(new WindowClosedState());
    }

    @Override
    public void printStatus() {
        System.out.println("window is open top");
    }
}
