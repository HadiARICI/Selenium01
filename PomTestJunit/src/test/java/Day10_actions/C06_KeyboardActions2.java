package Day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

        actions.click(firstName)
                .sendKeys("Hadi")
                .sendKeys(Keys.TAB)
                .sendKeys("ARICI")
                .sendKeys(Keys.TAB)
                .sendKeys("mina@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("mina@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12361236")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23").sendKeys(Keys.TAB)
                .sendKeys("5").sendKeys(Keys.TAB)
                .sendKeys("1976")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

/*
        WebElement dayElementi= driver.findElement(By.xpath("//select[@id='day']"));
        Select select=new Select(dayElementi);
        select.selectByValue("23");
        WebElement monthElementi= driver.findElement(By.xpath("//select[@id='month']"));
        Select select1=new Select(monthElementi);
        select1.selectByValue("5");
        WebElement yearElementi= driver.findElement(By.xpath("//select[@id='year']"));
        Select select2=new Select(yearElementi);
        select2.selectByValue("1976");
        WebElement kadinRadioButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekRadioButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelRadioButton=driver.findElement(By.xpath("//input[@value='-1']"));

        if (!erkekRadioButton.isSelected()){
            erkekRadioButton.click();
        }
        WebElement kaydolButton= driver.findElement(By.xpath("//button[@name='websubmit']"));
        kaydolButton.click();

 */





    }
}
