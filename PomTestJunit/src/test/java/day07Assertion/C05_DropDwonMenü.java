package day07Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDwonMenü {

    /*
    amazona gidip dropdwondan "books" seceneğini secip  java aratalim

    arama sonuclarinin Java icerdiğini test edin
     */
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
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        WebElement dropDwonMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2-bir Select objesi oluşturup
        // parametre olarak bir önceki adimda locate ettiğiniz ddm girelim
        Select select=new Select(dropDwonMenu);

        // Dropdwondan var olan option lardan istediğmiz bir taneyi secelim

        select.selectByVisibleText("Books");
        // select.deselectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");

        WebElement searchArama=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchArama.sendKeys("Java"+ Keys.ENTER);

        WebElement aramaSonucuJava=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi= aramaSonucuJava.getText();
        String arananKelime="Java";

        Assert.assertTrue(aramaSonucuJava.getText().contains(arananKelime));

        Thread.sleep(5000);


    }
}

