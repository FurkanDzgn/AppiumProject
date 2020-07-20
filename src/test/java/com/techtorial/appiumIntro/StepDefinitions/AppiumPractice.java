package com.techtorial.appiumIntro.StepDefinitions;

import com.techtorial.appiumIntro.Pages.ContentPage;
import com.techtorial.appiumIntro.Pages.ExternalStroge;
import com.techtorial.appiumIntro.Pages.MainPage;
import com.techtorial.appiumIntro.Pages.Views;
import com.techtorial.appiumIntro.Utils.CommonUtils;
import com.techtorial.appiumIntro.Utils.getDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumPractice {

    AndroidDriver<AndroidElement> driver;
    MainPage mainPage ;
    ContentPage contentPage;
    ExternalStroge externalStroge;
    Views views;
    @Before
    public void setUp() throws MalformedURLException {

   //     driver = CommonUtils.getAndroidDriver();
        driver = getDriver.getAndroidDriver();
        mainPage = MainPage.getMainPage(driver);
        contentPage = new ContentPage(driver);
        externalStroge = new ExternalStroge(driver);
        views = Views.getViewPage(driver);
    }

    @Test
    public void prac1(){
        mainPage.content.click();
        contentPage.storage.click();
        externalStroge.externalStroge.click();

        Assert.assertTrue(externalStroge.created1.isEnabled());
        Assert.assertTrue(externalStroge.created2.isEnabled());
        Assert.assertFalse(!externalStroge.created3.isEnabled());
        externalStroge.created3.click();
        Assert.assertFalse(externalStroge.created3.isEnabled());
        Assert.assertTrue(externalStroge.delete3.isEnabled());

 //       externalStroge.created1.click();
        // store all info

    }

    @Test
    public void prac2(){

        mainPage.views.click();
        views.expandableLists.click();
   //     views.customAdapt1.click();
        views.listOfExpandButton.get(0).click();
        views.fishName.click();
//        System.out.println(views.goldy.getText());
//        System.out.println(views.bubbles.getText());


    }
}
