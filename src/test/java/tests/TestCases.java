package tests;

import com.automation.base.Base;
import com.automation.listeners.TestListener;
import com.automation.pageFactory.LoginPage;
import com.automation.pageFactory.SignUpPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestCases extends Base {

    //  Register a new user account.
    @Test
    public void registerUser() {
        new LoginPage(driver).signUp();
        new SignUpPage(driver).registerUser();
    }

    // Log in with the created account.
    @Test
    public void loginApplication() {
        new LoginPage(driver).login();
    }

    // Update account information (if editable) OR delete the account and validate deletion
    @Test
    public void updateInfo(){

    }
}
