package com.automation.hook;

import com.automation.driverFactory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseEngine {

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
