package day13_CookiesWebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies01 extends TestBase {
    @Test
    public void test01() {
        //1 amazona gidelim
        driver.get("https://www.amazon.com");

        //2tüm cookieleri listeyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac = 1;
        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + ".ci cookie : " + each);
            System.out.println("name: " + each.getName());
            System.out.println("value: " + each.getValue());
            sayac++;

        }

        //3sayfadaki cookies sayininin 5 den buyuk olduğunu test edin..
        int cookieSayisi = cookiesSet.size();
        Assert.assertTrue(cookieSayisi > 5);

        //4ismi "i18n-prefs" olan cookie degerinin USD oldugunu test edin
        for (Cookie each : cookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        // 5ismi "en sevdeğim cookie" ve dgeri "cikolatali" olan cookie oluşturun
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);

        // 6eklediginiz cookie ni sayfaya eklendigini test edin
        cookiesSet = driver.manage().getCookies();
        sayac = 1;
        for (Cookie each : cookiesSet
        ) {
            System.out.println(sayac + ".ci cookie : " + each);
            //  System.out.println("name: " + each.getName());
            //System.out.println("value: " + each.getValue());
            sayac++;

        }
        //6 eklediğiniz cookienin sayfaya eklendiğini test edin
        Assert.assertTrue(cookiesSet.contains(cookie));

        // ismi skin olan cookie yi silin ve sildiğini test edin
        driver.manage().deleteCookieNamed("skin");

        Assert.assertFalse(cookiesSet.contains("skin"));

        //tüm cookieleri silin ve silindiğini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.size() == 0);

        Set<Cookie> cookiesSeti = driver.manage().getCookies();
        System.out.println("cookie ler silindikten sonra"+cookiesSeti);


       }




}

