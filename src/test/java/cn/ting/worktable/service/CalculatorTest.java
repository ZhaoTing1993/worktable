package cn.ting.worktable.service;

import cn.ting.worktable.WorktableApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CalculatorTest extends WorktableApplicationTests {

    @Autowired
    private Calculator calculator;

    @Test
    void calcByModule() {
        calculator.calcByModule("Login");
    }
}