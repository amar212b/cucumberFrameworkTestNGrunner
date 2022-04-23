package stepDefinitions;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OfferPageStepDefinition {

	public WebDriver driver;
	public String productName;
	public String offerPageProductName;
	TestContextSetup tc;
	OffersPage offersPage;

	public OfferPageStepDefinition(TestContextSetup tc) {
		this.tc = tc;
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String name) throws Throwable {
		String parentHandle = tc.pgm.driver.getWindowHandle();
		switchToOffersPage(parentHandle);
		
		OffersPage offersPage=new OffersPage(tc.pgm.driver);
		offersPage.searchItem(name);
		Thread.sleep(1000);
		offerPageProductName = offersPage.getProductName();
		System.out.println(offerPageProductName);
		//close the child window
		//tc.pgm.driver.close();
		// switch to the parent window
		//tc.pgm.driver.switchTo().window(parentHandle);
		
		//tc.pgm.driver.quit();
	}


	public void switchToOffersPage(String parentHandle ) {
		
		LandingPage landingPage=tc.pgm.getLandingPage();
		landingPage.clickTopDealsLink();

		Set<String> handles = tc.pgm.driver.getWindowHandles();

		Iterator<String> itr = handles.iterator();
		//String parentWindow=itr.next();
		while (itr.hasNext()) {
			
			String childWindow=itr.next();

		if (!parentHandle.equals(childWindow)) {
				// Switch to child window
				tc.pgm.driver.switchTo().window(childWindow);
			}
		}
		}


	@And("^validate product name in offers page matches with Landing Page$")
	public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {

		Assert.assertEquals(tc.productName, offerPageProductName);
	}

}
