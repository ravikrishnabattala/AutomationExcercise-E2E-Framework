package com.automation.base;

import com.automation.driverFactory.DriverManager;
import com.automation.utilities.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        ScreenshotUtils.takeScreenshot("a");
        DriverManager.quitDriver();
    }
}
