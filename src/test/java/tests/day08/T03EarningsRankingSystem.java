package tests.day08;

import org.junit.jupiter.api.Assertions;
import utilities.TestBase;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class T03EarningsRankingSystem extends TestBase {

    /*
    Given: Save EarningList.xlsx file into your project
    When: In the row column, write the row numbers according to the earnings amount (Natural Order -
    lowest to highest).
    Then: Assert that row number of Wednesday is 1
     */

    @Test
    void testEarningsRowOrder() throws IOException {
        String path = Path.of(".", "resources", "EarningsTask.xlsx").toString();

        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

        Sheet sheet = workbook.getSheetAt(0);

        ArrayList<Integer> earningsList = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int earnings = (int) row.getCell(1).getNumericCellValue();
            earningsList.add(earnings);
        }

        Collections.sort(earningsList);

        int wednesdayRow = 0;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int earnings = (int) row.getCell(1).getNumericCellValue();

            int order = earningsList.indexOf(earnings) + 1;
            row.getCell(2).setCellValue(order);

            if (row.getCell(0).getStringCellValue().equals("Wednesday")) {
                wednesdayRow = order;
            }
        }

        Assertions.assertEquals(1, wednesdayRow);

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}
