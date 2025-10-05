package com.utilities;

import com.constants.Environment;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {
    public static Environments readJson(Environment end){
        Gson gson=new Gson();
        File file=new File(System.getProperty("user.dir")+"\\config\\config.json");
        FileReader fileReader=null;
        try {
             fileReader=new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Config config=gson.fromJson(fileReader, Config.class);
        return config.getEnvironments().get("QA");

    }
}
