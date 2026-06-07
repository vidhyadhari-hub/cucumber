package Methods;

import Utils.Utility;
import pages.AdminPage;
import setup.Commonclass;


public class AdminMethods extends Commonclass {
    AdminPage objAdminPage=new AdminPage(webDriver);
    public void enterusername(String username) {
        Utility.type(objAdminPage.username, username, "username");
    }
    public void clicksSearchButton() {
        Utility.click(objAdminPage.searchbutton, "searchbutton");
    }
    public void searchresults(){
        Utility.getTextFromWebElement(objAdminPage.searchresults,"search results");

    }
    public void clicksOnAdmintab() throws InterruptedException {
        Utility.click(objAdminPage.admintab,"admintab");
        Thread.sleep(5000);
    }
}

