package cz.cvut.fel.omo.items.device.window.opener.windowState;

import cz.cvut.fel.omo.items.device.window.opener.WindowOpenerImpl;

public interface WindowState {
    void openFull(WindowOpenerImpl windowOpener);

    void openTop(WindowOpenerImpl windowOpener);

    void closedWindow(WindowOpenerImpl windowOpener);

    void printStatus();
}
