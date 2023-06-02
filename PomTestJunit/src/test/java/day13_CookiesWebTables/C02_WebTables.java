package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {


    @Test
    public void webTableTest() {
        //login methodu oluşturun
        // Username : manager
        // Password : Manager1!
        Girisyap();

        //Tüm table body sinin  boyutunu (sutun sayisi) bulun /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayi: " + sutunBasliklariListesi.size());

        //Table deki tüm body ile başlıklari (headers) konsole yazdırın
        WebElement tumBoyd = driver.findElement(By.xpath("//tbody"));
        System.out.println("tumBoyd = " + tumBoyd.getText());

        // table body sinde bulunan toplam satir(row) sayisini bulunuzu
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satirlarListesi = " + satirlarListesi.size());

        //table body sinde bulunan satirlari(row) konsola yazdirin

        for (WebElement each : satirlarListesi
        ) {
            System.out.println("satir sayilari: " + each.getText());
        }

        //4. satir daki(row) elementleri koonsola yazdirin

        List<WebElement> satir4 = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each : satir4
        ) {
            System.out.println(each.getText());
        }
        //tbody altindaki tüm datalar

        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each : cellList
        ) {
            System.out.println(each.getText());

        }
        // burası önemli bir kodla çünkü tablo başlığında ki direk sutunu giderek eğer o sutun mevcut ise
        // o sutunun bütün datalarını yazar yani çıktı verir..(60.satırdan  73. satıra kadr)
        // tablo daki başlıkların listesini verir...

        List<WebElement> baaliklarinListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo=0;
        for (int i = 0; i <baaliklarinListesi.size() ; i++) {
            if (baaliklarinListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }

        // E mail başlığında ki tüm elementleri(sutun) konsole yazdırın
        List<WebElement> emailSutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailSutunListesi
             ) {
            System.out.println(each.getText());

        }


             int telSutunNo=0;
        for (int i = 0; i <baaliklarinListesi.size() ; i++) {
            if (baaliklarinListesi.get(i).getText().equals("PhoneNo")){
                telSutunNo=i;

            }

        }

        // E mail başlığında ki tüm elementleri(sutun) konsole yazdırın
        List<WebElement> telnoSutunListesi=driver.findElements(By.xpath("//tbody//td["+(telSutunNo+1)+"]"));
        for (WebElement each:telnoSutunListesi
        ) {
            System.out.println(each.getText());

        }
    }

    public void Girisyap() {
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
