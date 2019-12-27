package cn.ting.worktable.util;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    void generateBetween() {
        for (int i = 0; i < 10; i++) {
            int x = RandomUtils.nextInt(8, 12);
            System.out.println(x);
        }
    }
}