package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/login.feature",
    glue = {"setup","stepdefinitions"},
    //dryRun = true,
    plugin = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber.json"
    },
    tags = "@sanity"
  //  monochrome=true
)
public class TestRunner {

}
