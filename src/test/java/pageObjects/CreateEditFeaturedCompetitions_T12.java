package pageObjects;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionEngine.readconfig;
import Resuable.ReusableMethods;
import data.Testdata;

public class CreateEditFeaturedCompetitions_T12 extends ReusableMethods{

	@FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continue_text;
	
	
	
		
		
	public CreateEditFeaturedCompetitions_T12(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public CreateEditFeaturedCompetitions_T12 crmUI_createNewFeaturedCompetition() throws Exception {
			encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);

			Testdata data=new Testdata();
			  readconfig rconfig = new readconfig();
			 String username= rconfig.getusername();
				 String crmpwd= rconfig.getcrmPwd();
			
		
		// Test data
		String CRMFeaturedComp = data.CRMFeaturedComp;

		// Launch and Login
		En_sign.Admin_login(username, crmpwd);
		// Expand Encash Offers and go to Competitions
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[contains(text(),'UI Configurations')]", "Expand UI Configurations");
		scrollToView("//span[text()='Featured Competitions']", "Scroll to Featured Competitions");
		jsClick("//span[text()='Featured Competitions']", "Goto Featured Competitions");
		Thread.sleep(8000);
		//driver.get(
		//		"http://crm.staging.ssnsolutions.com.s3-website-eu-west-1.amazonaws.com/admin/#/apps/encash-offers/ui-config/featured-competitions");
		//angularWait();

		//Delete if already created   //span[contains(text(),'Test2')]
		//boolean flag = isDisplayed1("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName"
		//		,CRMFeaturedComp), "Is competition already created?");
		//if(flag) {
		//	scrollToView("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName"
		//			,CRMFeaturedComp),"Scroll to featured competition");
		//	click1("//span[contains(text(),'toReplaceItemName')]".replaceAll("toReplaceItemName"
		//			,CRMFeaturedComp)+"//mat-icon[contains(text(),'close')]","Delete "+CRMFeaturedComp);
		//	clickAndWait("//mat-icon[contains(text(),'save')]","Save");
//		}

		// Add
		clickAndWait("//mat-icon[contains(text(),'add')]", "Add featured competition");
		Thread.sleep(5000);
		scrollToView("//span[contains(text(),'18ct White Gold Engagement Ring')]/following::div",
				"Scroll to view newly added featured competition");
		clickAndWait("//span[contains(text(),'18ct White Gold Engagement Ring')]/following::div",
				"Click on the last featured competition dropdown");
		waitTime();
		type1("//input[contains(@placeholder,'Search offers & competitions')]", CRMFeaturedComp, "Type new comp name");
		click1("//*[text()=' Test2 ']", "Select featured competition");
		waitTime();
		// Save
		clickAndWait("//mat-icon[contains(text(),'save')]", "Save");
		Thread.sleep(5000);
		En_sign.Admin_logout();
		// Logout
		// CRMUIMethods.logout();
		return this;
	}
	
		
	
	public List<String> getFeaturedCompetitionslist() throws IOException {

		List<WebElement> elements = getWebElement("mat-select-value-");
		List<String> featurenamelist = new ArrayList<String>();
		for (WebElement featurename : elements) {
			scrollByElement(featurename, "scroll to name");
			System.out.println("featurename " + featurename.getText());
			featurenamelist.add(featurename.getText());
		}
		return featurenamelist;

	}
	public void verifyFeatureCompetitions(List<String> CRMadminfeaturedComp) throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory  = new crmUI_AddCategoryToExistingCompetition(driver);
		// Launch the application
		crmui_addcategory.stagingUrl_launch();
		test.info("clicking on the Competitions button in home page" );
		//waitForElementPresent(normalLink("Competitions"));
		clickHyperlink("Competitions", "clicking on the Competitions button with out login");

		waitForElementVisibility1("//div[@class='card wow slideInUp']");
		scrollToView("//*[@id='competition-sticky']", "Scroll down to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll up to competitions");

		//get the list of all the feature offers 
		List<WebElement> compCard = getWebElement("//div[@class='card wow slideInUp']");

		//List to store the featured tag name for later verification 
		List<String> encashfeaturelist = new ArrayList<String>();
		Thread.sleep(1000);
		for(WebElement eachComp : compCard) {
			test.info("inside the each loop");
			Thread.sleep(1000);
			//get the webelements list which is having only featured tag in Competitions
			//verifying the Feature tag are present
			try {
				//feature tag verification
				WebElement featuretag = eachComp.findElement(By.xpath("span"));Thread.sleep(1000);
				test.info("featuretag name -- "+ featuretag.getText());
				assertEquals("FEATURED", featuretag.getText(), "Verify the feature tag");
				// feature name are stored in the list
				WebElement compname = eachComp.findElement(By.xpath("div[2]/a/span")); 
				scrollByElement(compname, "scroll each offers");
				encashfeaturelist.add(compname.getText());
				test.info("Competition names are :- " + compname.getText());

			}catch (Exception e) {

				//an element not found exception are through because feature tag will be present for few element 
				//so break the loop		
				break;

			}
		}
		System.out.println("Size of encashfeaturelist -- "+encashfeaturelist.size());
		System.out.println("Size of CRMadminfeaturedComp -- "+CRMadminfeaturedComp.size());
		//verify both the list that is encashfeaturelist and CRMadminfeaturedComp are same
		assertTrue1(encashfeaturelist.equals(CRMadminfeaturedComp), "verify the featured competition list are same");
	}
	public void crmUI_dragDropFeaturedCompetition(String Sourcefeaturenametodrag, String DestinationFeaturenamedrop)
			throws Exception {
		Common_methods common = new Common_methods(driver);
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);

		Testdata data = new Testdata();
		  readconfig rconfig = new readconfig();
	        String username= rconfig.getusername();
	        String crmpwd= rconfig.getcrmPwd();

		
		// Test data
		String CRMFeaturedComp = data.CRMFeaturedComp;

		// Launch and Login
		En_sign.Admin_login(username, crmpwd);

		// Expand Encash Offers and go to Competitions
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[contains(text(),'UI Configurations')]", "Expand UI Configurations");
		scrollToView("//span[text()='Featured Competitions']", "Scroll to Featured Competitions");
		clickAndWait("//span[text()='Featured Competitions']", "Goto Featured Competitions");
		Thread.sleep(8000);
//		driver.get(
//				"http://crm.staging.ssnsolutions.com.s3-website-eu-west-1.amazonaws.com/admin/#/apps/encash-offers/ui-config/featured-competitions");


		scrollToView("//span[contains(text(),'Test2')]", "Scroll to featured competition");

		// get the list of all feature offers
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the sourcefeature webelement   
		WebElement sourcefeaturename = null, destinationfeaturename = null;

		// get the sourcefeature webelement
		for (WebElement sourcefeature : elements) {
			if (sourcefeature.getText().equals(Sourcefeaturenametodrag)) {
				test.info("sourcefeaturename " + sourcefeature.getText());
				sourcefeaturename = sourcefeature;
				test.info("assign to sourde " + sourcefeaturename.getText());
			}
		}
		// get the destinationfeature webelement
		for (WebElement destinatefeature : elements) {
			if (destinatefeature.getText().equals(DestinationFeaturenamedrop)) {
				test.info("destinatefeaturename " + destinatefeature.getText());
				destinationfeaturename = destinatefeature;
				test.info("destinatefeaturename " + destinationfeaturename.getText());
			}
		}

	//	dragAndDrop(sourcefeaturename, destinationfeaturename);

		// Save
		clickAndWait("//mat-icon[contains(text(),'save')]", "Save");

		// Logout
		// CRMUIMethods.logout();

	}
	public void crmUI_deleteFeaturedCompetition() throws Exception {
		Common_methods common = new Common_methods(driver);
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);

		Testdata data = new Testdata();
		readconfig rconfig = new readconfig();
	    String username= rconfig.getusername();
	    String crmpwd= rconfig.getcrmPwd();
		
		// Test data
		String CRMFeaturedComp = data.CRMFeaturedComp;

		// Launch and Login
		En_sign.Admin_login(username, crmpwd);

		// Expand Encash Offers and go to Competitions
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		clickAndWait("//span[contains(text(),'UI Configurations')]", "Expand UI Configurations");
		scrollToView("//span[text()='Featured Competitions']", "Scroll to Featured Competitions");
		clickAndWait("//span[text()='Featured Competitions']", "Goto Featured Competitions");
		Thread.sleep(10000);
//		driver.get(
//				"http://crm.staging.ssnsolutions.com.s3-website-eu-west-1.amazonaws.com/admin/#/apps/encash-offers/ui-config/featured-competitions");

		waitForElementPresent_long("(//span[contains(text(),'Featured Competitions')])[2]");
	    scrollToView("//span[contains(text(),'Test2')]", "Scroll to featured competition");


		// Delete
		click1("(//mat-icon[contains(text(),'close')])[24]",
				"Delete " + CRMFeaturedComp);

		// Save
		clickAndWait("//mat-icon[contains(text(),'save')]", "Save");

		// Logout
		En_sign.Admin_logout();

	}
	public void encashUI_verifyDeletionOfFeaturedCompetition() throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory =new crmUI_AddCategoryToExistingCompetition(driver);
		// Test data
		Testdata data = new Testdata();
		String CRMFeaturedComp = data.CRMFeaturedComp;

		// Launch the application
		crmui_addcategory.stagingUrl_launch();
        waitForElementPresent("//*[(text()=' Competitions ')]");
        Thread.sleep(6000);
		// Goto Competition tab
		//clickAndWait("//span[contains(text(),'Competitions')]", "Goto Competition tab");
		clickHyperlink("Competitions", "Goto Competition tab");
		waitTime();

		// Verify deletion  
		type1("//*[@placeholder='Search']", CRMFeaturedComp, "Search for " + CRMFeaturedComp);
		scrollToView("//*[@id='competition-sticky']", "Scroll down to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll up to competitions");
		String tag = getText("//a[@title='Test2']", "Get tag");
		assertNotEquals(tag, "FEATURED", "Verify");
		test.info("Verify featured tag is not displayed");
		// boolean flag=isDisplayed(EncashUIMethods.featuredTag(CRMFeaturedComp),
		//		 "Check"," if featured tag is displayed");
 	    // assertFalse(flag, "Verify featured tag is not displayed");
	}

}
