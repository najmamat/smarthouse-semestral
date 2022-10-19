package cz.cvut.fel.omo.util;

import cz.cvut.fel.omo.house.House;

import java.util.List;
import java.util.Random;

public class Util {

    public int getRandomNum(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }


}
