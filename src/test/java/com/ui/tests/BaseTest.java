package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LambdaTestUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private boolean isLambdaTest=false;
    HomePage homePage;
    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Launch home page")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless,
            ITestResult result){
        this.isLambdaTest=isLambdaTest;
        if(isLambdaTest){
            WebDriver lambdaDriver= LambdaTestUtility.initializeLambdaTestSession(Browser.valueOf(browser.toUpperCase()),result.getMethod().getMethodName());
            homePage=new HomePage(lambdaDriver);
        }else {
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), true);
        }
    }

    public BrowserUtility getInstance(){ //browser utility is parent of all page object e.g. here home page
        return homePage;
    }
    @AfterMethod(description = "close the browser")
    public void tearDown(){
        homePage.closeBrowser();
    }
}
