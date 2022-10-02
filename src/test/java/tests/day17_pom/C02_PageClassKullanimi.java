package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {
        //amazona gidelim
        Driver.getDriver().get("https://amazon.com");

        // nutella aratalim
        AmazonPage amazonPage=new AmazonPage(); // burada obje olusturmamizin sebebi amazonPage'deki notasyonlarin static olmamasidir ve bu sekilde kullanilir
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // sonuc yazisinin nutella icerdigiini test edelim
       Assert.assertTrue(amazonPage.aramaSonucElementi.getText().contains("Nutella"));

       Driver.closeDriver();
    }
}
