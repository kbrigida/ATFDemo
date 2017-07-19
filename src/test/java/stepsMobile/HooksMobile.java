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


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class HooksMobile {
    public static WebDriver driver;

    public void startServer(){
        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c");
        command.addArgument("D:/Appium/node.exe");
        command.addArgument("D:/Appium/node_modules/appium/bin/appium.js");
        command.addArgument("--address");
        command.addArgument("127.0.0.1");
        command.addArgument("--port");
        command.addArgument("4724");
        command.addArgument("--no-reset");
        command.addArgument("--log");
        command.addArgument("D:/appiumLogs.txt");
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);


        try {
            executor.execute(command, resultHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer(){

        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c");
        command.addArgument("taskkill");
        command.addArgument("/F");
        command.addArgument("/IM");
        command.addArgument("node.exe");

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);

        try {
            executor.execute(command, resultHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Before
    public void setUp() throws MalformedURLException {
        startServer();
        System.out.println("---- Appium server started Successfully ! ----");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

    @After
    public void Finish() throws MalformedURLException {
        stopServer();

    }
}