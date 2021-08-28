package com.tmb.testcases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.pages.HomePageNative;
import com.tmb.pages.ViewLandingPageNative;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


public class TapTests extends BaseTest{



    @Test(dataProvider = "getData1")
    public void tapTests(Map<String,String> map) throws MalformedURLException {

       // new HomePage().clickOnViews().clickOnMenuItem("Drag and Drop");

        new HomePageNative().clickOnMenuItems("Views");
        new ViewLandingPageNative().clickOnMenuItem("Drag and Drop");

    }


    //Dataprovider to run test on parallel

    @DataProvider(parallel = true)
    public Object[] getData1(){
        Map<String,String> map = new HashMap<>();
        map.put("device", "Google Pixel 3");
        map.put("os_version", "9.0");

        Map<String,String> map2 = new HashMap<>();
        map2.put("device", "Xiaomi Redmi Note 9");
        map2.put("os_version", "10.0");

        Map<String,String> map3 = new HashMap<>();


        List<Map<String,String>> list = new ArrayList<>();

        //list.add(map);
     //   list.add(map2);
        list.add(map3);
        return list.toArray();
    }

    @DataProvider(parallel = true)
    public Object[] getData() throws IOException {

//       List<Map<String,String>> list = ((List<Map<String, String>>) new ObjectMapper().readValue(new File(System.getProperty("user.dir")
  ///              + "/src/test/resources/jsontestdata/iteration1.json"), HashMap.class));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<Map<String, Object>> list = mapper.readValue(new File(System.getProperty("user.dir")
                + "/src/test/resources/jsontestdata/iteration2.json"), new TypeReference<List<Map<String, Object>>>(){});

       // HashMap hashMap2 = new ObjectMapper().readValue(new File(System.getProperty("user.dir")
         //       + "/src/test/resources/jsontestdata/iteration1.json"), HashMap.class);

        return list.toArray();
       // return new Object[]{hashMap,hashMap2};
    }




}
