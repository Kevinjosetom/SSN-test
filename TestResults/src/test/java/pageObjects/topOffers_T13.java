package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

public class topOffers_T13 extends ReusableMethods {
	
	@FindBy(xpath = "//*[text()='Top Offers']")
    WebElement Top_Offers;
	
	
	
	public topOffers_T13(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	   Testdata data=new Testdata();
	   readconfig rconfig = new readconfig();
	
		/**
		 * This method is used to navigate to feature offers
		 * 
		 * @throws Exception
		 */
      public void topOffers() throws Exception {
	        encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
            readconfig rconfig = new readconfig();
            String username= rconfig.getusername();
            String crmpwd= rconfig.getcrmPwd();
	        String ui_congratulations = "//*[contains(text(),'UI Configurations')]";
	        String top_offers ="//*[contains(text(),'Top Offers')]";
		    En_sign.Admin_login( username ,crmpwd);

			// Navigate to Offers
		    String Encashoffers="//*[contains(text(),'Encash Offers')]";
		    waitForElementPresent(Encashoffers);
		    clickAndWait(Encashoffers, Encashoffers);
			clickAndWait(ui_congratulations, "Expand Encash Offers");
			
//			waitForElementPresent(ui_congratulations);
//			scrollToView(ui_congratulations, "scroll to UI Configurations");
			//waitForElementVisibility1(ui_congratulations);
			test.info("click on UI Configurations");
//			clickAndWait(ui_congratulations, "Expand UI Configurations");
			Thread.sleep(2000);
			
			waitForElementPresent(top_offers);
			scrollToView(top_offers, "scroll to Top Offers");
			//waitForElementVisibility1(top_offers);
			test.info("click on Top Offers");
			clickAndWait(top_offers, "Goto  Top Offers");
			
			waitForElementPresent_long("//*[text()=' Top Offers ']");
			
		}
 public List removetopofferslist(List<String> CRMadmintopoffers) throws Exception {
    waitTime();
	waitForElementPresent("//span[contains(text(),'Featured Offers')]");
	scrollToView("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName", "Featured Offers"),"Featured Offers");
	test.info("click on featured offers");
	clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","Featured Offers"),
			"Goto  Featured Offers");
	waitForElementPresent_long("//*[text()=' Featured Offers ']");
	

	Thread.sleep(2000);
	// get the list of all feature offers
	List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");
	List<String> featurename = new ArrayList<String>();
	// get the sourcefeature webelement
	for (WebElement sourcefeature : elements) {
		scrollByElement(sourcefeature, "scroll featuredoffers");
		featurename.add(sourcefeature.getText());
		test.info("sourcefeaturename " + sourcefeature.getText());
	}

	CRMadmintopoffers.removeAll(featurename);
	Thread.sleep(3000);

	test.info("click on Top Offers");
	mouseHoverAndClick(Top_Offers, "Goto  Top Offers");
	Thread.sleep(5000);
	
	return CRMadmintopoffers;

}
/**
 * This method is used to verify the feature offer created present in the CRMAdmin with encash offers
 * @throws Exception 
 */
public void verifyTopoffer(List<String> CRMadmintopoffers) throws Exception {

	test.info("clicking on the offers button in home page" );
	//waitForElementPresent(normalLink("Competitions"));
	clickHyperlink("Offers", "clicking on the Offers button with out login");
	Thread.sleep(5000);

	waitForElementVisibility1("//div[@class='card wow slideInUp']");

	//get the list of all the feature offers 
	List<WebElement> offerscard = getWebElement("//div[@class='card wow slideInUp']");

	//index for competation top offers
	int i =0 ;
	int topofferssize = CRMadmintopoffers.size();

	//List to store the featured tag name for later verification 
	List<String> encashfeaturelist = new ArrayList<String>();
	for(WebElement eachoffers : offerscard) {
		test.info("inside the each loop");
		//get the webelelements list which is having only featured tag in offers
		//verifyin the Feature tag are present


		// feature name are stored in the list
		WebElement offersname = eachoffers.findElement(By.xpath("div[2]/a/span"));
		scrollByElement(offersname, "scroll each offers");
		test.info("CRMadmintopoffers name "+ CRMadmintopoffers.get(i));
		if(offersname.getText().equals(CRMadmintopoffers.get(i))) {
			encashfeaturelist.add(offersname.getText());
			test.info("offersname are :- " + offersname.getText());
			i++;
			test.info(" i increment to "+ i);
		}
		//break the for loop if i reaches to end of list in CRMadmintopoffers
		test.info("outside the gettext i " + i);
		test.info("outside the gettext size of topofferssize " + topofferssize);
		if(i==topofferssize) {
			//break the loop
			test.info("inside the break loop");
			break;
		}
	}

	//System.out.println("end of the feature vinod");
	//verify both the list that is encashfeaturelist and CRMadminfeatureoffers are same
	System.out.println("encashfeaturelist :: "+encashfeaturelist.size());
	System.out.println("CRMadmintopoffers :: "+CRMadmintopoffers.size());
//	assertTrue1(encashfeaturelist.equals(CRMadmintopoffers), "verify the offer list are same");
 }

/**
 * this method is used to created the Featured offers in CRM admin page
 * 
 * @throws Exception
 */
  public void createTopOffers(String topoffername) throws Exception {
     Thread.sleep(2000);
	// click on the create feature offers button
	click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][1]", "the create new offers featured button");
	// wait for feature offers created
	// WebElement stateless = getElement(CRMWebLocators.waitFeatureofferscreation);
	// waitForElementstaleness(stateless);
	// waitForElementPresent(CRMWebLocators"//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][1]".waitFeatureofferscreation);
	// waitForElementInvisibility(CRMWebLocators.waitFeatureofferscreation);

	 Thread.sleep(2000);
	// get the list of featured created newly
	List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");
	
	// get the new created featured list from list as it is added at the end
	WebElement createdfeatured = elements.get(elements.size() - 1);
//	scrollByElement(createdfeatured, "scroll to new created topoffers");
	createdfeatured.findElement(By.xpath("//following-sibling::div")).click();

	// in the search box enter the text
	typeAndWait("//input[contains(@placeholder,'Search offers & competitions')]", topoffername, "typing the search offers");
	
	// click on the first options
	click1("//mat-option[starts-with(@class,'mat-option mat-focus-indicator ng-tns-c')]/span[@class='mat-option-text']"
			, "select the first resultoutput");

	// click on the Save featured button
	click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]", "click on the save feature");
	Thread.sleep(5000);

}

  public List getOfferFeaturelist() throws IOException, InterruptedException {  
	     waitTime();
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");
		List<String> featurenamelist = new ArrayList<String>();
		for (WebElement featurename : elements)
		{
			Thread.sleep(1000);
			scrollByElement(featurename, "scroll to name");
			System.out.println("featurename " + featurename.getText());
			featurenamelist.add(featurename.getText());
		}
		return featurenamelist;

	}

  
  /**
	 * This method is used to drag the featured and drop on selected WebElement
	 * 
	 * @param Sourcefeaturenametodrag
	 * @param DestinationFeaturenamedrop
	 * @throws IOException
	 */
	public void dragDropTopoffers(String Sourcefeaturenametodrag, String DestinationFeaturenamedrop)
			throws IOException {

		// get the list of all feature offers 
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the sourcefeature webelement
		WebElement sourcefeaturename = null, destinationfeaturename = null;

		// get the sourcefeature webelement
		for (WebElement sourcefeature : elements) {
			scrollByElement(sourcefeature, "scroll featuredoffers");
			if (sourcefeature.getText().equals(Sourcefeaturenametodrag)) {
				test.info("sourcefeaturename " + sourcefeature.getText());
				sourcefeaturename = sourcefeature;
				test.info("assign to sourde " + sourcefeaturename.getText());
				break;
			}
		}
		// get the destinationfeature webelement
		for (WebElement destinatefeature : elements) {
			scrollByElement(destinatefeature, "Scroll featuredoffers");
			if (destinatefeature.getText().equals(DestinationFeaturenamedrop)) {
				test.info("destinatefeaturename " + destinatefeature.getText());
				destinationfeaturename = destinatefeature;
				test.info("destinatefeaturename " + destinationfeaturename.getText());
				break;
			}
		}

		dragAndDrop(sourcefeaturename, destinationfeaturename);
		// save the featured offers to reflect the changes in encash
		// click on the Save featured button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]", "click on the save feature");

	}
	public void deleteTopOffers(String offerfeaturednamed) throws Exception {

		// get the list of all feature offers
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the sourcefeature webelement
		for (WebElement sourcefeature : elements) {
			scrollByElement(sourcefeature, "scroll featuredoffers");
			if (sourcefeature.getText().equals(offerfeaturednamed)) {
				test.info("sourcefeaturename " + sourcefeature.getText());
				WebElement close = sourcefeature.findElement(By.xpath("//ancestor::div/button"));
				scrollByElement(close, "scroll to close button");
				close.click();
				test.info("Deleted the top offers");

				// logger.info("assign to sourde "+ sourcefeature.getText());
				break;
			}
		}

		// click on the Save featured button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]", "click on the save feature");
        waitTime();
	}
  
	
	public void crmUI_application_list() throws Exception {//fixed 02 feb 2021 as per UI changes

		  Common_methods common = new Common_methods(driver);
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	     readconfig rconfig = new readconfig();
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();


	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);
		
		
		//Verify the SSN Admin Title
		assertEquals(getText("//span[@class='logo-text']", "Getting title text of Admin "),"SSN ADMIN", "Verifying the Title");							
		Thread.sleep(5000);
		// 1. Question Bank
		//test.info("Expand Question Bank");
		waitForElement1(30,"//span[contains(text(),'Question Bank')]", "Wait for Survey Questions to load");
	//	click1("//*[text()='Question Bank']", "Expand Question bank");
		// 1a Survey Questions
		common.clickAndVerifyAppTitle("Survey Questions", "Survey Question Bank");

		// 1b Questionnaires
		common.clickAndVerifyAppTitle("Questionnaires", "Questionnaires");

		// contract Question Bank Menu
		click1("//span[contains(text(),'Question Bank')]", "Contract Question bank");

		// 2. Encash Offers
		test.info("Expand Encash Offers"); 
		waitForElement1(120,"//span[contains(text(),'Encash Offers')]", "Wait for Encash Offers to load");
		click1("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		
		// 2a. Clients
		common.clickAndVerifyAppTitle("Clients", "Clients");
		// 2b. Categories
		common.clickAndVerifyAppTitle("Categories", "Categories");
		// 2c. Offers
		common.clickAndVerifyAppTitle("Offers", "Offers");
		// 2d. Competitions
		common.clickAndVerifyAppTitle("Competitions", "Competitions");
		// 2e. Testimonials
		common.clickAndVerifyAppTitle("Testimonials", "Testimonials");

		// 2f. Traffic
		test.info("Expand Traffic Configuration Sub menu");
		waitForElement1(30,"//span[contains(text(),'Traffic')]", "Wait for Traffic menu to load");
		click1("//span[contains(text(),'Traffic')]", "Expand Traffic");
		// Affiliates
		common.clickAndVerifyAppTitle("Affiliates", "Affiliates");
		// Traffic Sources
		common.clickAndVerifyAppTitle("Traffic Sources", "Traffic Sources");

		// 2g. UI Configurations
		test.info("Expand UI Configurations Sub menu");
		waitForElement1(30, "//span[contains(text(),'UI Configurations')]", "Wait for UI Configurations menu to load");
		click1("//span[contains(text(),'UI Configurations')]", "Expand UI Configurations");
		// Home Page Carousel
		common.clickAndVerifyAppTitle("Home Page Carousel", "Home Page Carousel Items");
		// Featured Offers
		common.clickAndVerifyAppTitle("Featured Offers", "Featured Offers");
		// Featured Competitions
		common.clickAndVerifyAppTitle("Featured Competitions", "Featured Competitions");
		// Top Offers
		common.clickAndVerifyAppTitle("Top Offers", "Top Offers");
		// Top Competitions
		common.clickAndVerifyAppTitle("Top Competitions", "Top Competitions");
		
//		//2f. Configurations
//		test.info("Click Configurations Sub menu"); 
//		waitForElement1(30, "//span[text()='Configurations']", "Wait for Configurations menu to load");
//		click1("//span[text()='Configurations']", "Configurations");
//		common.clickAndVerifyAppTitle("Configurations", "Configurations");
		
		// 3. Reports 
		scrollToView("//span[text()='Reports']", "scroll to Reports");
		clickAndWait("//span[text()='Reports']", "Expand Reports");
		scrollToView("//span[text()='Traffic Report']", "scroll to Traffic Reports");
		clickAndWait("//span[text()='Traffic Report']", "Goto Traffic Report");
		// Traffic Reports
		common.clickAndVerifyAppTitle("Traffic Report", "Traffic Reports");
		// Campaign Reports
		common.clickAndVerifyAppTitle("Campaign Report", "Campaign Reports");
//		
//		// 4. User Management  
//		scrollToView("//span[text()='User Management']", "scroll to User Management");
//		clickAndWait("//span[text()='User Management']", "Expand User Management");
//		scrollToView("//span[text()='Users']", "scroll to Users");
//		clickAndWait("//span[text()='Users']", "Goto Users");
//		common.clickAndVerifyAppTitle("Users", "Users");
//	
//
}}
	
	
    
	

