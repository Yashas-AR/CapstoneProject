package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "features" }, glue = { "test" }, plugin = { "pretty",
		"json:Report1" }, dryRun = false, monochrome = true

)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}
