package cz.cvut.fel.omo.items.device.window.blinds;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface WindowBlinds extends DeviceAPI {

    void close();

    void open();

    void rollUp();

    void rollMiddle();

    void rollDown();
}
