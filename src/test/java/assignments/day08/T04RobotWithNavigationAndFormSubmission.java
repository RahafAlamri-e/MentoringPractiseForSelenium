package assignments.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class T04RobotWithNavigationAndFormSubmission extends TestBase {

    /*
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */


    String url = "https://the-internet.herokuapp.com/login";
    By usernameById = By.id("username");
    By passwordById = By.id("password");
    By flashById = By.id("flash");

    @Test
    void test() throws AWTException{
        driver.get(url);


        WebElement usernameField = driver.findElement(usernameById);
        usernameField.click();
        usernameField.sendKeys("tomsmith");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Type password with sendKeys (element is focused now)
        WebElement passwordField = driver.findElement(passwordById);
        passwordField.sendKeys("SuperSecretPassword!");

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        // Enter -> Submit
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Verify login success
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement flashMessageEl = wait.until(ExpectedConditions.visibilityOfElementLocated(flashById));

        String flashMessage = flashMessageEl.getText();
        System.out.println("Flash message: " + flashMessage);
        Assertions.assertTrue(flashMessage.contains("You logged into a secure area!"));
    }

}
