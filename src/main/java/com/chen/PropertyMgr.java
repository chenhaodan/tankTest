package com.chen;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {

    private static Properties properties = new Properties();
    private static PropertyMgr propertyMgr = null;

    private PropertyMgr(){
    }

    public static PropertyMgr getPropMgr(){
        if(null == propertyMgr){
            synchronized (PropertyMgr.class){
                if(null == propertyMgr){
                    propertyMgr = new PropertyMgr();
                    try {
                        propertyMgr.properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return propertyMgr;
    }


    public static Object get(String key){
        return getPropMgr().properties.get(key);
    }


//
//
//    public static Object get(String key){
//        return getPropMgr().properties.get(key);
//    }



}
