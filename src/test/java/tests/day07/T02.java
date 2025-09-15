package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.nio.file.Path;
import java.time.Duration;

public class T02 extends TestBase {

    String url = "https://claruswaysda.github.io/downloadUpload.html";
    By singleUploadInput = By.id("uploadInput");
    By multipleUploadInput = By.id("multiUploadInput");
    By submitButton = By.className("submit-btn");
    By successBox = By.id("successBox");
    By alertBox = By.id("alertBox");

    WebDriverWait wait;

    @Test
    void test1() {
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Path pdfFile = Path.of(System.getProperty("user.home"), "Downloads", "sample.pdf");
        driver.findElement(singleUploadInput).sendKeys(pdfFile.toString());
        driver.findElement(submitButton).click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successBox));
        Assertions.assertTrue(successMsg.isDisplayed());
    }

    @Test
    void test2() {
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Path pngFile = Path.of(System.getProperty("user.home"), "Downloads", "Screenshot (1).png");
        driver.findElement(singleUploadInput).sendKeys(pngFile.toString());
        driver.findElement(submitButton).click();

        WebElement alertMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(alertBox));
        Assertions.assertTrue(alertMsg.isDisplayed());
    }

    @Test
    void test3() {
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Path pdf1 = Path.of(System.getProperty("user.home"), "Downloads", "sample.pdf");
        Path pdf2 = Path.of(System.getProperty("user.home"), "Downloads", "prestige.pdf");

        driver.findElement(multipleUploadInput).sendKeys(pdf1.toString() + "\n" + pdf2.toString());
        driver.findElement(submitButton).click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successBox));
        Assertions.assertTrue(successMsg.isDisplayed());
    }
}
