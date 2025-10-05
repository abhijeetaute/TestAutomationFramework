package com.ui.pages;

import com.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By EMAIL_INPUT_LOC=By.id("email");
    private static final By PASSWORD_INPUT_LOC=By.id("passwd");
    private static final By SIGN_IN_BUTTON_LOC=By.id("SubmitLogin");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String email,String password){
        enterText(EMAIL_INPUT_LOC,email);
        enterText(PASSWORD_INPUT_LOC,password);
        clickOn(SIGN_IN_BUTTON_LOC);
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        return myAccountPage;
    }
}
