package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by onyx on 02.07.2017.
 */
public class InstagramPage extends GeneralPage {

    public InstagramPage(WebDriver driver) {
        super(driver);
    }

    String instaLikesLink = "http://addmefast.com/free_points/instagram_likes";
    String instaFollowLink = "http://addmefast.com/free_points/instagram";

    @FindBy(xpath =".//div[text() = 'Follow']" )
        WebElement instaFollowButton;
    @FindBy(xpath =".//div[text() = 'Like']" )
        WebElement instaLikeButton;
    @FindBy(xpath =".//button[text() = 'Follow']" )
        WebElement instaFollow;
    @FindBy(xpath =".//span[text() = 'Like']" )
        WebElement instaLike;
    @FindBy(xpath =".//input[placeholder() = 'Username']" )
        WebElement instaLoginField;
    @FindBy(xpath =".//input[placeholder() = 'Password']" )
        WebElement instaPasswordField;

}
