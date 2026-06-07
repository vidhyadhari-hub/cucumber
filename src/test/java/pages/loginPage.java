package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public loginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this) ;
    
    }
    @FindBy(xpath="//input[@name='username']")
    public WebElement username;
    @FindBy(xpath="//input[@name='password']")
    public WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement submit;

}
