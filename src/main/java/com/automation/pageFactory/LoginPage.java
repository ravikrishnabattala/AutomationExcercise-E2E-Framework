package com.automation.pageFactory;

import com.automation.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By loginPageBtn = By.cssSelector("a[href='/login']");

    private final By signUpName = By.xpath("//div[@class='signup-form']/form/input[@placeholder='Name']");

    private final By signUpEmail = By.xpath("//div[@class='signup-form']/form/input[@placeholder='Email Address']");

    private final By signUpBtn = By.xpath("//form/button[normalize-space()='Signup']");

    private final By loginEmail = By.cssSelector("input[data-qa='login-email']");

    private final By loginPassword = By.cssSelector("input[data-qa='login-password']");

    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");

    private final By deleteAccountBtn = By.cssSelector("a[href='/delete_account']");

    private final By continueBtn = By.xpath("//a[text()='Continue']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage signUpIn() {
        driver.get(ConfigReader.getProperty("base.url"));
        driver.findElement(loginPageBtn).click();
        return this;
    }


    public LoginPage signUp() {
        signUpIn();
        driver.findElement(signUpName).sendKeys("Ravi Krishna");
        driver.findElement(signUpEmail).sendKeys("ravikrishna@gmail.com");
        driver.findElement(signUpBtn).click();
        return this;
    }

    public LoginPage login() {
        signUpIn();
        driver.findElement(loginEmail).sendKeys("ravikrishnabattala@gmail.com");
        driver.findElement(loginPassword).sendKeys("12345678");
        driver.findElement(loginBtn).click();
        return this;
    }

    public LoginPage deleteAccount(){
        driver.findElement(deleteAccountBtn).click();
        driver.findElement(continueBtn).click();
        return this;
    }
}
