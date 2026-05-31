package com.automation.apps;

import com.automation.driverFactory.MobileDriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calculator {


    private final AndroidDriver driver;

    public Calculator() {
        this.driver = MobileDriverManager.getDriver();
    }

    public Calculator clickDigit(Object digit) {
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_" + digit + "_s")).click();
        return this;
    }

    public void calculateExpression() {

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout")).click();

        // (25 + 15) × 3 − 10)
        clickDigit(2).clickDigit(5)
                .clickDigit("plus")
                .clickDigit(1).clickDigit(5).clickDigit("equal")
                .clickDigit("mul")
                .clickDigit(3).clickDigit("equal")
                .clickDigit("minus")
                .clickDigit(1).clickDigit(0)
                .clickDigit("equal");
    }
}
