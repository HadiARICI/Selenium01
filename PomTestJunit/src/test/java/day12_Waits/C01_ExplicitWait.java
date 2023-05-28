package day12_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // remove locate edelim
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement istGoneYaziElementi=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        Assert.assertTrue(istGoneYaziElementi.isDisplayed());

        WebElement addButtonElementi= driver.findElement(By.xpath("//button[text()='Add']"));
        addButtonElementi.click();


        WebElement istBackYaziElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(istBackYaziElementi.isDisplayed());


    }

    @Test
    public void explicitlwaitTesti() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // remove locate edelim
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement istGoneYaziElementi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(istGoneYaziElementi));
        */
        WebElement istGoneYaziElementi= wait.until(ExpectedConditions
                                                 .visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(istGoneYaziElementi.isDisplayed());

        /* yazının gorunur olmasini  beklerken yazinin  locatenin kullanmak sorun oluşturur.
        çünkü henuz görünmeyen bir yazının locate edilmesi d emümkün olmayabilir.
        HTML kodlari yazan developer farklı uygulamalar yapabilir
        bu durumda bekleme islemi ve locate birlikte yapmalıyız..
         */

        WebElement istBackYaziElementi=wait.until(ExpectedConditions
                                                   .visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //WebElement istBackYaziElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(istBackYaziElementi.isDisplayed());


    }
}
