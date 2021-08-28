package com.tmb.utils;


import com.tmb.Constant.FrameworkConstant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertyUtils {
    private static final Properties properties = new Properties();
    private static Map<String, String> MAP = new HashMap<>();

    static{
        try (FileInputStream fileInputStream =
                     new FileInputStream(FrameworkConstant.getConfigFilePath())) {

            properties.load(fileInputStream);

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                MAP.put(key, value);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("There is problem with file path");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getValue(String key) {
        return MAP.get(key);
    }
}