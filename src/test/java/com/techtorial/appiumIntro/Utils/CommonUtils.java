package com.techtorial.appiumIntro.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonUtils {


    public static DesiredCapabilities getDesiredCapabilities() throws MalformedURLException {
        File apk = new File("src\\test\\resources\\AppiumPractice.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);// session for time
        return desiredCapabilities;
    }

    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {

        if(driver == null) {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<AndroidElement>(appiumServer, getDesiredCapabilities());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
