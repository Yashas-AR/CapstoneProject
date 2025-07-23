package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"test"},
		plugin= {"pretty","json:Report1"},
		dryRun=false,
		monochrome=true
		
		)
public class TestRunner {

}
