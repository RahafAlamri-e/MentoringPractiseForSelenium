package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T03 extends TestBase {

    /*
    Go to https://claruswaysda.github.io/dragAndDrop.html
    Drag the items in their right places
    Assert the success message
    */

    String url = "https://claruswaysda.github.io/dragAndDrop.html";
    By dragItem1ById = By.id("piece1");
    By dragItem2ById = By.id("piece2");
    By dragItem3ById = By.id("piece3");
    By dropItem1ById = By.id("slot1");
    By dropItem2ById = By.id("slot2");
    By dropItem3ById = By.id("slot3");
    By successMsgById = By.id("celebrate");

    @Test
    void dragAndDropTest(){
        driver.get(url);

        Actions actions = new Actions(driver);

        WebElement piece1 = driver.findElement(dragItem1ById);
        WebElement piece2 = driver.findElement(dragItem2ById);
        WebElement piece3 = driver.findElement(dragItem3ById);

        WebElement slot1 = driver.findElement(dropItem1ById);
        WebElement slot2 = driver.findElement(dropItem2ById);
        WebElement slot3 = driver.findElement(dropItem3ById);

        actions.dragAndDrop(piece1, slot1).perform();
        actions.dragAndDrop(piece2, slot2).perform();
        actions.dragAndDrop(piece3, slot3).perform();

        String actualMsg = driver.findElement(successMsgById).getText();
        Assertions.assertEquals("Congratulations!", actualMsg);

    }
}
