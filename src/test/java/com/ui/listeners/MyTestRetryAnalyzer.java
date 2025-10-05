package com.ui.listeners;

import com.constants.Environment;
import com.utilities.JsonUtility;
import com.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyTestRetryAnalyzer implements IRetryAnalyzer {
   // private static final int MAX_NUM_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Environment.QA,"MAX_NUM_OF_ATTEMPTS"));
   private static final int MAX_NUM_OF_ATTEMPTS= JsonUtility.readJson(Environment.QA).getMaxNumberOfAttempts();
    private static int currentAttempt=1;
    @Override
    public boolean retry(ITestResult iTestResult) { //if retry method return true - it will rerun test and if it is false it willmark test a fail
        if(currentAttempt<=MAX_NUM_OF_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
