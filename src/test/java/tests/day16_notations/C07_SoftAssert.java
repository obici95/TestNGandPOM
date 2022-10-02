package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {

        //  Yeni bir Class Olusturun : C03_SoftAssert
        //  1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //  2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //  3. Login kutusuna “username” yazin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

        //  4. Password kutusuna “password” yazin
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");

        //  5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //  6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //  7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();


        //  8. “Currency” drop down menusunden Eurozone’u secin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        WebElement currencyDDO=  driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(currencyDDO);
        select.


                selectByVisibleText("Eurozone (euro)");


        //  9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil");

        //  10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin

        /*

          "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
          (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
          (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
          (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

         */

        List <WebElement> optionList=select.getOptions(); //ODEV BURASI
        optionList.stream().sorted();


        List <String> expectedList=new ArrayList<>(Arrays.asList( "Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)"
                ,"Sweden (krona)","Singapore (dollar)","Thailand (baht)"));
        expectedList.stream().sorted();



        for (int i = 0; i <optionList.size() ; i++) {
            softAssert.assertEquals(optionList.get(i).getText(),expectedList.get(i));
        }
        softAssert.assertAll();


    }
}
