package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
      TestNG test methodlarini isim sirasina gore calistirir
      eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
      ozaman test method'larina oncelik(priority) tanimlayabilrizi

      priority kucukten buyuge gore calisir
      eger bir test metohd'una priority degeri atanmamissa
      priority degeri 0 kabul edilir.
     */

    @Test (priority = -5)
    public void amazonTesti() {
        driver.get("https://amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void techproedTesti() {
        driver.get("https://techproeducation.com");
    }
}
