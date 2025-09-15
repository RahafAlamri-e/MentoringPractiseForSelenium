package tests.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T01JavaScriptExecutor extends TestBase {
    /*
    Go to https://claruswaysda.github.io/signIn.html
    enter username 'admin'
    enter password '123'
    Click on Sign In
    Assert the 'Employee Table' is visible
    Create a method to change border color and style of web elements.
    Use the method on each element you interact with.
    */

    By usernameById = By.id("username");
    By passwordById = By.id("password");
    By clickButtonByXpath = By.xpath("//input[@type=\"submit\"]");
    By employTableByTagName = By.tagName("table");

    String username = "admin";
    String pass = "123";


    @Test
    void test() throws InterruptedException{
        driver.get("https://claruswaysda.github.io/signIn.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement usernameField = driver.findElement(usernameById);
        flashElement(usernameField);
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(passwordById);
        flashElement(passwordField);
        passwordField.sendKeys(pass);

        WebElement signInButton = driver.findElement(clickButtonByXpath);
        flashElement(signInButton);
        signInButton.click();

        WebElement employeeTable = wait.until(ExpectedConditions.visibilityOfElementLocated(employTableByTagName));
        flashElement(employeeTable);
        Assertions.assertTrue(employeeTable.isDisplayed());
    }

    private void flashElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 4; i++) {
            js.executeScript("arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='blue';", element);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw e;
            }

        }
    }

    }

