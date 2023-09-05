package pageObjects;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;



public class Encash_Registration_Validations extends ReusableMethods {
	
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
	
	@FindBy(xpath = "//button[text()='Save']")
    WebElement Save_concent;
	
	@FindBy(xpath = "//button[contains(text(),'Skip')]")
    WebElement skip;
	
	
		
	public Encash_Registration_Validations(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public Encash_Registration_Validations register() throws Exception {
		Testdata data = new Testdata();
		
	    String phone = "7893920420";
	    
		String otp=data.otp;
		//waitForElementVisibility(jishiImage("flying-jishi wow zoomIn ng-star-inserted"));
		//click(buttonWithtext("No, I’ll explore myself"), "click on button Yes, Continue");
		
		
		waitForElementVisibility(click_on_the_Register_button, "Registerd_Button");
		click(click_on_the_Register_button, "click_on_the_Register_button");
		
//		click1("//*[contains(text(),' Login ')]", "click_on_the_Register_button");
//		Thread.sleep(4000);
//		click1("//*[contains(text(),' New here? Register ')]", "click_on_the_Register_button");
//		//test.info("click on the Register button");
		text(Enter_your_UK_mobile_number,phone, "Enter_your_UK_mobile_number");
		Thread.sleep(1000);
//		WebElement reg = driver.findElement(By.xpath("//*[text()='Register']"));
//		driver.switchTo().frame(reg);
//		System.out.println(reg);
		
		click1(spanLink("Continue"), "click on the continue button");
//		mouseHoverAndClick(click_on_the_continue, "click_on_the_continue_button");
////		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).submit();
//	   
//		WebElement element= driver.findElement(By.xpath("//input[@placeholder='Enter your UK mobile number']"));
//		element.sendKeys(Keys.TAB);
//		Thread.sleep(2000);
//		//or 
//		element.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		// OTP validations for pause OTP number in uk temp.mobile numbers
		Otp_validation();
		return this;
		
	
	}
		public Encash_Registration_Validations Otp_validation() throws Exception {
		//captcha();
			Testdata data = new Testdata();
		

			
		String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
		System.out.println(CaptchaCode);
		char[] otpchar = CaptchaCode.toCharArray();
	
	//	//OTP
		Thread.sleep(3000);
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
	
	public Encash_Registration_Validations registrationForm(HashMap<String,String> NewRegistration) throws Exception {
		
		
		waitForElementVisibility(title,"title");
		//select title
	    selectByText(title, "Mr.");
		waitTime();
	
		//Enter First name
	    text(firstName,NewRegistration.get("firstName"), "typing first name");
		waitTime();
	    text(lastName, NewRegistration.get("lastName"), "typing last name");
	    waitTime();
		text(email, "7893920420@mailinator.com", "typing email id name");
		waitTime();
	    click(Gender_male,"select Male");
	    waitTime();
	    selectByText(Select_day, NewRegistration.get("date"));
	    waitTime();
	    selectByText(Select_month, NewRegistration.get("Month"));
	    waitTime();
	    selectByText(Select_year, NewRegistration.get("year"));
	    waitTime();
	    text(password,NewRegistration.get("password"),"typing the password");
	    waitTime();
	    text(confirm_password,NewRegistration.get("password"),"typing the confirm  password");
	    waitTime();
		text(Display_name,"7893920420","Typing the display name");
		text(postalCode,NewRegistration.get("postalCode"),"Enter the postal code");
		waitTime();
	    click(find_Address, "find_Address");
	    Thread.sleep(13000);
     
	   
	
	    click(Click_on_the_consent_checkbox, "the consent checkbox");
	    waitTime();
	 //   click(partners,"click on the Partners");
		return this;
	
	    }
	 public Encash_Registration_Validations Consent() throws IOException  {
//		String xpath = "//*[@id='mat-dialog-2']/app-consumer-consent-dialog/div/div/div/div[2]/div/div";
//		String childrow_1 = "//*[@id='cdk-accordion-child-";
//		String childrow_2 = "']/div/div";
//		int numberofrow = (int) getXpathCount(xpath, "getting the number of consent");
//		int m = 2;
//	
//		for(int i=1;i<numberofrow;i++) {
//	    String row = xpath +"["+i+"]";
//		clickAndWait(row, "clicking on the consent number "+i);
//		//get the child number of row
//		String childrow = childrow_1+(i-1)+childrow_2;
//		int childcount = (int)getXpathCount(childrow, "get the number of child consent");
//		//loop in the child row 
//		for(int j=1;j<=childcount;j++) {
//		//test.info("printing the child cout "+ j);
//		// as consent is only through Email,sms,phone,Postal
//		String status = "//*[@id='mat-checkbox-";
//		// as consent is only through Email,sms,phone,Postal
//		for(int k=0;k<4;k++,m++) {
//		String consetstatus = status+m+"-input']";
//		String attributevalue = getAttribute(consetstatus, "aria-checked", "checking the conset is checked or not");
//		assertEquals("true", attributevalue, "verified the attributed value");
//	}
//		}
//	}

	//click on the save button
	scrollByElement(Save_concent, "Save_concent");
	click(Save_concent, "clicking on the save button");
	waitTime();
	
   
		return this;
		}

	public Encash_Registration_Validations SaveRegister() throws Exception {
		test.info("SaveRegister sucessfully");
	//	driver.findElement(By.xpath("//*[contains(text(),' Cancel ')]")).click();
		
	    waitTime();
		click(continue_, "clicked on the continue button");
		waitTime();
		waitTime();
		Thread.sleep(15000);
		return this;
	}
	public Encash_Registration_Validations skipemailverify() throws Exception {
		try {
		
		test.info("skip the email verification");
		waitForElement(20, skip, "Wait for skip to appear");
		click(skip, "Skip the email verification");
    

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}

		return this;	
	}

}



