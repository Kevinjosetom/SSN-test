package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;


public class Create_Edit_Disable_TenancyOffer extends ReusableMethods {
	

	public Create_Edit_Disable_TenancyOffer(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}



	public void crmUI_createTenancyOffer() throws Exception {

		// Testdata
		Testdata data = new Testdata();

		String CRMTenancyOfferName = data.CRMTenancyOfferName;
		String CRMTenancyOfferDesc = data.CRMTenancyOfferDesc;
		String CRMTenancyOfferTransferURL = data.CRMTenancyOfferTransferURL;
		String location = data.location;
		String CRMClientForOffer = data.CRMClientForOffer;

 
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	     readconfig rconfig = new readconfig();
	     String CRMCategoryName=data.CRMCategoryName;
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();
	     String actual ="AutomationTenancyOffer1503";
	     String offer= "//*[contains(text(),'SwathiTestOffer2901')]";

	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);

		// Navigate to Offers
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[text()='Offers']", "Goto Offers");
		waitForElementVisibility1("//*[text()=' Offers ']");
	

		// Check if offer exists      
		typeAndWait("//input[contains(@placeholder,'Search')]", CRMTenancyOfferName, "Search for " + CRMTenancyOfferName);
		boolean offerExists = isDisplayed1("//*[contains(text(),'AutomationTenancyOffer1503')]".replaceAll("AutomationTenancyOffer1503", CRMTenancyOfferName),
				"Check if " + CRMTenancyOfferName + " exists");
		if (!offerExists) {
			System.out.println("available CRMOfferName " );
			test.pass("available CRMOfferName ");
		System.out.println("not available CRMOfferName ");
			// More -> Add Campaign  
			clickAndWait("//*[contains(text(),'more_vert')]", "More");
			clickAndWait("//*[contains(text(),'Add Campaign')]", "Add Campaign");
			
			// Add Name, Desc, Client, Location. Click On ADD
			type1("//input[contains(@placeholder,'Name')]", CRMTenancyOfferName, "Add Name");

			// Add Description
			waitForElementPresent("//quill-editor/div[2]/div[1]/p");
			clearAndType("//quill-editor/div[2]/div[1]/p", CRMTenancyOfferDesc,
					"Edited Description to -->" + CRMTenancyOfferDesc);

			// Add Client  
			click1("//mat-select[contains(@placeholder,'Client')]", "Open Client dropdown");
			Thread.sleep(1000);
			clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRMClientForOffer),
					"Select " + CRMClientForOffer);
			
			// Add Location  
			click1("//mat-select[contains(@placeholder,'Location')]", "Open Location dropdown");
			Thread.sleep(1000);
			clickAndWait("//span[contains(text(),' UK ')]"," location");

			// Click on Add Button  
			clickAndWait("//span[contains(text(),'ADD')]", "ADD");

			// Mark the Competition as Active
			click1("//span[contains(text(),'Is Active?')]/../..//input[@role='switch']/..", "Select Is Active");

			// Verify the option "Is Tenancy" is present. It should be switchable. Mark the
			// Offer as Tenancy
			click1("//span[contains(text(),'Is Tenancy?')]/../..//input[@role='switch']/..", "Is Tenancy: is selected");

			// Verify there is a text box to input the Transfer URL. Give a Transfer URL
			// where the user will be directed to upon clicking Tenancy Offer.
			type1("//input[contains(@placeholder,'Transfer URL')]", CRMTenancyOfferTransferURL, "Add Transfer URL");
			
			// Save
			clickAndWait("//span[contains(text(),'SAVE')]", "SAVE");

			goBack("Back");
			
			// Verify Tenancy offer creation  
			typeAndWait("//input[contains(@placeholder,'Search')]", CRMTenancyOfferName, "Search for " + CRMTenancyOfferName);
			boolean offerExists1 = isDisplayed1("//*[contains(text(),'AutomationTenancyOffer1503')]",
					"Check if " + CRMTenancyOfferName + " exists");
			offerExists = isDisplayed1("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRMTenancyOfferName),
					"Check if " + CRMTenancyOfferName + " exists");
			assertTrue1(offerExists, "Tenancy Offer is Displayed.");

			// Click on the Tenancy Offer
			click1("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRMTenancyOfferName),
					"Open " + CRMTenancyOfferName);

			// Verify the Question tab should be disabled
			String QuestionsTabisDisabled = getAttribute("//div[@id='mat-tab-label-1-1']",
					"aria-disabled", "Verifying the Questions tab");
			assertEquals(QuestionsTabisDisabled, "true", "Questions Tab is Disabled for Tenancy Offers");

			// Verify the mandatory count field is disabled.
			boolean isMandatoryQuestionCountEnabled = isButtonEnabled("//input[@name='mandatoryQuestionCount']");
			assertFalse(isMandatoryQuestionCountEnabled,
					"Mandatory Question Count field is Disabled for Tenancy Offers");
		}
		// Logout of Admin
		En_sign.Admin_logout();
	
   } 

	
	public void encashUIVerify_tenancyOffer(String scenario) throws Exception {

		// Test data
		Testdata data = new Testdata();

		String CRMTenancyOfferName = data.CRMTenancyOfferName;
		String CRMTenancyOfferName_edited = "Edited" + data.CRMTenancyOfferName + "Edited";
		String CRMTenancyOfferTransferURL = data.CRMTenancyOfferTransferURL;
		String CRMTenancyOfferTransferURL_edited = data.CRMTenancyOfferTransferURL_edited;

		// Navigate to Encash Offer Home Page and Serch for Tenancy Offer
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		crmui_addcategory.stagingUrl_launch();

		clickAndWait("//a[contains(text(),'Offers')]", "Click on Offers");
		clickAndWait("//input[@placeholder='Search']", "Click on Search");

		if (scenario == "original") {
			typeAndWait("//input[@placeholder='Search']", CRMTenancyOfferName,
					"Type " + CRMTenancyOfferName);

			scrollToView("//*[@id='testimonial-wrapper']/div/div", "Scroll to testimonials");
			scrollToView("//input[@placeholder='Search']", CRMTenancyOfferName);
			
			// Click on Tenancy Offer
			waitForElementVisibility1("//*[contains(text(),'text1')]".replaceAll("text1",CRMTenancyOfferName));
		//	clickAndWait("//*[contains(text(),'toReplaceLinkText')]".replaceAll("toReplaceLinkText",CRMTenancyOfferName), "Click on the offer");
            // windowHandle();
			// Verify the Web page mentioned in the Transfer URL is navigated.
		//	List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		//	driver.switchTo().window(browserTabs.get(1));
		//	Thread.sleep(3000);
		//	waitForElementPresent("//*[text()='Register']");
		//	String webPageTitle = driver.getTitle();
		//	String webUrl = driver.getCurrentUrl();
//			assertEquals(webPageTitle,
//					"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
//					"Verifying the Transfer URL Title");
//			assertEquals(webUrl, CRMTenancyOfferTransferURL, "Verifing the Transfer URL");

		//	driver.close();
		//	driver.switchTo().window(browserTabs.get(0));
//			waitForElementVisibility1("//span[contains(text(),'toReplaceLinkText')]/..".replaceAll("toReplaceLinkText"
//					,CRMTenancyOfferName));
		}

		if (scenario == "edited") {  
			typeAndWait("//input[@placeholder='Search']", CRMTenancyOfferName_edited,
					"Type " + CRMTenancyOfferName_edited);

			scrollToView("//*[@id='testimonial-wrapper']/div/div", "Scroll to testimonials");
			scrollToView("//input[@placeholder='Search']", "Scroll");

			// Click on Tenancy Offer
			waitForElementVisibility1("//span[contains(text(),'toReplaceLinkText')]/..".replaceAll("toReplaceLinkText",CRMTenancyOfferName_edited));
			clickAndWait("//span[contains(text(),'toReplaceLinkText')]/..".replaceAll("toReplaceLinkText"
					,CRMTenancyOfferName_edited), "Click on the offer");

			// Verify the Web page mentioned in the Transfer URL is navigated.
		//	List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		//	driver.switchTo().window(browserTabs.get(1));
		//	Thread.sleep(3000);
		//	String webPageTitle = driver.getTitle();
		//	String webUrl = driver.getCurrentUrl();

//			assertEquals(webPageTitle,
//					"Get the Best Online Deals In UK, Best Internet Deals of the Day, Hot Deals Today",
//					"Verifying the Transfer URL Title");
//			assertEquals(webUrl, CRMTenancyOfferTransferURL_edited, "Verifing the Transfer URL");

		//	driver.close();
		//	driver.switchTo().window(browserTabs.get(0));
			waitForElementVisibility1("//span[contains(text(),'toReplaceLinkText')]/..".replaceAll("toReplaceLinkText"
					,CRMTenancyOfferName_edited));

		}
	}
	
	public void crmUI_editTenancyOffer() throws Exception {
		Testdata data = new Testdata();

		String CRMTenancyOfferName = data.CRMTenancyOfferName;
		String CRMTenancyOfferName_edited = "Edited" + data.CRMTenancyOfferName + "Edited";
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	     readconfig rconfig = new readconfig();
	     String CRMCategoryName=data.CRMCategoryName;
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();

	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);
		
		// Navigate to Offers
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[text()='Offers']", "Goto Offers");
		Thread.sleep(7000);
		waitForElementPresent("//*[text()=' Offers ']");
		typeAndWait("//input[contains(@placeholder,'Search')]", CRMTenancyOfferName, "Search for " + CRMTenancyOfferName);

		// Click on the Tenancy Offer  
		click1("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRMTenancyOfferName),
				"Open " + CRMTenancyOfferName);

		// Edit Name   
		clearAndType("//input[contains(@placeholder,'Name')]", CRMTenancyOfferName_edited, "Edit Name");

		// Edit Description
		waitForElementPresent("//quill-editor/div[2]/div[1]/p");
		// clearAndType(CRMWebLocators.encash_crm_offer_or_comp_description,
		// CRMTenancyOfferDesc_edited,"Edited Description to -->" +
		// CRMTenancyOfferDesc_edited);
		clear("//quill-editor/div[2]/div[1]/p", "Edited Description");

		// Remove the URL. The transfer URL should be left blank.
		clearAlt("//input[contains(@placeholder,'Transfer URL')]", "Removed URL");
		Thread.sleep(3000);
		
		// Save   
		clickAndWait("//span[contains(text(),'SAVE')]", "SAVE");
		Thread.sleep(5000);
		refresh("Refresh the page");
		Thread.sleep(5000);
		// Logout from CRM application
		En_sign.Admin_logout();

	}
	
	public void crmUI_disableOffer(String offerName) throws Exception {
		Testdata data = new Testdata();

		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	     readconfig rconfig = new readconfig();
	     String CRMCategoryName=data.CRMCategoryName;
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();

	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);
		// Testdata
		String CRMOfferName = offerName;

		// Navigate to Offers
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[text()='Offers']", "Goto Offers");
		Thread.sleep(9000);
		// Disable Offer 
		typeAndWait("//input[contains(@placeholder,'Search')]", CRMOfferName, "Search for " + CRMOfferName);
		click1("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRMOfferName),
				"Open " + CRMOfferName);
		click1("//span[contains(text(),'Is Active?')]/../..//input[@role='switch']/..", "De-select Is Active");
		clickAndWait("//span[contains(text(),'SAVE')]", "SAVE");
		
		goBack("Back");

		// Logout of Admin
		En_sign.Admin_logout();
	}

	
}
