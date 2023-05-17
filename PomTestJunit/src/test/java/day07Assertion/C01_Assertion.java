package day07Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertion {
    /*
    amazon anasayfa gidin
    3 farklı test methodu oluşturularak aşağıdaki görevleri yapin
    1. url in "amazon" içerdini test edin
    2. titlelin "facebook" içermediğini test edin
    3. sol üst köşde amazon logusunun göründüğünü test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");//bütün testlerin çalışması için buraya konması lazım
        //testleri bireysel çalışması için burada olması lazım

            }
@AfterClass
    public  static void tearDown(){
        driver.close();
}
@Test
public void test01(){
        //url in "amazon" içerdini test edin

        String arananKelime= "amazon";
        String actualUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(arananKelime));
}
@Test
    public void test02(){

    // titlelin "facebook" içermediğini test edin
    String istenmeyenKelime="facebook";
    String actualTitle= driver.getTitle();
    Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

}
@Test
    public void test03(){
        //sol üst köşde amazon logusunun göründüğünü test edin
    WebElement loguElementi=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
    Assert.assertTrue(loguElementi.isDisplayed());

}


}
