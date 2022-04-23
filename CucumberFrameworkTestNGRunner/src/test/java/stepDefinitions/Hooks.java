package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	
		
	private TestContextSetup tc;

	public Hooks(TestContextSetup tc) {
		super();
		this.tc=tc;
		
		
	}

	@After
	public void AfterScenario() {
		tc.testBase.initDriver().quit();
	}
	
	
	@AfterStep
	public void AddAcreenshot(Scenario scenario) throws IOException {
		
		
		if(scenario.isFailed()) {
			
			File screenshotFilepath=((TakesScreenshot)tc.testBase.initDriver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshotFilepath);
			scenario.attach(fileContent, "image/png", "image");
		}
		
	}
}
