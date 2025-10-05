package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;

    @BeforeMethod(description = "Launch home page")
    public void setUp(){
        homePage=new HomePage(Browser.EDGE);
    }

    public BrowserUtility getInstance(){ //browser utility is parent of all page object e.g. here home page
        return homePage;
    }
    @AfterMethod(description = "close the browser")
    public void tearDown(){
        homePage.closeBrowser();
    }
}
