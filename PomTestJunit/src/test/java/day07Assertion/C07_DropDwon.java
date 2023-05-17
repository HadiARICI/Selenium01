package day07Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class C07_DropDwon {

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

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDwonMenu= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(dropDwonMenu);

        // index kullanarak  Seçenek 1' (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println("index secim: "+select.getFirstSelectedOption().getText());

        // Value kullanarak  Seçenek 2' (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("value secim: "+select.getFirstSelectedOption().getText());

        // text kullanarak  Seçenek 1' (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("text ile secim: "+select.getFirstSelectedOption().getText());

        // tum dropDwon değerleri option yazdırın
        List<WebElement> tumOptionslar=select.getOptions();

        for (WebElement each: tumOptionslar
             ) {
            System.out.println("Tum Optionslar:"+each.getText());
        }

        // dropdown boyutunu bulun DropDown da 4 öğeden oluşuyrsa console True
        // oluşmyorsa False yazdırın..
        int dropDwonBoyut=tumOptionslar.size();

        if (dropDwonBoyut==4){
            System.out.println("True");
        }else {
            System.out.println("False");
        }


    }
}


