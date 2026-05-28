package com.automation.driverFactory;

import com.automation.utilities.ConfigReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                driver.set(new ChromeDriver(chromeOptions));
                break;
            }
            case "firefox": {
                driver.set(new FirefoxDriver());
                break;
            }
            case "safari": {
                driver.set(new SafariDriver());
                break;
            }
            case "edge": {
                driver.set(new EdgeDriver());
                break;
            }
            default:
                throw new RuntimeException(
                        "Invalid Browser Name : " + browser
                );
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        driver.get().manage().window().setPosition(new Point(0, 0));
        driver.get().manage().window().maximize();
        driver.get().manage().window().fullscreen();
        driver.get().manage().window().setSize(new Dimension(1920, 1080));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }

    public static void switchToWindow(int index) {

        Set<String> windows = getDriver().getWindowHandles();
        String[] windowArray = windows.toArray(new String[0]);
        getDriver().switchTo().window(windowArray[index]);
    }

    public void switchToDefaultContent() {
        driver.get().switchTo().defaultContent();
    }

    public void switchToNewWindow() {
        driver.get().switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchToNewTab() {
        driver.get().switchTo().newWindow(WindowType.TAB);
    }
}
