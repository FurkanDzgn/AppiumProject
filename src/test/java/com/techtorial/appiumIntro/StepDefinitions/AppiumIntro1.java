package com.techtorial.appiumIntro.StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumIntro1 {

    AndroidDriver<AndroidElement> androidDriver;

    @Before
    public void setUp(){
        File apk = new File("src\\test\\resources\\AppiumPractice.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName","Pixel 3 API 28");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        desiredCapabilities.setCapability("app",apk.getAbsolutePath());


        URL url;
        try{
            url = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException ex){
            throw new RuntimeException(ex);
        }

        androidDriver = new AndroidDriver(url,desiredCapabilities);

    }

    @Test
    public void intro1() throws InterruptedException {

        AndroidElement element =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']"));

        element.click();
        Thread.sleep(2000);
        androidDriver.navigate().back();

        List<AndroidElement> element1 =
                androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));

        for (AndroidElement el: element1) {
            el.click();
            Thread.sleep(2000);
            androidDriver.navigate().back();
        }


    }

    @Test
    public void preference1() throws InterruptedException {


        androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        AndroidElement androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox preference']"));
        androidElement.click();

        androidDriver.navigate().back();
        androidDriver.navigate().back();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Edit text preference']"));
        androidElement.click();

         androidElement =
                 androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']"));
                androidElement.clear();
                androidElement.sendKeys("Hello Techtorial");
        androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

        androidDriver.navigate().back();
        Thread.sleep(1000);
        androidDriver.navigate().back();
        androidDriver.navigate().back();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='List preference']"));
        androidElement.click();

        androidElement =
                androidDriver.findElement(By.xpath("//android.widget.Button[@text='CANCEL']"));
        androidElement.click();

        androidDriver.navigate().back();
        Thread.sleep(500);
        androidDriver.navigate().back();
        Thread.sleep(500);
        androidDriver.navigate().back();


    }

}
