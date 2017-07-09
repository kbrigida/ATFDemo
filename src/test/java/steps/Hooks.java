package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lynx on 06.11.2016.
 */
public class Hooks {
    public static WebDriver driver;
    public Hooks (){
    }
    @Before
    public void setUpBrowser() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver","d:/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Runtime.getRuntime().addShutdownHook(new Thread(){
                public void run(){
                //    driver.close();
                }
            });
        }
        else {
            driver.manage().deleteAllCookies();
        }
    }

    @After
    public void closeBrowser(){
           driver.close();
    }
}