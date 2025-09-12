package assignments.day07;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05 extends TestBase {

    /*
    Go to https://claruswaysda.github.io/form.html
    Create a method to flash the elements you are working on and use it.
    Register a user
    Login
    Celebrate the login!
    */

    String url = "https://claruswaysda.github.io/form.html";

    By ssnById = By.id("ssn");
    By firstNameById = By.id("first-name");
    By lastNameById = By.id("last-name");
    By addressById = By.id("address");
    By phoneNumberById = By.id("phone");
    By usernameById = By.id("username");
    By emailById = By.id("email");
    By passwordById = By.id("password");
    By confirmPasswordById = By.id("confirm-password");
    By registerButtonById = By.xpath("//button[@type='submit']");
    By loginButtonById = By.xpath("//button[@class='login-button']");
    By successMsgById = By.id("clickMeButton");

    public static void flash(WebElement element, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalColor = element.getCssValue("backgroundColor"); // get original color
        for (int i = 0; i < 5; i++) {  // number of flashes
            changeColor("yellow", element, js);  // highlight color
            changeColor(originalColor, element, js);  // back to original
        }
    }

    public static void changeColor(String color, WebElement element, JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(200);  // pause so flash is visible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void formHandlingWithJavaScriptExecutorTest() {
        driver.get(url);

        // Fill registration form
        Faker faker = new Faker();
        String username = faker.name().username();
        String pass = faker.internet().password();

        driver.findElement(ssnById).sendKeys(faker.idNumber().ssnValid());
        driver.findElement(firstNameById).sendKeys(faker.name().firstName());
        driver.findElement(lastNameById).sendKeys(faker.name().lastName());
        driver.findElement(addressById).sendKeys(faker.address().fullAddress());
        driver.findElement(phoneNumberById).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(usernameById).sendKeys(username);
        driver.findElement(emailById).sendKeys(faker.internet().emailAddress());
        driver.findElement(passwordById).sendKeys(pass);
        driver.findElement(confirmPasswordById).sendKeys(pass);

        WebElement registerBtn = driver.findElement(registerButtonById);
        flash(registerBtn, driver);
        registerBtn.click();

        WebElement loginBtn = driver.findElement(loginButtonById);
        flash(loginBtn, driver);
        loginBtn.click();

        driver.findElement(usernameById).sendKeys(username);
        driver.findElement(passwordById).sendKeys(pass);

        WebElement loginBtn2 = driver.findElement(registerButtonById);
        loginBtn2.click();

        // Verify success message
        WebElement successMsg = driver.findElement(successMsgById);
        flash(successMsg, driver);

        String actualMsg = successMsg.getText();
        Assertions.assertEquals("Celebrate Login", actualMsg);

    }
}
