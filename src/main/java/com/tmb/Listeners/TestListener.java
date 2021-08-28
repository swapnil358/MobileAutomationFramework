package com.tmb.Listeners;

import com.aventstack.extentreports.Status;
import com.tmb.Report.ExtentLogger;
import com.tmb.Report.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class TestListener implements ITestListener, ISuiteListener {
    @Override  //BeforeMethod
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+" is failed");
        // log the error
        ExtentLogger.fail(result.getThrowable().toString());

        // to log whole track stracktrace
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName()+" is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override //It is similar to @BeforeSuit
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override //It is similar to @AfterSuit
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReport();
    }
}
