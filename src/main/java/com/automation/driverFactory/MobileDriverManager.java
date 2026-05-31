package com.automation.driverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.Getter;

import java.net.URL;
import java.time.Duration;

public class MobileDriverManager {

    private MobileDriverManager() {
    }

    @Getter
    public static AndroidDriver driver;

    public static void initAndroid() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.miui.calculator");
        options.setAppActivity("com.miui.calculator.cal.CalculatorActivity");

        options.setNoReset(false);
        try {
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitAndroid() {
        if (driver != null) {
            driver.quit();
        }
    }
}
