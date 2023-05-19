package day09_HandleWindow_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
        driver.quit();
    }

    @Test
    public void test01() {
        // 1. amazon git
        driver.get("https://www.amazon.com");
        String ilkSayfaninHandle=driver.getWindowHandle();

        // 2 url in amazon içerdiğini test edin
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        // 3. yeni bir pencere açıp bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaninHandle= driver.getWindowHandle();

        // 4. title nin Bestbuy içerdiğini test edelim
        String actulaTitle= driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actulaTitle.contains(arananKelime));

        // 5. ilk sayfaya donup java aratalım
        driver.switchTo().window(ilkSayfaninHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //6. arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucJava= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYaziElmenti=aramaSonucJava.getText();
        String aramaTitleJva="Java";
        Assert.assertTrue(sonucYaziElmenti.contains(aramaTitleJva));

        //7. yeniden bestbuy in açık olduğu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaninHandle);

        // 8. logunun göründününü test edelim
        WebElement loguElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(loguElementi.isDisplayed());



    }
}
