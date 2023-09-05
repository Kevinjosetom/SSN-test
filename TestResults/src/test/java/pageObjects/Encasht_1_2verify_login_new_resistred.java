package pageObjects;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resuable.ReusableMethods;
import data.Testdata;

public class Encasht_1_2verify_login_new_resistred extends ReusableMethods{

	@FindBy(xpath = "//a[@onclick='deleteEmail();']")
    WebElement delete_mail;
	
	@FindBy(xpath ="//*[contains(@id,'otp')]")
    WebElement otp;
	
	@FindBy(xpath="(//*[contains(text(),' Register ')])[1]")
    WebElement click_on_the_Register_button;
	
	@FindBy(xpath="//input[@placeholder='Enter your UK mobile number']")
    WebElement Enter_your_UK_mobile_number;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue_button;
	
	@FindBy(xpath="//*[@type='tel']")
    WebElement OTP;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
    WebElement click_on_the_continue;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement Login;
	
	@FindBy(xpath="//button[contains(text(),'New here? Register')]")
    WebElement Newhere_Register;
	
	@FindBy(linkText ="Competitions")
    WebElement Competitions_Linktext;
	
	@FindBy(xpath="(//div[@class='card-img-container live-competition'])[2]")
    WebElement Live_competition;
	
	@FindBy(xpath ="(//a[text()=' Participate '])[1]")
    WebElement Participate;
	
	@FindBy(linkText ="Offers")
    WebElement Offers;
	
	@FindBy(xpath="//div[@class='card-img-container']")
    WebElement Live_Offers;
	
	@FindBy(xpath="//a[@class='secondary-button'][@title='Play']")
    WebElement play;
	
	@FindBy(xpath="//button[contains(text(),'Play now')]")
    WebElement play_now;
	

  public Encasht_1_2verify_login_new_resistred(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
  }
  
  
  public Encasht_1_2verify_login_new_resistred verifyRegister() throws Exception {
	  
	  Testdata data = new Testdata();
	    String phone="7893920411";
		String otp=data.otp;
		String continue_Button ="(//label[contains(text(),'Enter your mobile number')]//following::button)[1]";
		//String get_text="//input[@placeholder='Enter your UK mobile number']";
		Thread.sleep(10000);
		waitForElementVisibility(click_on_the_Register_button, "Registerd_Button");
		click(click_on_the_Register_button, "Register_button");
		waitForElementPresent(continue_Button);
		String attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		
		//verify after entering the 10 digit number continue button is enabled
		test.info("Enter the Mobile Number");
		text(Enter_your_UK_mobile_number, "1234567890", "enter the mobile number");
//	    
//		//verify continue button is enabled 
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is disable");
		waitTime();
		//clear the enter mobile number
		Enter_your_UK_mobile_number.clear();
		waitTime();
		//verify after entering the textin the mobile number continue button is enabled
		text(Enter_your_UK_mobile_number, "Encash!@#$", "Enter textin the mobile number field");
		waitTime();
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		waitTime();
		test.info("click on the continue button");
		click(click_on_the_continue_button, "click_on_the_continue_button");
		
		
		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();
	
	//	//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
		String OTP = locator+"["+i+"]";
		Thread.sleep(500);
			String OTPnumber = Character.toString(otpchar[i-1]);
		driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		waitTime();
		click(click_on_the_continue, "click_on_the_continue");
		
		
		return this;
	}
	  
	
  /* this method is used to new user Register from Login Button in the home screen
   * 
   */
  public Encasht_1_2verify_login_new_resistred verifyLoginRegister() throws Exception {
	
	  Testdata data = new Testdata();
		String phone="7893920064";
		String otp=data.otp;
		String continue_Button ="//label[contains(text(),'Enter your mobile number')]//following::button";
		
		
		Thread.sleep(7000);
		test.info("click on the home page login Button");
		waitForElementVisibility(Login, "Login_Button");
		click(Login, "the_login_button");
		waitForElementVisibility(Newhere_Register, "Newhere_Register");
		click(Newhere_Register, " the Newhere_Register");
		waitForElementPresent(continue_Button);
		String attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		
		//verify after entering the 10 digit number continue button is enabled
		test.info("Enter the Mobile Number");
		text(Enter_your_UK_mobile_number, "1234567890", "enter the mobile number");
//	    
//		//verify continue button is enabled 
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is disable");
		waitTime();
		//clear the enter mobile number
		Enter_your_UK_mobile_number.clear();
		waitTime();
		//verify after entering the textin the mobile number continue button is enabled
		text(Enter_your_UK_mobile_number, "Encash!@#$", "Enter textin the mobile number field");
		waitTime();
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		System.out.println(attribute);
		//enter the valid mobile number 
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		waitTime();
		test.info("click on the continue button");
		click(click_on_the_continue_button, "click_on_the_continue_button");

		
		
		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();
	
	//	//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
		String OTP = locator+"["+i+"]";
		Thread.sleep(500);
			String OTPnumber = Character.toString(otpchar[i-1]);
		driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		waitTime();
		click(click_on_the_continue, "click_on_the_continue");
	  
	  
	return this;
  }
  
  
  public Encasht_1_2verify_login_new_resistred competitionsLogin() throws Exception {
	
	  Testdata data = new Testdata();
		String phone="7893920040";
		String otp=data.otp;
		String continue_Button ="//label[contains(text(),'Enter your mobile number')]//following::button";
		////span[contains(text(),'toReplaceLinkText')]
	    test.info("clicking on the competitions button in home page" );
	    waitForElementVisibility(Competitions_Linktext,"Competitions_Linktext");
	    click(Competitions_Linktext, "Competitions_Linktext with out login");
        waitTime();
		test.info("clicking on the first competitions button");
//		waitForElementVisibility(Live_competition,"Live_competition");
//		scrollByElement(Live_competition, "Live_competition first element");
		Thread.sleep(5000);
		waitForElementVisibility(Live_competition,"Live_competition");
		click(Live_competition, "the first competations");

		test.info("click on the Participate button");
		//waitForElementPresent(normalLink("Participate"));
	//	clickHyperlink("//span[contains(text(),'Participate')]", "the Participate with out login");
		click(Participate, "Participate Button with out login");
		waitTime();
			//login part 
		//wait for continue button present
        waitForElementPresent(continue_Button);
		String attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		
		//verify after entering the 10 digit number continue button is enabled
		test.info("Enter the Mobile Number");
		text(Enter_your_UK_mobile_number, "1234567890", "enter the mobile number");
//	    
//		//verify continue button is enabled 
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is disable");
		waitTime();
		//clear the enter mobile number
		Enter_your_UK_mobile_number.clear();
		waitTime();
		//verify after entering the textin the mobile number continue button is enabled
		text(Enter_your_UK_mobile_number, "Encash!@#$", "Enter textin the mobile number field");
		waitTime();
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		System.out.println(attribute);
		//enter the valid mobile number 
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		waitTime();
		test.info("click on the continue button");
		click(click_on_the_continue_button, "click_on_the_continue_button");


		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();

		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		
		waitTime();
		click(click_on_the_continue, "click_on_the_continue");
	
	 
	  return this;
		
      }
  
  public Encasht_1_2verify_login_new_resistred offersLogin() throws Exception {
	  
	    Testdata data = new Testdata();
		String phone="7893932967";
		String otp=data.otp;
		String continue_Button ="//label[contains(text(),'Enter your mobile number')]//following::button";
	  
        test.info("clicking on the offers button in home page" );	
	    waitForElementVisibility(Competitions_Linktext,"Competitions_Linktext");
	 
		//waitForElementPresent(normalLink("Competitions"));
		click(Offers, "clicking on the Offers button with out login");
        waitTime();	  
        test.info("clicking on the first offers button");
        scrollByElement(Live_Offers, " first Live_Offers");
        waitTime();
        waitForElementVisibility(Live_Offers, "First_offers_display");
		click(Live_Offers, "first offers");

		//login part 
		//wait for continue button present
        waitForElementPresent(continue_Button);
		String attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		
		//verify after entering the 10 digit number continue button is enabled
		test.info("Enter the Mobile Number");
		text(Enter_your_UK_mobile_number, "1234567890", "enter the mobile number");
//	    
//		//verify continue button is enabled 
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is disable");
		waitTime();
		//clear the enter mobile number
		Enter_your_UK_mobile_number.clear();
		waitTime();
		//verify after entering the textin the mobile number continue button is enabled
		text(Enter_your_UK_mobile_number, "Encash!@#$", "Enter textin the mobile number field");
		waitTime();
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		System.out.println(attribute);
		//enter the valid mobile number 
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		waitTime();
		test.info("click on the continue button");
		click(click_on_the_continue_button, "click_on_the_continue_button");
		
		
		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();

		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		
		waitTime();
		click(click_on_the_continue, "click_on_the_continue");
	
	 
	  return this;
    }
  public Encasht_1_2verify_login_new_resistred playLogin() throws Exception {
	  
	  Testdata data = new Testdata();
		String phone="7893932984";
		String otp=data.otp;
		String continue_Button ="//label[contains(text(),'Enter your mobile number')]//following::button";
	  
	  
	  
	  
	    test.info("clicking on the play button in home page" );
	    waitForElementVisibility(play, "play");
		//scroll to leader board
		//scrollToView("//div[@class='top-competitions mb-4 wow slideInUp']","Scrolling to leaderboard");

		//scroll to play button
		//scrollToView(EncashWebLocators.encash_play, "scrolling to play button");
		waitTime();
		click(play, "play");
		
		waitForElementVisibility(play_now, "play_now");
		click(play_now, " the play now button");
		//login part 
		//wait for continue button present
        waitForElementPresent(continue_Button);
		String attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
		
		
		//verify after entering the 10 digit number continue button is enabled
//		test.info("Enter the Mobile Number");
		text(Enter_your_UK_mobile_number, "1234567890", " the mobile number field");
//	    
//		//verify continue button is enabled 
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals(null, attribute, "verifying the continue button is disable");
		waitTime();
		//clear the enter mobile number
		Enter_your_UK_mobile_number.clear();
		waitTime();
		//verify after entering the textin the mobile number continue button is enabled
		text(Enter_your_UK_mobile_number, "Encash!@#$", " the mobile number field");
		waitTime();
		attribute = getAttribute(continue_Button, "disabled", "getting the aributed value");
		System.out.println("attributed value after continue button enabled " + attribute);
		//verifying the continue button is disable by default
		assertEquals("true", attribute, "verifying the continue button is disable");
		waitTime();
		System.out.println(attribute);
		//enter the valid mobile number 
		text(Enter_your_UK_mobile_number,phone, "the_mobile_number");
		waitTime();
		test.info("click on the continue button");
		click(click_on_the_continue_button," the_continue_button");
		
		
		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();
		//OTP
		String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
		for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
		}
		
		waitTime();
		click(click_on_the_continue, "the_continue");
	
	 
	  return this;
  }


	
}
			