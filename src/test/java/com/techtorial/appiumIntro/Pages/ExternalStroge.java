package com.techtorial.appiumIntro.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ExternalStroge {

    public ExternalStroge(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

//    @AndroidFindBy(uiAutomator = "text(\"External Storage\")")
//    public AndroidElement externalStroge;

    @AndroidFindBy(xpath = "//*[@text='External Storage']")
    public AndroidElement externalStroge;

                             // tag name = class name
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='io.appium.android.apis:id/label']" +
            "/following-sibling::android.widget.LinearLayout/android.widget.Button[@text='CREATE']")
    public AndroidElement created1;

    @AndroidFindBy(xpath = "//*[@text='Picture getExternalFilesDir']" +
            "//following-sibling::android.widget.LinearLayout/android.widget.Button[@text='CREATE']")
    public AndroidElement created2;

    @AndroidFindBy(xpath = "//*[@text='File getExternalFilesDir']" +
            "//following-sibling::android.widget.LinearLayout/android.widget.Button[@text='CREATE']")
    public AndroidElement created3;


    @AndroidFindBy(xpath = "//*[@resource-id='io.appium.android.apis:id/label']" +
            "/following-sibling::android.widget.LinearLayout/android.widget.Button[@text='DELETE']")
    public AndroidElement delete1;

    @AndroidFindBy(xpath = "//*[@text='Picture getExternalFilesDir']" +
            "//following-sibling::android.widget.LinearLayout/android.widget.Button[@text='DELETE']")
    public AndroidElement delete2;

    @AndroidFindBy(xpath = "//*[@text='File getExternalFilesDir']" +
            "//following-sibling::android.widget.LinearLayout/android.widget.Button[@text='DELETE']")
    public AndroidElement delete3;
}
