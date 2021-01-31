package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = { "src/test/resources/Features" }, glue = {
		"StepDefs" }, monochrome = true, dryRun = false)
public class JunitTest {

}
