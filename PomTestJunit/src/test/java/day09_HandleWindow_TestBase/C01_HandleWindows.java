package day09_HandleWindow_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {

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
        driver.close();
    }
    @Test
    public void test01(){
//1. amazona git
        driver.get("https://www.amazon.com");

        // 2. nuttella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        String ilkHanleDeğeri= driver.getWindowHandle();


       // 3. ilk ürünün resmini tiklarak farklı bir tabla
        WebElement ilUrunResmmi= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        // bu komutu kullandığımızda driveri otamatik olarak oluşturur
        // yeni tab fda görevi
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
   driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();



        //4 ürün başlığı
        WebElement urunBasligi=driver.findElement(By.xpath("//div[@id='availability']"));
        System.out.println("urunBasligi.getText() = " + urunBasligi.getText());

        // ilk sayfaya geçip  uruli yazdıralım
        driver.switchTo().window(ilkHanleDeğeri);
        System.out.println(driver.getCurrentUrl());

    }
}
