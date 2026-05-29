package com.automation.listeners;

import com.automation.utilities.ExtentManager;
import com.automation.utilities.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed Successfully");
        try {
            String screenshotPath = ScreenshotUtils.takeScreenshot("success_" + result.getName());
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());

        try {
            String screenshotPath = ScreenshotUtils.takeScreenshot("failure_" + result.getName());
            test.get().addScreenCaptureFromPath(screenshotPath);
            test.get().log(Status.FAIL, "Screenshot captured at: " + screenshotPath);
        } catch (Exception e) {
            test.get().log(Status.FAIL, "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
