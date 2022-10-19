package cz.cvut.fel.omo.items.device.tv;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

public class TVImpl extends Device implements TV{

    private int channel;

    public TVImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        channel = 1;
    }

    public TVImpl() {
    }

    @Override
    public void switchChannel(int channelNumber) {
        channel = channelNumber;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        switchChannel(util.getRandomNum(50) + 1);
        minusFunctionality();
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
