package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

public class CreateOffer_Verify_DisableOffer_ReturningUser extends ReusableMethods {
	@FindBy(xpath="(//a[contains(text(),'Offers')])[1]")
    WebElement Offers_linktext;
	
	@FindBy(xpath="//img[@title='Profile icon']")
    WebElement user_profile;
	
	@FindBy(xpath="//div[contains(text(),'My offers')]")
    WebElement My_Offers;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
    WebElement logout;
	
	@FindBy(xpath="//*[@placeholder='Search']")
    WebElement Search;
	
	
	
	
	
	
	  Testdata data=new Testdata();
	  readconfig rconfig = new readconfig();
		public String username= rconfig.getusername();
		public String crmpwd= rconfig.getcrmPwd();


	
	public CreateOffer_Verify_DisableOffer_ReturningUser(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	
	public CreateOffer_Verify_DisableOffer_ReturningUser encashUIVerifyOffer_returningUser() throws Exception {
		String CRMOfferName = data.CRMOfferName;
		

		waitForElementVisibility(Offers_linktext,"Offers_linktext");
		click(Offers_linktext, "Offers_linktext");
		waitTime();
		text(Search, CRMOfferName,"Search for " + data.CRMOfferName);
		//text(SearchText, data.CRMOfferName, "Search for " + data.CRMOfferName);

////	typeAndWait(EncashUIMethods.textFieldWithPlaceholder("Search"), CRMOfferName, "Type " + CRMOfferName);
////	scrollToView(EncashUIMethods.textFieldWithPlaceholder("Search"), "Scroll");
//
//		waitForElementVisibility(EncashUIMethods.spanLink(CRMOfferName));
//		clickAndWait(EncashUIMethods.spanLink(CRMOfferName), "Click on the offer");
//	    EncashUIMethods.skipemailverify();
//
//		encashUI_availOffer_returningUser();

	
		return this;
		
  }
	
	
	public CreateOffer_Verify_DisableOffer_ReturningUser encashUI_myOffers() throws Exception {
		
		Thread.sleep(5000);
		click(user_profile, "click on the user_profile");
		waitTime();
		click(My_Offers, "click on My_Offers");
//		assertTrue(isDisplayed(EncashUIMethods.spanLink(data.CRMOfferName), "Offer name " + data.CRMOfferName),
//				"Verify if " + data.CRMOfferName + " is displayed");
		
		
		
		
		
		return this;
	
	
	}	
}