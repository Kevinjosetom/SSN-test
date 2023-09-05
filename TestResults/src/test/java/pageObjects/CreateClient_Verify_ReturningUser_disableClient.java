package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class CreateClient_Verify_ReturningUser_disableClient extends ReusableMethods {

	@FindBy(xpath="(//span[contains(text(),'7893920459')])[2]")
    WebElement Click_on_user_profile;
	
	@FindBy(xpath="//*[@title='Edit communication preferences']")
    WebElement Edit_communication_preferences;
	
	@FindBy(xpath="(//*[contains(text(),'Utility')])[1]")
    WebElement Scrool_intoView_Utility;
	
	@FindBy(xpath="//*[contains(text(),'Swathi Test Client 0902')]")
    WebElement Verify_New_client_is_listed;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement Save_client;

	 
   public CreateClient_Verify_ReturningUser_disableClient(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
    }
   
   
   
  public CreateClient_Verify_ReturningUser_disableClient encashUIVerifyClient_returningUser() throws Exception {
	  crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
	  
	// Verify client for new user
	  crmui_addcategory.stagingUrl_launch().Userlogin();
	  

//	if (isDisplayed(EncashUIMethods.buttonWithtext("Skip"),
//		"Is " + EncashUIMethods.buttonWithtext("Skip") + " diplayed?"))
//	   click(EncashUIMethods.buttonWithtext("Skip"), "Skip the email verification");
	  
	   Thread.sleep(5000);
	   waitForElementVisibility(Click_on_user_profile, "Click_on_user_profile");
       click(Click_on_user_profile, "Click on user profile");
       waitTime();
       click(Edit_communication_preferences, "Edit_communication_preferences");//upto this
	  // Expand category
       waitTime();
	   scrollByElement(Scrool_intoView_Utility, "Scrool_intoView_Utility");
	   waitTime();
	   clickAndWait2(Scrool_intoView_Utility, "click_on_Utility ");
	   
		// Verify New client is listed
	   scrollByElement(Verify_New_client_is_listed, "Verify_New_client_is_listed");
	   isDisplayed(Verify_New_client_is_listed, "Verify_New_client_is_listed_Swathi Test Client 0902");
	   String Actual_client=driver.findElement(By.xpath("//*[contains(text(),'Swathi Test Client 0902')]")).getText();
	   String expected_client = "Swathi Test Client 0902";
	   verifyText(Actual_client, expected_client);
		   
	// Save and complete registration
	   click(Save_client, "Click on Save");
//	   click(EncashUIMethods.spanLink("Continue"), "Continue");//(modified by kumar)
	   Thread.sleep(10000);
//	   EncashUIMethods.skipemailverify();//(modified by kumar)
 	 
	  return this;

}
  }
