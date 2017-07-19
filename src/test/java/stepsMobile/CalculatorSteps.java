package stepsMobile;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagesMobile.CalculatorPage;
import steps.Hooks;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

/**
 * Created by kbrigida on 18.07.2017.
 */
public class CalculatorSteps {
    protected WebDriver driver;
    public CalculatorPage lPage;

    public CalculatorSteps() {
        this.driver = HooksMobile.driver;
    }


    @Given("^User add \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userAddTo(String arg0, String arg1) throws Throwable {
        lPage = new CalculatorPage(driver);
        lPage.Add();
    }

    @When("^User subtracts from result \"([^\"]*)\"$")
    public void userSubtractsFromResult(String arg0) throws Throwable {
        lPage.Minus();
    }

    @And("^User multiply result in \"([^\"]*)\" times$")
    public void userMultiplyResultInTimes(String arg0) throws Throwable {
        lPage.Multiply();
    }

    @And("^User divides result on \"([^\"]*)\"$")
    public void userDividesResultOn(String arg0) throws Throwable {
        lPage.Divide();
    }

    @And("^User check result$")
    public void userCheckResult() throws Throwable {
        lPage.CheckResult("1");
    }
}
