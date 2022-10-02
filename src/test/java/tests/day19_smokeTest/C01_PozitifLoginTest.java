package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;

import pages.blueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PozitifLoginTest {

    blueRentalCarsPage blueRentalCarsPage=new blueRentalCarsPage();

    @Test
    public void test01() {
        // Bir Class olustur : PositiveTest
        //  Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        blueRentalCarsPage.IlkLoginButonu.click();


        // test data user email: customer@bluerentalcars.com ,
        blueRentalCarsPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));


        // test data password : 12345
        blueRentalCarsPage.passwordtexBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //ikinci login butonuna bas
        blueRentalCarsPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et



      //  Driver.closeDriver();



    }
}
