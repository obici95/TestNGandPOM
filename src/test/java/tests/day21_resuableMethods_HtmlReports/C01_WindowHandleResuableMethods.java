package tests.day21_resuableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandleResuableMethods {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
          //click yapinca yeni bir sekme aciliyor bu yuzden click ypamadan once bu sekmenin handle'ini alalim
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
           //click yapinca 2 tane sekmemiz oldu bu iki sekmenin handleini alalim simdi
            List<String> sayfaHandleDegerleri=new ArrayList<>(Driver.getDriver().getWindowHandles());
            Driver.getDriver().switchTo().window(sayfaHandleDegerleri.get(1));

        System.out.println(Driver.getDriver().getTitle());
         //acilan yeni tab'in titleinin "New Window" oldugunu test edin
         String expectedTitle="New Window";
         String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();

        //acilan yeni tab'in titleinin "New Window" oldugunu test edin

        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        ReusableMethods.waitFor(5);

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.quitDriver();


    }


















}
