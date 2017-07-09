package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RetweetPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by onyx on 24.06.2017.
 */
public class RetweetTest {

    protected WebDriver driver;
    public RetweetPage lPage;

    public RetweetTest() {
        this.driver = Hooks.driver;
    }
    @When("^Click on Retweet link in window$")
    public void clickOnRetweetLinkInWindow() throws Throwable {
        lPage = new RetweetPage(driver);

    }

    @And("^Click Retweet in window$")
    public void clickRetweetInWindow() throws Throwable {
        lPage.startRetweet();
        lPage.clickRetweet();
    }
    @And("^Login to Tweeter if needed$")
    public void loginToTweeterIfNeeded() throws Throwable {
        lPage.checkAndTweeterLogin();
    }

    @And("^Make (\\d+) retweets$")
    public void makeRetweets(int count) throws Throwable {
        Integer i = 0;
        while (i < count) {
            lPage.clickRetweet();
            lPage.makeRetweet();
            i++;
        }
    }
}
