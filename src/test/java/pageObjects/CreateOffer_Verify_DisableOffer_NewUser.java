package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionEngine.readconfig;
import Resuable.ReusableMethods;
import data.Testdata;


public class CreateOffer_Verify_DisableOffer_NewUser extends ReusableMethods{

	@FindBy(xpath="//span[text()='Offers']")
    WebElement Goto_Offers;
	
	@FindBy(xpath="//*[text()=' Offers ' ]")
    WebElement Offers;
		
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//span[contains(text(),'Add Campaign')]")
    WebElement add_Campaign;

	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(linkText = "Competitions")
    WebElement Competitions_linktest;
	
	@FindBy(xpath="//*[text()=' Categories ']")
    WebElement caregories_Text;
	
	@FindBy(xpath="//*[contains(text(),' Competitions ')]")
    WebElement Competition_Text;
	
	@FindBy(xpath ="//input[contains(@placeholder,'Name')]")
    WebElement campaign_name;
	
	@FindBy(xpath ="//mat-select[contains(@placeholder,'Client')]")
    WebElement client_Dropdown;
	
	@FindBy(xpath ="//mat-select[contains(@placeholder,'Location')]")
    WebElement client_location;
	
	@FindBy(xpath ="//*[@placeholder='Choose categories']")
    WebElement categories_DropDown;
	
	@FindBy(xpath ="//*[contains(text(),' test@2691 ')]")
    WebElement categories_test2691;
	
	@FindBy(xpath ="//button[@class='mat-focus-indicator mat-icon-button mat-button-base']")
    WebElement date_picker;
		
	@FindBy(xpath ="//*[@id='mat-tab-content-0-0']/div")
    WebElement Escape_categories_DropDown;
	
	@FindBy(xpath ="//*[text()='ADD']")
    WebElement Categorie_Add;
	
	@FindBy(xpath ="//*[text()=' New Competition ']")
    WebElement New_Competition;
	
	@FindBy(xpath ="//*[text()=' SSN Internal ']")
    WebElement client_Dropdown_List;
	
	@FindBy(xpath ="//*[text()=' UK ']")
    WebElement client_location_UK;
	
	@FindBy(xpath ="(//*[@id='mat-slide-toggle-7']//following-sibling::div)[1]")
    WebElement Status_toggle;
	
	@FindBy(xpath ="//*[text()='Status']")
    WebElement Status;
	
	@FindBy(xpath ="//*[text()='SAVE']")
    WebElement save;
	
	@FindBy(xpath ="//span[contains(text(),'Is High Value?')]/../..//input[@role='switch']/..")
    WebElement High_Value;
	
	@FindBy(xpath ="//span[contains(text(),'ADD')]")
    WebElement ADD;
	
	@FindBy(xpath ="//*[contains(text(),'SwathiTestOffer2901')]")
    WebElement CRMofferName;
	
	@FindBy(xpath ="//div[contains(text(),'Questions')]")
    WebElement Questions;
	
	 
   public CreateOffer_Verify_DisableOffer_NewUser(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
	
    }
   Testdata data = new Testdata();
  public CreateOffer_Verify_DisableOffer_NewUser crmUI_createOffer() throws Exception {
		// Testdata
	  
		String CRMOfferName = data.CRMOfferName;
	//	String offer= "//*[text()='Test Offers @Kumar']";
        String actual ="Test Offers @Kumar";
        String CRMofferName ="//*[contains(text(),'SwathiTestOffer2901')]";
        
        encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
        readconfig rconfig = new readconfig();
        String username= rconfig.getusername();
        String crmpwd= rconfig.getcrmPwd();
		
		
		En_sign.Admin_login( username ,crmpwd);

  	  //Expand Encash Offers and go to Clients 
        waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
  		click(EncashOffers_linktest, "EncashOffers_linktest");
		waitTime();
		click(Goto_Offers, "Goto_Offers");
		waitTime();
		waitForElementVisibility(Offers, "Offers");
		text(SearchText, CRMOfferName, "Search for " + CRMOfferName);
		Thread.sleep(5000);
		String offer= driver.findElement(By.xpath("//*[text()='Test Offers@test']")).getText();
       // boolean offerExists = driver.findElement(By.xpath("//*[contains(text(),'SwathiTestOffer2901')]")).isDisplayed();
			if (actual.equals(offer)) {
				Thread.sleep(2000);
				System.out.println("available CRMOfferName " );
				test.pass("available CRMOfferName ");
			}
		 else {
			System.out.println("not available CRMOfferName ");
			
			// More -> Add Campaign
		
		click(right_side3Dots, "right_side3Dots");
		click(add_Campaign, "add_Campaign");
		waitTime();
		text(campaign_name, CRMOfferName, "campaign_name");
		click(client_Dropdown, "client_Dropdown");
		click(client_Dropdown_List,"client_Dropdown_List");
		click(client_location, "client_Dropdown");
		click(client_location_UK, "client_location_UK");
		waitTime();
		click(categories_DropDown, "categories_DropDown");
		// Need to select shopping from the drop down , but list not having name with 
		// shopping have fix issue for temporarily name given for automate
		waitTime();
		click(categories_test2691,"categories_DropDown_Gaming");
		waitTime();
		escape();
		//click(Escape_categories_DropDown, "Escape_categories_DropDown");
		click(High_Value, "High_Value");
		waitTime();
		scrollByElement(Escape_categories_DropDown, "Escape_categories_DropDown");
//		click(Categorie_Add, "Categorie_Add");
//		waitTime();
//		click(Status_toggle, "Status_toggle");
		waitForElementVisibility(ADD, "ADD_New_Campaign");
		scrollByElement(ADD, "ADD_New_Campaign");
		waitTime();
		click(ADD, "ADD_New_Campaign");
		//issue with the saving details
		//waitForElementVisibility(save, "save_New_Catrgorie");
		//click(save, "save");
		waitTime();
		goBack("Back");
		waitTime();
		text(SearchText, data.CRMOfferName, "Search for "+CRMOfferName);
		waitTime();
		
//		isDisplayed2(CRMofferName, "verify CRMofferName");
//		boolean offerExists = isDisplayed2(CRMOfferName, "Check if " + CRMOfferName + " exists");
//		if(!offerExists) {
		//assertTrue(offerExists, "Verify");
		
		 }
			
			
			En_sign.Admin_logout();
			return this;
  
       }




  public CreateOffer_Verify_DisableOffer_NewUser crmUI_AddQuestionsToOffer() throws Exception {
	  
	  
	  encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
      readconfig rconfig = new readconfig();
      String username= rconfig.getusername();
      String crmpwd= rconfig.getcrmPwd();
      
	  En_sign.Admin_login( username ,crmpwd);


  waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
	click(EncashOffers_linktest, "EncashOffers_linktest");
	waitTime();
	click(Goto_Offers, "Goto_Offers");
	waitTime();
	waitForElementVisibility(Offers, "Offers");
	text(SearchText, data.CRMOfferName, "Search for " + data.CRMOfferName);
	click1("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",data.CRMOfferName), "Open " + data.CRMOfferName);
	click(Questions, "Questions");
	
	// need to fix issues regarding add campaign so i am not able go further for automation
	
	waitTime();
	click1("//*[contains(text(),'Add Questionnaire')]", "Click on Questions tab");
	
//	String actual= "Client Questions (1 segments)";
//	String offer= driver.findElement(By.xpath("//span[contains(text(),'Client Questions (1 segments)]")).getText();
//    // boolean offerExists = driver.findElement(By.xpath("//*[contains(text(),'SwathiTestOffer2901')]")).isDisplayed();
//	if (actual.equals(offer)) {
//				Thread.sleep(2000);
//				System.out.println("available CRMOfferName " );
//				test.pass("available CRMOfferName ");
//			}
//		 else {
//			System.out.println("not available CRMOfferName ");
//			
//			// More -> Add Campaign
//	
//		clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName"
//				,"Add Questionnaire"), "Add Questionnaire");

		// 1st questionnaire
		// click(CRMWebLocators.encash_crm_competitions_questionnarie_dropdown, "select
		// the 1st dropdown");
		
		waitForElementPresent("//mat-select[contains(@placeholder,'toReplaceDropdownName')]".replaceAll("toReplaceDropdownName"
				,"Select Questionnaire"));
		click1("//mat-select[contains(@placeholder,'toReplaceDropdownName')]".replaceAll("toReplaceDropdownName","Select Questionnaire"), "Click on Select Questionnaire");
		// Client Questions (1 segments)
		click1("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",data.CRMOfferQuestion1), "Selected the question type " + data.CRMOfferQuestion1);

		// addition of question click on the Add button i.e. '+'
		click1("//*[@id='cdk-drop-list-1']/div[1]/button", "clicking on the + symbol");

		// 2nd questionnaire
		click1("//*[@id='mat-select-12']", "select the 2nd dropdown");
		waitForElementPresent("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",data.CRMOfferQuestion2));
		click1("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",data.CRMOfferQuestion2), "Selected the question type " + data.CRMOfferQuestion2);

		clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName"
				,"SAVE"), "SAVE");

	    
	goBack("Back");
//	angularWait();
	  En_sign.Admin_logout();
	return this;

  }
  public CreateOffer_Verify_DisableOffer_NewUser crmUI_disableOffer() throws Exception {
	  encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
      readconfig rconfig = new readconfig();
      String username= rconfig.getusername();
      String crmpwd= rconfig.getcrmPwd();
      En_sign.Admin_login( username ,crmpwd);
		
	  
	    waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		waitTime();
		click(Goto_Offers, "Goto_Offers");
		waitTime();
		waitForElementVisibility(Offers, "Offers");
		text(SearchText, data.CRMOfferName, "Search for " + data.CRMOfferName);
		
//		click(CRMWebLocators.encash_crm_isActive, "De-select Is Active");
//		clickAndWait(CRMUIMethods.appLink("SAVE"), "SAVE");

		goBack("Back");
	    waitTime();
		En_sign.Admin_logout();
	  
	return this;
	
	
    }	
}

         		
	
		
		

  
