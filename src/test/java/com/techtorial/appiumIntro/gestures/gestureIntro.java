package com.techtorial.appiumIntro.gestures;

import com.techtorial.appiumIntro.Pages.MainPage;
import com.techtorial.appiumIntro.Pages.Views;
import com.techtorial.appiumIntro.Utils.getDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class gestureIntro {

    MainPage mainPage;
    AndroidDriver<AndroidElement> driver;
    Views views;

    @Before
    public void setUp() throws MalformedURLException { // declare exception
        // try and catch -->> handle exception
        driver = getDriver.getAndroidDriver();
        mainPage = MainPage.getMainPage(driver);
        views = Views.getViewPage(driver);
    }

    @Test
    public void gesture1() {
        // tap
        TouchAction touchAction = new TouchAction(driver);

        TapOptions tapOptions = new TapOptions();
        //     touchAction.tap(tapOptions.withElement(ElementOption.element(mainPage.app))).perform();
        //    touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.app))).perform();

        touchAction.tap(TapOptions.tapOptions().withElement(element(mainPage.app))).perform();

    }

    @Test
    public void gesture2(){
        // Tap on OS ,go back
        // Tap on Text ,go back
        // Tap on Views ,go back
        TouchAction touchAction = new TouchAction(driver);

        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.OS))).perform();
        driver.navigate().back();
        touchAction.tap(TapOptions.tapOptions().withElement(element(mainPage.text))).perform();
        driver.navigate().back();
        touchAction.tap(TapOptions.tapOptions().withElement(element(mainPage.views))).perform();
        driver.navigate().back();

    }

    @Test
    public void gesture3(){
        // long press

        TouchAction touchAction = new TouchAction(driver);

//        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.views))).perform();
//        touchAction.tap(TapOptions.tapOptions().withElement(element(views.expandableLists))).perform();
//        touchAction.tap(TapOptions.tapOptions().withElement(element(views.customAdapt1))).perform();
//
//        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(3))
//                .withElement(element(views.peopleNames))).perform();

        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.views)))
                .perform()
                .tap(TapOptions.tapOptions().withElement(element(views.expandableLists)))
                .perform()
                .tap(TapOptions.tapOptions().withElement(element(views.customAdapt1)))
                .perform()
                .longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(3))
                        .withElement(element(views.peopleNames)))
                .perform();

        Assert.assertEquals("Sample action",views.sampleAction.getText());



    }
}