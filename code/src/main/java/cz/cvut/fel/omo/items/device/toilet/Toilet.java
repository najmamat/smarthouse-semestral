package cz.cvut.fel.omo.items.device.toilet;

import cz.cvut.fel.omo.items.device.DeviceAPI;

public interface Toilet extends DeviceAPI {

    void flush();

    void useCleaningSoap();
}
