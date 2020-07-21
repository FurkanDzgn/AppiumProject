package com.techtorial.appiumIntro.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private MainPage(AndroidDriver driver){
        // instantiating the elements                                // this is instance (MainPage.class)
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


//    @AndroidFindBy(uiAutomator = "text(\"Content\")")
//    public AndroidElement content;

    public static MainPage getMainPage(AndroidDriver driver){
        return new MainPage(driver);
    }

    @AndroidFindBy(accessibility = "Content")
    public AndroidElement content;

    @AndroidFindBy(accessibility = "Accessibility")
    public AndroidElement accessibility;

    @AndroidFindBy(accessibility = "Animation")
    public AndroidElement animation;

    @AndroidFindBy(accessibility = "App")
    public AndroidElement app;

    @AndroidFindBy(accessibility = "Graphics")
    public AndroidElement graphics;

    @AndroidFindBy(accessibility = "Media")
    public AndroidElement media;

    @AndroidFindBy(accessibility = "NFC")
    public AndroidElement NFC;

    @AndroidFindBy(accessibility = "OS")
    public AndroidElement OS;

    @AndroidFindBy(accessibility = "Preference")
    public AndroidElement preference;

    @AndroidFindBy(accessibility = "Text")
    public AndroidElement text;

    @AndroidFindBy(accessibility = "Views")
    public AndroidElement views;




//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
//    public List<AndroidElement> login;
//
//    @AndroidFindBy(id = "android:id/text1")
//    public AndroidElement login;
//
//    @AndroidFindBy(uiAutomator = "")
//    public AndroidElement login;
//
//    @AndroidFindBy(accessibility = "App")
//    public AndroidElement accessibility;
//
//    @AndroidFindBy(uiAutomator = "")
//    public AndroidElement login;









//  login = driver.findelement(By.xpath("")) -->> PageFactory.initElements call this line

//    @iOSBy(xpath = "")
//    public IOSElement login;

}
