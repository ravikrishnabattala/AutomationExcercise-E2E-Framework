package com.automation.apps;

import com.automation.driverFactory.MobileDriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Calculator {


    private final AndroidDriver driver;

    public Calculator() {
        this.driver = MobileDriverManager.getDriver();
    }

    private By digit0 = By.id("digit_0");
    private By digit1 = By.id("digit_1");
    private By digit2 = By.id("digit_2");
    private By digit3 = By.id("digit_3");
    private By digit5 = By.id("digit_5");

    private By plus = By.id("op_add");
    private By multiply = By.id("op_mul");
    private By minus = By.id("op_sub");
    private By equals = By.id("eq");

    private By result = By.id("result_final");

    private By clear = By.id("clr");

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public void clearCalculation() {
        driver.findElement(clear).click();
    }

    public void calculateExpression() {

        // 25 + 15

        click(digit2);
        click(digit5);

        click(plus);

        click(digit1);
        click(digit5);

        click(equals);

        // * 3

        click(multiply);

        click(digit3);

        click(equals);

        // -10

        click(minus);

        click(digit1);
        click(digit0);

        click(equals);
    }
}
