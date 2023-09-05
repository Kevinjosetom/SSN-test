package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ActionEngine.readconfig;
import Resuable.ReusableMethods;
import data.Testdata;

public class forgotPasswordTest extends ReusableMethods {
	
	public forgotPasswordTest(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	   Testdata data=new Testdata();
	   readconfig rconfig = new readconfig();

	public void launchAndClickOnForgotPassword() throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		// launch encash offers
		crmui_addcategory.stagingUrl_launch();
		// Enter phone number and Click on login button"
		click1("//button[contains(text(),'Login')]", "the Login");
		waitTime();
		// Click on forgot password button
		click1("//button[contains(text(),'Forgot password?')]", " Forgot Password button");
	}  

	public void enterPasswordAndOTP() throws Exception {
		Common_methods common = new Common_methods(driver);
	    Testdata data=new Testdata();
		   
		common.setPhoneNumber(data.phoneForPasswordResetTest_mailVerify);
		common.clickContinueButton();
		common.setLoginOTP(data.otp);
		common.clickContinueButton();
		
		
		}

	public void enterNewPasswordAndVerifySuccessMessage() throws Exception {
		Common_methods common = new Common_methods(driver);
		   Testdata data=new Testdata();
		common.setPasswordInResetDialog(data.password);
		click1("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Continue"),
				"Clicking on the continue button");
		assertEquals(
				getText("//h3[contains(text(),'Email and password updated successfully')]",
						"Getting success message text"),
				"Email and password updated successfully", "Comparing the messages");
		Thread.sleep(1000);
		click1("//button[@class='btn-close']", "Closing the message dialog");
		waitForElementInvisibility("//div[@class='ladda-progress']");
	}

	public void loginWithNewPasswordVerifyPasswordReset() throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		Common_methods common = new Common_methods(driver);
		   Testdata data=new Testdata();
		   String Email = data.phoneForPasswordResetTest_mailVerify+"mailinator.com";
		   String Display = data.phoneForPasswordResetTest_mailVerify;
		   String password = data.password;
		common.setPhoneNumber(data.phoneForPasswordResetTest_mailVerify);
		   

		// launch encash offers
		crmui_addcategory.stagingUrl_logout();
		//common.encashUILogin(data.emailForPostalCodeTest, "123456");
		common.encashUILogin(Email,password);
		waitForElementVisibility1(("*//div[@title='Profile name']//span[contains(text(),Display)]".replaceAll("Display",Display)));
				
		assertEquals(common.getProfileDisplayName(), Display, "Verifying display is not correct");
		Thread.sleep(8000);
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(8000);
	}

}

