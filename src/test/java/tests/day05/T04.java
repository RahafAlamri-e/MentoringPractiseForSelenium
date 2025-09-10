package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T04 extends TestBase {

//    Go to https://claruswaysda.github.io/addDeleteStar.html
//    Create a method to add given number of stars
//    Create a method to delete given numbers of stars
//    Create a method to verify the given number of stars deleted

    String url = "https://claruswaysda.github.io/addDeleteStar.html";

    By addStarButtonById = By.id("push-button");
    By deleteStarButtonById = By.id("delete-button");
    By starsByXpath = By.xpath("//div[@class='star']");

    // Method to add stars
    void addStars(int addNum) {
        WebElement addButton = driver.findElement(addStarButtonById);
        for (int i = 0; i < addNum; i++) {
            addButton.click();
        }
    }

    // Method to delete stars
    void deleteStars(int deleteNum) {
        WebElement deleteButton = driver.findElement(deleteStarButtonById);
        for (int i = 0; i < deleteNum; i++) {
            deleteButton.click();
        }
    }

    // Method to verify remaining stars
    void verifyStarsAfterDeleted(int expectedCount) {
        List<WebElement> stars = driver.findElements(starsByXpath);
        Assertions.assertEquals(expectedCount, stars.size());
    }

    @Test
    void testAddDeleteStars() {
        driver.get(url);
        int addnum =10;
        int deletnum1 = 2;
        int deletnum2 = 5;

        addStars(addnum);

        deleteStars(deletnum1);
        int expectednum = addnum - deletnum1;
        verifyStarsAfterDeleted(expectednum);

        deleteStars(deletnum2);
        expectednum = expectednum - deletnum2 ;
        verifyStarsAfterDeleted(expectednum);
    }
}
