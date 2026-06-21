package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Commonclass;

public class AdminPage extends Commonclass {
    @FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper']//a[@href='/web/index.php/admin/viewAdminModule']")
    public WebElement admintab;
    @FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div//input")
    public WebElement username;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchbutton;
    @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span")
    public WebElement searchresults;
    public AdminPage(WebDriver webDriver)
    {

        PageFactory.initElements(webDriver,this);
    }}
