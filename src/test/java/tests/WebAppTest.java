package tests;

import com.automation.hook.BaseWebEngine;
import com.automation.listeners.TestListener;
import com.automation.pageFactory.AddCartPage;
import com.automation.pageFactory.LoginPage;
import com.automation.pageFactory.SignUpPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class WebAppTest extends BaseWebEngine {

    //  Register a new user account.
    @Test(priority = 1)
    public void registerUser() {
        new LoginPage().signUp();
        new SignUpPage().registerUser();
    }

    // Log in with the created account.
    @Test(priority = 2)
    public void loginApplication() {
        new LoginPage().login();
    }

    // Update account information (if editable) OR delete the account and validate deletion
    @Test(priority = 3)
    public void updateInfo() {
        new LoginPage().signUp();
        new SignUpPage().registerUser();
        new LoginPage().deleteAccount();
    }

    // Add at least one product to the cart
    @Test(priority = 4)
    public void addToCart() {
        new LoginPage().login();
        new AddCartPage().addItemsToCart("Blue Top");
    }

    // Proceed to checkout and validate order summary details
    @Test(priority = 5)
    public void summaryDetails() {
        new LoginPage().login();
        new AddCartPage()
                .openCart()
                .checkOut()
                .validateDetails();
    }

}
