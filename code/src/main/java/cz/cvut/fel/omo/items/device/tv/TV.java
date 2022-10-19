package cz.cvut.fel.omo.items.device.tv;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface TV extends DeviceAPI {

    void switchChannel(int channelNumber);
}
