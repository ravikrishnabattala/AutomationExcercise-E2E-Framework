package com.automation.driverFactory;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;

import java.net.URL;

public class WindowsDriverManager {

    private static WindowsDriver driver;

    public static void initDriver() {
        try {

            WindowsOptions options = new WindowsOptions();
            options.setPlatformName("Windows");
            options.setApp("Microsoft.WindowsNotepad_8wekyb3d8bbwe!App");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (Exception e) {
            throw new RuntimeException("Driver init failed: " + e.getMessage());
        }
    }

    public static WindowsDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) driver.quit();
    }
}