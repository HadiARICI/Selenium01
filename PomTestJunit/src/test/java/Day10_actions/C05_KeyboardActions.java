package Day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        // amazona didelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions=new Actions(driver);
        // önce arama kutusuna click yapip
        actions.click(aramaKutusu).perform();

        //sonra harf harf Nutella yazini yazdıralım
        actions.keyDown(Keys.SHIFT)
        .sendKeys("n").keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER).perform();



        // sonra ENTER tusuna basalım
    }
}
