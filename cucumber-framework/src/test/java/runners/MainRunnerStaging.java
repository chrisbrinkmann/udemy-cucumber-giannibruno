package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
		glue = "com.brink.cucu.steps", monochrome = true, tags = {"@staging"},
		plugin = { "pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })
public class MainRunnerStaging {

}