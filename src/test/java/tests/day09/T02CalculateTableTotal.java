package tests.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;

public class T02CalculateTableTotal extends TestBase2 {
    /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
    */

    @Test
    void test(){
        //Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");

        //Calculate and assert the total price in Table 2.
        List<WebElement> priceList = driver.findElements(By.xpath("//table[2]//tr/td[3]"));

        int total = 0;
        for (WebElement price : priceList) {
            String priceText = price.getText().substring(1);
            int priceNum = Integer.parseInt(priceText);
            total += priceNum;
        }


            Assertions.assertEquals(2275, total);

    }
}
