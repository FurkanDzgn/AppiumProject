package com.techtorial.appiumIntro.MobileBrowser;

import com.techtorial.appiumIntro.Pages.ecommerce.MainPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ECommerceApp {

    AndroidDriver driver;
    MainPage mainPage;

    @Before
    public void setUp() throws MalformedURLException {

        File apkFile = new File("src\\test\\resources\\Store.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());

        URL serverurl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverurl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = MainPage.getMainPage(driver);
    }

    @Test
    public void test1(){

        mainPage.countriesDropdownbox.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
        mainPage.brasil.click();

    }

    @Test
    public void test2(){

        mainPage.countriesDropdownbox.click();
        mainPage.albania.click();
        mainPage.nameField.sendKeys("techtorial");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.letsShopButton))).perform();
    }

    @Test
    public void testToastMessage(){
        mainPage.letsShopButton.click();
        AndroidElement toastMessage = (AndroidElement) driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals("Please enter your name", toastMessage.getAttribute("name"));
        Assert.assertEquals("Please enter your name", toastMessage.getAttribute("text"));
       Assert.assertEquals("Please enter your name", toastMessage.getText());
    }

}

