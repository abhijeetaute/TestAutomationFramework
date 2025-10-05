package com.ui.pages;

import com.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    private static final By ACCOUNT_NAME= By.xpath("//a[@title='View my customer account']");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public String getUserName(){
        return getVisibleText(ACCOUNT_NAME);
    }
}
