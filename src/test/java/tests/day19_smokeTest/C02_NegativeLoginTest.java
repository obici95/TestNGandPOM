package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.blueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeLoginTest {
    blueRentalCarsPage blueRentalCarsPage;

    @Test
    public void yanlisSifreTest01() {
        blueRentalCarsPage=new blueRentalCarsPage();
        // Bir Class olustur : PositiveTest
        //  Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        blueRentalCarsPage.IlkLoginButonu.click();

        // test data user email: customer@bluerentalcars.com ,
        blueRentalCarsPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 54321
        blueRentalCarsPage.passwordtexBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //ikinci login butonuna bas
        blueRentalCarsPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentalCarsPage.ikinciLoginButonu.isDisplayed());

    }
    // bu classta iki test methodu daha olusturun
    // biri yanlisKullanici
    // digeri de yanlis sifre ve kullanici adi
    //ders notlarinda otel ile ilgili olan da var onu da yap.
}
