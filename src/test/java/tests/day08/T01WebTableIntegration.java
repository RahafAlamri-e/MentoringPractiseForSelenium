package tests.day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;


public class T01WebTableIntegration extends TestBase {

    /*
    Objective: Go to https://claruswaysda.github.io/addRecordWebTable.html and add 10 records to the
    table by taking data (Name, Age, Country) from Excel.
     */
    String url = "https://claruswaysda.github.io/addRecordWebTable.html";

    @Test
    void test() throws IOException {
        driver.get(url);


        FileInputStream fis = new FileInputStream(Path.of(".","resources","Task01.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 1; i <= 10; i++) {
            Row row = sheet.getRow(i);
            String name = row.getCell(0).toString();
            int age = (int) row.getCell(1).getNumericCellValue();
            String country = row.getCell(2).toString();

            WebElement nameBox =driver.findElement(By.id("nameInput"));
            WebElement ageBox = driver.findElement(By.id("ageInput"));
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addRecord()']"));

            nameBox.clear();
            nameBox.sendKeys(name);

            ageBox.clear();
            ageBox.sendKeys(String.valueOf(age));

            Select select = new Select(countryDropdown);
            select.selectByVisibleText(country);

            addButton.click();
        }

        workbook.close();
        fis.close();
    }
}
