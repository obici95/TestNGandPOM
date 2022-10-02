package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {


    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();

        //facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");

        //cikarsa cookies'i kabul edin.

        // kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker =new Faker();

        facebookPage.emailTextBox.sendKeys(faker.name().firstName());


        //kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.passwordTextBox.sendKeys(faker.internet().password());

        //login butonuna basin
        facebookPage.loginButonu.click();


        //giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYazisi.isDisplayed());

        Driver.closeDriver();

    }
}
