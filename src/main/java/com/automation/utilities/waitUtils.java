package com.automation.utilities;

import com.automation.driverFactory.DriverManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class waitUtils {

    private waitUtils() {
    }

    public static void waitForVisibility(WebElement element) {

        new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("explicit.wait"))
                )
        ).until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public static void waitForClickable(WebElement element) {

        new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("explicit.wait"))
                )
        ).until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    public static void fluentWait(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("fluent.wait"))))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(driver -> element.isDisplayed());
    }
}
