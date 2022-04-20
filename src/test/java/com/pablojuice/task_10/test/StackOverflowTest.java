package com.pablojuice.task_10.test;

import com.pablojuice.drivers.DriverManager;
import com.pablojuice.task_10.elements.StackOverflowTestBO;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class StackOverflowTest {

    @BeforeTest
    void init() {
        DriverManager.setupChromeDriver();
    }

    @Test
    void stackOverflowTest() {
        StackOverflowTestBO stackOverflowTestBO = new StackOverflowTestBO();
        stackOverflowTestBO.goToHomePage();
        stackOverflowTestBO.acceptCookies();
        stackOverflowTestBO.clickSignUp();
        stackOverflowTestBO.acceptCookies();
        stackOverflowTestBO.verifySignUpPage();
    }

    @AfterTest
    void closeSession() {
        DriverManager.closeDriver();
    }
}
