package com.techtorial.appiumIntro.MobileBrowser;

import com.techtorial.appiumIntro.Utils.getDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class mobileBrowser {

    AndroidDriver driver;

    @Before
    public void mobileBrowser() throws MalformedURLException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability("chromedriverExecutable","C:\\Users\\12242\\IdeaProjects\\Appium\\src\\test\\resources\\chromedriver.exe");

        URL serverurl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverurl,desiredCapabilities);
    }

   @Test
    public void setUp(){

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("appium automation"+ Keys.ENTER);
    }
}
