 package pageObjects;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class YBC_Confirm_Bank_Details_Page_Validations extends ReusableMethods {
	@FindBy(xpath="//*[text()=' Confirm your bank details ']")
    WebElement Confirm_Page_Title;
	
	@FindBy(xpath="//*[@class='recaptcha-checkbox-border']")
    WebElement Recaptcha_Checkbox;
	
	@FindBy(xpath="//*[contains(text(),'Confirm and Sign up ')]")
    WebElement Confirm_Signup;
	
	@FindBy(xpath="//*[contains(text(),'Payment Confirmation ')]")
    WebElement Payment_Page_Title;
	
	@FindBy(xpath="//*[contains(text(),' Print ')]")
    WebElement print;
	
	@FindBy(xpath="//*[contains(text(),'Next ')]")
    WebElement Payment_Page_Next;
	
	public YBC_Confirm_Bank_Details_Page_Validations(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
	
	public YBC_Confirm_Bank_Details_Page_Validations Bank_details_validation() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		waitForElementVisibility(Confirm_Page_Title, "Page_Title");
		String Actual=Confirm_Page_Title.getText();
		String Expected = "Confirm your bank details";
		verifyText(Actual, Expected);
		waitTime();
		assertTrue1(common1.is_Text_Displayed(data.Account_Name1), " Name on Account not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Account_Number1), "Account number not displayed");
		assertTrue1(common1.is_Text_Displayed(data.ShortCode1), " Short  code not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Bank_Name), " Bank Name  not displayed");
		waitTime();
		driver.switchTo().frame(Frame);
		Thread.sleep(1000);
		click(Recaptcha_Checkbox, "Recaptcha_Checkbox");
		Thread.sleep(30000);
		switchToParentFrame("");
		click(Confirm_Signup, "Confirm_Signup");
		
		
		return this;

}
	public YBC_Confirm_Bank_Details_Page_Validations Bank_details_validation2() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		waitForElementVisibility(Confirm_Page_Title, "Page_Title");
		String Actual=Confirm_Page_Title.getText();
		String Expected = "Confirm your bank details";
		verifyText(Actual, Expected);
		waitTime();
		assertTrue1(common1.is_Text_Displayed(data.Account_Name3), " Name on Account not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Account_Number3), "Account number not displayed");
		assertTrue1(common1.is_Text_Displayed(data.ShortCode3), " Short  code not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Bank_Name3), " Bank Name  not displayed");
		waitTime();
		driver.switchTo().frame(Frame);
		Thread.sleep(1000);
		click(Recaptcha_Checkbox, "Recaptcha_Checkbox");
		Thread.sleep(30000);
		switchToParentFrame("");
		click(Confirm_Signup, "Confirm_Signup");
		
		
		return this;

}

	
	public YBC_Confirm_Bank_Details_Page_Validations Payment_Confirmation2() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
		waitForElementPresent_long("//*[contains(text(),'Payment Confirmation ')]");
		String Actual=Payment_Page_Title.getText();
		String Expected = "Payment Confirmation";
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[contains(text(),'Name on Account')]", " Name on Account");
	    Thread.sleep(1000);
		assertTrue1(common1.is_Text_Displayed(data.Account_Name3), " Name on Account not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Account_Number3), "Account number not displayed");
		assertTrue1(common1.is_Text_Displayed(data.ShortCode3), " Short  code not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Bank_Name3), " Bank Name  not displayed");
		waitTime();
		String Actual_Customername = driver.findElement(By.xpath("//*[text()='Hi "+data.Account_Name3+", Thank you for choosing to pay YBC by Direct Debit.']")).getText();
        String Expected_Customername ="Hi "+data.Account_Name3+", Thank you for choosing to pay YBC by Direct Debit.";
		verifyText(Actual_Customername, Expected_Customername);
		click(print, "the print option");
		waitTime();
		click(Payment_Page_Next, "the Payment_Page_Next_Button");
		
		
		return this;

}
	public YBC_Confirm_Bank_Details_Page_Validations Payment_Confirmation() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
		waitForElementPresent_long("//*[contains(text(),'Payment Confirmation ')]");
		String Actual=Payment_Page_Title.getText();
		String Expected = "Payment Confirmation";
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[contains(text(),'Name on Account')]", " Name on Account");
	    Thread.sleep(1000);
		assertTrue1(common1.is_Text_Displayed(data.Account_Name1), " Name on Account not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Account_Number1), "Account number not displayed");
		assertTrue1(common1.is_Text_Displayed(data.ShortCode1), " Short  code not displayed");
		assertTrue1(common1.is_Text_Displayed(data.Bank_Name), " Bank Name  not displayed");
		waitTime();
		String Actual_Customername = driver.findElement(By.xpath("//*[text()='Hi "+data.Account_Name2+", Thank you for choosing to pay YBC by Direct Debit.']")).getText();
        String Expected_Customername ="Hi "+data.Account_Name2+", Thank you for choosing to pay YBC by Direct Debit.";
		verifyText(Actual_Customername, Expected_Customername);
		click(print, "the print option");
		waitTime();
		click(Payment_Page_Next, "the Payment_Page_Next_Button");
		
		
		return this;

}
	
}