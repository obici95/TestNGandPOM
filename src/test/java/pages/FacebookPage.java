package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){ //bir page sayfasi olusturdugumda ilk yapmam gereken sey parametresiz bir contructor olusturup
                            //driver'imizi bu sayfaya tanitmaktir
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@id='pass']")
    public WebElement passwordTextBox;

    @FindBy (xpath = "//button[@name='login']")
    public WebElement loginButonu;

    @FindBy (xpath = "//div[@class='_9ay7']")
    public WebElement girilemediYazisi;




}
