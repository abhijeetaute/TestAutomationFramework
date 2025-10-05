package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.BaseTest;
import com.utilities.BrowserUtility;
import com.utilities.ReporterUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    Logger logger= LogManager.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {

        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ReporterUtility.creteExtentText(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+" PASSED.");
        ReporterUtility.getTest().log(Status.PASS,result.getMethod().getMethodName()+" "+" PASSED.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName()+" "+" FAILED");
        logger.error(result.getThrowable().getMessage());
        ReporterUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName()+" "+" FAILED.");
        ReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());

        Object testClass=result.getInstance();
        BrowserUtility browserUtility=((BaseTest)testClass).getInstance();
        String path=browserUtility.takeScreenShot(result.getMethod().getMethodName());
        ReporterUtility.getTest().addScreenCaptureFromPath(path);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" "+" SKIPPED");
        ReporterUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName()+" "+" SKIPPED.");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started..");
        ReporterUtility.setupSparkReporter("report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed..");
        ReporterUtility.flushReport();
    }
}
