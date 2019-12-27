package cn.ting.worktable.util;

import java.util.Random;

public class RandomUtils {

    private static final Random rdSeed = new Random();

    public static int generateBetween(int x, int y) {
        int i = rdSeed.nextInt(y - x + 1) + x;
        return i;
    }
}
