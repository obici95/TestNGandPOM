package tests.day21_resuableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.blueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    pages.blueRentalCarsPage blueRentalCarsPage=new blueRentalCarsPage();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");
        // Bir Class olustur : PositiveTest
        //  Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anaasayfaya gidildi");

        // login butonuna bas
        blueRentalCarsPage.IlkLoginButonu.click();
        extentTest.info("login butonuna tiklandi");


        // test data user email: customer@bluerentalcars.com
        blueRentalCarsPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");


        // test data password : 12345
        blueRentalCarsPage.passwordtexBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");

        //ikinci login butonuna bas
        blueRentalCarsPage.ikinciLoginButonu.click();
        extentTest.info("ikinci Login butonuna click yapildi");

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUsername=blueRentalCarsPage.kullaniciProfilIsmi.getText();
        String expectedUsername=ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(expectedUsername,actualUsername);
        extentTest.pass("kullanici basarii sekilde giris yapti");

          Driver.closeDriver();

    }
}
