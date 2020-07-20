package com.techtorial.appiumIntro.locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

public class Locators1 {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws MalformedURLException {

        File apkFile = new File("src\\test\\resources\\AppiumPractice.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 28");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("newCommandTime",600);
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());

        URL serverUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverUrl,desiredCapabilities);
    }

    @Test
    public void loc1(){
        // xpath
        // className[@attribute='value']
        AndroidElement views = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        views.click();
    }

    @Test
    public void loc2(){

        //id
        // resource-id
        AndroidElement views = driver.findElement(By.id("android:id/text1"));
        views.click();
    }

    @Test
    public void loc3(){

        // accessibilityId
        AndroidElement app = driver.findElementByAccessibilityId("App");
        app.click();

    }

    @Test
    public void loc4(){

        // findElementByAndroidUIAutomator
       AndroidElement content = driver.findElementByAndroidUIAutomator("text(\"Content\")");
       content.click();

        driver.findElementByAndroidUIAutomator("text(\"Storage\")").click();
        driver.findElementByAndroidUIAutomator("text(\"External Storage\")").click();
    }

    @Test
    public void loc5(){

        // name doesn't support new version (depricated)  -- InvalidSelectorException
        AndroidElement hardware = driver.findElement(By.name("Accessibility"));
        hardware.click();
    }



}
