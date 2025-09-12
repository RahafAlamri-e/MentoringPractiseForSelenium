package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T01 extends TestBase {

    /*
    Go to https://claruswaysda.github.io/
    Click on Window Handle
    Click on 'Open Index Page'
    Verify the link 'https://claruswaysda.github.io/index.html'
    */

    String url = "https://claruswaysda.github.io/";
    By windowHandleByXpath = By.xpath("//a[@href=\"#\"]");
    By openIndexPageById= By.id("openIndex");


    @Test
    void windowHandleTest() {
        driver.get(url);

        driver.findElement(windowHandleByXpath).click();
        String firstHandle = driver.getWindowHandle();

        // Switch to new window
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Now we are in the new window, click "Open Index Page"
        driver.findElement(openIndexPageById).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getWindowHandles().size() > 2);

        String handle1 = driver.getWindowHandle();
        // Switch to the "Index Page" tab
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstHandle) && !handle.equals(handle1)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://claruswaysda.github.io/index.html", actualUrl);

    }


}
