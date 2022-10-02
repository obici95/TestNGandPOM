package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass { // artik driver'i kullanmak icin extends'e ihtiyacim kalmadi



    @Test
    public void test01() { //ve artik Driver class'inin altindaki getDriver methodunu kullanacagim
        Driver.getDriver().get("https://amazon.com");

        /*
            Bugune kadar TestBase class'inda extends ederek kullandiigimiz driver yerine
            bundan sonra Driver class'indan kullanacagimiz getDriver static methodunu kullanacagiz

            Driver.getDriver() in
            driver.get()       out
         */

        Driver.closeDriver();
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://facebook.com");
        // Biz getDriver methodunu her cagirdigimizda getDriver methodundaki driver'a new Chrome degerini atiyor
        //dolayisiyla yeni bir driver olusuyor ama ben istiyorum ki bir kere olusturdugumda yenisine gerek yok zaten.
        //Nasil yapacagiz?If ile (Driver classinda yapacagiz)

        Driver.closeDriver(); // bu methodu olusturarak istedigim zaman driver'i acarim istedigim zaman kapatirim.


    }
}
