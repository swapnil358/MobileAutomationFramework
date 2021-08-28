package com.tmb.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.driver.DriverManager;

import java.lang.reflect.Method;
import java.util.Objects;

public class ExtentReport {
    public static ExtentReports extent;

    public static void initReport() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setReportName("Automation report");
            sparkReporter.config().setDocumentTitle("Mobile Automation");
            extent.attachReporter(sparkReporter);
        }

    }

    public static void createTest(String testCaseName) {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentReport(test);
    }

    public static void tearDownReport() {
        if (Objects.nonNull(extent))
        extent.flush();
        ExtentManager.unload();
        }
    }


