package assignments.day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;

import java.util.List;

public class T04FindYoungestRecord extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records using Faker.
    Find the name of the youngest record.
    */


    @Test
    void test() {
        // Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("claruswaysda web site is opened.... ");

        // Add 10 records using Faker.
        logger.info("Adding 10 records to the site");

        for (int i = 0; i < 10; i++) {

            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), String.valueOf(Faker.instance().number().numberBetween(18, 50)));
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int index = Faker.instance().number().numberBetween(1, 5);

            try {
                select.selectByIndex(index);
                logger.info("country is selected with index...");
            } catch (Exception e) {
                logger.error("couldn't select with index :" + index);
            }

            actionHelper.click(By.xpath("//button[@onclick='addRecord()']"));

        }

        // Find the name of the youngest record.
        List<WebElement> nameList = driver.findElements(By.xpath("//table//tr/td[1]"));
        List<WebElement> ageList = driver.findElements(By.xpath("//table//tr/td[2]"));

        int youngestAge = Integer.parseInt(ageList.get(0).getText());
        String youngestName = nameList.get(0).getText();

        for (int j = 1; j < ageList.size(); j++) {
            int age = Integer.parseInt(ageList.get(j).getText());
            if (age < youngestAge) {
                youngestAge = age;
                youngestName = nameList.get(j).getText();
            }
        }

        System.out.println("Youngest record is: " + youngestName + " || Age is: " + youngestAge);

        }


    }



