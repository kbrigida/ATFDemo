package pagesMobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.GeneralPage;

import static junit.framework.Assert.fail;

/**
 * Created by kbrigida on 14.07.2017.
 */

public class CalculatorPage extends GeneralMobilePage {
    @FindBy(id = "com.android.calculator2:id/digit_1")
    public WebElement buttonOne;

    @FindBy(id = "com.android.calculator2:id/digit_2")
    public WebElement buttonTwo;

    @FindBy(id = "com.android.calculator2:id/digit_3")
    public WebElement buttonThree;

    @FindBy(id = "com.android.calculator2:id/digit_4")
    public WebElement buttonFour;

    @FindBy(id = "com.android.calculator2:id/op_add")
    public WebElement buttonAdd;

    @FindBy(id = "com.android.calculator2:id/op_mul")
    public WebElement buttonMultiply;

    @FindBy(id = "com.android.calculator2:id/op_sub")
    public WebElement buttonMinus;

    @FindBy(id = "com.android.calculator2:id/op_div")
    public WebElement buttonDivide;

    @FindBy(id = "com.android.calculator2:id/eq")
    public WebElement buttonEqual;

    @FindBy(id= "com.android.calculator2:id/result")
    public WebElement resultField;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void Add() {
        clickButton(buttonOne);
        clickButton(buttonAdd);
        clickButton(buttonFour);
    }
    public void Minus() {
        clickButton(buttonMinus);
        clickButton(buttonOne);
    }
    public void Multiply() {
        clickButton(buttonMultiply);
        clickButton(buttonFour);
    }
    public void Divide() {
        clickButton(buttonDivide);
        clickButton(buttonOne);
    }

    public void Calculate() {
        clickButton(buttonEqual);
    }

    public void CheckResult(String expectedResult) {
        Integer actualResult = Integer.parseInt(resultField.getText());
        Integer expectedIntResult = Integer.parseInt(expectedResult);
        if (expectedIntResult != actualResult)
            fail("Calculator Broken");

    }

}
