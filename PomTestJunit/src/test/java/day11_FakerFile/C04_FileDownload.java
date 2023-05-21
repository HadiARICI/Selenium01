package day11_FakerFile;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {




    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //3. afs.txt dosyasını inderelim
        WebElement afsLinkiYolu= driver.findElement(By.xpath("//a[text()='afs.txt']"));
        afsLinkiYolu.click();

        Thread.sleep(5000);


        //4. Ardından isExist() methodunda dosyanın başarıyla indirildiğini test edelim

        //download ptht lazım

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\afs.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));




    }
}
