package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by onyx on 24.06.2017.
 */
public class RetweetPage extends GeneralPage {
    String reTweetURL = "http://addmefast.com/free_points/twitter_retweets";

    @FindBy(xpath =".//div[text() = 'Retweet']" )
            WebElement retweetButton;
    @FindBy (id = "username_or_email")
            WebElement retweetLogin;
    @FindBy (id = "password")
            WebElement retweetPassword;
    @FindBy (className = "submit")
            WebElement retweetLoginSubmit;
    @FindBy (xpath = ".//fieldset/input")
            WebElement retweetRetweetSubmit;
    @FindBy(xpath =".//a[text() = 'Twitter']" )
            WebElement twitterLogo;
    @FindBy(id = "loading-indicator-site-links-list")
            WebElement loadingIndicator;
    @FindBy(id ="site-links-list" )
            WebElement linksList;

    public RetweetPage(WebDriver driver) {
        super(driver);
    }

    public void startRetweet() {
        driver.navigate().to(reTweetURL);
    }

    public void clickRetweet() throws InterruptedException {
        PageFactory.initElements(driver, this);
        clickButton(retweetButton);

    }

    public void checkAndTweeterLogin() throws InterruptedException {
            String parentHandle = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }
            waitElementVisible(twitterLogo);
            if (checkElementExist(retweetLogin)) { // If login to Tweeter neeeded
                fillField("LynxLynxy@gmail.com", retweetLogin);
                fillField("Testpass1", retweetPassword);
                clickButton(retweetLoginSubmit);
                PageFactory.initElements(driver, this);;
                clickButton(retweetRetweetSubmit);
                driver.close();
            }
        driver.switchTo().window(parentHandle);
        waitElementLoad(loadingIndicator);
    }
    public void makeRetweet() throws InterruptedException{
        String parentHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        waitElementVisible(twitterLogo);
        PageFactory.initElements(driver, this);
        if (checkElementExist(retweetRetweetSubmit)) {
            PageFactory.initElements(driver, this);
            clickButton(retweetRetweetSubmit);
        }
        driver.close();
        driver.switchTo().window(parentHandle);
        waitElementLoad(loadingIndicator);
    }

}
