package Day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // amazon git
        // account menusunde create a list tıklayalı

        Actions actions=new Actions(driver);

        driver.get("https://www.amazon.com");

        WebElement AccountListElementi= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(AccountListElementi).perform();

        WebElement CreateListElementi= driver.findElement(By.xpath("//a[@class='nav-link nav-item']"));
        actions.click(CreateListElementi).perform();

        Thread.sleep(5000);
    }


}
