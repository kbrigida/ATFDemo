
package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;

import java.util.Set;

/**
 * Created by Lynx on 10.11.2016.
 */
public class LoginTest {

    protected WebDriver driver;
    public LoginPage lPage;

    public LoginTest() {
        this.driver = Hooks.driver;
    }
    @Given("^User opens login page$")
    public void userOpensLoginPage() throws Throwable {
        lPage = new LoginPage(driver);
        lPage.isPageOpened();
    }
    @When("User clicks login$")
    public void loginStart() throws Throwable {
        lPage.clickLogin();
    }

    @And("^Login is \"([^\"]*)\"$")
    public void loginIs(String login) throws Throwable {
        lPage.fillLogin(login);
    }
    @And("^Password is \"([^\"]*)\"$")
    public void passwordIs(String password) throws Throwable {
        lPage.fillPassword(password);
    }

    @And("^User submit form$")
    public void userSubmitForm() throws Throwable {
        lPage.clickSubmitLogin();
    }

    @And("^Clicks logout$")
    public void clicksLogout() throws Throwable {
        lPage.clickLogout();
    }
}