package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public WebDriver driver;
	ConfigFileReader configFileReader;

	Properties prop = new Properties();

	public WebDriver initDriver() {
		// Write code here that turns the phrase above into concrete actions
		String currentDir = System.getProperty("user.dir");
		// setting chromedriver system classpath
		// System.setProperty("webdriver.chrome.driver", currentDir +
		// "\\chromedriver.exe");
		configFileReader= new ConfigFileReader();
		//System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		
		if (driver == null) {
			
			if (configFileReader.getBrowser().equalsIgnoreCase("brave")) {
			// Initializing ChromeOptions Object
				ChromeOptions options = new ChromeOptions();
			// Setting Binary Path of Brave Browser in options object.
				options.setBinary(configFileReader.getBravePath());
			//"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			// Initializing Chrome Browser Instance
				driver = new ChromeDriver(options);

			// Maximizing Browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
				driver.get(configFileReader.getApplicationUrl());
					//"https://rahulshettyacademy.com/seleniumPractise/#/");
			}
		}
		return driver;
	}

}
