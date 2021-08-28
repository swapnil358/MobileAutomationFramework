package com.tmb.driver;

import com.tmb.Constant.FrameworkConstant;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.assertj.core.util.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LocalDriverImp implements IDriver {

    @Override
    public WebDriver getDriver(Map<String,String> map) throws MalformedURLException, MalformedURLException {
        File AppLocation = new File(FrameworkConstant.getApkFilePath());


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8200");
        //capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
        //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
      capabilities.setCapability(MobileCapabilityType.APP,FrameworkConstant.getApkFilePath());
        //capabilities.setCapability(MobileCapabilityType.APP, AppLocation.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        return new AndroidDriver<AndroidElement>(
                new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
    }




}
