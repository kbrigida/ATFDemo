package pagesMobile;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by kbrigida on 14.07.2017.
 */

public class GeneralMobilePage {
    AndroidDriver driver;

    public GeneralMobilePage(AndroidDriver driver) {
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

    public int getWidthSize(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        return elem.getSize().getWidth();
    }

    public int getHeightSize(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        return elem.getSize().getHeight();
    }
    public void scrollTo(WebElement webElement){
        Integer topY = webElement.getLocation().getY();
        Integer bottomY = topY + webElement.getSize().getHeight()-400;
        Integer centerX = webElement.getLocation().getX() + (webElement.getSize().getWidth()/2);
        driver.swipe(centerX, topY, centerX, bottomY, 100);
    }

}
