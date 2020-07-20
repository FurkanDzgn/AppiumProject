package com.techtorial.appiumIntro.StepDefinitions;

import com.techtorial.appiumIntro.Pages.ContentPage;
import com.techtorial.appiumIntro.Pages.ExternalStroge;
import com.techtorial.appiumIntro.Pages.MainPage;
import com.techtorial.appiumIntro.Pages.Views;
import com.techtorial.appiumIntro.Utils.getDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class AppiumPractice2 {

    AndroidDriver<AndroidElement> driver;
    MainPage mainPage ;
    ContentPage contentPage;
    ExternalStroge externalStroge;
    Views views;
    @Before
    public void setUp() throws MalformedURLException {

        // driver = CommonUtils.getAndroidDriver();
        driver = getDriver.getAndroidDriver();
        mainPage = MainPage.getMainPage(driver);
        contentPage = new ContentPage(driver);
        externalStroge = new ExternalStroge(driver);
        views = Views.getViewPage(driver);
    }

    @Test
    public void testCase1(){

        mainPage.views.click();
        views.expandableLists.click();
        //     views.customAdapt1.click();
        views.listOfExpandButton.get(0).click();
//        views.fishName.click();
//
//        for (AndroidElement fishName:views.fishNames) {
//            System.out.println(fishName.getText());
//        }

        for (AndroidElement name:views.names) {
        //    System.out.println(name.getText());
            if(name.getText().contains("Dog")){
                name.click();
                for(AndroidElement allName:views.allNames){
                    System.out.println(allName.getText());
                }

            }
        }




//        System.out.println(views.goldy.getText());
//        System.out.println(views.bubbles.getText());
//        System.out.println(views.bubbles); // Which methods usually overriden? -->> toString() and equals() methods

    }
}
