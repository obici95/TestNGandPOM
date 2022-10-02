package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {

        FacebookPage facebookPage=new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //cikarsa cookies'i kabul edin.

        // kullanici mail kutusuna yanlis kullanici adini isim yazdirin
        facebookPage.emailTextBox.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //kullanici sifre kutusuna yanlis bir password yazdirin
        facebookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna basin
        facebookPage.loginButonu.click();


        //giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYazisi.isDisplayed());


        // sayfayi kapatin
        Driver.closeDriver();

    }
}
