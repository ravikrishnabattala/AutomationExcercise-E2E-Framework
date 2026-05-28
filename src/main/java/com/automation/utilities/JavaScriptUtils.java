package com.automation.utilities;

import com.automation.driverFactory.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils{

    public void click(WebElement element) {

        scroll(element);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "arguments[0].click();", element
        );
    }

    public void scroll(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }
}