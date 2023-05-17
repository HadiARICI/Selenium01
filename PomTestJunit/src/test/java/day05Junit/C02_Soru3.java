package day05Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Soru3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.google.com");

        String actualTitle= driver.getTitle();
        String arananKElime="Google";

        if (actualTitle.contains(arananKElime)){
            System.out.println("Title Aranan Kelime Testi PASSED: "+arananKElime);

        }else {
            System.out.println("Title Aranan Kelime Testi FAILED:"+ arananKElime);

        }

        driver.findElement(By.xpath("//textarea[@id='APjFqb']"))
                                                  .sendKeys("Nuttela"+ Keys.ENTER);


        WebElement nuttellaBulununaSonucSayisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("nuttellaBulununaSonucSayisi.getText() = " + nuttellaBulununaSonucSayisi.getText());


        //if (nuttellaBulununaSonucSayisi.getSize()=10000000){

        }
    }



