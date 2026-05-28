package com.automation.pageFactory;

import com.automation.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage signUpIn() {
        driver.get(ConfigReader.getProperty("base.url"));
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        return this;
    }


    public LoginPage signUp() {
        signUpIn();
        driver.findElement(By.xpath("//div[@class='signup-form']/form/input[@placeholder='Name']")).sendKeys("Ravi Krishna");
        driver.findElement(By.xpath("//div[@class='signup-form']/form/input[@placeholder='Email Address']")).sendKeys("ravikrishna@gmail.com");
        driver.findElement(By.xpath("//form/button[normalize-space()='Signup']")).click();
        return this;
    }

    public LoginPage login() {
        signUpIn();
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("ravikrishnabattala@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        return this;
    }

    public LoginPage deleteAccount(){
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        return this;
    }
}
