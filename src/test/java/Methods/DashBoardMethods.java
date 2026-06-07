package Methods;

import Utils.Utility;
import pages.DashboardPage;
import setup.Commonclass;

public class DashBoardMethods extends Commonclass {
    DashboardPage ObjDashboardPage=new DashboardPage(webDriver);
    public void hamburger(){
        Utility.click(ObjDashboardPage.logouthamburger,"hamburgerlogout");

    }
    public void logoutnbutton(){
        Utility.click(ObjDashboardPage.logoutlink,"logoutlink");
    }
}
