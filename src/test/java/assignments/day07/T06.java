package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class T06 extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Dropdowns.html
    In 1. Traditional Dropdown select 'Ford'
    In 2. Multi-Select Dropdown select 'Mercedes'
    In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
    In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
    In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
    */

    String url = "https://claruswaysda.github.io/Dropdowns.html";

    By traditionalDropdownById = By.id("carSelect");
    By multiSelectDropdownById = By.id("multiCarSelect");
    By customDropdownButtonById =  By.id("customDropdown");
    By customDropdownOptionsByXpath =By.xpath("//div[@id='customList']//div[contains(text(),'BMW')]");
    By staticAutoSuggestById = By.id("staticInput");
    By dynamicAutoSuggestById = By.id("dynamicInput");
    By dynamicAutoSuggestOptionsById = By.id("dynamicSuggestions");
    By staticAutoSuggestOptionsByCss = By.cssSelector("#staticSuggestions .suggestion-item");


    @Test
    public void dropdownHandlingTest() {
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 1. Traditional Dropdown -> Ford
        Select select = new Select(driver.findElement(traditionalDropdownById));
        select.selectByVisibleText("Ford");
        Assertions.assertEquals("Ford", select.getFirstSelectedOption().getText());

        // 2. Multi-Select Dropdown -> Mercedes
        Select multiSelect = new Select(driver.findElement(multiSelectDropdownById));
        multiSelect.selectByVisibleText("Mercedes");
        boolean isMercedesSelected = false;
        for (WebElement option : multiSelect.getAllSelectedOptions()) {
            if (option.getText().equals("Mercedes")) {
                isMercedesSelected = true;
                break;
            }
        }
        Assertions.assertTrue(isMercedesSelected);

        // 3. Custom Dropdown -> BMW
        driver.findElement(customDropdownButtonById).click();
        driver.findElement(customDropdownOptionsByXpath).click();
        Assertions.assertEquals("BMW", driver.findElement(customDropdownButtonById).getText());

        // 4. Static Auto-Suggest Dropdown -> Tesla Model 3
        WebElement staticInput = driver.findElement(staticAutoSuggestById);
        staticInput.sendKeys("Tes");
        List<WebElement> staticOptions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(staticAutoSuggestOptionsByCss));
        for (WebElement option : staticOptions) {
            if (option.getText().equals("Tesla Model 3")) {
                option.click();
                break;
            }
        }
        Assertions.assertEquals("Tesla Model 3", staticInput.getAttribute("value"));

        // 5. Dynamic Auto-Suggest Dropdown -> Toyota
        WebElement dynamicInput = driver.findElement(dynamicAutoSuggestById);
        dynamicInput.sendKeys("ta");
        List<WebElement> dynamicOptions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dynamicAutoSuggestOptionsById)
        );
        boolean isToyotaSelected = false;
        for (WebElement option : dynamicOptions) {
            if (option.getText().equals("Toyota")) {
                option.click();
                isToyotaSelected = true;
                break;
            }
        }
        Assertions.assertTrue(isToyotaSelected);
    }
}
