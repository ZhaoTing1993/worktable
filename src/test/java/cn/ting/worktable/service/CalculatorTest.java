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
        calculator.calcByModule("Doctor Workbench");
        calculator.calcByModule("hub");
        calculator.calcByModule("Hospital Search");
        calculator.calcByModule("Triage");
        calculator.calcByModule("Config");
        calculator.calcByModule("Backend System Localization");
        calculator.calcByModule("Login v1.2");
        calculator.calcByModule("Doctor Workbench v1.2");
        calculator.calcByModule("hub v1.2");
        calculator.calcByModule("Hospital Search v1.2");
        calculator.calcByModule("Triage v1.2");
        calculator.calcByModule("Config v1.2");
        calculator.calcByModule("Backend System Localization v1.2");
    }

    @Test
    void exportAll() {
        calculator.exportAll("all");
    }
}