package com.automation.hook;

import com.automation.driverFactory.MobileDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseMobileEngine {

    @BeforeMethod(alwaysRun = true)
    public void setUpMobile() {
        MobileDriverManager.initAndroid();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MobileDriverManager.quitAndroid();
    }
}
