package day08_Alerts_Iframe_BasickAuthetion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
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
        driver.get("https://the-internet.herokuapp.com/iframe");


        WebElement baslikYaziElementi= driver.findElement(By.xpath("//h3"));
Assert.assertTrue(baslikYaziElementi.isEnabled());
        System.out.println(baslikYaziElementi.getText());


        WebElement iframeelementi=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeelementi);



        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dünya");


        driver.switchTo().defaultContent();//iframe min dışına çıkar




//link yazi eleenti doğru locat etmemize rağmen yazdır madı çünkü iframe geçiş yapmıştırk ordan çıkmamız lazım
        WebElement linkTestElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkTestElementi.isDisplayed());
        System.out.println(linkTestElementi.getText());


    }
}
