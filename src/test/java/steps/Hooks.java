package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile ffprofile = profile.getProfile("default");
            driver = new FirefoxDriver(ffprofile);
                System.out.println("Opening Browser....");
            driver.manage().window().maximize();
                System.out.println("Window maximized...");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
                System.out.println("Cookies deleted...");

        }
    }
    @After
    public void closeBrowser() {
        System.out.println("Finish...");
        driver.quit();
    }
}