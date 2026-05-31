package tests;

import com.automation.driverFactory.WindowsDriverManager;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class DesktopAppTest {

    WindowsDriver driver;
    String filePath;

    @BeforeMethod
    public void setup() {
        WindowsDriverManager.initDriver();
        driver = WindowsDriverManager.getDriver();
    }

    @Test
    public void notepadScenario() throws Exception {

        WebElement edit = driver.findElement(By.className("Edit"));
        String text = "Line 1: Automation\n" +
                "Line 2: WinAppDriver Test\n" +
                "Line 3: Execution Validation";
        edit.sendKeys(text);

        String fileName = "TestFile_" + System.currentTimeMillis() + ".txt";
        filePath = System.getProperty("user.home") + "\\" + fileName;

        driver.findElement(By.name("File")).click();
        driver.findElement(By.name("Save As")).click();

        WebElement fileInput = driver.findElement(By.className("Edit"));
        fileInput.sendKeys(filePath);

        driver.findElement(By.name("Save")).click();

        driver.findElement(By.name("Close")).click();
        driver.findElement(By.name("Don't Save")).click();
        WindowsDriverManager.quitDriver();

        WindowsDriverManager.initDriver();
        driver = WindowsDriverManager.getDriver();

        driver.findElement(By.className("Edit")).sendKeys("Validation");

        File file = new File(filePath);
        Assert.assertTrue(file.exists(), "File not saved properly");
        System.out.println("Test Passed File saved at: " + filePath);
    }

    @AfterMethod
    public void tearDown() {
        WindowsDriverManager.quitDriver();
    }
}