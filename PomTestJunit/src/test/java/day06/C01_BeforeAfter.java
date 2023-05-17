package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfter {

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
//her başında Before method call
        driver.get("https://www.amazon.com");
        // her sonun da After method call
    }
    @Test
    public void test02(){

        driver.get("https://wwww.facebook.com");

    }
    @Test
    public void test03(){
         driver.get("https://www.google.com");
    }

}
