package day05Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Soru1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com/ sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");

        //Signin Buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //Login alanına "usarname" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // Password alanına "password" yazdırın
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");;

        //Sing in Buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        driver.navigate().back();
        // Online Banking tiklayin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();

        //Pay Bills
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //Account kısmina yatırmak istediğini değeri girin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("20000");

        // date kismina "20233-05-14" girin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("20233-05-14");

        // pay tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //The payment was successfully submitted. göründüğünü test edin
        WebElement sonucYzısıElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYzısıElementi.isDisplayed()){
            System.out.println("Sonuc Yazısı Elementi PASSED");

        }else {
            System.out.println("Sonuc Yazısı Elementi FAILED");
        }
driver.close();




    }
}
