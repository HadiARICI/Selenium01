package Day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions2 extends TestBase {

    @Test
    public void test01() {
        //facebook anasayfaya gidip
        //yeni bir kayit oluşturun
        //isim kutusunu locate edip
        // geriye kalan alanlari TAB ile doldurark formu doldurun

        Actions actions=new Actions(driver);
        driver.get("https://www.facebook.com");

        WebElement yeniHesapOlustur= driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        yeniHesapOlustur.click();

        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(firstName).sendKeys("Hadi"+ Keys.TAB)
                .sendKeys("ARICI"+Keys.TAB)
                .sendKeys("mina@hotmail.com"+Keys.TAB)
                .sendKeys("mina@hotmail.com"+Keys.TAB)
                .sendKeys("12361236"+Keys.TAB)
                .sendKeys("23").sendKeys(Keys.TAB)
                                .sendKeys("May"+Keys.TAB)
                .sendKeys("1976"+Keys.TAB)
                .sendKeys().click().sendKeys(Keys.TAB).perform();
        WebElement kaydolButton= driver.findElement(By.xpath("//button[@name='websubmit']"));
        kaydolButton.click();





    }
}
