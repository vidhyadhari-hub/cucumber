package stepdefinitions;

import Methods.DashBoardMethods;
import Methods.loginMethod;
import Utils.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static setup.Commonclass.webDriver;

public class DataDrivenLoginSteps {
    loginMethod ObjLoginMethod;
    DashBoardMethods ObjDashBoardMethod;
    Object[][] data= ExcelUtility.getData("Login");
    @Given("User enters Username  and password and clicks submit button and tests the expected result")
    public void user_enters_username_and_password_and_clicks_submit_button() {

        for(Object[] row:data){
            if(row==null || row[0]==null){
                continue;
            }
            String username=row[0].toString();
            String password=row[1].toString();
            String expected=row[2].toString();
            ObjLoginMethod=new loginMethod();
            ObjLoginMethod.enterUsername(username);
            ObjLoginMethod.enterpassword(password);
            ObjLoginMethod.clickloginbutton();
            if(expected.equals("OrangeHRM")){
                Assert.assertEquals(webDriver.getTitle(),expected);
                ObjDashBoardMethod=new DashBoardMethods();
                ObjDashBoardMethod.hamburger();
                ObjDashBoardMethod.logoutnbutton();

            }
            else{
                String actual= ObjLoginMethod.invalid();
                Assert.assertEquals(expected,actual);
            }



        }
    }

}
