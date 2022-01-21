package com.tmb.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImp implements IDriver {


    @Override
    public WebDriver getDriver(Map<String,String> map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        map.forEach(capabilities::setCapability); //it read all the key value from map and store in capabilities
        // Set your access credentials
        capabilities.setCapability("browserstack.user", "swapnilautomatio_CveJw5");
        capabilities.setCapability("browserstack.key", "My2PMpjoqZA5xp7MigxQ");

        // Specify device and os_version for testing
       // capabilities.setCapability("device", "Google Pixel 3");
      //  capabilities.setCapability("os_version", "9.0");


        // Set other BrowserStack capabilities
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android demo");
        capabilities.setCapability("name", "Browser stack test");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        //TO print on the capabilites on the console at runtime
        capabilities.asMap().forEach((k,v)-> System.out.println(k+":"+v));

        // Set URL of the application under test
        capabilities.setCapability("app", "bs://aeda22ec9a0c83310c01799e517da8314fe7830a");
        // Initialise the remote WebDriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver<AndroidElement>(
                new  URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }
}
