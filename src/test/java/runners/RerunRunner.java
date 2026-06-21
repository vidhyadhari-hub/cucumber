package runners;

import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failes_scenarios.txt",
        glue = {"setup","stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
        },
        tags = "@sanity"
)


public class RerunRunner {

}
