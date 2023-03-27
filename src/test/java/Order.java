import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;


public class Order
{

    private final By DISCOUNT_CODE = By.id("discountCode");
    private final By FULL_NAME = By.id("fullName");
    private final By ADRESS1 = By.id("address1");
    private final By ADRESS2 = By.id("address2");
    private final By COUNTRY = By.id("country");
    private final By STATE = By.id("state");
    private final By CITY = By.id("city");
    private final By ZIP = By.id("zip");
    private final By PHONE = By.id("phone");
    private final By AGREE_CHECKBOX = By.xpath(".//input [contains(@type,'checkbox' )]");
    private final By PAY_BTN = By.xpath(".//button [contains(@class, 'border bg-indigo-500')]");
    private final By APPLY_BTN = By.xpath(".//button [contains(@class, 'border border-indigo-500')]");

    private WebDriver browser;
    private WebDriverWait wait;
    @Test
    public void testOrder()
    {

        WebDriver browser = new FirefoxDriver();
        browser.get("http://billing-qa-test.netlify.app/#/");
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser,Duration.ofSeconds(10));



        type(DISCOUNT_CODE,"TESTCODE5");
        browser.findElement(APPLY_BTN).click();

        type(FULL_NAME,"Edgars Peregudovs");
        type(ADRESS1,"Prusu street");
        type(ADRESS2,"Prūšu iela");
        type(COUNTRY,"Latvia");
        type(STATE,"Latvia");
        type(CITY,"Riga");
        type(ZIP,"LV-1057");
        type(PHONE,"+371 29772191");


        browser.findElement(AGREE_CHECKBOX).click();
        browser.findElement(PAY_BTN).click();

    }

    private void type (By locator,String text)
    {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);

    }

  
}
