package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.blueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    pages.blueRentalCarsPage blueRentalCarsPage;

    @DataProvider
    public static Object[][] KullaniciListesi() {
        Object [][] kullaniciBilgileri ={{"frize@nehaber.com","54678"},
                                        {"murat@benbuisibilirim.com","65874"},
                                        {"ilyas@hollandadanselam@.com","78798"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "KullaniciListesi")
    public void yanlisSifreTest01(String userEmail, String password) {
        blueRentalCarsPage=new blueRentalCarsPage();
        // Bir Class olustur : PositiveTest
        //  Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        blueRentalCarsPage.IlkLoginButonu.click();

        // test data user email: dataprovider'dan alalim. ,
        blueRentalCarsPage.emailTextBox.sendKeys(userEmail);

        // test data password : dataprovider'dan alalim.
        blueRentalCarsPage.passwordtexBox.sendKeys(password);

        //ikinci login butonuna bas
        blueRentalCarsPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentalCarsPage.ikinciLoginButonu.isDisplayed());

    }
}
