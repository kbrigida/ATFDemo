package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lynx on 06.11.2016.
 */
public class LoginPage extends GeneralPage {
    String loginUrl = "http://addmefast.com/";
    String redirectUrl = "http://addmefast.com/welcome";
    @FindBy (name = "email")
            WebElement loginFieldLocator;
    @FindBy (name = "password")
            WebElement passwordFieldLocator;
    @FindBy (name = "login_button")
            WebElement submitButtonLocator;
    @FindBy (name = "login_button")
            WebElement loginButtonLocator;
    @FindBy (name = ".//a[text() = 'Logout']")
            WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        driver.navigate().to(loginUrl);
       // Assert.assertTrue("Wrong page opened", driver.getTitle().startsWith("EIS Core Insurance Software"));
    }
    public void clickLogin() {
        PageFactory.initElements(driver, this);
        clickButton(loginButtonLocator);
    }

    public void fillLogin(String login) {
        PageFactory.initElements(driver, this);
        fillField(login, loginFieldLocator);
    }

    public void fillPassword(String password) {
        fillField(password, passwordFieldLocator);
    }

    public void clickSubmitLogin() {
        clickButton(submitButtonLocator);
    }

    public void clickLogout() {
        pageRedirect(redirectUrl);
    }




}