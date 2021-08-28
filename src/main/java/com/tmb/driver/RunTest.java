package com.tmb.driver;

import com.tmb.utils.PropertyUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class RunTest {

    private AndroidDriver<AndroidElement> driver;


    @BeforeMethod


    public void getDriver() throws MalformedURLException, MalformedURLException {

        String temp = "local";
        if(temp.equals(PropertyUtils.getValue("mode"))){
            File f = new File("src/test/resources/apkFiles");
            File fs = new File(f, "ApiDemos-debug.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            //capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8200");
            //capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
            //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
            // capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir" + "src/test/resources/apkFiles/ApiDemos-debug.apk"));
            capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
            DriverManager.setDriver(driver);
        }




    }
    @Test
    public void tes(){
        DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
    }


    @AfterMethod
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}
