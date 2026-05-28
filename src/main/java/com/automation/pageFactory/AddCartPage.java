package com.automation.pageFactory;

import com.automation.utilities.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class AddCartPage {

    private final WebDriver driver;

    public AddCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCartPage addItemsToCart(String item) {

        String hoverXpath =
                "//p[text()='" + item + "']/ancestor::div[@class='product-image-wrapper']";
        WebElement element = driver.findElement(By.xpath(hoverXpath));
        JavaScriptUtils.scrollIntoView(element);
        new Actions(driver).moveToElement(element).pause(Duration.ofSeconds(1)).perform();
        String addToCartXpath = "//p[text()='" + item + "']/ancestor::div[@class='product-overlay']//a[contains(@class,'add-to-cart')]";
        driver.findElement(By.xpath(addToCartXpath)).click();
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
        return this;
    }

    public AddCartPage openCart() {
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
        return this;
    }

    public AddCartPage checkOut() {
        driver.findElement(By.xpath("//section[@id='cart_items']//a[contains(text(),'Proceed To Checkout')]")).click();
        return this;
    }

    public AddCartPage validateDetails() {
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='cart_info_table']//tbody//td"));
        for (WebElement element : rowElements) {
            System.out.println(element.getText());
        }
        return this;
    }
}

