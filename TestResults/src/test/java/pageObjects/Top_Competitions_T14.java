package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

 public class Top_Competitions_T14 extends ReusableMethods {

	public Top_Competitions_T14(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}



	public Top_Competitions_T14 topCompetitions() throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	     readconfig rconfig = new readconfig();
	     Testdata data = new Testdata();
	     String CRMCategoryName=data.CRMCategoryName;
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();

	  // Launch and Login
		En_sign.Admin_login( username ,crmpwd);

		// Navigate to Offers  
		clickAndWait("//span[contains(text(),'Encash Offers')]", "Expand Encash Offers");
		
		waitForElementPresent("//span[contains(text(),'UI Configurations')]");
		scrollToView("//span[contains(text(),'UI Configurations')]", "scroll to UI Configurations");
		waitForElementVisibility1("//span[contains(text(),'UI Configurations')]");
		test.info("click on UI Configurations");
		clickAndWait("//span[contains(text(),'UI Configurations')]", "Expand UI Configurations");
		
		waitForElementPresent("//span[contains(text(),'Top Competitions')]");
		scrollToView("//span[contains(text(),'Top Competitions')]", "scroll to Top Competitions");
		waitForElementVisibility1("//span[contains(text(),'Top Competitions')]");
		test.info("click on Top Competitions");
		clickAndWait("//span[contains(text(),'Top Competitions')]", "Goto  Top Competitions");
		waitForElementPresent("//*[text()=' Top Competitions ']");
		return this;
		
		
	}


		
		
    public List removetopCompetitionlist(List<String> CRMadmintopCompetitions) throws Exception {
  
    	waitForElementPresent("//*[contains(text(),'Featured Competitions')]");
		scrollToView("//*[contains(text(),'Featured Competitions')]","scroll to Featured Competitions");
		waitForElementVisibility1("//*[contains(text(),'Featured Competitions')]");
		test.info("click on featured Competitions");
		clickAndWait("//*[contains(text(),'Featured Competitions')]","Goto Featured Competitions");
        Thread.sleep(5000);		
        // get the list of all feature offers
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");
		List<String> featurename = new ArrayList<String>();
		// get the sourcefeature webelement                             
		for (WebElement sourcefeature : elements) {
			scrollByElement(sourcefeature, "scroll to name");
			System.out.println("featurename " +featurename.add(sourcefeature.getText()));
			test.info("sourcefeaturename " + sourcefeature.getText());
		}

		CRMadmintopCompetitions.removeAll(featurename);
		waitTime();
		test.info("click on Top Competitions");
		clickAndWait("//span[contains(text(),'Top Competitions')]","Goto  Top Competitions");

		return CRMadmintopCompetitions;

	}
    /**
	 * This method is used to verify the feature offer created present in the CRMAdmin with encash offers
	 * @throws Exception 
	 */
	public void verifyTopCompetition(List<String> CRMadmintopCompetitions) throws Exception {

		test.info("clicking on the Competition button in home page" );
		Thread.sleep(8000);
		waitForElementVisibility1("(//*[@title='Competitions'])[1]");
		//waitForElementPresent(normalLink("Competitions"));
		clickHyperlink("Competitions", "clicking on the Competition button with out login");
        waitTime();
		waitForElementVisibility1("//div[@class='card wow slideInUp']");

		//get the list of all the feature offers 
		List<WebElement> offerscard = getWebElement("//*[@class='card wow slideInUp']");

		//index for competation top offers    
		int i =0 ;
		int topofferssize = CRMadmintopCompetitions.size();
       System.out.println(CRMadmintopCompetitions.size());
		//List to store the featured tag name for later verification 
	List<String> encashfeaturelist = new ArrayList<String>();
		for(WebElement eachoffers : offerscard) {
			System.out.println(eachoffers);
			test.info("inside the each loop");
			//get the webelelements list which is having only featured tag in offers
			//verifyin the Feature tag are present


			// feature name are stored in the list
			WebElement offersname = driver.findElement(By.xpath("//*[@class='card wow slideInUp']//*[text()='Featured']"));
			System.out.println(offersname);
			scrollByElement(offersname, "scroll each offers");
			
			test.info("CRMadmintopoffers name "+ CRMadmintopCompetitions.get(i));
			if(offersname.getText().equals(CRMadmintopCompetitions.get(i))) {
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

		//verify both the list that is encashfeaturelist and CRMadminfeatureoffers are same
		System.out.println("encashfeaturelist :: "+encashfeaturelist.size());
		System.out.println("CRMadmintopCompetitions :: "+CRMadmintopCompetitions.size());
		assertTrue(encashfeaturelist.equals(CRMadmintopCompetitions), "verify the competitions list are same");
	}
	
	public void createTopCompetition(String topCompetitionname) throws Exception {

		// click on the create feature offers button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][1]", "click on the create new Competition featured button");
		// wait for feature offers created
		// WebElement stateless = getElement(CRMWebLocators.waitFeatureofferscreation);
		// waitForElementstaleness(stateless);
		// waitForElementPresent(CRMWebLocators.waitFeatureofferscreation);
		// waitForElementInvisibility(CRMWebLocators.waitFeatureofferscreation);

		Thread.sleep(10000);
		// get the list of featured created newly  
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the new created featured list from list as it is added at the end
		WebElement createdfeatured = elements.get(elements.size() - 1);
		scrollByElement(createdfeatured, "scroll to new created top Competition");
		createdfeatured.findElement(By.xpath("//following-sibling::div")).click();
		
		// in the search box enter the text
		typeAndWait("//input[contains(@placeholder,'Search offers & competitions')]", topCompetitionname, "typing the search Competitions");

		// click on the first options
		click1("//mat-option[starts-with(@class,'mat-option mat-focus-indicator ng-tns-c')]/span[@class='mat-option-text']"
				, "select the first resultoutput");

		// click on the Save featured button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]"
				, "click on the save feature");

	}
	
	/**
	 * This method is used to drag the featured and drop on selected WebElement
	 * 
	 * @param Sourcefeaturenametodrag
	 * @param DestinationFeaturenamedrop
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void dragDropTopCompetitions(String Sourcefeaturenametodrag, String DestinationFeaturenamedrop)
			throws IOException, InterruptedException {
         reloadpage();
         Thread.sleep(15000);
		// get the list of all feature offers  
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the sourcefeature webelement
		WebElement sourcefeaturename = null, destinationfeaturename = null;

		// get the sourcefeature webelement
		for (WebElement sourcefeature : elements) {
			scrollByElement(sourcefeature, "scroll featured Competitions");
			if (sourcefeature.getText().equals(Sourcefeaturenametodrag)) {
				test.info("sourcefeaturename " + sourcefeature.getText());
				sourcefeaturename = sourcefeature;
				test.info("assign to sourde " + sourcefeaturename.getText());
				break;
			}
		}
		// get the destinationfeature webelement
		for (WebElement destinatefeature : elements) {
			scrollByElement(destinatefeature, "Scroll featured Competitions");
			if (destinatefeature.getText().equals(DestinationFeaturenamedrop)) {
				test.info("destinatefeaturename " + destinatefeature.getText());
				destinationfeaturename = destinatefeature;
				test.info("destinatefeaturename " + destinationfeaturename.getText());
				break;
			}
		}

		dragAndDrop(sourcefeaturename, destinationfeaturename);
		// save the featured Competition to reflect the changes in encash
		// click on the Save featured button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]", "click on the save Competition");

	}

	public void deleteTopCompetition(String CompetitionFeatured) throws Exception {

		// get the list of all feature offers
		List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");

		// get the sourcefeature webelement
		for (WebElement sourcefeature : elements) {
			scrollByElement(sourcefeature, "scroll featured Competition");
			if (sourcefeature.getText().equals(CompetitionFeatured)) {
				test.info("sourcefeaturename " + sourcefeature.getText());Thread.sleep(1000);
				WebElement close = sourcefeature.findElement(By.xpath("ancestor::div/button"));
				scrollByElement(close, "scroll to close button");
				close.click();
				test.info("Deleted the top Competition");

				// logger.info("assign to sourde "+ sourcefeature.getText());
				break;
			}
		}
		
			
		

		// click on the Save featured button
		click1("//button[starts-with(@class,'mat-focus-indicator ng-tns-c')][2]", "click on the save feature");

	}

}
