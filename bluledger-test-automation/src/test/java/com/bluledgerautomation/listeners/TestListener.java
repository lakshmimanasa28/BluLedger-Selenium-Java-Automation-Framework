package com.bluledgerautomation.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.utils.ExtentManager;
import com.bluledgerautomation.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver =
                ((BaseTest) result.getInstance()).getDriver();

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getMethod().getMethodName());

        if (screenshotPath != null) {
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}