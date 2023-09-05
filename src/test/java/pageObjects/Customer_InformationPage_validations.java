package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resuable.ReusableMethods;
import data.Testdata;

public class Customer_InformationPage_validations extends ReusableMethods {
	YBC_Common_Methods common1= new YBC_Common_Methods(driver);
	
	@FindBy(xpath="//*[@formcontrolname='postalCode']")
    WebElement Postalcode;
	
	@FindBy(xpath="//*[contains(text(),' Next ')]")
    WebElement next;
	
	@FindBy(xpath="//*[@formcontrolname='title']")
    WebElement title;
	
	@FindBy(xpath="//*[@formcontrolname='phone']")
    WebElement phone;
	
	@FindBy(xpath="//*[@formcontrolname='email']")
    WebElement email;
	
	@FindBy(xpath="//*[@formcontrolname='lastName']")
    WebElement lastName;
	
	@FindBy(xpath="//*[@formcontrolname='firstName']")
    WebElement firstName;
	
	@FindBy(xpath="//*[@id='recaptcha-anchor']/child::div")
    WebElement Recaptcha;
	
	@FindBy(xpath="//*[@class='recaptcha-checkbox-border']")
    WebElement Recaptcha_Checkbox;
	
	@FindBy(xpath="//*[text()='Find Address']")
    WebElement Find_Address;
	
	@FindBy(xpath="//*[text()=' Next ']")
    WebElement CI_next_button;
	
	@FindBy(xpath="//*[@formcontrolname='addressLine1']")
    WebElement AddressLine1;
	
	@FindBy(xpath="//*[@formcontrolname='addressLine1']")
    WebElement city;
	
	
	
	public Customer_InformationPage_validations(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public Customer_InformationPage_validations verifyFieldsHaveMandatoryMarker() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
    waitForElementPresent("//label[contains(text(),'Title')]/sup");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Title"), "Title is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Last Name"),
			"LAST NAME is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("First Name"),
			"First Name is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Email"), "eMAIL is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Postal Code"),
			"POSTAL CODE is not mandatory field");
	assertFalse(common1.isCustomer_INformation_DialogFieldMandatory_mobile("Phone"),
			"Phone number is mandatory field");
	return this;

}  
	
	public Customer_InformationPage_validations verifyFieldsHaveInvalidTag() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
//	     	waitTime();
//		    text(Postalcode, "123", "for showing field validation message");
//			waitTime();
//		    Postalcode.clear();
			waitTime();
			click(next, "the next button to visible validation messages");
			waitTime();
			assertTrue1(common1.isUserRegistrationDialogFieldInvalid("title"), "Field is not marked invalid");
			assertTrue1(common1.isUserRegistrationDialogFieldInvalid("firstName"),
					"Field is not marked invalid");
			assertTrue1(common1.isUserRegistrationDialogFieldInvalid("lastName"),
					"Field is not marked invalid");
			assertTrue1(common1.isUserRegistrationDialogFieldInvalid("email"), "Field is not marked invalid");
						assertTrue1(common1.isUserRegistrationDialogFieldInvalid("postalCode"),
					"Field is not marked invalid");
			assertFalse(common1.isUserRegistrationDialogFieldInvalid("phone"), "Field is  marked invalid");
			return this;
}
	public Customer_InformationPage_validations CI_Validation_Message_Fields() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		    waitTime();
			assertTrue1(common1.is_Validation_Displayed(" First Name is required. "), "First Name related error not displayed");
			assertTrue1(common1.is_Validation_Displayed(" Last Name is required. "), " Last Name related error not displayed");
			assertTrue1(common1.is_Validation_Displayed("Enter valid email address."), "Email related error not displayed");
//			assertTrue1(common1.is_Validation_Displayed(" Postal code is required. "), "Postal code related error not displayed");
			assertTrue1(common1.is_Validation_Displayed(" Captcha is required. "), "Captcha related error not displayed");
		    waitTime();
			return this;

		}
	public Customer_InformationPage_validations CI_Validate_Placeholders_Fields() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
	    waitTime();
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("firstName"),
			"Enter Your First Name", "firstName Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("lastName"),
			"Enter Your Last Name", "lastName Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("email"),
			"Enter Your Email Address", "email Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("phone"), "Enter your UK Mobile Number",
			"UK Mobile Number Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("postalCode"),
			"Enter Your Postal Code", "Postal Code Place holder text does not match");
    waitTime();
	return this;
	
	}
	
	public Customer_InformationPage_validations Validate_the_postalcode() throws Exception {
		Testdata data = new Testdata();
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")); 
		Thread.sleep(3000);
	    waitTime();
//		selectByText(title, " Mr. ");
//		text(firstName, data.FirstName1, "the first name");
//		Thread.sleep(1000);
//		text(lastName,data.lastName1, "the last name");
//		Thread.sleep(1000);
//		text(email, data.Email1, "the emai address");
//		Thread.sleep(1000);
//		text(phone, data.phone1, "the phone number");
//		Thread.sleep(1000);
//		text(Postalcode, data.Postalcode1, "the postal code");
//		Thread.sleep(1000);
//		click(Find_Address, "the find Address");
//		waitForElementVisibility(AddressLine1, "AddressLine1");
//        assertTrue1(is_field_Displayed("addressLine1"), "addressLine field not Displayed");
//        assertTrue1(is_field_Displayed("city"), "city field not Displayed");
//        waitTime();
//        Postalcode.clear();
//		Thread.sleep(1000);
//		text(Postalcode, data.Postalcode2, "the postal code");
//		Thread.sleep(1000);
//		click(Find_Address, "the find Address");
//		waitTime();
////		scrollByElement(CI_next_button, "CI_next_button");
//		waitTime();
		driver.switchTo().frame(Frame);
		Thread.sleep(5000);
		scrollByElement(Recaptcha_Checkbox, "Recaptcha_Checkbox");
//		driver.switchTo().frame(Frame);
//		selectFrame(Frame, Frame);
		click(Recaptcha_Checkbox, "the Recaptcha heckbox");
		Thread.sleep(30000);
		switchToParentFrame("");
		click(CI_next_button, "the CI_next_button ");
		Thread.sleep(3000);
		
		
		
		
		
		
		
		return this;

	}
	
		
	public Customer_InformationPage_validations Validate_the_Postalcode_Without_Enter_Mobile_Number() throws Exception {
		Testdata data = new Testdata();

		
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")); 
		Thread.sleep(3000);
	    waitTime();
		selectByText(title, " Mr. ");
		text(firstName, data.FirstName1, "the first name");
		Thread.sleep(1000);
		text(lastName,data.lastName1, "the last name");
		Thread.sleep(1000);
		text(email, data.Email1, "the emai address");
		Thread.sleep(1000);
//		text(phone, data.phone1, "the phone number");
//		Thread.sleep(1000);
		text(Postalcode, data.Postalcode1, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
		waitForElementVisibility(AddressLine1, "AddressLine1");
        assertTrue1(is_field_Displayed("addressLine1"), "addressLine field not Displayed");
        assertTrue1(is_field_Displayed("city"), "city field not Displayed");
        waitTime();
        Postalcode.clear();
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode2, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
		waitTime();
//		scrollByElement(CI_next_button, "CI_next_button");
		waitTime();
		driver.switchTo().frame(Frame);
		Thread.sleep(5000);
		scrollByElement(Recaptcha_Checkbox, "Recaptcha_Checkbox");
//		driver.switchTo().frame(Frame);
//		selectFrame(Frame, Frame);
		click(Recaptcha_Checkbox, "the Recaptcha heckbox");
		Thread.sleep(30000);
		switchToParentFrame("");
		click(CI_next_button, "the CI_next_button ");
		Thread.sleep(3000);
		
		
		
		
		
		
		
		return this;

	}

	
	
	public boolean is_field_Displayed(String text) {
		//	test.info("Checking if age related DOB error is displayed");
			try{
				driver.findElement(By.xpath("//*[@formcontrolname='addressLine1']".replaceAll("addressLine1", text))).isDisplayed();
				return true;
			}catch (Exception e) {
				return false;
			}
		}

}