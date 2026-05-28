package tests;

import com.automation.base.BaseTest;
import com.automation.utilities.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {

        driver.get(ConfigReader.getProperty("base.url"));
    }
}
