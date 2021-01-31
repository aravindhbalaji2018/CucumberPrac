package StepDefs;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.utils.PropUtil;
import com.ui.utils.WebDriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebSiteLaunch {

	WebDriverFactory wbf = new WebDriverFactory();
	PropUtil pu = new PropUtil();
	Properties prop;
	WebDriver driver;

	@Before(order = 0)
	public void getAllProperties() {
		this.prop = pu.getPropObj();
	}

	@Before(order = 1)
	public void initDriver() throws Exception {
		wbf.initLocalDriver(prop.getProperty("browserName"));
		this.driver = wbf.getDriver();
	}

	@Given("url is")
	public void url_is(DataTable data) {
		List<List<String>> d = data.asLists();

		// Write code here that turns the phrase above into concrete actions
		for (int i = 1; i < d.size(); i++)
			driver.get(d.get(i).get(0));
	}

	@Then("expected title should be {string}")
	public void title_is(String expectedTitle) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		try {

			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions.titleContains(expectedTitle));

		} catch (Exception e) {
			throw new Exception("Expected title :: " + expectedTitle + " not found");
		}
		System.out.println("Title :: " + driver.getTitle());

	}

	@After
	public void tearDown(Scenario s) {

		String scenarioName = s.getName();

		if (s.isFailed())
			System.out.println("Sceanario '" + scenarioName + "' Execution Failed");
		else
			System.out.println("Sceanario '" + scenarioName + "' Execution Passed ");

		driver.quit();
	}

}
