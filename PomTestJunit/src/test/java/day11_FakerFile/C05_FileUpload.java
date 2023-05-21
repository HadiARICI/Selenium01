package day11_FakerFile;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

        // 1. Dosya seç yolunu locate edlim uploadFile
        WebElement dosyaSecYolu= driver.findElement(By.xpath("//input[@id='file-upload']"));


        //2. adim yüklenecek dosyanın dosya yolunu olusturalım
        // masa üstündedki text.txt gönderelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim= "\\Desktop\\Text.txt";
        String yuklenecekDosya=farkliKisim+ortakKisim;

        // 3. adım senkeys ile dosya yolunu seçem butyunan yollayalım
        dosyaSecYolu.sendKeys(yuklenecekDosya);

        Thread.sleep(5000);

        // upload buttonuna basalım
        driver.findElement(By.xpath("//input[@class='button']")).click();

        WebElement yaziElementi= driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(yaziElementi.isDisplayed());

        //

    }
}
