package tests.day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;

import java.util.List;

public class T01AddRecordsAndStoreData extends TestBase2 {
    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records.
    Store the name, age, and country columns in separate arrays (not ArrayList).
    */

    @Test
    void test(){
        //Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("claruswaysda web site is opened.... ");

        //Add 10 records
        logger.info("Adding 10 records to the site");

        for (int i = 0 ; i<10 ; i++) {

            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), String.valueOf(Faker.instance().number().numberBetween(18,50)));
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int index = Faker.instance().number().numberBetween(1,5);

            try {
                select.selectByIndex(index);
                logger.info("country is selected with index...");
            } catch (Exception e) {
                logger.error("couldn't select with index :"+ index);
            }

            actionHelper.click(By.xpath("//button[@onclick='addRecord()']"));

        }

        List<WebElement> nameList = driver.findElements(By.xpath("//table//tr/td[1]"));
        List<WebElement> ageList = driver.findElements(By.xpath("//table//tr/td[2]"));
        List<WebElement> countryList = driver.findElements(By.xpath("//table//tr/td[3]"));

        int rowCount = nameList.size();
        String[] namesArr = new String[rowCount];
        int[] agesArr = new int[rowCount];
        String[] countriesArr = new String[rowCount];

        for (int i = 0; i < rowCount; i++) {
            namesArr[i] = nameList.get(i).getText();
            agesArr[i] = Integer.parseInt(ageList.get(i).getText());
            countriesArr[i] = countryList.get(i).getText();
            System.out.println(namesArr[i] + " || " + agesArr[i] + " || " + countriesArr[i]);
        }


    }

}
