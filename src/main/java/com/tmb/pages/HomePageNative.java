package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageNative extends NativeBasePage {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    private AndroidElement views;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='animation']")
    private AndroidElement animation;




    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "views")
    private List<MobileElement> menuitems;



    public HomePageNative(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public ViewLandingPageNative clickOnViews(){
        click(views, "Views");
        return new ViewLandingPageNative();
    }



    public void clickOnMenuItems(String menu){
        chooseItemAndClick(menuitems, menu);

      /*  for(WebElement element : menuitems){
            if(element.getText().equalsIgnoreCase(menu){
                element.click();
            }
*/
     }
   }



