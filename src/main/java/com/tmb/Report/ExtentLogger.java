package com.tmb.Report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.sun.xml.internal.ws.util.StringUtils;
import com.tmb.utils.ScreenshotUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;

public class ExtentLogger {

    public ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        //ExtentManager.getExtentTest().fail(message);
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder
                .createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);

    }

    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }




}
