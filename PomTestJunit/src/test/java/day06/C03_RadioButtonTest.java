package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtonTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
        @Test
        public void test01(){

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

            WebElement kadinRadioButton=driver.findElement(By.xpath("//input[@value='1']"));
            WebElement erkekRadioButton=driver.findElement(By.xpath("//input[@value='2']"));
            WebElement ozelRadioButton=driver.findElement(By.xpath("//input[@value='-1']"));

            if (!erkekRadioButton.isSelected()){
                erkekRadioButton.click();
            }

        }
    @After
    public void tearDown(){
      //  driver.close();
    }
}

