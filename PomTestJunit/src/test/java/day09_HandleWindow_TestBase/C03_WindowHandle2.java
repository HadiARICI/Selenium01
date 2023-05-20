package day09_HandleWindow_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle2 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {
      // driver.quit();
    }
    @Test
    public void test01(){


        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement sonucYazisiStr= driver.findElement(By.xpath("//h3"));
        String expectedYazi= "Opening a new window";
        String actualYazi=sonucYazisiStr.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        String ilksayfaninHandleDegeri=driver.getWindowHandle();
        System.out.println("ilksayfaninHandleDegeri = " + ilksayfaninHandleDegeri);

// bütün sayfalarin handle değeri==================================
        Set<String> windowHandleSeti= driver.getWindowHandles();
        System.out.println("windowHandleSeti = " + windowHandleSeti);
        String ikinciSayfaHandleDegeri="";

        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilksayfaninHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }

        }

// 2.sayfa geçiş=====================================================00
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        // click Here buttonuna basalım
       driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        String expectedikinciTitle="New Window";
        String actualiknicTitle= driver.getTitle();
       Assert.assertEquals(expectedTitle,actualiknicTitle);


        WebElement ikinciSayfaYaziElementi=driver.findElement(By.xpath("//div[@class='example']"));
        String expectedIkınciSayfaYazi="New Window";
        String actualIkınciSyafaYazi=ikinciSayfaYaziElementi.getText();
       // Assert.assertEquals(expectedIkınciSayfaYazi,actualIkınciSyafaYazi);

// tekrar ilk sayfaya dönüş==============================================
        driver.switchTo().window(ilksayfaninHandleDegeri);
        String expected111="The Internet";
        String actual111=driver.getTitle();
        Assert.assertEquals(expected111,actual111);





    }


}
