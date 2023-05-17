package day05Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Soru2 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://saucedemo.com " adresine git
        driver.get("https://saucedemo.com");

        //Username Kutusuna "standart_user yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Password Kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //login tuşunua basın
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // ilk ürün isimini kaydedin ve bu ürünün sayfasına gidin
        WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("ilkUrunIsimElementi.getText() = " + ilkUrunIsimElementi.getText());

        if (ilkUrunIsimElementi.isDisplayed()){
            System.out.println("ilkUrunIsimElementi Testi PASSED");
        }else {
            System.out.println("ilkUrunIsimElementi Testi FAİLED");
        }
        ilkUrunIsimElementi.click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        WebElement secmisOldugumuzUrunSepetiElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        System.out.println("secmisOldugumuzUrunSepetiElementi.getText() = " + secmisOldugumuzUrunSepetiElementi.getText());
        if (secmisOldugumuzUrunSepetiElementi.isDisplayed()){
            System.out.println("Urun sepate Eklendi Testi PASSED");
        }else {
            System.out.println("Urun sepate Eklendi Testi FAILED");
        }



driver.close();
    }
}
