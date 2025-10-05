package com.ui.pages;

import com.constants.Browser;
import static com.constants.Environment.*;
import com.utilities.BrowserUtility;
import static com.utilities.PropertiesUtil.*;

import com.utilities.JsonUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtility {
    private static final  By SIGN_IN_LINK_LOC=By.xpath("//a[@class='login']");

    public HomePage(Browser browserName) {
        super(browserName);
        navigateToWebsite(JsonUtility.readJson(QA).getUrl());
    }

    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LINK_LOC);
        LoginPage loginPage=new LoginPage(getDriver());
        return loginPage;
    }


}
