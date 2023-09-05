package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionEngine.readconfig;
import Resuable.ReusableMethods;
import data.Testdata;


  public class createClient_verifyInPrivacyPolicy_DisableClient extends ReusableMethods {
	Testdata data = new Testdata();
	
	
	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(xpath = "//span[contains(text(),'Clients')]")
    WebElement Goto_Clients;

	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//span[contains(text(),'Add Client')]")
    WebElement Add_client;
		
	@FindBy(xpath="//input[contains(@placeholder,'Name')]")
    WebElement Add_name;
	
	@FindBy(xpath="//*[@data-placeholder='Client Description']")
    WebElement Description;
	
	@FindBy(xpath="//mat-select[contains(@placeholder,'Category')]")
    WebElement Open_Category_dropdown;
	
	@FindBy(xpath="//span[contains(text(),'ADD')]")
    WebElement ADD;
	
	@FindBy(xpath="//span[contains(text(),'Is Co-Reg?')]/../..//input[@role='switch']/..")
    WebElement Enable_Co_Reg;
	
	@FindBy(xpath="//mat-select[contains(@placeholder,'Location')]")
    WebElement location_uk;
	
	@FindBy(xpath="//span[text()=' Clients ']")
    WebElement clients;
	
	@FindBy(xpath="//a[contains(text(),'Privacy policy')]")
    WebElement Click_on_Privacy_policy;
	
	@FindBy(xpath="//a[contains(text(),'click here')]")
    WebElement click_here;
	
	@FindBy(xpath="(//*[contains(text(),'Utility')])[1]")
    WebElement Scrool_intoView_Utility;
	
	@FindBy(xpath="//*[contains(text(),'Swathi Test Client 0902')]")
    WebElement Verify_New_client_is_listed;
	
	@FindBy(xpath="//*[contains(text(),'kumar Test Client 0902')]")
    WebElement Swathi_Test_Description_for_client;
	
	@FindBy(xpath="//a[contains(text(),'https://www.test.org.uk/terms/privacy-policy')]")
    WebElement Client_privacy_policy;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//div[contains(text(),'Is Co-reg?')]")
    WebElement Disable_co_reg;
//	
//	@FindBy(xpath="//a[contains(text(),'toReplaceLinkText')]")
//    WebElement Click_on_Privacy_policy;
//	
//	@FindBy(xpath="//a[contains(text(),'toReplaceLinkText')]")
//    WebElement click_here;
	 
   public createClient_verifyInPrivacyPolicy_DisableClient(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
    }
  public createClient_verifyInPrivacyPolicy_DisableClient crmUI_createClient_T15() throws Exception {
	  
	  encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	   readconfig rconfig = new readconfig();
	   String username= rconfig.getusername();
	   String crmpwd= rconfig.getcrmPwd();
	     
		
	  
	  String location2 = "//span[contains(text(),' UK ')]";
	  String CRMClientName=data.CRMClientName;
	  String location=data.location;
	  String categoryForClient= "//span[contains(text(),'Utility')]";
		
	  En_sign.Admin_login( username ,crmpwd);
	  
	  //Expand Encash Offers and go to Clients 
	    waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
		click(EncashOffers_linktest, "EncashOffers_linktest");
	    click(Goto_Clients, "goto_clients");

	    //Pagination		
	    //	lick(CRMWebLocators.encash_crm_itemsPerPage, "Pagination - items per page");
	    //	click(CRMUIMethods.spanLink("100"), "Select 100");

	   //Click on the more button (three vertical dots) on the right
         waitForElementVisibility(clients, " clients");
         click(right_side3Dots, "More");
         
		//Add client
		click(Add_client,"Add Client");
		
		//Add name & description
		text(Add_name, CRMClientName, "Add Name");
		waitTime();
		text(Description, data.CRMFullClientDesc, "Add Desc");
		
		//Enable co-reg
		click(Enable_Co_Reg, "Enable_Co_Reg");
		
		//Set location to UK
		click(location_uk, "location_uk");
		clickAndWait(location2,"Select "+location);
		
		//Set Categories as Utility
		click(Open_Category_dropdown, "Open_Category_dropdown");
		clickAndWait(categoryForClient, "Select "+categoryForClient);
		
		//ADD
		clickAndWait2(ADD, "ADD");
		

		//Verify created client
		//Pagination
		//		click(CRMWebLocators.encash_crm_itemsPerPage, "Pagination - items per page");
		//		click(CRMUIMethods.spanLink("100"), "Select 100");

		//		typeAndWait(CRMUIMethods.txtFld("Search..."), CRMClientName, "Search for "+CRMClientName);
		//		boolean clientExists=isDisplayed(CRMUIMethods.productLink(CRMClientName), "Check if "+CRMClientName+" exists");
		//		assertTrue(clientExists, "Verify");
		
		
		En_sign.Admin_logout();
	
	return this;
	  }
  
  public createClient_verifyInPrivacyPolicy_DisableClient encashUIVerifyClientInPrivacyPolicy() throws Exception {
	  crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
	  encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
       //scrollToView(EncashUIMethods.buttonWithtext("No, I’ll explore
	   //myself"),"Scroll down");
	   // clickAndWait(EncashUIMethods.buttonWithtext("No, I’ll explore myself"),"No,
	   // I’ll explore myself");

		// Go to privacy policy
	   System.out.println("*************** Verifying in Privacy Policy *****************");
	   
	   crmui_addcategory.stagingUrl_launch();
	   Thread.sleep(5000);		
	   scrollBybottom();
	   scrollByElement(Click_on_Privacy_policy, "Click on Privacy policy");
	   click(Click_on_Privacy_policy, "Click_on_Privacy_policy");
	   windowHandle();
	  
	// Under the section "Sharing with partners ', click on 'click here'
	   scrollByElement(click_here, "click_here");
	   click(click_here, "click_here");
	   
	// Expand category
	   scrollByElement(Scrool_intoView_Utility, "Scrool_intoView_Utility");
	  clickAndWait2(Scrool_intoView_Utility, "click_on_Utility ");
	  
	// Verify New client is listed
	   isDisplayed(Verify_New_client_is_listed, "Verify_New_client_is_listed_kumar Test Client 0902");
	   String Actual_client=driver.findElement(By.xpath("//*[contains(text(),'kumar Test Client 0902')]")).getText();
	   String expected_client = "kumar Test Client 0902";
	   verifyText(Actual_client, expected_client);
	  
	// Verify New client_Description
	   isDisplayed(Swathi_Test_Description_for_client,"kumar Test Client 0902");
	   String Actual_client_Description=driver.findElement(By.xpath("//*[contains(text(),'kumar Test Client 0902')]")).getText();
	   String expected_client_Description = "kumar Test Client 0902";
	   verifyText(Actual_client_Description, expected_client_Description);
	// Verify New client_privaacy_policy
	   isDisplayed(Client_privacy_policy, "Client_privacy_policy");
	   String Actual_client_privacy_policy=driver.findElement(By.xpath("//a[contains(text(),'https://www.test.org.uk/terms/privacy-policy')]")).getText();
	   String expected_client_privacy_policy = "https://www.test.org.uk/terms/privacy-policy";
	   verifyText(Actual_client_privacy_policy, expected_client_privacy_policy);
	   close("Close window");
	   	   for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	  waitTime();
	  driver.navigate().to("https://staging-admin.encashoffers.com/admin/");
	  
	 // En_sign.Admin_logout();
	  return this;
  }
  public createClient_verifyInPrivacyPolicy_DisableClient crm_UI_disableClient_T15()throws Exception {
	  String CRMClientName=data.CRMClientName;
	  encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	  readconfig rconfig = new readconfig();
      String username= rconfig.getusername();
      String crmpwd= rconfig.getcrmPwd();
      
    
	  waitTime();
	  En_sign.Admin_login( username ,crmpwd);
   //Expand Encash Offers and go to Clients 
	 click(EncashOffers_linktest, "EncashOffers_linktest");
     click(Goto_Clients, "goto_clients");
     //Pagination
  	 //		click(CRMWebLocators.encash_crm_itemsPerPage, "Pagination - items per page");
  	 //		click(CRMUIMethods.spanLink("100"), "Select 100");

  	//Disable Co-Reg
     waitForElementVisibility(clients, "Waiting for clients");
     text(SearchText, CRMClientName, "Search for "+CRMClientName);
	 //Pagination
  	  //	scrollToView(CRMWebLocators.encash_crm_itemsPerPage, "Scroll to view pagination");
  	  //	click(CRMWebLocators.encash_crm_itemsPerPage,"Click on items per page");
  	 //		click(CRMUIMethods.spanLink("100"),"Select items per page");
  	Thread.sleep(2000);
  	text(SearchText, CRMClientName, "Search for "+CRMClientName);
  	//Table
  	int row=table_getRowNumber("check");
  	Thread.sleep(2000);
  	String cell=table_getCellData(3, row);
  	Thread.sleep(2000);

  	click1(cell, "Select "+CRMClientName);
  	click(Disable_co_reg, "Disable Co-Reg");
//
//  		//SAVE	
//  		clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","SAVE"), "SAVE");
//  		goBack("Back");
//  		///angularWait();
//
  		//Logout
 		En_sign.Admin_logout();
	return this;
  }
  public createClient_verifyInPrivacyPolicy_DisableClient encashUIVerifyClientInPrivacyPolicy_nonCoReg()throws Exception {
	  	// Test data
	  crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
			String CRMClientName = data.CRMClientName;
			String categoryForClient = data.CRM_categoryForClient;
			
			

               waitTime();
			// scrollToView(EncashUIMethods.buttonWithtext("No, I’ll explore
			// myself"),"Scroll down");
			// clickAndWait(EncashUIMethods.buttonWithtext("No, I’ll explore myself"),"No,
			// I’ll explore myself");
               System.out.println("*************** Verifying in Privacy Policy *****************");
        	   
        	   crmui_addcategory.stagingUrl_launch();
        	   Thread.sleep(5000);
        	   scrollBybottom();
        	   scrollByElement(Click_on_Privacy_policy, "Click on Privacy policy");
        	   click(Click_on_Privacy_policy, "Click_on_Privacy_policy");
        	   windowHandle();
        	  
        	// Under the section "Sharing with partners ', click on 'click here'
        	   scrollByElement(click_here, "click_here");
        	   click(click_here, "click_here");
        	   
        	// Expand category
        	   scrollByElement(Scrool_intoView_Utility, "Scrool_intoView_Utility");
        	  clickAndWait2(Scrool_intoView_Utility, "click_on_Utility ");
        	  
        	// Verify New client is listed
       	     isDisplayed(Verify_New_client_is_listed, "Verify_New_client_is_listed_Swathi Test Client 0902");
       	     String Actual_client=driver.findElement(By.xpath("//*[contains(text(),'Swathi Test Client 0902')]")).getText();
       	     String expected_client = "Swathi Test Client 0902";
       	     verifyText(Actual_client, expected_client);  
			
			close("Close window");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		
	
	  
	  return this;  
	    	  
  }
  
	public int table_getRowNumber(String expColumnValue, String... container) {

		int rowNum=0;
        String tablebody ="//mat-table[@role='grid']//mat-row[rowNumber]//mat-icon";

		try {
			String actualColumnValue;
			String tableLocator=tablebody;

			if (container.length>0)
				tableLocator=container[0]+tableLocator;

			int index=tableLocator.indexOf("rowNumber");
			tableLocator=tableLocator.substring(0, (index-1));
			int totalRows= (Integer) getXpathCount(tableLocator, "Get xpath count");

			for(int i=1; i<=totalRows; i++) {
				actualColumnValue=getText(table_getCellData(3,i), "Get text");
				if(actualColumnValue.contains(expColumnValue)) {
					rowNum=i;
					break;
				}
			}
		}
		catch(Exception e) {

		}
		
		return rowNum;
	}
	public String table_getCellData(int colNumber, int rowNumber, String... container) {
        String tablebody = "//mat-table[@role='grid']//mat-row[rowNumber]//mat-icon";
		String tableLocator=tablebody;

		if (container.length>0)
			tableLocator=container[0]+tableLocator;
		if(tableLocator.contains("rowNumber")) 
			tableLocator=tableLocator.replaceAll("rowNumber", Integer.toString(rowNumber));

		return tableLocator;
	}

	
}