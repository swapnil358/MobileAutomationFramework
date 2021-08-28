package com.tmb.Constant;

import lombok.Getter;

import java.util.Objects;
@Getter
public class FrameworkConstantWithLombak {


    private static FrameworkConstantWithLombak frameworkConstantWithLombak;

    public static synchronized FrameworkConstantWithLombak getInstance(){
        if(Objects.isNull(frameworkConstantWithLombak)){
            frameworkConstantWithLombak = new FrameworkConstantWithLombak();
        }
        return frameworkConstantWithLombak;
    }

    private static String resourcePath = System.getProperty("user.dir") + "/src/test/resources";
    private static String configFilePath = resourcePath + "/config/config.properties";
    private static String apkFilePath = resourcePath +"/apkFiles/ApiDemos-debug.apk";



}
