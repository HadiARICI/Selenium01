package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void theedSllep() {
        driver.close();
    }

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");

        /*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")) {
            System.out.println("url test PASSED");
        } else {
            System.out.println("url test FAILED");
        }

         */
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();

       Assert.assertEquals(expectedUrl,actualUrl);

    }


}
