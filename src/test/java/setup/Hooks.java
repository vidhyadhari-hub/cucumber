package setup;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static setup.Commonclass.configProp;
import static setup.Commonclass.webDriver;

public class Hooks{

    @Before
    public void launch(Scenario scenario) throws IOException {
        System.out.println("Scenario name::" + scenario.getName());
        System.out.println("Scenario Tagname::" + scenario.getSourceTagNames().toArray()[1]);
        Commonclass.scenario = scenario;
        configProp = new Properties();
        FileInputStream configPropFile = new FileInputStream("src/test/resources/config.properties");
        configProp.load(configPropFile);
        Commonclass.launchbrowser(configProp.getProperty("browser"));
        //Commonclass.launchbrowser(configProp.getProperty("env"),configProp.getProperty("url"));
    }

    @After
    public void afterMethod(Scenario scenario)
    {

        if(scenario.isFailed()) {
            System.out.println("Scenario is failed::");
            Commonclass.getTagId();
        }
        else
            System.out.println("Scenario ::"+scenario +" got passed");
        webDriver.quit();
    }

    @AfterAll
    public static void afterExection()
    {
        System.out.println("Failed Scenario id::"+Commonclass.failedScenario);
    }
}
