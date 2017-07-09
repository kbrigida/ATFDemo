package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lynx on 06.11.2016.
 */
public class GeneralPage{
    WebDriver driver;

    public GeneralPage(WebDriver driver) {this.driver=driver;}

    public void fillField(String fieldValue, WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertNotNull("field not found", elem);
        elem.clear();
        elem.sendKeys(fieldValue);
    }
    public void clickButton(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertNotNull("button not found", elem);
        elem.click();
    }

    public void pageRedirect(String url){
        Assert.assertTrue(url+"Not Opened", driver.getCurrentUrl().startsWith(url));
    }

    public void checkTextOnPage(String text){
        Assert.assertNotNull(text+"Doesn't exist on this page", driver.getPageSource().contains(text));
    }

    public boolean checkElementExist(WebElement elem) {
        try {
            elem.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitElementLoad(WebElement elem){
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }
    public void waitElementVisible(WebElement elem){
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

}