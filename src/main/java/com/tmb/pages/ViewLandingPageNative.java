package com.tmb.pages;

import com.tmb.utils.DynamicXpathUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ViewLandingPageNative extends NativeBasePage {
    //android and ios ---> you might need to create two different varibales
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    @iOSXCUITFindBy(accessibility = "views")
    private MobileElement views;

    private static String dragAndDrop = "//android.widget.TextView[@text='%s']";



    public void clickOnMenuItem(String menuname){
        String newXpath = DynamicXpathUtils.getXpath(dragAndDrop, menuname);
        click("xpath", newXpath, "Drag and Drop");
    }
}
