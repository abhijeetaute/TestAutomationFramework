package com.utilities;

import com.constants.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    // to read properties
    public static String readProperty(Environment env, String property) {
        File propFile=new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
        FileInputStream fileInputStream= null;
        Properties prop=new Properties();
        try {
            fileInputStream = new FileInputStream(propFile);
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(property.toUpperCase());
    }
}
