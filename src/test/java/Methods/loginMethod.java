package Methods;


import pages.loginPage;
import Utils.Utility;

import static setup.Commonclass.webDriver;

public class loginMethod {
    loginPage lp=new loginPage(webDriver);
    public void enterUsername(String username){
        Utility.type(lp.username,username,"username");

    }
    public void enterpassword(String password){
        Utility.type(lp.password,password,"Password");
    }
    public void clickloginbutton(){
        Utility.click(lp.submit,"submitbutton");

    }
    public String invalid(){
        String actual=Utility.getTextFromWebElement(lp.invalid,"Invalid Text");
        return actual;
    }
}
