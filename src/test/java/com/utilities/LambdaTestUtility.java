package com.utilities;

import com.constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<>();
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";

    public static WebDriver initializeLambdaTestSession(Browser browser, String testName){
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "abhiaute123");
        ltOptions.put("accessKey", "LT_ZHlmDCr7EOnRToUZPiuMlh6H2LaLQa8rqOhDq5rmjCVerRQ");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver=null;
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driverLocal.set(driver);
        return driverLocal.get();

    }
    public static void quitSession(){
        if(driverLocal.get()!=null){
            driverLocal.get().quit();
        }
    }
}
