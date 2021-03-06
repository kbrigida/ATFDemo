package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lynx on 06.11.2016.
 */

public class Hooks {
    public static WebDriver driver;

    public static void reportGeneration() throws IOException {
        Runtime.getRuntime().exec("cmd /C start java -jar D:\\cucumber-sandwich-0.0.4.jar -n -f C:\\Users\\kbrigida\\IdeaProjects\\addMeFastId -o d:/Reports");
    }
    @Before
    public void setUpBrowser() {
        if (driver == null) {
            //System.setProperty("webdriver.gecko.driver","d:/geckodriver.exe");
            //ProfilesIni profile = new ProfilesIni();
            //FirefoxProfile ffprofile = profile.getProfile("default");
            //driver = new FirefoxDrivdct nfrb 'nj [jhjier(ffprofile);
            System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
            driver = new ChromeDriver();
                System.out.println("Opening Browser....");
            // driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(1920, 1080));
                System.out.println("Window maximized...");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
                System.out.println("Cookies deleted...");

        }
    }
}