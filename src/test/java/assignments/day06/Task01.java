package assignments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task01 extends TestBase {

//    Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
//    Maximize the website
//    Click on the second emoji
//    Click on all second emoji items
//    Return to the parent iframe
//    Fill out the form and press the apply button

    String url = "https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/";
    By secondEmojiByXpath = By.xpath("//div[@class=\"mdl-tabs__tab-bar\"]//a[2]");
    By textById = By.id("text");
    By smilesById = By.id("smiles");
    By natureById = By.id("nature");
    By foodById = By.id("food");
    By activitiesById = By.id("activities");
    By placesById = By.id("places");
    By objectsById = By.id("objects");
    By symbolsById = By.id("symbols");
    By flagsById = By.id("flags");
    By applyButtonById = By.id("send");


    @Test
    void test(){
        driver.get(url);
        driver.manage().window().maximize();

        driver.switchTo().frame("emoojis");

        WebElement secondEmoji = driver.findElement(secondEmojiByXpath);
        secondEmoji.click();

        List<WebElement> secondEmojiItems = driver.findElements(By.xpath("//div[@id='nature']//div/img"));
        for (WebElement emoji : secondEmojiItems){
            emoji.click();
        }

        driver.switchTo().parentFrame();

        driver.findElement(textById).sendKeys("Rahaf");
        driver.findElement(smilesById).sendKeys("Happy");
        driver.findElement(natureById).sendKeys("Tree");
        driver.findElement(foodById).sendKeys("Pizza");
        driver.findElement(activitiesById).sendKeys("Football");
        driver.findElement(placesById).sendKeys("Paris");
        driver.findElement(objectsById).sendKeys("Laptop");
        driver.findElement(symbolsById).sendKeys("Heart");
        driver.findElement(flagsById).sendKeys("KSA");

        driver.findElement(applyButtonById).click();


    }


}
