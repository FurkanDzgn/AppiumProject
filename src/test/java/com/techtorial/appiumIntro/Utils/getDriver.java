package com.techtorial.appiumIntro.Utils;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class getDriver {

    private static AndroidDriver<AndroidElement> driver;

    private getDriver(){};

    public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {

        if(driver == null) {
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            driver = new io.appium.java_client.android.AndroidDriver<AndroidElement>(appiumServer, CommonUtils.getDesiredCapabilities());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
