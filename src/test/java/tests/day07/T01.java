package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01 extends TestBase {

    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on download
    Verify that 'QAProgram.png' file is downloaded
    */

    String url = "https://claruswaysda.github.io/downloadUpload.html";
    By downloadButton = By.xpath("//*[.='Download']"); // أو عدل حسب الـ locator الصحيح

    @Test
    void testFileDownload() throws InterruptedException, IOException {
        driver.get(url);
        String fileName = "QAProgram.png";

        driver.findElement(downloadButton).click();
        Thread.sleep(1000);

        //Verify if the file downloaded successfully

        Path path = Path.of(System.getProperty("user.home"),"Downloads",fileName);
        Assertions.assertTrue(Files.exists(path));
        Files.deleteIfExists(path);
    }
}

