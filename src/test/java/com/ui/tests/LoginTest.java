package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;

import com.ui.pojos.User;
import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends BaseTest{
    //kosih62204@ncien.com


   @Test(description = "This is JSON data driven login test",dataProviderClass = com.ui.dataprovider.LoginTestDataProvider.class,dataProvider = "loginTestDataProvider")
    public void loginTest1(User user) {
          assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Abhi Tester");

    }

    @Test(description = "This is CSV data driven login test",dataProviderClass = com.ui.dataprovider.LoginTestDataProvider.class, dataProvider = "csvDataProvider")
    public void loginTest2(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Abhi Tester");
    }

    @Test(description = "This is Excel data driven login test",groups = {"e2e","smoke"},dataProviderClass = com.ui.dataprovider.LoginTestDataProvider.class, dataProvider = "excelDataProvider",retryAnalyzer = com.ui.listeners.MyTestRetryAnalyzer.class)
    public void loginTest3(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Abhi Tester");
    }


}
