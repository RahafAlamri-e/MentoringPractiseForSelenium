package tests.day07;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBase;
import utilities.JavaScriptUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03 extends TestBase {

    String url = "https://claruswaysda.github.io/homepage.html";

    By registerByXpath = By.xpath("//a[1]");
    By ssnById = By.id("ssn");
    By firstNameById = By.id("first-name");
    By lastNameById = By.id("last-name");
    By addressById = By.id("address");
    By phoneById = By.id("phone");
    By usernameById = By.id("username");
    By emailById = By.id("email");
    By passwordById = By.id("password");
    By confirmPasswordById = By.id("confirm-password");
    By registerBtnByXpath = By.xpath("//button[@type='submit']");
    By loginBtnByXpath = By.xpath("//button[@class='login-button']");
    By celebrateBtnById = By.id("clickMeButton");

    @Test
    void testUserRegistrationAndScreenshots() throws IOException, InterruptedException {
        driver.get(url);

        Faker faker = new Faker();

        String ssn = faker.idNumber().ssnValid();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().fullAddress();
        String phone = faker.phoneNumber().cellPhone();
        String username = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();


        // Register
        driver.findElement(By.className("fa-regular")).click();
        driver.findElement(registerByXpath).click();
        driver.findElement(ssnById).sendKeys(ssn);
        driver.findElement(firstNameById).sendKeys(firstName);
        driver.findElement(lastNameById).sendKeys(lastName);
        driver.findElement(addressById).sendKeys(address);
        driver.findElement(phoneById).sendKeys(phone);
        driver.findElement(usernameById).sendKeys(username);
        driver.findElement(emailById).sendKeys(email);
        driver.findElement(passwordById).sendKeys(password);
        driver.findElement(confirmPasswordById).sendKeys(password);
        driver.findElement(registerBtnByXpath).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

        File screenShot = ts.getScreenshotAs(OutputType.FILE);
        Path path1 = Path.of(System.getProperty("user.dir"), "target", "screenshots", "RegistrationPage_" + timeStamp + ".png");
        FileUtils.copyFile(screenShot, path1.toFile());

        // Login
        driver.findElement(loginBtnByXpath).click();
        driver.findElement(usernameById).sendKeys(username);
        driver.findElement(passwordById).sendKeys(password);

        File screenShot2 = ts.getScreenshotAs(OutputType.FILE);
        Path path2 = Path.of(System.getProperty("user.dir"), "target", "screenshots", "LoginPage_" + timeStamp + ".png");
        FileUtils.copyFile(screenShot2, path2.toFile());

        driver.findElement(registerBtnByXpath).click();


        // Celebrate Button
        WebElement celebrateBtn = driver.findElement(celebrateBtnById);
        JavaScriptUtils.highlightElement(driver, celebrateBtn);
        Assertions.assertTrue(celebrateBtn.isDisplayed());

        File screenShot3 = celebrateBtn.getScreenshotAs(OutputType.FILE);
        Path path3 = Path.of(System.getProperty("user.dir"), "target", "screenshots", "CelebrateButton_" + timeStamp + ".png");
        FileUtils.copyFile(screenShot3, path3.toFile());

        // Confetti Page
        celebrateBtn.click();
        Thread.sleep(2000);

        File screenShot4 = ts.getScreenshotAs(OutputType.FILE);
        Path path4 = Path.of(System.getProperty("user.dir"), "target", "screenshots", "ConfettiPage_" + timeStamp + ".png");
        FileUtils.copyFile(screenShot4, path4.toFile());
    }

}

