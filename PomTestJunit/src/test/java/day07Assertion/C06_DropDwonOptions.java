package day07Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDwonOptions {

    /*
    1. amazon anasayfa ya gidin
    dropdown menüden Books 'u secelim sectiğiniz option yazdiralim

    2.dropdwon daki apsiyonlarin toplam sayisinin 28 olduğunu yazdırın.


     */
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
        //driver.close();
    }
    @Test
    public void test01(){

        //1. amazon anasayfa ya gidin dropdown menüden Books 'u secelim sectiğiniz option yazdiralim
        driver.get("https://www.amazon.com");
        WebElement dropDwonMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDwonMenu);

        select.selectByVisibleText("Books");
        /*
        bir dropdownla çalışıyorken , son secilen optiona ulaşmak isterseniz
        select.getFirstSelectedOption() method unu kullanmalısınız
        üzerindeki yazi yazdırmak için getText() unutulmamalıdir
         */

        System.out.println("secilen options: "+select.getFirstSelectedOption().getText());


        //2.dropdwon daki apsiyonlarin toplam sayisinin 28 olduğunu yazdırın.

        List<WebElement> optionsListesi=select.getOptions();

        int actualOptionsSayisi=optionsListesi.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionsSayisi);

        for (WebElement each:optionsListesi
             ) {
            System.out.println("each = " + each.getText());

        }
    }
}
