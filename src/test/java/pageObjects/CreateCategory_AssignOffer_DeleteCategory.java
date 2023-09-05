package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ActionEngine.readconfig;
import Resuable.ReusableMethods;
import data.Testdata;

public class CreateCategory_AssignOffer_DeleteCategory extends ReusableMethods {
	
	
	public CreateCategory_AssignOffer_DeleteCategory(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
		
		
		
		
		// TODO Auto-generated constructor stub
	
	public CreateCategory_AssignOffer_DeleteCategory crmUI_createNewCategory() throws Exception {
		
			encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		     readconfig rconfig = new readconfig();
		     Testdata data = new Testdata();
		     String CRMCategoryName=data.CRMCategoryName;
		     String username= rconfig.getusername();
		     String crmpwd= rconfig.getcrmPwd();


		  // Launch and Login
			En_sign.Admin_login( username ,crmpwd);
		

			//Expand Encash Offers and go to Categories
			clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
			clickAndWait("//span[contains(text(),'Categories')]","Goto Categories");
			
			Thread.sleep(20000);

			//Click on the more button (three vertical dots) on the right
			clickAndWait("//mat-icon[contains(text(),'more_vert')]", "More");
			
			//Add client
			clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName"
					, "Add Category"),"Add Category");
            waitTime();
			//Add name & description
			type1("//input[contains(@placeholder,'Name')]", CRMCategoryName, "Add Name");
			
			//Set location to UK
			clickAndWait("//mat-select[contains(@placeholder,'locations')]", "Open Locations dropdown");
			clickAndWait("//span[contains(text(),'UK')]", "Select UK");
			pressKey("//mat-select[contains(@placeholder,'locations')]", Keys.ESCAPE, "Escape key");
			
			//ADD	
			clickAndWait("//span[contains(text(),'ADD')]", "ADD");

			goBack("Go Back");
			
			
			//Verify created client  "//input[contains(@placeholder,'Search')]"
			typeAndWait("//input[contains(@placeholder,'Search')]", CRMCategoryName, "Search for "+CRMCategoryName);
			boolean categoryExists=isDisplayed1("//*[contains(text(),'Test with Stewart')]".replaceAll("Test with Stewart", CRMCategoryName), "Check if "+CRMCategoryName+" exists");
			assertTrue1(categoryExists, "Verify category exists");
			
			//Logout
			En_sign.Admin_logout();

	
		return this;
		

}
	
	public void crmUI_AddCategoryToExistingOffer() throws Exception {
		
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	    readconfig rconfig = new readconfig();
	    Testdata data = new Testdata();
	    String CRMCategoryName=data.CRMCategoryName;
	    String username= rconfig.getusername();
	    String crmpwd= rconfig.getcrmPwd();
	  // Test data
		String CRM_existingOfferName = data.CRM_existingOfferName;
		String CRM_categoryForOffer = data.CRM_categoryForOffer;

	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);
		


		// Expand Encash Offers and go to Competitions
		waitForElementPresent("//span[contains(text(),'Encash Offers')]");
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		Thread.sleep(2000);
		clickHyperlink("Offers", "Goto Offers");
		Thread.sleep(2000);
		waitForElement1(30, "//*[text()=' Offers ']", "offers to load");

		// Search and open existing competition  
		typeAndWait("//input[contains(@placeholder,'Search')]", CRM_existingOfferName, "Search for " + CRM_existingOfferName);
		clickAndWait("//*[contains(text(),'TestOffer')]".replaceAll("TestOffer", CRM_existingOfferName), "Goto " + CRM_existingOfferName);
	
		// Assign category  
		scrollToView("//mat-select[contains(@placeholder,'categories')]", "Scroll to view categories");
		clickAndWait("//mat-select[contains(@placeholder,'categories')]", "Open Categories dropdown");
		clickAndWait("//span[contains(text(),'Test Offers @Kumar')]", "Add Category " + CRM_categoryForOffer);
		pressKey("//input[@formcontrolname='productEndDateTime']", Keys.ESCAPE, "Escape key");
		waitTime();
		clickAndWait("//span[contains(text(),'SAVE')]", "SAVE");
		
		// Logout
		En_sign.Admin_logout();
	}

	
	public void encashUIVerifyOfferInCategory() throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		// Test data
		Testdata data = new Testdata();
		String CRMCategoryName = data.CRMCategoryName;
		String CRM_existingOfferName = data.CRM_existingOfferName;
		
		crmui_addcategory.stagingUrl_launch();
		
		clickAndWait("//a[contains(text(),'Offers')]", "Click on Offers");
		scrollToView("//input[@placeholder='Search']", "Scroll");
		type1("//input[@placeholder='Search']", CRM_existingOfferName,
				"Enter offer name " + CRM_existingOfferName);

		// Scrolling for page render  
		scrollToView("//a[contains(text(),'Privacy policy')]", "Scroll to Privacy policy");
		scrollToView("//input[@placeholder='Search']", "Scroll");
		
		// Verify offer category 
		boolean categoryForOffer = isDisplayed1("//*[text()='Test Offers@Kumar']".replaceAll("Test Offers@Kumar", CRM_existingOfferName),
				"Is category displayed for offer?");
		assertTrue1(categoryForOffer, "Verify offer category");

	} // Test Offers@Kumar
	
	public void crmUI_deleteCategory() throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	    readconfig rconfig = new readconfig();
	    
	     // Test data
	    Testdata data = new Testdata();
	    String CRMCategoryName=data.CRMCategoryName;	
	    String username= rconfig.getusername();
	    String crmpwd= rconfig.getcrmPwd();
		String CRM_existingOfferName = data.CRM_existingOfferName;
		
		//Launch and Login
	    En_sign.Admin_login( username ,crmpwd);
		
	    
		//Expand Encash Offers and go to Categories
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//*[text()='Categories']","Goto Categories");
        waitTime();
        waitForElementPresent("//*[text()=' Categories ']");
		//Search for category to be deleted
		typeAndWait("//input[contains(@placeholder,'Search')]", CRMCategoryName, "Search for "+CRMCategoryName);
		Thread.sleep(4000);
		//Delete
		clickAndWait("//mat-icon[contains(text(),'delete')]","Delete Category");
		clickAndWait("//span[contains(text(),'Confirm')]","Confirm deletion");
		waitTime();
		//Logout
		En_sign.Admin_logout();
	}
}
	

