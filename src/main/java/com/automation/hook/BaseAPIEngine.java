package com.automation.hook;

import com.automation.listeners.TestListener;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseAPIEngine {

    protected String finalResponse;

    @BeforeMethod(alwaysRun = true)
    public void setUpAPI() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @AfterMethod(alwaysRun = true)
    public void tearAPI() {
        if(finalResponse != null) {
            TestListener.getCurrentTest()
                    .info("<pre>" + finalResponse + "</pre>");
        }
    }
}
