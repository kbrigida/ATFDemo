package stepsMobile;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class HooksMobile {
    public static WebDriver driver;

    public static void reportGeneration() throws IOException {
        Runtime.getRuntime().exec("cmd /C start java -jar D:\\cucumber-sandwich-0.0.4.jar -n -f C:\\Users\\kbrigida\\IdeaProjects\\addMeFastId -o d:/Reports");
    }

    public void startServer() throws InterruptedException, IOException {
        // start Android emulator
        Runtime.getRuntime().exec("cmd /C start emulator -avd Nexus");
        Thread.sleep(15000);
        //start Appium server
        Runtime.getRuntime().exec("cmd /C start appium -a 127.0.0.1");;
        Thread.sleep(5000);
    }
    public static void stopServer() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        // stop emulator
        runtime.exec("taskkill /F /IM qemu-system-i386.exe");
        //stop node.js
        runtime.exec("taskkill /F /IM node.exe");
        //stop appium
        runtime.exec("taskkill /F /IM cmd.exe");

    }

    @Before
    public void setUp() throws IOException, InterruptedException {
        startServer();
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "5.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.android.calculator2");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // wearDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);


    }
}