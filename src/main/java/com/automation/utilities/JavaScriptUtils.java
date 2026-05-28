package com.automation.utilities;

import com.automation.driverFactory.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private JavaScriptUtils() {
    }

    public static void clickUsingJS(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "arguments[0].click();", element
        );
    }

    public static void scrollIntoView(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }

    public static String getPageTitle() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        return js.executeScript(
                "return document.title;"
        ).toString();
    }
}