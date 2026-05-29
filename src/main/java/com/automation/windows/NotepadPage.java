package com.automation.windows;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class NotepadPage {

    private static WindowsDriver driver;

    private static final String TEXT_AREA = "Edit";
    private static final String FILE_MENU = "File";
    private static final String SAVE_OPTION = "Save";
    private static final String FILE_NAME_FIELD = "FileNameControlHost";
    private static final String SAVE_BUTTON = "Save";
    private static final String DONT_SAVE_BUTTON = "Don't Save";

    public NotepadPage(WindowsDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        try {
            WebElement textArea = driver.findElement(AppiumBy.className(TEXT_AREA));
            textArea.click();
            textArea.sendKeys(text);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public String getText() {
        WebElement textArea =
                driver.findElement(AppiumBy.className(TEXT_AREA));
        return textArea.getAttribute("Value.Value");
    }

    public void saveFile(String fileName) throws InterruptedException {

        driver.findElement(AppiumBy.name(FILE_MENU)).click();
        Thread.sleep(500);

        driver.findElement(AppiumBy.name(SAVE_OPTION)).click();
        Thread.sleep(1000);

        WebElement fileNameInput = driver.findElement(AppiumBy.accessibilityId(FILE_NAME_FIELD));

        fileNameInput.clear();
        fileNameInput.sendKeys(fileName);
        Thread.sleep(500);

        driver.findElement(AppiumBy.name(SAVE_BUTTON)).click();
        Thread.sleep(2000);
    }

    public void closeNotepad() {
        driver.findElement(AppiumBy.name("Close")).click();
    }

    public void closeWithoutSaving() {
        try {
            driver.findElement(AppiumBy.name(DONT_SAVE_BUTTON)).click();
        } catch (Exception e) {
            driver.findElement(AppiumBy.name("不保存")).click();
        }
    }

    public void clearText() {
        WebElement textArea =
                driver.findElement(AppiumBy.className(TEXT_AREA));

        textArea.sendKeys(Keys.CONTROL, "a");
        textArea.sendKeys(Keys.DELETE);
    }
}