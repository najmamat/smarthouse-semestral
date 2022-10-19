package cz.cvut.fel.omo.statsvisitor;

import cz.cvut.fel.omo.items.device.DeviceAPI;

/**
 * Basic interface for visitor design pattern
 */
public interface StatsVisitor {
    /**
     * Visits a Device.
     * @param device to visit
     * @return parameter which concrete visitor collects
     */
    int visitDevice(DeviceAPI device);
}
