package cz.cvut.fel.omo.items.device.stove;

import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.util.Util;

import java.lang.reflect.Array;

public class StoveImpl extends Device implements Stove{

    private boolean[] stoveParts;


    public StoveImpl(String name, int PSActive, int PSIdle) {
        super(name, PSActive, PSIdle);
        stoveParts = new boolean[]{false, false, false, false};
    }

    public StoveImpl() {}

    @Override
    public void startPartOfTheStove(int stovePart) {
        stoveParts[stovePart-1] = true;
    }

    @Override
    public void stopPartOfTheStove(int stovePart) {
        stoveParts[stovePart-1] = false;
    }

    @Override
    public void doRandomMethod() {
        Util util = new Util();
        int tmp = util.getRandomNum(2);
        switch (tmp) {
            case 0:
                startPartOfTheStove(util.getRandomNum(4)+1);
                minusFunctionality();
                break;
            case 1:
               stopPartOfTheStove(util.getRandomNum(4)+1);
                minusFunctionality();
                break;
        }
    }

    @Override
    public void getFixed() {
        this.setFunctionalityPercentage(100);
    }
}
