package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class Customer_bank_details_verifivation extends ReusableMethods {
	
	@FindBy(xpath="(//label[text()='Sort Code']/following::input)[1]")
    WebElement Sortcode;
	
	@FindBy(xpath ="(//label[text()='Account Number']/following::input)[1]")
    WebElement Account_Number;
	
	@FindBy(xpath ="(//label[text()='Bank Name']/following::select)")
    WebElement bank_name;
	
	@FindBy(xpath ="(//*[text()='Preferred Payment Date']/following::input)[1]")
    WebElement prefferd_payment;
	
	@FindBy(xpath ="//*[text()='Plan start day']/following::input")
    WebElement plan_start_day;
	
	@FindBy(xpath ="//*[text()=' Submit ']")
    WebElement Submit;
	
	@FindBy(xpath ="//*[text()=' Your cover is confirmed.']")
    WebElement thanku;
	
	@FindBy(xpath ="//*[text()=' ok ']")
    WebElement tq_ok;
	
	@FindBy(xpath ="//*[text()=' Refer a Friend & Get']")
    WebElement Referal_page;
	
	@FindBy(xpath ="//*[text()='Nah, I’m good thanks.']")
    WebElement iam_good_tq;
	
	
	
	
	public Customer_bank_details_verifivation(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
	
	public Customer_bank_details_verifivation customer_bank_Details() throws IOException {
		text(Sortcode, "123456", "sortcode");
		text(Account_Number, "12345678", "account_number");
	//	selectByIndex(bank_name, "ICICI");
		text(prefferd_payment, "28042023","payment_date");
		text(plan_start_day, "30042023", "plan start date");
		click(Submit, "submit");
		
		return this;
	
	}
	public Customer_bank_details_verifivation thank_you_popup() throws IOException {
		
		String Actual_title =thanku.getText();
		String expected_title = "Your cover is confirmed.";
		verifyText(Actual_title, expected_title);
		System.out.println(" successfully navigateted to thank you page");
		click(tq_ok, "tq_ok");
		return this;
	}
	public Customer_bank_details_verifivation Referal_page_popup() throws IOException {
		String Actual_title =Referal_page.getText();
		String expected_title = " Refer a Friend & Get";
		verifyText(Actual_title, expected_title);
		System.out.println(" successfully navigateted to Referal page");
		click(iam_good_tq, "iam_good_tq");
		waitTime();
		return this;
	}
	public Customer_bank_details_verifivation title_validation() {
		String expected ="YBC";
		String Actual= driver.getTitle();
		System.out.println(Actual);
		if(expected.equalsIgnoreCase(Actual)) {
			System.out.println("user  login into to the ybc website sucessfully");
		}
		else{
			System.out.println("user not login to the ybc website");
		}
		return this;
		
		
	}
	}

	
		
		