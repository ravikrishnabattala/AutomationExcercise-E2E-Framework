package com.automation.pageFactory;

import com.automation.driverFactory.DriverManager;
import com.automation.utilities.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    private final WebDriver driver;

    private final JavaScriptUtils js;

    private final By titleMrRadioBtn = By.cssSelector("[value='Mr']");

    private final By passwordField = By.id("password");

    private final By daysDropdown = By.id("days");

    private final By monthsDropdown = By.id("months");

    private final By yearsDropdown = By.id("years");

    private final By newsletterCheckbox = By.xpath("//label[text()='Sign up for our newsletter!']");

    private final By specialOfferCheckbox = By.xpath("//label[text()='Receive special offers from our partners!']");

    private final By firstNameField = By.id("first_name");

    private final By lastNameField = By.id("last_name");

    private final By companyField = By.id("company");

    private final By addressField = By.id("address1");

    private final By stateField = By.id("state");

    private final By cityField = By.id("city");

    private final By zipCodeField = By.id("zipcode");

    private final By mobileField = By.id("mobile_number");

    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    private final By continueBtn = By.xpath("//a[text()='Continue']");

    public SignUpPage() {
        this.driver = DriverManager.getDriver();
        this.js = new JavaScriptUtils();
    }

    public SignUpPage registerUser() {
        js.click(driver.findElement(titleMrRadioBtn));
        driver.findElement(passwordField).sendKeys("12345678");

        WebElement daysElement = driver.findElement(daysDropdown);
        Select daysSelect = new Select(daysElement);
        daysSelect.selectByValue("22");

        WebElement monthsElement = driver.findElement(monthsDropdown);
        Select monthsSelect = new Select(monthsElement);
        monthsSelect.selectByValue("8");

        WebElement yearsElement = driver.findElement(yearsDropdown);
        Select yearsSelect = new Select(yearsElement);
        yearsSelect.selectByValue("2002");

        js.click(driver.findElement(newsletterCheckbox));
        js.click(driver.findElement(specialOfferCheckbox));

        driver.findElement(firstNameField).sendKeys("Ravi");
        driver.findElement(lastNameField).sendKeys("krishna");
        driver.findElement(companyField).sendKeys("AI Infotech");
        driver.findElement(addressField).sendKeys("Mudichur,Chennai");
        driver.findElement(stateField).sendKeys("TamilNadu");
        driver.findElement(cityField).sendKeys("Chennai");
        driver.findElement(zipCodeField).sendKeys("600063");
        driver.findElement(mobileField).sendKeys("7893101744");
        driver.findElement(createAccountBtn).click();
        driver.findElement(continueBtn).click();
        return this;
    }

}
