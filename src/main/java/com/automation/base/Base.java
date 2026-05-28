package com.automation.base;

import com.automation.driverFactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Base {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
