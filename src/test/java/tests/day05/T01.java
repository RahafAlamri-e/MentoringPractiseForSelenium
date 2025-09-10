package tests.day05;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


public class T01 extends TestBase {
/*
    Go to https://claruswaysda.github.io/ActionsForm.html
Fill the form
Generate Passcode
Use passcode to submit form
     */

    String url = "https://claruswaysda.github.io/ActionsForm.html";

    By nameById = By.id("name");
    By ageById = By.id("age");
    By selectOptionsByXpath = By.xpath("//select[@id='options']");
    By codingByXpath = By.xpath("//input[@value='coding']");
    By femaleByXpath = By.xpath("//input[@value='female']");
    By generateButtonByXpath = By.xpath("//button[@type='button']");

    @Test
    void fillFormAndSubmitWithPasscode() throws InterruptedException {

        driver.get(url);

        // Fill text fields
        driver.findElement(nameById).sendKeys("Zahra");
        driver.findElement(ageById).sendKeys("23");

        Select select = new   Select(driver.findElement(selectOptionsByXpath));
        select.selectByValue("it");

        driver.findElement(codingByXpath).click();
        driver.findElement(femaleByXpath).click();
        driver.findElement(generateButtonByXpath).click();

        String alertPassword = driver.switchTo().alert().getText();
        System.out.println("password = " + alertPassword);


        String password = alertPassword.substring(alertPassword.indexOf(":") + 1).trim();
        System.out.println("Extracted password = " + password);
        driver.switchTo().alert().accept();


        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(password);
        prompt.accept();

        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();

    }
}
