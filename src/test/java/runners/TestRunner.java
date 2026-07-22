package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"setup","stepdefinitions"},
    //dryRun = true,
    plugin = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber.json",
            "rerun:target/failed_scenarios.txt",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }

    //tags = "@sanity"
  //  monochrome=true
)

public class TestRunner{
    }

