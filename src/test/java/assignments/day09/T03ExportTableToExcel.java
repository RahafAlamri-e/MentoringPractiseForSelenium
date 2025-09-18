package assignments.day09;

import utilities.TestBase2;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T03ExportTableToExcel extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    void test() throws IOException {

        driver.get("https://claruswaysda.github.io/webTable.html");


        WebElement table1 = driver.findElement(By.xpath("//table[1]"));

        List<WebElement> rows = table1.findElements(By.tagName("tr"));

        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("Table1");

        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//th|.//td"));

            for (int j = 0; j < cells.size(); j++) {
                Cell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(cells.get(j).getText());
            }
        }

        FileOutputStream fos = new FileOutputStream(Path.of(".", "resources","Table1.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Table 1 exported successfully to Excel!");
    }

}
