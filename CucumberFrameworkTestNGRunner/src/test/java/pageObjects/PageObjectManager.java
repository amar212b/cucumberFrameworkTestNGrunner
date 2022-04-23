package pageObjects;

import org.openqa.selenium.WebDriver;

//class responsible to create objects - factory design pattern
public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offersPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}


	public LandingPage getLandingPage() {
		landingPage=new LandingPage(driver);
		return landingPage;
	}


	public void setLandingPage(LandingPage landingPage) {
		this.landingPage = landingPage;
	}


	public OffersPage getOffersPage() {
		offersPage=new OffersPage(driver);
		return offersPage;
	}


	public void setOffersPage(OffersPage offersPage) {
		this.offersPage = offersPage;
	}

	

}
