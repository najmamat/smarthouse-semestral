package cz.cvut.fel.omo.items.device.toilet;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

public class ToiletImpl extends Device implements Toilet{

    public ToiletImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
    }

    public ToiletImpl() {
    }

    @Override
    public void flush() {}

    @Override
    public void useCleaningSoap() {}

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(2);
        switch (tmp) {
            case 0:
                flush();
                minusFunctionality();
                break;
            case 1:
                useCleaningSoap();
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
