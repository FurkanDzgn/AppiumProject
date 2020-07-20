package com.techtorial.appiumIntro.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Views {

    private Views(AndroidDriver driver){ // We can not create an Object Cuz of private
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(accessibility = "Expandable Lists")
    public AndroidElement expandableLists;
    @AndroidFindBy(accessibility = "1. Custom Adapter")
    public AndroidElement customAdapt1;
    @AndroidFindBy(accessibility = "2. Custom Adapter")
    public AndroidElement customAdapt2;
    @AndroidFindBy(accessibility = "3. Custom Adapter")
    public AndroidElement customAdapt3;

    @AndroidFindBy(id = "android:id/text1")
    public List<AndroidElement> listOfExpandButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fish Names']")
    public AndroidElement fishName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fish Names']/following-sibling::android.widget.TextView")
    public List<AndroidElement> fishNames;

    //    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Goldy']")
//    public AndroidElement goldy;
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bubbles']")
//    public AndroidElement bubbles;

    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id='android:id/list']" +
            "//android.widget.TextView") // [contains(text(),'Names']
    public List<AndroidElement> names;

    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id='android:id/list']" +
            "//android.widget.TextView[contains(text(),'Names']/following-sibling::android.widget.TextView")
    public List<AndroidElement> allNames;

    @AndroidFindBy(xpath = "android.widget.TextView[position()>1")
    public List<AndroidElement> allText;

    public static Views getViewPage(AndroidDriver driver){
        return new Views(driver);


    }

}
