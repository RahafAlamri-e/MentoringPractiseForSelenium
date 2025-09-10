package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T03 extends TestBase {
/*
Go to https://claruswaysda.github.io/deleteChars.html
Enter your full name
click delete until msg deleted appeare
Verify the message 'Deleted'
*/

    String url = "https://claruswaysda.github.io/deleteChars.html";

    By nameById = By.id("inputText");
    By enterButtonById = By.id("enterButton");
    By deleteButtonById = By.id("deleteButton");
    By messageById = By.id("deletedMessage");

    @Test
    void test() {
        driver.get(url);

        // Enter full name
        driver.findElement(nameById).sendKeys("Rahaf");
        WebElement deleteButton = driver.findElement(deleteButtonById);

        // Click delete button until message appears
        WebElement enterButton = driver.findElement(enterButtonById);
        enterButton.click();

        while (driver.findElement(messageById).getText().isEmpty()) {
            deleteButton.click();
        }

        // Verify the message 'Deleted'
        String actualMsg = driver.findElement(messageById).getText();
        Assertions.assertEquals("Deleted", actualMsg, "Message is not correct!");

    }
}
