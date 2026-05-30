package tests;

import com.automation.hook.BaseWebEngine;
import com.automation.hook.BaseWebEngine;
import com.automation.listeners.TestListener;
import com.automation.pageFactory.AddCartPage;
import com.automation.pageFactory.LoginPage;
import com.automation.pageFactory.SignUpPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ApplicationTests extends BaseWebEngine {

    //  Register a new user account.
    @Test
    public void registerUser() {
        new LoginPage().signUp();
        new SignUpPage().registerUser();
    }

    // Log in with the created account.
    @Test
    public void loginApplication() {
        new LoginPage().login();
    }

    // Update account information (if editable) OR delete the account and validate deletion
    @Test
    public void updateInfo() {
        new LoginPage().signUp();
        new SignUpPage().registerUser();
        new LoginPage().deleteAccount();
    }

    // Add at least one product to the cart
    @Test
    public void addToCart() {
        new LoginPage().login();
        new AddCartPage().addItemsToCart("Blue Top");
    }

    // Proceed to checkout and validate order summary details
    @Test
    public void summaryDetails() {
        new LoginPage().login();
        new AddCartPage()
                .openCart()
                .checkOut()
                .validateDetails();
    }

}
