package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

public class iosBasePage {

    private void tap(IOSElement view) {
        TouchAction tap = new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(view))).perform();
    }

    private void longPress(IOSElement people_names) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(people_names)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();
    }
}
