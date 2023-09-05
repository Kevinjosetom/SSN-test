package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;


public class Test_Encashui_Password_Reset_Functionality  extends ReusableMethods{
	
	

	public Test_Encashui_Password_Reset_Functionality(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	   Testdata data=new Testdata();
	   readconfig rconfig = new readconfig();
	
	public Test_Encashui_Password_Reset_Functionality launchAndNavigateToUserProfile() throws Exception {
		 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		  Common_methods common = new Common_methods(driver);
          String phoneForPasswordReset = "kumar";
	        Testdata data = new Testdata();
	     // Login to encashoffers
	       
		/// Login to encashui
	        crmui_addcategory.stagingUrl_launch();
		common.encashUILogin(data.phoneForPasswordResetTest + "@mailinator.com", data.password);
//		EncashUIMethods.skipemailverify();
		// Navigate to user profile
		common.navigateToAccountprofile(phoneForPasswordReset);
	
		
		return this;


}
	public void checkVerifyButtonIsDisabled() throws Exception {
		Common_methods common = new Common_methods(driver);
		// Click on change password button
		common.clickChangePasswordButton();
		// Check verify button is disabled
		assertFalse(common.isButtonEnabled("//button[contains(text(),'Verify')]"),
				"Verify button is enabled");
		// Enter correct password
		common.setEnterVerifyPasswordText(data.password);
		click1("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Verify"),
				"Clicking on verify button");

	}
	public void newPasswordTextBoxWrongPasswordTest() throws Exception {
		Common_methods common = new Common_methods(driver);
		// Enter a wrong password and click on verify
		common.setEnterVerifyPasswordText("123");
		// Verify error message is displayed
		assertTrue1(
				common.isElementDisplayed("//div[contains(text(),'Password must have minimum of 6 characters')]"),
				"Error message not displayed");
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).click();
		// Check if red border displayed for the text box
		assertTrue1(
	    common.isElementDisplayed("//input[@id='textToReplace' and contains(@class,'error-input')]".replaceAll("textToReplace", "password")),
				"Red border not displayed for text box");
	}
	public void confirmPasswordTextBoxMismatchingPasswordTest() throws Exception {
		Common_methods common = new Common_methods(driver);
		// Enter a mismatching password
		common.setConfirmPassword(data.password);
		// Verify error message is displayed
		assertTrue1(
				common.isElementDisplayed("//div[contains(text(),'Password does not match')]"),
				"Mismatch password error not displayed");
		driver.findElement(By.xpath("//input[@id='password']")).click();
		assertTrue1(
				common.isElementDisplayed("//input[@id='textToReplace' and contains(@class,'error-input')]".replaceAll("textToReplace", "confirmPassword")),
				"Red border not displayed for text box");
		// Check Update button is disabled
		assertFalse(
				common.isButtonEnabled("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Update")),
				"Verify button is enabled");

	}
	
	public void enterNewPasswordsAndVerify() throws Exception {
		Common_methods common = new Common_methods(driver);
		


		// Enter a valid password in NEW PASSWORD textbox
		common.setEnterVerifyPasswordText(data.password);
		// Verify no error messages are displayed
		assertFalse(
				common.isElementDisplayed("//div[contains(text(),'Password must have minimum of 6 characters')]"),
				"Error message is displayed");
		assertFalse(
				common.isElementDisplayed("//div[contains(text(),'Password does not match')]"),
				"Mismatch password error is displayed");
		assertFalse(
				common.isElementDisplayed("//input[@id='textToReplace' and contains(@class,'error-input')]".replaceAll("textToReplace", "password")),
				"Red border displayed for text box");
		assertFalse(
				common.isElementDisplayed("//input[@id='textToReplace' and contains(@class,'error-input')]".replaceAll("textToReplace", "confirmPassword")),
				"Red border displayed for text box");

	}
	
	public void closePasswordResetDialogAndCheckPasswordNotChanged() throws Exception {
		Common_methods common = new Common_methods(driver);
		click1("//button[@class='btn-close']", "Closing the dialog box");
		// Verify password is not changed
		common.clickChangePasswordButton();
		common.setEnterVerifyPasswordText(data.password);
	}
	
	public void resetToNewPasswordAndVerifyPasswordIsChanged() throws Exception {
		 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		 Common_methods common = new Common_methods(driver);
		
		common.clickVerifyButton();
		// Enter new password and click on update button
		common.setConfirmPassword(data.password);
		common.setEnterVerifyPasswordText(data.password);
		click1("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Update"),
				"Clicking on update button");
		//waitForElementInvisibility("*//div[@title='Profile name']//span[contains(text(),'phoneNumber')]".replaceAll("phoneNumber", "kumar"));
		// Logout and login with new password
		crmui_addcategory.stagingUrl_logout();
		Thread.sleep(8000);
		common.encashUILogin(data.phoneForPasswordResetTest + "@mailinator.com", data.password);
	}
}

