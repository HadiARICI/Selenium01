package Day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C03_MouseActions1 extends TestBase {

    @Test
    public  void test01(){

        Actions actions=new Actions(driver);
        // https://the-internet.herokuapp.com/context_menü sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

       // Cizili üzerine olan sağ click yapalım
        WebElement ciziliKutuElementi=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliKutuElementi).perform();


       // Alert çıkan yazının "You selected a context menu" olduğunu test edelim
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);

       // Tamam diyerek alerti kapatalım
        driver.switchTo().alert().accept();

       // Elemental Selenium linkine tıklayalim

        String ilksayfaninWindowHandle=driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti=driver.getWindowHandles();
        System.out.println("handleSeti = " + handleSeti);
        String ikinciSayfaninWindowHanle="";

        for (String each:handleSeti
             ) {
            if (!each.equals(ilksayfaninWindowHandle))
            ikinciSayfaninWindowHanle=each;
        }


        //Acilan sayfada h1 tagında "Elemental Selenium" yazdiğini test edelim

        driver.switchTo().window(ikinciSayfaninWindowHanle);

        WebElement yaziElementi= driver.findElement(By.xpath("//h1"));
        String expectedYaziT="Elemental Selenium";
        String actualYaziT=yaziElementi.getText();

        Assert.assertEquals(expectedYaziT,actualYaziT);

    }


}
