package setup;

import io.cucumber.java.Scenario;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Commonclass {
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static Scenario scenario;
    public static List<String> failedScenario = new ArrayList<>();
    public static Properties configProp= new Properties();
    //public static ThreadLocal<WebDriver> webDriver=new ThreadLocal<>();

    public static void launchbrowser(String env,String browser) throws MalformedURLException{
        if(browser.equalsIgnoreCase("chrome") && env.equalsIgnoreCase("local"))
           webDriver=new ChromeDriver();

        else if(browser.equalsIgnoreCase("safari") && env.equalsIgnoreCase("local"))
            webDriver=new SafariDriver();

        else if(browser.equalsIgnoreCase("edge") && env.equalsIgnoreCase("local"))
            webDriver=new EdgeDriver();

        else if(browser.equalsIgnoreCase("Firefox") && env.equalsIgnoreCase("local"))
            webDriver=new FirefoxDriver();
        else if (env.equalsIgnoreCase("remote")){
            webDriver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    new ChromeOptions()
            );
        }

        webDriver.manage().window().maximize();

    }
   /*public static void launchbrowser(String env,String url) throws MalformedURLException {
        webDriver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                new ChromeOptions()
        );
        webDriver.manage().window().maximize();
    }*/

    public void openurl(String url){
        //webDriver.get().get(url);
        wait=new WebDriverWait(webDriver,Duration.ofSeconds(10));
        webDriver.get(url);
    }

    public static void getTagId()
    {
        failedScenario.add((String) scenario.getSourceTagNames().toArray()[1]);
    }
}
