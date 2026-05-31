package com.automation.hook;

import com.automation.driverFactory.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseWebEngine {

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        WebDriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
