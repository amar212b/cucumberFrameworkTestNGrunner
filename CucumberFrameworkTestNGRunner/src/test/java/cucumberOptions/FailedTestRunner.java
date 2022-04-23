package cucumberOptions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="target/failed_scenarios.txt",glue = "stepDefinitions",monochrome=true,dryRun = false,
				 plugin = {"pretty","html:target/cucumber.html",
						   "json:target/cucumber.json",
						   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestRunner {
	
}
