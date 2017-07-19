package pagesMobile;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by kbrigida on 14.07.2017.
 */

public class GeneralMobilePage {
    WebDriver driver;

    public GeneralMobilePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButton(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    public void fillField(String fieldValue, WebElement elem){
        elem.clear();
        elem.sendKeys(fieldValue);
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
    }
}
