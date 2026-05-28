package com.automation.utilities;

import com.automation.driverFactory.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String takeScreenshot(String testName) {
        File source = ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}