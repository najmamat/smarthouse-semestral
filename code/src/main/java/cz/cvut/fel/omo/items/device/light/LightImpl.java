package cz.cvut.fel.omo.items.device.light;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

public class LightImpl extends Device implements Light{
    public LightImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
    }

    public LightImpl() {}

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(2);
        switch (tmp) {
            case 0:
                this.setON(true);
                minusFunctionality();
                break;
            case 1:
                this.setON(false);
                minusFunctionality();
                break;
        }
    }


    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
