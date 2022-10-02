package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class blueRentalCarsPage {

    public blueRentalCarsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "(//a[@role='button'])[1]")
    public WebElement IlkLoginButonu;

    @FindBy (xpath = "//input[@id='formBasicEmail']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@id='formBasicPassword']")
    public WebElement passwordtexBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement ikinciLoginButonu;

    @FindBy (id = "dropdown-basic-button")
    public WebElement kullaniciProfilIsmi;
}
