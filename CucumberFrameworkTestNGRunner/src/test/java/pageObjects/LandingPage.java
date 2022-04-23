package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.cssSelector("input.search-keyword");
	By productName = By.cssSelector("h4.product-name");
	By productAction = By.xpath("//button/parent::div[@class='product-action']");
	//By topDeals = By.linkText("Top Deals");
	By topDeals=By.xpath("//a[@href='#/offers']");
	By flightBooking=By.xpath("//a[contains(text(),'Flight')]");

	public void SearchItem(String name) {
		WebElement searchProduct = driver.findElement(search);
		// wait.until(ExpectedConditions.visibilityOf(searchProduct)).sendKeys(name);
		searchProduct.sendKeys(name);
	}
	
	public String getProductName() {
		String item=driver.findElement(productName).getText();

		// wait.until(ExpectedConditions.visibilityOf(searchProduct)).sendKeys(name);
		return item;
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void clickTopDealsLink() {
		driver.findElement(topDeals).click();

	}
	
	public void clickFlightBookingLink() {
		driver.findElement(flightBooking).click();

	}
	
	
}
