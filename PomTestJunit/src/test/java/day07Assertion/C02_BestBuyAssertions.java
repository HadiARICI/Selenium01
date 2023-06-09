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

public class C02_BestBuyAssertions {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");

    }
        @AfterClass
      public static void tearDown(){
       driver.close();

        }
        @Test
        public void test01(){

        String expectedUrl="https://www.bestbuy.com/";
        String actulaUrl= driver.getCurrentUrl();
            Assert.assertEquals("url Testi: ",expectedUrl,actulaUrl);
        }
        @Test
    public void test02(){

        String istenmeyenKelime="Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

        }
        @Test
    public void test03(){
            WebElement loguTesti=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

            Assert.assertTrue(loguTesti.isDisplayed());

        }
        @Test
    public void test04(){
        WebElement linkTesti=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(linkTesti.isDisplayed());

        }
    }

