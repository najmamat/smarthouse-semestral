package cz.cvut.fel.omo.items.device.window.opener;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface WindowOpener extends DeviceAPI {

    void openWindowFull();

    void openWindowTop();

    void closeWindow();
}
