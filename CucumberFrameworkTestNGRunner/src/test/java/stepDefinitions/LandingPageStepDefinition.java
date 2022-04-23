package stepDefinitions;



import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String productName;
	public String offerPageProductName;
	private TestContextSetup tc;
	LandingPage landingPage;

	
	public LandingPageStepDefinition(TestContextSetup tc){
		this.tc=tc;
		this.landingPage =tc.pgm.getLandingPage();
	}

	@Given("^User is on GreenCart Landing page$")
	public void user_is_on_green_cart_landing_page() {
		
		String title=landingPage.getTitleLandingPage();
		//System.out.println(title);
		Assert.assertEquals(title,"GreenKart - veg and fruits kart");
		
	}

	@SuppressWarnings("deprecation")
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String name) throws Throwable {
		
	
		
		//LandingPage landingPage=new LandingPage(tc.driver);
		landingPage.SearchItem(name);
		Thread.sleep(2000);
		tc.productName=landingPage.getProductName().split("-")[0].trim();

		System.out.println(tc.productName);
		
		//tc.driver.findElement(By.xpath("//button/parent::div[@class='product-action']")).click();

	}
	
	@Then("user click on flight booking link")
	public void user_click_on_flight_booking_link() {
		landingPage.clickFlightBookingLink();
		
	}

}
