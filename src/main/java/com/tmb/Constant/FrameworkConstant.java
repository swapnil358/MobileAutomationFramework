package com.tmb.Constant;


import lombok.Getter;

import java.util.Objects;


public class FrameworkConstant {


    private FrameworkConstant() {
    }


    private static String resourcePath = System.getProperty("user.dir") + "/src/test/resources";
    private static @Getter String configFilePath = resourcePath + "/config/config.properties";
    private static @Getter String apkFilePath = resourcePath +"/apkFiles/ApiDemos-debug.apk";




}