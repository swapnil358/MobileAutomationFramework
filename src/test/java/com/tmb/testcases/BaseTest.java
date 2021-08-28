package com.tmb.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.tmb.Report.ExtentManager;
import com.tmb.Report.ExtentReport;
import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Objects;

public class BaseTest {


    @BeforeMethod
    public void setUpTest(Object[] data) throws MalformedURLException {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map);
    }



    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
