package day12_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_EnableTest extends TestBase {
    @Test
    public void EnableTesti01() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());


        WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
                                wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        WebElement itsEnableYaziElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnableYaziElementi.isDisplayed());

        Assert.assertTrue(enableKutusu.isEnabled());
        
        
        
    }

}
