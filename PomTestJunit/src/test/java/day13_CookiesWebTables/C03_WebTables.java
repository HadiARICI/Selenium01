package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    // önceki class daki adrese gidp
    // girisYap Methodu kullanarak sayfaya giris yapın
    // input olarak verilen satir sayisi ve sutun sayisi'na sahip celldeki text i yazdirin.

    @Test
    public void dinamikYazici() {
     girisyap();

        int satir=5;
        int sutun=6;

        WebElement arananCell=
                driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("arananCell = " + arananCell.getText());

    }

    private void girisyap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        WebElement userName= driver.findElement(By.xpath("//input[@id='UserName']"));

        Actions actions=new Actions(driver);
        actions.click(userName)
                .sendKeys("manager").sendKeys(Keys.TAB)
                .sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }


}
