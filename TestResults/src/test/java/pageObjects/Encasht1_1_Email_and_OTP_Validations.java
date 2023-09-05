package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

  public class Encasht1_1_Email_and_OTP_Validations extends ReusableMethods {
	@FindBy(xpath = "//*[@id='search']")
    WebElement Search_Mail;
	
	@FindBy(xpath = "//*[text()='GO']")
    WebElement click_public;
	
	@FindBy(xpath = "//*[contains(@id,'row_')]//td[2]")
    WebElement mailinator;
	
	@FindBy(xpath = "//*[contains(@id,'row_')]//td[2]")
    WebElement Open_FirstMail;
	
	@FindBy(xpath = "//b[1]")
    WebElement wait;
	
	@FindBy(xpath = "//a[@onclick='deleteEmail();']")
    WebElement delete_mail;
	
	@FindBy(xpath ="//*[contains(@id,'otp')]")
    WebElement otp;
	
	
  public Encasht1_1_Email_and_OTP_Validations(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
  }
  
  
  public Encasht1_1_Email_and_OTP_Validations mailOpen(String mailid) throws Exception {
	
	 
		String[] mail = mailid.split("@");
//		type(id("addOverlay"), mail[0], "Enter the mail id");
		text(Search_Mail,"7893920411@mailinator.com", "Enter the mail id");
		Thread.sleep(4000);
		//click on the go button
		//click(id("go-to-public"), "click on the Go button");
		click(click_public, "click on the Go button");
		
		return this;
		
		
		//*[@id='search']	

	}
  
  public void emailOTP(String OTP) throws IOException, InterruptedException {
	  Thread.sleep(3000);
	  String Otp= "//*[contains(@id,'row_')]//td[2]";
		char[] otp = OTP.toCharArray();
		waitForElementPresent("Otp");
		List<WebElement> otpemail = getWebElement(Otp);
		int i=0;
		//Enter the OTP
		for(WebElement e : otpemail) {
			e.sendKeys(Character.toString(otp[i]));
			i++;
		}
		
  }
  public String openMailReadOTP() throws Exception {
	// in chrome it is working fine but facing issue in 
	// firefox because of xpath. 
	//waitForElementPresent(mailinatorDynamicId("row_"));
	//click(mailinatorDynamicId("row_"), "open the first mail");
	String locator = "//b[1]";  
	  
    waitForElementVisibility(mailinator, "mailinator");
    click(Open_FirstMail, "Open_FirstMail");
	waitForFrameAvaiableandSwitch("html_msg_body");

	waitForElementVisibility(wait,"wait");
	String OTP = getText(locator,"wait");

	System.out.println("Read OTP " + OTP);

	// switch to default frame
	switchToParentFrame("switch back to parent frame");

	//deleting the mail
	click(delete_mail, "Deleting Read mail");

	//accept the alert message for deleted mail
	//code has been comment because of mailinator issue
	//waitForAlertPrent();
	//acceptAlert("accept delete mail alert message");

	return OTP;
}

}
