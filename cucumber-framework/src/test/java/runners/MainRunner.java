package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/brink/cucu/features",
		glue = "com.brink.cucu.steps", monochrome = true, tags = {"@test1"},
		plugin = { "pretty", "html:target/cucumber",
				"json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter: target/report.html" })
public class MainRunner {

}
