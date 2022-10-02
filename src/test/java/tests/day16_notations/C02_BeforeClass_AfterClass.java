package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    //JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip methodlar
    //static olmak ZORUNDAYDI
    //Ama TestNG bu ZORUNLULUKTAN bizi kurtariyor.

    /*
      TestNG bize daha fazla before ve after notasyonlari sunar
      diger before/after notasyonlari tanimlayacagimiz
      grup, test ve suitten once ve sonra calisirlar
      ileride xml dosyalari ile birlikte bunlari gorecegiz
     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("setup calisti");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("tearDown calisti");
    }

    @Test
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
