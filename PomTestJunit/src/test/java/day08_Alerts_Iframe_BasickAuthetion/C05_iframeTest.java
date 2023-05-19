package day08_Alerts_Iframe_BasickAuthetion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_iframeTest {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
    @After
    public void tearDown(){
        // driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://demo.guru99.com/test/guru99home/");


        // sayfadaki iframe sayisini bulunuz
        List<WebElement> iframeSayisiElementih=driver.findElements(By.tagName("iframe"));
        System.out.println("iframeSayisiElementih.size() = " + iframeSayisiElementih.size());

        //youtebe sayfasına tıklayınız
        WebElement iframeSayisiElementi= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframeSayisiElementi);

        driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).click();

        //ilk iframden çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // ikinci frmae
        WebElement ikinciFrameElementi= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(ikinciFrameElementi);

        WebElement jmeterMaddeEsayEl= driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        jmeterMaddeEsayEl.click();







    }
}
