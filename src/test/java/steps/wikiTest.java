package steps;



import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.wikiPage;


/**
 * Created by kbrigida on 11.07.2017.
 */

public class wikiTest {

    protected WebDriver driver;
    public wikiPage lPage;

    public wikiTest() {
        this.driver = Hooks.driver;
    }



    @Given("^User opens wiki$")
    public void userOpensWiki() throws Throwable {
        lPage = new wikiPage(driver);
        lPage.goToPage();
    }

    @When("^User fill \"([^\"]*)\" in search$")
    public void userFillInSearch(String search) throws Throwable {
        lPage.fillSearch(search);
    }

    @And("^User clicks search$")
    public void userClicksSearch() throws Throwable {
        lPage.startSearch();
    }

    @And("^User move to Iberian lynx$")
    public void userMoveToIberianLynx() throws Throwable {
        lPage.changePageIberianLynx();
    }

    @And("^User change language$")
    public void userChangeLanguage() throws Throwable {
        lPage.changeLanguage();
    }

}

