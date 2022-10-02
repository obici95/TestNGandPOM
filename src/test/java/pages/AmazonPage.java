package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage { // genelde page sayfalarinda class isimlerinin yanina yazmayi siddetle tavsiye ediyoruz.
    public AmazonPage (){
        PageFactory.initElements(Driver.getDriver(),this);// bu classtaki driver, Driver classindaki getDriver'methodudur dedik
    }

    @FindBy (id = "twotabsearchtextbox")
    public WebElement aramaKutusu; // artik arama kutusunu loca etmeye ihtiyacim kalmadi ne zmana lazim olursa burdan kullanacagim

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucElementi;

    //POM'de temel hedef sudur: yukarida gorunen hicbir yesili orada gormemektir.

}
