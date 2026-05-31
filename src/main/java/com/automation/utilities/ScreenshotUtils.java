package com.automation.utilities;

import com.automation.driverFactory.WebDriverManager;
import com.automation.driverFactory.MobileDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String takeScreenshot(String testName) {
        try {
            WebDriver driver = WebDriverManager.getDriver();
            if (driver == null) {
               driver = MobileDriverManager.getDriver();
            }
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "test-output/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(source, new File(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}