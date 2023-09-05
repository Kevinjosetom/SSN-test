package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class YBC_Thank_you_And_SocialMediaLink_Validations extends ReusableMethods {
	@FindBy(xpath="//*[contains(text(),'Next ')]")
    WebElement Payment_Page_Next;
	
	@FindBy(xpath="//*[contains(text(),' ok ')]")
    WebElement ok;
	
	@FindBy(xpath="//*[contains(text(),'Yes')]")
    WebElement Yes;
	
	@FindBy(xpath="//*[contains(text(),'Yes')]/following::share-buttons")
    List<WebElement> share_buttons;
	
	@FindBy(xpath="//*[contains(text(),'Yes')]/following::a")
    WebElement Cheers_Now;
	
	@FindBy(xpath="//*[contains(text(),' Activate Now ')]")
    WebElement Activate_Now;
	
	@FindBy(xpath="//*[contains(text(),' Continue ')]")
    WebElement Continue;
	
	@FindBy(xpath="//*[@title='Profile icon']")
    WebElement Profile_icon;
	
	@FindBy(xpath="//*[contains(text(),'Kumar_s')]")
    WebElement user;
	
	@FindBy(xpath="//*[@placeholder=\"Enter your UK mobile number\"]")
    WebElement Mobile_num;
	
	@FindBy(xpath="//*[contains(text(),'Continue ')]")
    WebElement mob_continue;
	
	@FindBy(xpath="//*[contains(text(),' Continue ')]")
    WebElement continue1;
	
	
	
	public YBC_Thank_you_And_SocialMediaLink_Validations(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
	
	public YBC_Thank_you_And_SocialMediaLink_Validations Thank_You_page_Validations() throws Exception {
		
		
		String Expected = "Thank you for choosing Your Brand Cover!";
		
		waitForElementVisibility1("//*[contains(text(),'Thank you for choosing Your Brand Cover!')]");
		String Actual = driver.findElement(By.xpath("//*[contains(text(),'Thank you for choosing Your Brand Cover!')]")).getText();
		verifyText(Actual, Expected);
		waitTime();
		click(ok, "the ok button on Thank You page");
		
	    return this;
  }
	
   public YBC_Thank_you_And_SocialMediaLink_Validations Irresistible_offer_alert() throws Exception {
		
		
		String Expected = "Irresistible offer alert!";
		
		waitForElementVisibility1("//*[contains(text(),'Irresistible offer alert!')]");
		String Actual = driver.findElement(By.xpath("//*[contains(text(),'Irresistible offer alert!')]")).getText();
		verifyText(Actual, Expected);
		waitTime();
		click(Yes, "the Yes button on Irresistible offer alert!");
		for(int i=0;i<share_buttons.size();i++) {
//			windowHandle();
			String Ybc = getCurrentWindow();
			System.out.println(Ybc);
			waitTime();
			share_buttons.get(i).click();
			Thread.sleep(5000);
			 setWindow(Ybc);    
		}
		    Thread.sleep(5000);
			String Ybc = getCurrentWindow();
		    exceptionalWindowHandle3("Facebook");
		    Thread.sleep(5000);
		    exceptionalWindowHandle3("Twitter");
		    Thread.sleep(5000);
		    exceptionalWindowHandle3("LinkedIn ");
		    Thread.sleep(5000);
			 setWindow(Ybc);
			Thread.sleep(5000);
		    exceptionalWindowHandle3("WhatsApp");
		    Thread.sleep(5000);
			setWindow(Ybc);    
			waitTime();
			click(Cheers_Now, "Cheers_Now");
			waitTime();
	return this;

    }
   public YBC_Thank_you_And_SocialMediaLink_Validations Verify_EO_Landing() throws Exception {
	   Testdata data = new Testdata();
		String otp=data.otp;
	   
	   
	  waitTime();
	  click(Cheers_Now, "Cheers_Now");
	  Thread.sleep(5000); 
	  String Actual= driver.getTitle();
	  String Expected = "EncashOffers";
      verifyText(Actual, Expected);
	  waitTime();
	  Thread.sleep(15000); 
	  click(Activate_Now, "the Activate Now");
	  waitForElementVisibility(Continue, "continue_Button");
	  char[] otpchar = otp.toCharArray();

		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}

	   
	   click(continue1, "otp_continue1");
	   waitTime();
	return this;
   
  }
   
   public YBC_Thank_you_And_SocialMediaLink_Validations Verify_EO_Landing_Without_Mobile_Number_Enter_Reg_Num() throws Exception {
	   Testdata data = new Testdata();
		String otp=data.otp;
	   
	   
	  waitTime();
	  click(Cheers_Now, "Cheers_Now");
	  Thread.sleep(5000); 
	  String Actual= driver.getTitle();
	  String Expected = "EncashOffers";
      verifyText(Actual, Expected);
	  waitTime();
	  Thread.sleep(15000); 
	  click(Activate_Now, "the Activate Now");
	  waitForElementVisibility(Mobile_num, "Mobile_num");
	  text(Mobile_num, data.phone1, "the Registered number");
	  waitTime();
	  click(mob_continue, "mob_continue");
	  waitTime();
	  char[] otpchar = otp.toCharArray();
		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		
		click(continue1, "continue1");
		waitTime();
	return this;
   
  }

   
   public YBC_Thank_you_And_SocialMediaLink_Validations Verify_EO_Landing_Without_Mobile_Number_Enter_New_Num() throws Exception {
	   Testdata data = new Testdata();

		String otp=data.otp;
	   
	   
	  waitTime();
//	  click(Cheers_Now, "Cheers_Now");
	  Thread.sleep(5000); 
	  String Actual= driver.getTitle();
	  String Expected = "EncashOffers";
      verifyText(Actual, Expected);
	  waitTime();
	  Thread.sleep(15000); 
	  click(Activate_Now, "the Activate Now");
	  waitForElementVisibility(Mobile_num, "Mobile_num");
	  text(Mobile_num, data.New_phone, "the Registered number");
	  waitTime();
	  click(mob_continue, "mob_continue");
	  waitTime();
	  char[] otpchar = otp.toCharArray();

		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}

	   Thread.sleep(3000);
	   click(Continue, "Continue_Button");
	   waitTime();
	   waitTime();
//	   EO_field_validation();

	   	return this;
   
  }

   public YBC_Thank_you_And_SocialMediaLink_Validations EO_field_validation() throws Exception {
		YBC_Common_Methods common = new YBC_Common_Methods(driver);
	   waitTime();
	   waitTime();
	   waitTime();
	   waitTime();
//       assertTrue1(common.EO_Signup_Validations("title"," Mr. "), "title field not Displayed");
       assertTrue1(common.EO_Signup_Validations("firstName","Pasupuleti"), "firstname field not Displayed");
       assertTrue1(common.EO_Signup_Validations("lastName","kumar"), "lastname field not Displayed");
       assertTrue1(common.EO_Signup_Validations("email","kumar33@mailinator.com"), "email field not Displayed");
       assertTrue1(common.EO_Signup_Validations("postalCode","M11AE"), "postalcode field not Displayed");
 
	   
	   
	   
	   
	   
	return this;
   }
   
   public YBC_Thank_you_And_SocialMediaLink_Validations Verify_EO_UserScorePoints() throws Exception {
		YBC_Common_Methods common1= new YBC_Common_Methods(driver);
		Testdata data = new Testdata();
	   waitTime();
	   waitForElementVisibility(user, "user");
	   click(Profile_icon, "Profile icon");
	   waitForElementPresent("(//*[@title=\"Change password\"]/following::li)[3]");
	   waitTime();
	   assertTrue1(common1.is_Text_Displayed("+44".concat(data.phone1)), " Name on Account not displayed");
	   assertTrue1(common1.is_Text_Displayed(data.Email1), " Name on Account not displayed");
	   waitTime();
	   String Score = driver.findElement(By.xpath("(//*[@title=\"Change password\"]/following::li)[3]")).getText();
	   System.out.println("scorepoints is"+Score);
	   test.info("scorepoints is"+Score);
	   waitTime();
	   return this;

   
   
   
   }
   

}
