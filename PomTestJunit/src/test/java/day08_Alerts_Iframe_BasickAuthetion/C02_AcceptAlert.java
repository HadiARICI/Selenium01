package day08_Alerts_Iframe_BasickAuthetion;

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

public class C02_AcceptAlert {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void accepAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualResult=sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String istenmeyeKelime = "successfuly";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualYazi=sonucYaziElementi.getText();

        Assert.assertFalse(actualYazi.contains(istenmeyeKelime));

    }
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hadi");
        driver.switchTo().alert().accept();

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYaziStr=sonucYaziElementi.getText();
        String girileİsim="Hadi";

        Assert.assertTrue(sonucYaziStr.contains(girileİsim));


    }
}
