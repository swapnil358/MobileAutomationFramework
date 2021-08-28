package com.tmb.pages;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.Report.ExtentLogger;
import com.tmb.Report.ExtentManager;
import com.tmb.Report.ExtentReport;
import com.tmb.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NativeBasePage {

    protected void click(MobileElement element, String elementName) {

        element.click();
        System.out.println(elementName + " is clicked successfully");
        //ExtentManager.getExtentTest().pass(elementName + " is clicked successfully");
        ExtentLogger.pass(elementName + " is clicked successfully");

    }


    protected void click(By by, String elementName) {
        //DriverManager.getDriver().findElement(By.xpath(elementName)).click();
        click((MobileElement) DriverManager.getDriver().findElement(by), elementName);
    }

    protected void click(String locatorType, String value, String elementName) {
        if (locatorType.equalsIgnoreCase("xpath")) {
            click(By.xpath(value), elementName);
        } else if (locatorType.equalsIgnoreCase("id")) {
            click(By.id(value), elementName);
        }
    }

    protected void chooseItemAndClick(List<MobileElement> list, String menu) {
        MobileElement mobileElement = list.parallelStream()
                .filter(e -> e.getText().contains(menu))
                .findFirst().get();
        click(mobileElement, menu);
    }


    protected void dragAndDrop(AndroidElement drag, AndroidElement drop) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(drag)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }


    private void swipeSourceToTarget(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    private void longPress(AndroidElement people_names) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(people_names)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    private void TapUsingCordinates(int x, int y) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(PointOption.point(x, y)).perform();
    }


    private void tap(AndroidElement view) {
        TouchAction tap = new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(view))).perform();

    }

    protected void scrollToSpecificElementClick(By by)
    {
        while(DriverManager.getDriver().findElements(by).isEmpty())
        {
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStrat = screenHeightStart.intValue();
            Double screenHeightEnd =  dimension.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            int center = (int)(dimension.width*0.5);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                    .press(PointOption.point(center,scrollStrat)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(center, scrollEnd)).release().perform();
        }
            if(!DriverManager.getDriver().findElements(by).isEmpty()){
                DriverManager.getDriver().findElement(by).click();
            }
    }


}
