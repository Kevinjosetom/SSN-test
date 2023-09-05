package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class Test_User_Registration_Dialog extends ReusableMethods {
	@FindBy(xpath ="//button[contains(text(),' Verify ')]")
    WebElement verify;
	
	@FindBy(xpath = "//span[contains(@title,'Edit profile')]")
    WebElement Edit_Profile;
	
	@FindBy(xpath = "*//div[@title='Profile name']//span[contains(text(),'kumar')]")
    WebElement Profile_Name;
	
	@FindBy(xpath = "//button[contains(text(),' Cancel ')]")
    WebElement Cancel;
	
	

  public Test_User_Registration_Dialog(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
	
  }
  
  public Test_User_Registration_Dialog verifyFieldsHaveMandatoryMarker() throws Exception {
	  
	  Common_methods common = new Common_methods(driver);
	  
	    assertTrue1(common.isUserRegistrationDialogFieldMandatory("TITLE"), "Title is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("FIRST NAME"),
				"First Name is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("LAST NAME"),
				"LAST NAME is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("EMAIL"), "eMAIL is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("GENDER"),
				"GENDER is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("DATE OF BIRTH"),
				"DOB is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("CREATE A PASSWORD"),
				"CREATE A PASSWORD is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("CONFIRM PASSWORD"),
				"CONFIRM PASSWORD is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("SELECT AN USER NAME / DISPLAY NAME"),
				"DISPLAY NAME is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("POSTAL CODE"),
				"POSTAL CODE is not mandatory field");
		assertTrue1(common.isUserRegistrationDialogFieldMandatory("ADDRESS"),
				"ADDRESS is not mandatory field");
	
	  
	return this;
	
  }
  
  public Test_User_Registration_Dialog verifyPlaceHolderTexts()throws Exception {
	  Common_methods common = new Common_methods(driver);

	// TODO Auto-generated method stub
	assertEquals(common.getUserRegistrationDialogFieldPlaceHolderText("FIRST NAME"),
			"Enter your first name", "Place holder text does not match");
	assertEquals(common.getUserRegistrationDialogFieldPlaceHolderText("LAST NAME"),
			"Enter your last name", "Place holder text does not match");
	assertEquals(common.getUserRegistrationDialogFieldPlaceHolderText("EMAIL"),
			"Enter your email address", "Place holder text does not match");
	assertEquals(common.getUserRegistrationDialogFieldPlaceHolderText("CREATE A PASSWORD"), "Password",
			"Place holder text does not match");
	assertEquals(common.getUserRegistrationDialogFieldPlaceHolderText("CONFIRM PASSWORD"),
			"Confirm password", "Place holder text does not match");
	assertEquals(
			common.getUserRegistrationDialogFieldPlaceHolderText("SELECT AN USER NAME / DISPLAY NAME"),
			"@jack.jones", "Place holder text does not match");
	assertEquals(common.getPostalCodePlaceholderText(), "Your postal code",
			"Place holder text does not match");
	assertEquals(common.getUserRegistrationDialogTitleSelctedText(), "Title",
			"Title selection does not match");
	
	return this;

   }
  public Test_User_Registration_Dialog verifyFieldsHaveInvalidTag() throws Exception {
	  Common_methods common = new Common_methods(driver);

	            common.clickContinueButton();
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("TITLE"), "Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("FIRST NAME"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("LAST NAME"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("GENDER"), "Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("DATE OF BIRTH"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("CREATE A PASSWORD"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("CONFIRM PASSWORD"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("SELECT AN USER NAME / DISPLAY NAME"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("POSTAL CODE"),
				"Field is not marked invalid");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("ADDRESS"), "Field is not marked invalid");

	
	return this;
 
    }
  public Test_User_Registration_Dialog validateDOBField() throws Exception {
	  Common_methods common = new Common_methods(driver);

		// Verify DOB cannot be set to less than 18 years
		common.setDOB("1", "jan", "2020");
		assertTrue1(common.isDOBAgeErrorDisplayed(), "Age related error not displayed");
		// Verify invalid DOB is not accepted
		common.setDOB("31", "feb", "1920");
		common.clickContinueButton();
		assertTrue1(common.isDOBInvalidErrorDisplayed(), "Invalid DOB error not displayed");
		return this;

	}
  public Test_User_Registration_Dialog validatePasswordFelds() throws Exception {
	  Common_methods common = new Common_methods(driver);

		// Verify password field character length validation
	  common.setPassword("12345");
		assertTrue1(common.isPasswordLengthValidationErrorDisplayed(),
				"Password length related error not displayed");
		// Verify password matching validation
		common.setConfirmPassword("1234567");
		common.setDisplayName("081");
		return this;

	}
  public Test_User_Registration_Dialog validateDisplayNameField() throws Exception {
	  Common_methods common = new Common_methods(driver);
		Testdata data = new Testdata();

	    // Verify existing display name cannot be used
	//	assertTrue1(common.isDisplayNameNotAvailableMessageDisplayed(),
	//					"Display not available message not displayed");
	//	common.setDisplayName(data.phoneForRegistrationFormTest);
	//	assertFalse(common.isDisplayNameNotAvailableMessageDisplayed(),
	//					"Display available message not displayed");
		assertTrue1(common.isPasswordMismatchErrorDisplayed(), "Password mismatch error not displayed");

		
	return this;

  

  }
  public Test_User_Registration_Dialog validateConsentCheckbox()  throws Exception {
	  Common_methods common = new Common_methods(driver);

	// Verify the consent checkbox is unchceked by default
				assertFalse(common.isConsentChecked(), "Consent checkbox is checked");
				// Verify message asking user to check the box is displayed
				assertTrue1(common.isConsentCheckboxMessageDisplayed(),
						"Consent checkbox message is not displayed");

			

	  
	return this;
    }
       public void validateEmailText() throws Exception {
	      Common_methods common = new Common_methods(driver);
		     Testdata data = new Testdata();

		// eMail already in use message verification
		common.setTitle("Mr.");
		common.setFirstName("FirstName");
		common.setLastName("LastName");
		common.setEmail("123.com");
		common.selectGender("Male");
		common.setDOB("3", "JAN", "1960");
		common.setPassword("tester123");
		common.setConfirmPassword("tester123");
		common.setDisplayName("kumar1");
		common.setPostalCode("KW14YT");
		common.selectAddressFromList(2);
		common.optOutOfMarketingMessages();
		// Verify the checkbox related message is not shown
		assertFalse(common.isConsentCheckboxMessageDisplayed(), "Checkbox related message is displayed");
		// Validate email field by providing various inputs
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@mailinator.");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@@mailinator.com");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@mailinator..com");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@mailinator@.com");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007$@mailinator.com");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@mailinator.c)9");
		assertTrue1(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is not validated");
		common.setEmail("007@mailinator.co.in");
		assertFalse(common.isUserRegistrationDialogFieldInvalid("EMAIL"), "Email field is validated");
		// Enter an already used email
		common.setEmail("7700150906@mailinator.com");
		common.clickContinueButton();
		assertTrue1(common.isEmailErrorMessageDisplayed(), "Email error message not displayed");

	}
  public void validateProfileSummary() throws Exception {
	  
	  Common_methods common = new Common_methods(driver);
	     Testdata data = new Testdata();


		// Cancel the registration
		common.clickCancelButton();
		common.buttonWithtext("Cancel");
		// Verify display name is anonymous
		assertTrue1(common.getProfileDisplayName().equalsIgnoreCase("Anonymous"),
				"Display name not does not match");
		// Navigate to account profile
		common.navigateToAccountprofile("Anonymous");
		// Verify profile details on the account summary
		assertTrue1(common.getProfileNameFromSumamry().equalsIgnoreCase("Anonymous"),
				"Person name does not match");
		assertTrue1(common.getProfileName2FromSummary().equalsIgnoreCase("Anonymous"),
				"Person name does not match");
		// Verify phone number is set on summary page
		assertTrue1(common.getPersonPhoneNumberFromSummary()
				.equals("+44".concat("7893920075")), "Phone number is not set correctly");
		// Verify email is empty
		assertTrue1(common.getPersonEmailFromSummary().equals(""), "Email is not set correctly");

	}
  public void validateProfileDetails() throws Exception {
	  Common_methods common = new Common_methods(driver);
	     Testdata data = new Testdata();

		// Click on edit profile button
		common.clickEditProfile();
		// Verify that personal details are empty
		assertTrue1(common.isPersonalDetailsFieldEmpty("TITLE"), "Title is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("FIRST NAME"), "Firstname is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("LAST NAME"), "Last Name is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("EMAIL"), "EMAIL is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("GENDER"), "Gender is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("DATE OF BIRTH"), "DOB is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("CREATE A PASSWORD"),
				"CREATE A PASSWORD is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("CONFIRM PASSWORD"),
				"CONFIRM PASSWORD is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("SELECT AN USER NAME / DISPLAY NAME"),
				"DISPLAY NAME is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("POSTAL CODE"), "POSTAL CODE is not empty");
		assertTrue1(common.isPersonalDetailsFieldEmpty("ADDRESS"), "ADDRESS is not empty");

	}
}




