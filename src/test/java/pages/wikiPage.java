package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kbrigida on 11.07.2017.
 */
public class wikiPage extends GeneralPage {
    String wikiUrl = "https://en.wikipedia.org";
    @FindBy (id = "searchInput")
    WebElement wikiSearch;
    @FindBy (xpath = ".//span[text() = 'Iberian lynx']")
    WebElement LynxLink;
    @FindBy (xpath = ".//li[@class='interlanguage-link interwiki-vi']/a")
    WebElement changeToVietnamese;
    @FindBy (id = "searchButton")
    WebElement searchButton;


    public wikiPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() throws InterruptedException {
        driver.navigate().to(wikiUrl);
        // Assert.assertTrue("Wrong page opened", driver.getTitle().startsWith("EIS Core Insurance Software"));
    }

    public void fillSearch(String searchString){
        waitElementLoad(wikiSearch);
        fillField(searchString, wikiSearch);
    }

    public void startSearch(){
        clickButton(searchButton);
    }

    public void changePageIberianLynx(){
        waitElementLoad(LynxLink);
        clickButton(LynxLink);
    }

    public void changeLanguage(){
        PageFactory.initElements(driver, this);
        clickButton(changeToVietnamese);
    }
}
