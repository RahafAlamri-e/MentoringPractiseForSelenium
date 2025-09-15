package tests.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02RobotForKeyboardActions extends TestBase {


    String url = "https://claruswaysda.github.io/downloadUpload.html";
    By uploadButtonByXpath = By.xpath("//label[normalize-space()='Upload']");

    @Test
    void uploadAndCloseTab() throws AWTException, InterruptedException {


        // Go to page
        driver.get(url);

        // Click on Upload
        driver.findElement(uploadButtonByXpath).click();

        // Short wait to make sure new tab opened
        Thread.sleep(2000);

        // Use Robot to press CTRL+F4 and close new tab
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(1000);
        }

}
