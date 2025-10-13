package com.utilities;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    Logger logger= LogManager.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browser,boolean isHeadless){
        logger.info("Launching browser: "+browser);
        if(browser==Browser.CHROME) {
            if(isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            }else driver.set(new ChromeDriver());
        }else if(browser==Browser.EDGE) {
            if(isHeadless){
                EdgeOptions options=new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("disable-gpu");
                driver.set(new EdgeDriver(options));
            }else
            driver.set(new EdgeDriver());
        }
        else if(browser==Browser.FIREFOX)
            driver.set(new FirefoxDriver());
        else
            logger.error("Invalid browser name..!!");
    }
    public void navigateToWebsite(String url){
        logger.info("Navigating to URL: "+url);
        getDriver().get(url);
        logger.info("Maximizing browser");
        getDriver().manage().window().maximize();
    }

    public void clickOn(By locator){
        logger.info("clicking on Element: "+locator);
        WebElement element=getDriver().findElement(locator); // find element
        element.click();
    }

    public void enterText(By locator,String textToEnter){
        logger.info("Entering text: "+textToEnter);
        WebElement element=getDriver().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator){
        WebElement element=getDriver().findElement(locator);
        return element.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot screenshot= (TakesScreenshot) getDriver();
        File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
        String timestamp=format.format(date);
        String path=System.getProperty("user.dir")+"//screenshots//"+name+" - "+timestamp+".png";
        File screenshotFile=new File(path);
        try {
            FileUtils.copyFile(screenshotData,screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void closeBrowser(){
        getDriver().close();
    }
}
