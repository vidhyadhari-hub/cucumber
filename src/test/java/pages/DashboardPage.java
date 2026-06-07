package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Commonclass;

public class DashboardPage extends Commonclass {
    @FindBy(xpath="//li[@class='oxd-userdropdown']//i")
    public WebElement logouthamburger;
    @FindBy(xpath="//a[text()='Logout']")
    public WebElement logoutlink;
    @FindBy(xpath="//a[@class='oxd-main-menu-item']//*[text()='Admin']")
    public WebElement admin;
    public DashboardPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}

