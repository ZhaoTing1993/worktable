package cn.ting.worktable.util;

import org.apache.commons.lang3.RandomUtils;

public class SeedUtils {

    private static final int[] workHours = {8, 9, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 12, 13, 15, 16, 17};

    public static int generateWorkHour() {
        int index = RandomUtils.nextInt(0, workHours.length);
        return workHours[index];
    }
}
