package com.automation.listeners;

import com.automation.utilities.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println(context.getStartDate());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        if (ITestResult.SUCCESS == result.getStatus()) {
            ScreenshotUtils.takeScreenshot(
                    "success_"+result.getName()
            );
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.takeScreenshot(
                    "failure_"+result.getName()
            );
        }
    }
}
