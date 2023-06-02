package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_Soru extends TestBase {

    @Test
    public void test01() {

        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan "department" isimlerini yazdirin

        List<WebElement> headersbaaliklarinListesi=driver.findElements(By.xpath("//div[@class='rt-tr']"));

        for (WebElement each:headersbaaliklarinListesi
             ) {
            System.out.println(each.getText());
        }


        List<WebElement> departmentList=driver.findElements(By.xpath("(//div[@class='rt-resizable-header-content'])[6]"));

        for (WebElement each:departmentList
             ) {
            System.out.println("departmentList = " + each.getText());
        }


    }
}
