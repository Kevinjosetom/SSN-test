package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class Bank_Details_Page_Validation extends ReusableMethods {
	@FindBy(xpath="//*[@formcontrolname='accountName']")
    WebElement accountName;
	
	@FindBy(xpath="//*[@formcontrolname='shortCode']")
    WebElement shortCode;
	
	@FindBy(xpath="//*[@formcontrolname='accountNumber']")
    WebElement accountNumber;
	
	@FindBy(xpath="//*[@formcontrolname='bankName']")
    WebElement bankName;
	
	@FindBy(xpath="//*[@type='radio']")
    List<WebElement> date_radio;
	
	@FindBy(xpath="//*[text()='Bank Name']")
    WebElement clicking_Outside;
	
	@FindBy(xpath="//*[text()='Bank Details']")
    WebElement bank_page_title;
	
	@FindBy(xpath="//*[@formcontrolname='giveConcent']")
    WebElement Give_Concent;
	
	@FindBy(xpath="//*[@formcontrolname='acceptTerms']")
    WebElement acceptTerms;
	
	@FindBy(xpath="//*[text()=' Next ']")
    WebElement Bank_Next_Button;
	
	public Bank_Details_Page_Validation(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public Bank_Details_Page_Validation fields_Validations_Message() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
		
		waitForElementVisibility(bank_page_title,"bank_page_title");
//		String title_acual = driver.findElement(By.xpath("//*[text()='Bank Details']")).getText();
		String title_acual = bank_page_title.getText();
		String Actual= "Bank Details";
		verifyText(Actual, title_acual);
		waitTime();
		text(accountNumber,data.Account_Number, "accountNumber");
		text(accountName,data.Account_Name, "accountName");
		accountName.clear();
		text(shortCode,data.ShortCode, "shortCode");
		shortCode.clear();
		click(clicking_Outside, "clicking_Outside for bank validation");
		waitTime();
		assertTrue1(common1.is_Validation_Displayed(" Please enter valid name on account. "), " Name on Account related error not displayed");
		assertTrue1(common1.is_Validation_Displayed(" Sort Code is required. "), "  Sort Code related error not displayed");
		assertTrue1(common1.is_Validation_Displayed(" Account Number is required. "), " Account number related error not displayed");		
		return this;

    }
	
	public Bank_Details_Page_Validation Bank_Details_Validate_Placeholders_Fields() throws Exception {
		    YBC_Common_Methods common1= new YBC_Common_Methods(driver);
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("accountName"),
			"Name on Account", "accountName Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("shortCode"),
			"Sort Code", "shortCode Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("accountNumber"),
			"Account Number", "accountNumber Place holder text does not match");
	assertEquals(common1.getUserRegistrationDialogFieldPlaceHolderText("bankName"), "Bank Name",
			"bankName Place holder text does not match");
	
	return this;
	
	}
	
	
	public Bank_Details_Page_Validation Bank_Date_Available_Validations_Message() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		
		        waitTime();
		        waitTime();
		   for(int i=0;i<date_radio.size();i++) {
		    	date_radio.get(i).click();
		    	waitForElementPresent("//*[@role='alert']");
		    	Thread.sleep(2000);
		    	String message= driver.findElement(By.xpath("//*[@role='alert']")).getText();
				System.out.println("Toaster message"+message);
			if(message.contains("Settelment Date is available")) {
				Thread.sleep(1000);
				System.out.println("Toaster message"+message);
				break;
			}
			
		}
		
		return this;
	
    }
	
	public Bank_Details_Page_Validation verifyFieldsHaveInvalidTag() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		
		assertTrue1(common1.isUserRegistrationDialogFieldInvalid("accountName"), "accountName Field is not marked invalid");
		assertTrue1(common1.isUserRegistrationDialogFieldInvalid("shortCode"),
				"shortCode Field is not marked invalid");
		assertTrue1(common1.isUserRegistrationDialogFieldInvalid("accountNumber"),
				"accountNumber Field is not marked invalid");
		assertTrue1(common1.isUserRegistrationDialogFieldInvalid("bankName"),
				"bankName Field is not marked invalid");
		return this;
	}
	
	
	public Bank_Details_Page_Validation verifyFieldsHave_MandatoryTag() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Name on Account"), "Name on Account is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Sort Code"),
			"Sort Code is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Account Number"),
			"Account Number is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Bank Name"), "Bank Name is not mandatory field");
	assertTrue1(common1.isCustomer_INformation_DialogFieldMandatory("Preferred payment date"),
			"Preferred payment date is not mandatory field");
	return this;
	
	
  }
	
	public Bank_Details_Page_Validation Validate_Bankname_Field_validData() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();


		waitTime();
		text(accountName,data.Account_Name1, "accountName");
		waitTime();
		text(shortCode,data.ShortCode1, "shortCode");
		waitTime();
		text(accountNumber,data.Account_Number1, "accountNumber");
		waitTime();
		accountNumber.sendKeys(Keys.TAB);
//		click(clicking_Outside, "clicking_Outside for bank validation");
		
		assertTrue1(common1.is_Validation_Displayed(" Bank Validated "), "Bank name validation success message not displayed");	
	    waitTime();
	    waitTime();
		return this;

    }
	
	public Bank_Details_Page_Validation Validate_Bankname_Field_validData2() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();


		waitTime();
		text(accountName,data.Account_Name3, "accountName");
		waitTime();
		text(shortCode,data.ShortCode3, "shortCode");
		waitTime();
		text(accountNumber,data.Account_Number3, "accountNumber");
		waitTime();
		accountNumber.sendKeys(Keys.TAB);
//		click(clicking_Outside, "clicking_Outside for bank validation");
		
		assertTrue1(common1.is_Validation_Displayed(" Bank Validated "), "Bank name validation success message not displayed");	
	    waitTime();
		return this;

    }
	
	
	
	public Bank_Details_Page_Validation Validate_Bankname_Field_InvalidData() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();


		waitTime();
		text(accountName,data.Account_Name2, "accountName");
		waitTime();
		text(shortCode,data.ShortCode2, "shortCode");
		waitTime();
		text(accountNumber,data.Account_Number2, "accountNumber");
		Thread.sleep(1000);
//		click(clicking_Outside, "clicking_Outside for bank validation");
		accountNumber.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		assertTrue1(common1.is_Validation_Displayed(" Sort Code and Account Number do not match "), "Bank validation failure message not displayed");		
		waitTime();
		accountNumber.clear();
		shortCode.clear();
		accountName.clear();
		waitTime();
		return this;

    }
	public Bank_Details_Page_Validation Submit_concent_Terms() throws Exception {
		scrollByElement(Give_Concent, "Next button");
		waitTime();
		click(Give_Concent, "the give Concent");
		waitTime();
		click(acceptTerms, "the acceptTerms&conditions ");
		waitTime();
		click(Bank_Next_Button, "the Bank_Details_Next_Button");
		
		
		return this;
  }}