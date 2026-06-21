package stepdefinitions;

import Methods.AdminMethods;
import Methods.DashBoardMethods;
import Methods.loginMethod;
import Utils.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import setup.Commonclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertTrue;


public class loginsteps extends Commonclass {
    Logger logger= LogManager.getLogger(loginMethod.class);
    loginMethod objloginmethod;
    DashBoardMethods objDashBoardMethods;
    AdminMethods objAdminMethods;

    @Given("User launch browser")
    public void user_launch_browser() throws IOException {
        Properties configProp=new Properties();
        FileInputStream configPropFile=new FileInputStream("src/test/resources/config.properties");
        configProp.load(configPropFile);
        launchbrowser(configProp.getProperty("browser"));
        //launchbrowser(configProp.getProperty("env"),configProp.getProperty("url "));
   }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        openurl(url);

    }
    @When("User enters Username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {

        objloginmethod = new loginMethod();
        objloginmethod.enterUsername(username);
        scenario.log("entered username");
        objloginmethod.enterpassword(password);

    }
    @When("User clicks login button")
    public void user_clicks_login_button() {
        objloginmethod.clickloginbutton();

    }
    @Then("Page Title should be displayed as {string}")
    public void page_title_should_be_displayed_as(String pagetitle) {
        assertTrue(String.valueOf(webDriver.getTitle().equals(pagetitle)),true);
    }
    @Then("clicks logout hamburger and logout link")
    public void clicks_logout_hamburger_and_logout_link() {
        objDashBoardMethods=new DashBoardMethods();
        objDashBoardMethods.hamburger();
        objDashBoardMethods.logoutnbutton();


    }
    @Then("close browser")
    public void close_browser() {
        webDriver.close();
    }

    @When("User clicks on admin tab")
    public void user_clicks_on_admin_tab() throws InterruptedException {
        objAdminMethods=new AdminMethods();
        objAdminMethods.clicksOnAdmintab();

    }
    @When("User enters user search text as {string}")
    public void user_enters_user_search_text_as(String search) {
        objAdminMethods=new AdminMethods();
        objAdminMethods.enterusername(search);
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        objAdminMethods=new AdminMethods();
        objAdminMethods.clicksSearchButton();
    }
    @Then("Application displays the displays")
    public void application_displays_the_displays() {
        objAdminMethods=new AdminMethods();
        objAdminMethods.searchresults();
    }
    @When("User enters Username  and password")
    public void user_enters_username_and_password(DataTable dataTable) {
        List<Map<String,String >> users=dataTable.asMaps(String.class,String.class);
       for(Map<String,String> user: users ){
           String username=user.get("Username");
           String password=user.get("password");
           objloginmethod.enterUsername(username);
           objloginmethod.enterpassword(password);
       }
    }


}
