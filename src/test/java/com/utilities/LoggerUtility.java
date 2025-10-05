package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
    //Global configuration/setup for logger
    //following singleton design pattern - generally used in database connectivity or logger class
   // private static Logger logger;
    private LoggerUtility(){

    }

    public static Logger getLogger(Class<?> clazz){
        Logger logger=null;
        if(logger==null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }

}
