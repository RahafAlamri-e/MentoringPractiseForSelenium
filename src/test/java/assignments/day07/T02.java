package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T02 extends TestBase {

    /*
    Go to https://claruswaysda.github.io/submit-button.html
    Click on submit
    Verify link contains 'actionsClickDrag'
    Drag 'Drag me' to 'Drop here'
    Right-click on 'Right-click' me
    Double-click on 'Double-click me'
    Hover on 'Hover over me'
    Verify all actions' success messages.
    */

    String url = "https://claruswaysda.github.io/submit-button.html";

    By submitById = By.id("submitButton");
    By dragById = By.id("drag1");
    By dropById = By.id("drop1");
    By rightClickById = By.id("showSuccessButton");
    By doubleClickById = By.id("doubleClickButton");
    By hoverById = By.id("hoverButton");
    By dragSuccessMessageById = By.id("dragSuccessMessage");
    By rightClickSuccessMessageById = By.id("rightClickSuccessMessage");
    By doubleClickSuccessMessageById = By.id("doubleClickSuccessMessage");
    By hoverSuccessMessageById = By.id("hoverSuccessMessage");



    @Test
    void actionsClassTest(){
        driver.get(url);

        driver.findElement(submitById).click();
        String firstHandle = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String url2 = driver.getCurrentUrl();
        Assertions.assertTrue(url2.contains("actionsClickDrag"));

        WebElement drag = driver.findElement(dragById);
        WebElement drop = driver.findElement(dropById);

        Actions actions = new Actions(driver);

        Action dragAndDrop = actions.dragAndDrop(drag, drop).build();
        Action rightClick = actions.contextClick(driver.findElement(rightClickById)).build();
        Action doubleClick = actions.doubleClick(driver.findElement(doubleClickById)).build();
        Action hover = actions.doubleClick(driver.findElement(hoverById)).build();

       dragAndDrop.perform();
       Assertions.assertTrue(driver.findElement(dragSuccessMessageById).isDisplayed());

        rightClick.perform();
        Assertions.assertTrue(driver.findElement(rightClickSuccessMessageById).isDisplayed());

        doubleClick.perform();
        Assertions.assertTrue(driver.findElement(doubleClickSuccessMessageById).isDisplayed());

        hover.perform();
        Assertions.assertTrue(driver.findElement(hoverSuccessMessageById).isDisplayed());

    }

}
