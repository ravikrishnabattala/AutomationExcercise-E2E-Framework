package com.automation.pageFactory;

import com.automation.utilities.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AddCartPage {

    private final WebDriver driver;

    private final By cartBtn = By.cssSelector("a[href='/view_cart']");

    private final By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");

    private final By checkoutBtn = By.xpath("//section[@id='cart_items']//a[contains(text(),'Proceed To Checkout')]");

    private final By cartItemsDetails = By.xpath("//tbody//tr[@id='product-1']/td");

    public AddCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCartPage openCart() {
        driver.findElement(cartBtn).click();
        return this;
    }

    public AddCartPage addItemsToCart(String item) {
        String hoverXpath = "//p[text()='" + item + "']/ancestor::div[@class='product-image-wrapper']";
        WebElement element = driver.findElement(By.xpath(hoverXpath));
        JavaScriptUtils.scrollIntoView(element);
        new Actions(driver).moveToElement(element).pause(Duration.ofSeconds(1)).perform();
        String addToCartXpath = "//p[text()='" + item + "']/ancestor::div[@class='product-overlay']//a[contains(@class,'add-to-cart')]";
        driver.findElement(By.xpath(addToCartXpath)).click();
        driver.findElement(continueShoppingBtn).click();
        return this;
    }

    public AddCartPage checkOut() {
        driver.findElement(checkoutBtn).click();
        return this;
    }

    public AddCartPage validateDetails() {
        List<WebElement> rowElements = driver.findElements(cartItemsDetails);
        Assert.assertTrue(rowElements.get(1).getText().contains("Blue Top"));
        int itemRate = Integer.parseInt(rowElements.get(2).getText().replaceAll("[^0-9]",""));
        int itemCount = Integer.parseInt(rowElements.get(3).getText());
        int total = Integer.parseInt(rowElements.get(4).getText().replaceAll("[^0-9]",""));
        Assert.assertEquals(itemCount*itemRate,total);
        return this;
    }
}

