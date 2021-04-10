package com.lx.fight.util;

import java.util.Random;

public class RandomUtils {
    public static int getNextInt(int seed) {
        Random random = new Random();
        return random.nextInt(seed);
    }
}
