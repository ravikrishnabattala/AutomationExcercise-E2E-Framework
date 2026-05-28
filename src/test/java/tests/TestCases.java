package tests;

import com.automation.base.BaseTest;
import com.automation.listeners.TestListener;
import com.automation.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestCases extends BaseTest {

//  Register a new user account.
    @Test
    public void registerUser() {
        driver.get(ConfigReader.getProperty("base.url"));
        driver.findElement(By.cssSelector("jfafaf"));
    }
}
