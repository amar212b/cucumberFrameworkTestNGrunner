package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String productName;
	public PageObjectManager pgm;
	public TestBase testBase;
	
	public TestContextSetup() {
		//super();
		testBase=new TestBase();
		pgm=new PageObjectManager(testBase.initDriver());
	}
	
	

}
