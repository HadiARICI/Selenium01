package day07Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_YoutubeAssertion {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){

        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void test02(){

        WebElement imgElementi=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[4]"));
        Assert.assertTrue(imgElementi.isDisplayed());


    }
    @Test
    public void test03(){
        WebElement searchBoxElementi=driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBoxElementi.isEnabled());

    }
    @Test
    public void test04(){
    String expectedTitleWrong="youtube";
    String actualTitleWrong= driver.getTitle();

    Assert.assertFalse(expectedTitleWrong, Boolean.parseBoolean(actualTitleWrong));

    }
}
