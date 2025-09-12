package assignments.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T04 extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Draw.html
    Draw a triangle
    Reset
    */

    String url = "https://claruswaysda.github.io/Draw.html";
    By canvasById = By.id("myCanvas");
    By resetButtonById = By.id("resetButton");

    @Test
    void drawingTest(){
        driver.get(url);

        WebElement canvas = driver.findElement(canvasById);

        Actions actions = new Actions(driver);
        actions.moveToElement(canvas, 50, 50)
                .clickAndHold()
                .moveByOffset(100, 0)
                .moveByOffset(-50, -100)
                .moveByOffset(-50, 100)
                .release()
                .perform();

        driver.findElement(resetButtonById).click();
    }

}
