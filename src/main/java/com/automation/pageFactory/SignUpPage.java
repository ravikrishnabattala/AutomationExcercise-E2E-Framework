package com.automation.pageFactory;

import com.automation.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Base {

    private final WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage registerUser() {
        driver.findElement(By.cssSelector("[value='Mr']")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");

        WebElement daysElement = driver.findElement(By.id("days"));
        Select daysSelect = new Select(daysElement);
        daysSelect.selectByValue("22");

        WebElement monthsElement = driver.findElement(By.id("months"));
        Select monthsSelect = new Select(monthsElement);
        monthsSelect.selectByValue("8");

        WebElement yearsElement = driver.findElement(By.id("years"));
        Select yearsSelect = new Select(yearsElement);
        yearsSelect.selectByValue("2002");

        driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']")).click();
        driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();

        driver.findElement(By.id("first_name")).sendKeys("Ravi");
        driver.findElement(By.id("last_name")).sendKeys("krishna");
        driver.findElement(By.id("company")).sendKeys("AI Infotech");
        driver.findElement(By.id("address1")).sendKeys("Mudichur,Chennai");
        driver.findElement(By.id("state")).sendKeys("TamilNadu");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("zipcode")).sendKeys("600063");
        driver.findElement(By.id("mobile_number")).sendKeys("7893101744");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        return this;
    }

}
