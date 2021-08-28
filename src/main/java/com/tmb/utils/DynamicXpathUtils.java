package com.tmb.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}


    public static String getXpath(String xpath, String value){
        return String.format(xpath, value);
    }

    //    private static String dragAndDrop = "//android.widget.TextView[@text='%s'] and [@id='%s']";
    public static String getXpath(String xpath, String value, String id){
        return String.format(xpath, value, id);
    }





}
