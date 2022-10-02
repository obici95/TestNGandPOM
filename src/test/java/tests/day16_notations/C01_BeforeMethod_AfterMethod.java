package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    //@BeforeMethod ve @AfterMethod notasyonlari
    //JUnitteki @Before ve @After gibidir.
    // her test method'undan once ve sonra calisir

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");
    }

}
