package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;

public class Featured_offers_T11 extends ReusableMethods {
	
	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;

	@FindBy(xpath = "//span[contains(text(),'UI Configurations')]")
    WebElement UI_Configurations_linktest;
	
	
	
	public Featured_offers_T11(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
		
	public  Featured_offers_T11 allOffersFeatures() throws Exception  {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	    readconfig rconfig = new readconfig();
	    String username= rconfig.getusername();
	    String crmpwd= rconfig.getcrmPwd();
	    String Featured_offers="//span[contains(text(),'Featured Offers')]";
	    String UI_configuration= "//span[contains(text(),'UI Configurations')]";
	    
	    
	    En_sign.Admin_login( username ,crmpwd);
	    
	    waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
  		click(EncashOffers_linktest, "EncashOffers_linktest");
		waitTime();
		click(UI_Configurations_linktest, "UI_Configurations_linktest");
		// Navigate to Offers
	    clickAndWait(UI_configuration, "Expand Encash Offers");
		waitForElementPresent(UI_configuration);
		scrollToView(UI_configuration, "scroll to UI Configurations");
		waitForElementVisibility1(UI_configuration);
		test.info("click on UI Configurations");
		clickAndWait(UI_configuration, "Expand UI Configurations");

		waitForElementPresent(Featured_offers);
		scrollToView(Featured_offers, "scroll to Featured Offers");
		waitForElementVisibility1(Featured_offers);
		test.info("click on featured offers");
		clickAndWait(Featured_offers, "Goto  Featured Offers");
		waitForElementPresent_long("//*[text()=' Featured Offers ']");
			
		
		return this;
		
		
	}

}
