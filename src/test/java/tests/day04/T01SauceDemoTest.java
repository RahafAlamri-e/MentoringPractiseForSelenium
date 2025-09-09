package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class T01SauceDemoTest {

WebDriver driver;
String url = "https://www.saucedemo.com/";

String username = "standard_user";
String password = "secret_sauce";
String visibleText = "Price (low to high)";

By usernameById = By.id("user-name");
By passwordById = By.id("password");
By loginButtonById = By.id("login-button");
By DropDownByCss = By.cssSelector(".product_sort_container");
By priceByXpath = By.xpath("//div[@class='inventory_item_price']");

    @Test
    void test(){
//    Given: Go to https://www.saucedemo.com/
        driver.get(url);
//    When: Enter username as "standard user"
        driver.findElement(usernameById).sendKeys(username);

//    And: Enter password as "secret sauce"
        driver.findElement(passwordById).sendKeys(password);

//    And: Click login button
        driver.findElement(loginButtonById).click();

//    And: Order products by "Price (low to high)"
        Select select = new Select(driver.findElement(DropDownByCss));
        select.selectByVisibleText(visibleText);

//    Then: Assert last product costs $49.99, first product costs $7.99
        List<WebElement> pricesList = driver.findElements(priceByXpath);
        Assertions.assertEquals("$7.99", pricesList.get(0).getText());
//        Assertions.assertEquals("$7.99", pricesList.getFirst().getText());
        Assertions.assertEquals("$49.99", pricesList.get(pricesList.size()-1).getText());
//        Assertions.assertEquals("$49.99", pricesList.getLast().getText());

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
