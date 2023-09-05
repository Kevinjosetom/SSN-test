package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Resuable.ReusableMethods;
import data.Testdata;



public class Postalcode_Test_New_User extends ReusableMethods {
	@FindBy(xpath="(//*[contains(text(),' Register ')])[1]")
    WebElement click_on_the_Register_button;
	
	@FindBy(xpath="//input[@placeholder='Enter your UK mobile number']")
    WebElement Enter_your_UK_mobile_number;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue_button;
	
	@FindBy(xpath="//*[@type='tel']")
    WebElement OTP;
	
	@FindBy(xpath="//*[@id='title']")
    WebElement title;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue;
	
	@FindBy(id="firstName")
    WebElement firstName;
	
	@FindBy(id="lastName")
    WebElement lastName;
	
	@FindBy(id="email")
    WebElement email;
	
	@FindBy(xpath="//*[@id='mat-radio-2']/label/div[2]")
    WebElement Gender_male;

	
	@FindBy(xpath = "//*[@id='day']")
    WebElement Select_day;
	
	@FindBy(xpath = "//*[@id='month']")
    WebElement Select_month;
	
	@FindBy(xpath = "//*[@id='year']")
    WebElement Select_year;
	
	@FindBy(xpath = "//*[@id='password']")
    WebElement password;
	
	@FindBy(xpath = "//*[@id='confirmPassword']")
    WebElement confirm_password;
	
	@FindBy(xpath = "//*[@id='display_name']")
    WebElement Display_name;
	
	@FindBy(xpath = "//*[@id='postalCode']")
    WebElement postalCode;
	
	@FindBy(xpath = "//*[@id='addressLine1']")
	WebElement addressLine1;
	
	@FindBy(xpath = "//*[@id='city']")    
	WebElement city;
	
	@FindBy(xpath = "//*[text()=' Find Address ']")
    WebElement find_Address;
	
	@FindBy(xpath = "//*[@id='customCheck']/label/div")
    WebElement Click_on_the_consent_checkbox;
	
	@FindBy(xpath = "//a[text()=' partners, ']")
    WebElement partners;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continue_;
	
	@FindBy(xpath = "//input[@id='postalCode']")
    WebElement postalCode_text;
	
	@FindBy(xpath ="//span[text()=' Find Address ']")
    WebElement Find_Address;
	
	@FindBy(xpath = "//*[@id='customCheck']/label/div")
    WebElement consent;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continue_button;
	

	@FindBy(xpath = "//button[text()='Save']")
    WebElement Save_concent;
	
	@FindBy(xpath = "//button[contains(text(),'Skip')]")
    WebElement skip;
	
	@FindBy(xpath = "//input[@id='password']")
    WebElement Set_Password;
	
	@FindBy(xpath ="//button[contains(text(),' Verify ')]")
    WebElement verify;
	
	@FindBy(xpath = "//span[contains(@title,'Edit profile')]")
    WebElement Edit_Profile;
	
	@FindBy(xpath = "*//div[@title='Profile name']//span[contains(text(),'kumar')]")
    WebElement Profile_Name;
	
	@FindBy(xpath = "//*[contains(text(),' Cancel ')]")
    WebElement Cancel;
	
	@FindBy(xpath = "//span[contains(text(),' Find Address ')]")
	 WebElement FindAddress;
	

  public Postalcode_Test_New_User(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
  }
  
  
  public Postalcode_Test_New_User registerNewUserForPostalCodeTest(HashMap<String,String> NewRegistration) throws Exception {
	  Encash_Registration_Validations registration = new Encash_Registration_Validations(driver);   
	  crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
	  Testdata data = new Testdata();
	  String Email = data.PhoneForPostalcode+"@mailinator.com";
	  String Display = data.PhoneForPostalcode;
	// Start with registering a new user
	  crmui_addcategory.stagingUrl_launch();
	  
	 // Enter phone number and click continue
    // Enter OTP and click continue
	  registration.Postalcode_Register();
	  
	// Enter all registration details until postal code
		isDisplayed(title,"title");
		//select title
	    selectByText(title, "Mr.");
		waitTime();

		
		//Enter First name
	    text(firstName,data.phoneForPostalCodeTest, "typing first name");
		waitTime();
	    text(lastName, data.lastName, "typing last name");
	    waitTime();
		text(email,Email, "typing email id name");
		waitTime();
	    click(Gender_male,"select Male");
	    waitTime();
	    selectByText(Select_day, NewRegistration.get("date"));
	    waitTime();
	    selectByText(Select_month, NewRegistration.get("Month"));
	    waitTime();
	    selectByText(Select_year, NewRegistration.get("year"));
	    waitTime();
	    text(password,data.password,"typing the password");
	    waitTime();
	    text(confirm_password,data.password,"typing the confirm  password");
	    text(Display_name,Display,"Typing the display name");
	    
	    waitTime();
	  
	return this;

 }
    public Postalcode_Test_New_User enterInvalidPostalCodeAndVerifyTextboxes() throws Exception {
    	Testdata data = new Testdata();
    	
		// Enter postal code xx500x
    	test.info("Postal Code");

		//postalCode_text.clear();
		text(postalCode_text,"xx500x","Enter the postal code");
		test.info("click on the Find address button");
		scrollByElement(Find_Address, "scrolling to find address");
		waitTime();
		click(FindAddress, "the find address");
        Thread.sleep(6000);
		//isDisplayed(addressLine1, "addressLine1 when Enter wrong postal code ");
		assertTrue1(isDisplayed1("//*[@id='addressLine1']","Addressline"), "Checking if Address text box is displayed");
		waitTime();
		assertTrue1(isDisplayed1("//*[@id='city']","city"), "Town/City when Enter wrong postal code");
		Thread.sleep(5000);
		postalCode_text.clear();
		waitTime();
		return this;
	  
		
	
}
	
  
 public Postalcode_Test_New_User entervalidPostalCodeAndVerifyTextboxes() throws Exception {

	 
 	
		// Enter postal code kw14yt
 	test.info("Postal Code");

		//postalCode_text.clear();
		text(postalCode_text,"kw14yt","Enter the postal code");
		test.info("click on the Find address button");
		scrollByElement(Find_Address, "scrolling to find address");
		waitTime();
		click(Find_Address, "Click on the find address button");
		Thread.sleep(5000);    //  
//		assertTrue1(addressLine1, "addressLine1w");
		//assertFalse(isDisplayed1("//*[@id='addressLine1']","Addressline"), "Checking if Address text box is displayed");
		waitTime();
//		assertTrue1(city, "Town/City when Enter wrong postal code");
		return this;
	
}
  	public Postalcode_Test_New_User giveConsent() throws Exception {
		test.info("accept the consent by clicking onthe checkbox");
		click(consent, "click on the consent checkbox");
		return this;
		
	}
	
	public Postalcode_Test_New_User clickContinueButton() throws Exception {
			test.info("clicking on the Continue button in Registering page");
			click(continue_button, "clicked on the continue button");
			waitForElementInvisibility("//div[@class='ladda-progress']");
			return this;
			
		}
	
	public Postalcode_Test_New_User skipemailverify() throws Exception {
			try {
			test.info("skip the email verification");
			waitForElement(20, skip, "Wait for skip to appear");
			click(skip, "Skip the email verification");
	    

		}   catch (Exception e) {
			// TODO Auto-generated catch block
			test.fail("unable to skip the email verification");
			e.printStackTrace();
			Assert.fail();
		    }
			return this;
        }
	public Postalcode_Test_New_User	openEditProfileDialogAndVerifyPostalCode() throws Exception {
		Testdata data = new Testdata();
		  String Display = data.PhoneForPostalcode;
		String password= data.password;
//		click(Profile_Name, "Profile_ICON");
		click1("*//div[@title='Profile name']//span[contains(text(),'kumar')]".replaceAll("kumar", Display), "the Profile name");
		waitForElementVisibility(Edit_Profile, "Edit_Profile");
		click(Edit_Profile, "Edit_Profile");
		String verify_locator= "//button[contains(text(),' Verify ')]";
		waitForElementPresent(verify_locator);
		String attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the verify button is disable");
		waitTime();
		text(Set_Password,password, "Enter password");
		waitTime();
		attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the verify button is enable");
		System.out.println(attribute);
		waitTime();
		click(verify, "verify");
		
		
		return this;
		
		
		
		
	}
	public Postalcode_Test_New_User	modifyPostalCodeCancelAndVerifyChanges() throws Exception {
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		Testdata data = new Testdata();
		String password= data.password; 
		 //postalCode_text.clear();
		text(postalCode_text,"kw1 4yt","Enter the postal code");
//		test.info("click on the Find address button");
		scrollByElement(Find_Address, "scrolling to find address");
		waitTime();
		click(Find_Address, "Click on the find_address button");
		waitTime();
		
		// Verify address and town box is displayed
		
		//isDisplayed(addressLine1, "Address Line1 textbox ");
		waitTime();
		//isDisplayed(city, "Town/City textbox ");
		// Cancel and verify old postal code is saved
		click(Cancel, "cancel on signup page");
		
		waitForElementVisibility(Edit_Profile, "Edit_Profile");
		click(Edit_Profile, "Edit_Profile");
		String verify_locator= "//button[contains(text(),' Verify ')]";
		waitForElementPresent(verify_locator);
		String attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		text(Set_Password,password, "Enter password");
		waitTime();
		attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is enable");
		System.out.println(attribute);
		waitTime();
		click(verify, "verify");
		assertEquals(getPostalCode(), data.kw14yt.toUpperCase(), "Verifying postal code");
		waitTime();
		
		return this;
	

  }
	
   public String getPostalCode()  throws Exception {
     String Postalcode = "//input[@id='postalCode']";
	scrollToView(Postalcode,"Postalcode");
	return jsGetTextById(driver.findElement(By.id("postalCode")));
   }
   public boolean isAddressBoxDisplayed() throws Exception {
	  
	  String address="//*[@id='addressLine1']";
	  
		test.info("Checking if address1 text box is displayed");
		return isDisplayed1(address, "Checking if Address text box is displayed");
	}
   public boolean isTowncityTextBoxDisplayed() throws Exception {
	   String CITY= "//*[@id='city']";
		test.info("Checking if town/city text box is displayed");
		return isDisplayed1(CITY, "Checking if town/city text box is displayed");
	}
   public Postalcode_Test_New_User	modifyPostalCodeSaveAndVerifyChanges() throws Exception {
	   
	   Testdata data = new Testdata();
		String password= data.password;
		
		waitTime();
		 postalCode_text.clear();
		 waitTime();
		text(postalCode_text,data.xx500x,"Enter the postal code");
//		test.info("click on the Find address button");
		scrollByElement(Find_Address, "scrolling to find address");
		waitTime();
		click(Find_Address, "Click on the find_address button");
		waitTime();
		//isDisplayed(addressLine1, "Address Line1 textbox is displayed");
		waitTime();
		//isDisplayed(city, "Town/City textbox is displayed");
		waitTime();
		text(addressLine1,"1 Breck Cottages", "Setting address into address line 1 filed");
		waitTime();
		text(city,data.town_city, "Setting address into address line 1 filed");
		 giveConsent();
					// Save changes
		clickContinueButton();
		Thread.sleep(5000);
		skipemailverify();
		Thread.sleep(3000);
		// Verify new postal code is saved
		waitForElementVisibility(Edit_Profile, "Edit_Profile");
		click(Edit_Profile, "Edit_Profile");
		String verify_locator= "//button[contains(text(),' Verify ')]";
		waitForElementPresent(verify_locator);
		String attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		text(Set_Password,password, "Enter password");
		waitTime();
		attribute = getAttribute(verify_locator, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is enable");
		System.out.println(attribute);
		waitTime();
		click(verify, "verify");
		assertEquals(getPostalCode(), data.xx500x, "Verifying postal code");
		
	 
	   
	   
	   
	return this;
   
   
         
   
   
   
   } 
 }