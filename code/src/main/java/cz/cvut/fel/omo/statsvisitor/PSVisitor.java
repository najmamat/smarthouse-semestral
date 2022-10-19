package cz.cvut.fel.omo.statsvisitor;

import cz.cvut.fel.omo.items.device.DeviceAPI;

/**
 * Visitor for collecting consumption data of devices
 */
public class PSVisitor implements StatsVisitor{

    @Override
    public int visitDevice(DeviceAPI device) {
        return device.getConsumption();
    }
}
