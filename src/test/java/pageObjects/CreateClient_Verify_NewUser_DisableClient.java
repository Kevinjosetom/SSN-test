package pageObjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class CreateClient_Verify_NewUser_DisableClient extends ReusableMethods {

	@FindBy(xpath="//*[@id='navbarSupportedContent']/div/a/div[1]/img")
    WebElement profile_ion;	
	
	@FindBy(xpath="//*[@title='Edit communication preferences']")
    WebElement Edit_communication_preferences;
	
	@FindBy(xpath="(//*[contains(text(),'Utility')])[1]")
    WebElement Scrool_intoView_Utility;
	
	@FindBy(xpath="//*[contains(text(),'Swathi Test Client 0902')]")
    WebElement Verify_New_client_is_listed;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement Save_client;
	@FindBy(xpath="(//*[contains(text(),' Register ')])[1]")
    WebElement click_on_the_Register_button;
	
	@FindBy(xpath="//input[@placeholder='Enter your UK mobile number']")
    WebElement Enter_your_UK_mobile_number;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue_button;

	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue;
	
	
   public CreateClient_Verify_NewUser_DisableClient(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
    }
   public CreateClient_Verify_NewUser_DisableClient encashUIVerifyClient_newUser() throws Exception {
	   crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
	
	// Verify partners - Expand category
			//passing directly for utility access in the profile
	   click(profile_ion, "Edit profile details");
	   waitTime();
	   click(Edit_communication_preferences, "Edit_communication_preferences");//upto this
	  // Expand category
	   scrollByElement(Scrool_intoView_Utility, "Scrool_intoView_Utility");
	   clickAndWait2(Scrool_intoView_Utility, "click_on_Utility ");
	   
		// Verify New client is listed
	   isDisplayed(Verify_New_client_is_listed, "Verify_New_client_is_listed_Swathi Test Client 0902");
	   String Actual_client=driver.findElement(By.xpath("//*[contains(text(),'Swathi Test Client 0902')]")).getText();
	   String expected_client = "Swathi Test Client 0902";
	   verifyText(Actual_client, expected_client);
		   
	// Save and complete registration
	   click(Save_client, "Click on Save");
//	   click(EncashUIMethods.spanLink("Continue"), "Continue");//(modified by kumar)
	   Thread.sleep(10000);
//	   EncashUIMethods.skipemailverify();//(modified by kumar)

	   crmui_addcategory.stagingUrl_logout();
	   
	   return this;
	   
   }
   
   
   public CreateClient_Verify_NewUser_DisableClient register() throws Exception {
		Testdata data = new Testdata();
		String phone="7700150906";
		//String phone="7488810565";
	
		String otp=data.otp;
		//waitForElementVisibility(jishiImage("flying-jishi wow zoomIn ng-star-inserted"));
		//click(buttonWithtext("No, I’ll explore myself"), "click on button Yes, Continue");
		
		
		waitForElementVisibility(click_on_the_Register_button, "Registerd_Button");
		click(click_on_the_Register_button, "click_on_the_Register_button");
		
		//test.info("click on the Register button");
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		Thread.sleep(5000);
		
		//test.info("click on the continue button");
		click(click_on_the_continue_button, "click_on_the_continue_button");
		Thread.sleep(3000);
		
		// OTP validations for pause OTP number in uk temp.mobile numbers
		Otp_validation();
		return this;
		
	
	}
   
   public CreateClient_Verify_NewUser_DisableClient Otp_validation() throws Exception {
		//captcha();
			Testdata data = new Testdata();
			String phone="7700150906";
			String otp=data.otp;
			
		//String otp = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(otp);
		char[] otpchar = otp.toCharArray();
	
	//	//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
		String OTP = locator+"["+i+"]";
		Thread.sleep(500);
			String OTPnumber = Character.toString(otpchar[i-1]);
		driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		waitTime();
		click(click_on_the_continue, "click_on_the_continue");
		
		
		return this;
	}
   
}   
	   
	