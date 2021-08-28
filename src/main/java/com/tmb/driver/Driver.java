package com.tmb.driver;


import com.tmb.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Objects;

public final class Driver {


    private Driver() {
    }


    public static void initDriver(Map<String,String> map) throws MalformedURLException {
        if (Objects.isNull(DriverManager.getDriver())) {
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()), map);
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver()))
            DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}

