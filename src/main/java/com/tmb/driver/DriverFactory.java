package com.tmb.driver;

import com.tmb.exception.FrameworkException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver get(Modes mode, Map<String,String> map) throws MalformedURLException {
        WebDriver driver = null;

        if (mode == Modes.LOCAL) {
            driver = new LocalDriverImp().getDriver(map);
        } else if (mode == Modes.BS) {
            driver = new BrowserStackImp().getDriver(map);
        } else if (mode == Modes.SAUCELABS) {
            driver = new SauceLabImp().getDriver(map);
        }
        else{
            throw new FrameworkException("No cloud provider with name you mentioned is configured");
        }
        return driver;
    }
}
