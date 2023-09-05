package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;


public class Encah_signup_validations extends ReusableMethods{
	
	@FindBy(xpath="//*[@type='checkbox']")
    WebElement Next_Checkbox;
	
	@FindBy(xpath="//*[text()='Quick Quote Overview']")
    WebElement Quote_Title;
	
	@FindBy(xpath="//*[text()='+ Add More ']")
    WebElement Add_More;
	
	@FindBy(xpath="//*[@id='selectNo']")
    WebElement NO_Radio;
	
	@FindBy(xpath="//*[@name='optradio' and (@value='yes')]")
    WebElement Declaration_Yes;
	
	@FindBy(xpath="//*[@name='optradio' and (@value='no')]")
    WebElement Declaration_No;
	
	@FindBy(xpath="(//*[text()=' Next '])[2]")
    WebElement Declaration_Next;
	
	@FindBy(xpath="(//*[@type='checkbox'])[2]")
    WebElement Declaration_checkBox;
	
	
	@FindBy(xpath="//*[text()='Selected Appliances']")
    WebElement Appliance_title;
	
	@FindBy(xpath ="//*[@title='Login']")
     WebElement login;
	
	@FindBy(xpath ="//*[@placeholder='Email id']")
    WebElement email_id;
	
	@FindBy(xpath ="//*[@placeholder='Password']")
    WebElement password;
	
	@FindBy(xpath ="//*[text()=' Continue ']")
    WebElement continuee;
	
	@FindBy(xpath ="//*[text()='Blank Link']")
    WebElement blank_link;
	
	
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
	
	
	@FindBy(xpath ="//*[@id='testimonial-wrapper']/child::div")
    WebElement testimonial;
	
	@FindBy(xpath="//*[@id='competition-sticky']")
    WebElement competitionCategories;
	
	@FindBy(xpath="(//*[contains(text(),'How it works')])[2]")
    WebElement scrool_how_it_works;
	
	@FindBy(xpath="(//*[contains(text(),'How it works')])[1]")
    WebElement scrool_how_it_works2;
	
	@FindBy(xpath="//*[contains(text(),'Get cover today ')]")
    WebElement GetCoverToday;
	
	@FindBy(xpath="//*[contains(text(),' Get Cover Today')]")
    WebElement BTM_GetCoverToday;
	
	@FindBy(xpath="(//*[text()='Get Cover Today'])[4]")
    WebElement Plan_GetCoverToday;
	
	@FindBy(xpath="//*[@class='checkmark']")
    List<WebElement> Appliance_check_Box;
	
	@FindBy(xpath="(//*[@class='checkmark'])[7]")
    WebElement Select_max_Appliance_Checkbox;
	
	@FindBy(xpath="//select[@class='form-select']")
    WebElement Appliance_Brand1;
	
	@FindBy(xpath="(//select[@class='form-select'])[2]")
    WebElement Appliance_Brand2;
	
	@FindBy(xpath="(//select[@class='form-select'])[3]")
    WebElement Appliance_Brand3;

	@FindBy(xpath="(//select[@class='form-select'])[4]")
    WebElement Appliance_Brand4;

	@FindBy(xpath="(//select[@class='form-select'])[5]")
    WebElement Appliance_Brand5;

	@FindBy(xpath="(//select[@class='form-select'])[6]")
    WebElement Appliance_Brand6;

	@FindBy(xpath="//*[text()=' Next ']")
    WebElement Next;
	
	@FindBy(xpath="(//*[@class='checkmark'])[4]")
    WebElement Select_Appliance;
	
	@FindBy(xpath="//*[contains(text(),'Allow all cookies ')]")
    WebElement cookies;
	
	@FindBy(xpath="//*[@value='yes']")
    WebElement Search_YES;
	
	@FindBy(xpath="//*[@value='no']")
    WebElement Search_NO;
	
	@FindBy(xpath="//*[contains(text(),' ok ')]")
    WebElement ok;
	
	@FindBy(xpath="//*[contains(text(),' Continue ')]")
    WebElement continue1;
	
	
	public Encah_signup_validations(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
public Encah_signup_validations YBC_LandingPage_validations() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";

	
//	Ybc_sign_in();
	Ybc_sign_in_newtab();
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	
	
//	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
//
//
//	   test.info("verify the title");
//	   waitTime();
//	   String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
//	   verifyText(actual_Title, title_Expected);
//	   scrollByElement(Search_YES, "Search_yes");
//	   waitTime();
//	   click(Search_YES,"Search_Appliance");
//	   test.info("verify the title");
//	   waitTime();
//	   waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
//	   String title_Expected1= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
//	   verifyText(actual_Title, title_Expected1);
//	waitTime();
//	 click(ok, "the ok button on Thank You page");
//	 waitForElementPresent("//*[@title='EncashOffers']");
//	 String Actual= driver.getTitle();
//	 String Expected = "EncashOffers";
//	 verifyText(Actual, Expected);
     waitTime();

	return this;
	

}

public Encah_signup_validations YBC_LandingPage_validations_newtab_appliance_YES() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();


	
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
//	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	 test.info("verify the title");
	   waitTime();
		String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	   String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
	   verifyText(actual_Title, title_Expected);
	   waitTime();
	   scrollByElement(Search_YES, "Search_YES");
	   click(Search_YES,"Search_YES");
	  	waitTime();
		Thread.sleep(3000);
	    waitTime();
		selectByText(title, " Mr. ");
		text(firstName, data.FirstName1, "the first name");
		Thread.sleep(1000);
		text(lastName,data.lastName1, "the last name");
		Thread.sleep(1000);
		text(email, data.Email1, "the emai address");
		Thread.sleep(1000);
		text(phone, data.phone1, "the phone number");
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode1, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
//		waitForElementVisibility(AddressLine1, "AddressLine1");
//        assertTrue1(is_field_Displayed("addressLine1"), "addressLine field not Displayed");
//        assertTrue1(is_field_Displayed("city"), "city field not Displayed");
        waitTime();
        Postalcode.clear();
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode2, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
		waitTime();
//		scrollByElement(CI_next_button, "CI_next_button");
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")); 
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
		String actual_Title2= " We have received your request and will be shortly contacting you. ";
		
		
		   test.info("verify the title");
		   waitTime();
		   waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
		   String title_Expected2= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
		   verifyText(actual_Title2, title_Expected2);
		waitTime();
		 click(ok, "the ok button on Thank You page");
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual3= driver.getTitle();
		 String Expected4 = "EncashOffers";
		 verifyText(Actual3, Expected4);
//		 Thread.sleep(5000);
//		 exceptionalWindowHandle3("EncashOffers ");
		 setWindow(Ybc);
         Thread.sleep(5000);
	     
	return this;
	

}

public Encah_signup_validations YBC_LandingPage_validations_newtab_appliance_NO() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();


	
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	 test.info("verify the title");
	   waitTime();
		String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	   String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
	   verifyText(actual_Title, title_Expected);
	   waitTime();
	   scrollByElement(Search_YES, "Search_YES");
	  	waitTime();
	   click(Search_NO,"Search_NO");
	  	waitTime();
		Thread.sleep(3000);
	    waitTime();
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual3= driver.getTitle();
		 String Expected4 = "EncashOffers";
		 verifyText(Actual3, Expected4);
         Thread.sleep(10000);
//		 exceptionalWindowHandle3("EncashOffers ");
         setWindow(Ybc);
         Thread.sleep(5000);
	     
	return this;
	

}



public Encah_signup_validations YBC_LandingPage_validations_Dec_yes() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();


	
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
//	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();
    click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
    Thread.sleep(1000);
    scrollByElement(Appliance_Brand1," Appliance_Brand1");
	  selectByText(Appliance_Brand1," AEG ");//temp
 	  click(Next, "the next button to Appliance Details page");
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
  	    click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		String NextButton = "//*[text()=' Next ']";
		String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
		
		String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	    waitTime();
		String actual= Quote_Title.getText();
	    System.out.println(actual);
		String expected = "Quick Quote Overview";
		verifyText(actual, expected);
		System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
		WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
		String classcontain = Xpath.getAttribute("class");
		if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
		System.out.println("Yes radio Button Defaulty Selected");
		test.info("Yes radio Button Defaulty Selected");
		}
		String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
	    waitTime();
	    click(NO_Radio, "the NO_Radio button on the Quote summary");
	    waitTime();
	    click(Declaration_Yes, "Declaration_Yes");
	    waitTime();
	    click(Declaration_checkBox, "Declaration_checkBox");
	    waitTime();
	    click(Declaration_Next, "Declaration_Next");
	    waitTime();
		Thread.sleep(3000);
	    waitTime();
		selectByText(title, " Mr. ");
		text(firstName, data.FirstName1, "the first name");
		Thread.sleep(1000);
		text(lastName,data.lastName1, "the last name");
		Thread.sleep(1000);
		text(email, data.Email1, "the emai address");
		Thread.sleep(1000);
		text(phone, data.phone1, "the phone number");
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode1, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
//		waitForElementVisibility(AddressLine1, "AddressLine1");
//        assertTrue1(is_field_Displayed("addressLine1"), "addressLine field not Displayed");
//        assertTrue1(is_field_Displayed("city"), "city field not Displayed");
        waitTime();
        Postalcode.clear();
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode2, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
		waitTime();
//		scrollByElement(CI_next_button, "CI_next_button");
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")); 
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
		String actual_Title2= " We have received your request and will be shortly contacting you. ";
		
		
		   test.info("verify the title");
		   waitTime();
		   waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
		   String title_Expected2= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
		   verifyText(actual_Title2, title_Expected2);
		waitTime();
		 click(ok, "the ok button on Thank You page");
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual3= driver.getTitle();
		 String Expected4 = "EncashOffers";
		 verifyText(Actual3, Expected4);
		 Thread.sleep(5000);
	     setWindow(Ybc);
	     Thread.sleep(5000);
//		 exceptionalWindowHandle3("EncashOffers ");
//         Thread.sleep(5000);
//         
	     
	return this;
	

}

public Encah_signup_validations YBC_LandingPage_validations_Dec_() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();


	
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
//	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();
    click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
    Thread.sleep(1000);
    scrollByElement(Appliance_Brand1," Appliance_Brand1");
	  selectByText(Appliance_Brand1," AEG ");//temp
 	  click(Next, "the next button to Appliance Details page");
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
  	    click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		String NextButton = "//*[text()=' Next ']";
		String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
		
		String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	    waitTime();
		String actual= Quote_Title.getText();
	    System.out.println(actual);
		String expected = "Quick Quote Overview";
		verifyText(actual, expected);
		System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
		WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
		String classcontain = Xpath.getAttribute("class");
		if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
		System.out.println("Yes radio Button Defaulty Selected");
		test.info("Yes radio Button Defaulty Selected");
		}
		String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
	    waitTime();
	    click(NO_Radio, "the NO_Radio button on the Quote summary");
	    waitTime();
	    click(Declaration_Yes, "Declaration_Yes");
	    waitTime();
	    click(Declaration_checkBox, "Declaration_checkBox");
	    waitTime();
	    click(Declaration_Next, "Declaration_Next");
	    waitTime();
		Thread.sleep(3000);
	    waitTime();
		selectByText(title, " Mr. ");
		text(firstName, data.FirstName1, "the first name");
		Thread.sleep(1000);
		text(lastName,data.lastName1, "the last name");
		Thread.sleep(1000);
		text(email, data.Email1, "the emai address");
		Thread.sleep(1000);
		text(phone, data.phone1, "the phone number");
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode1, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
//		waitForElementVisibility(AddressLine1, "AddressLine1");
//        assertTrue1(is_field_Displayed("addressLine1"), "addressLine field not Displayed");
//        assertTrue1(is_field_Displayed("city"), "city field not Displayed");
        waitTime();
        Postalcode.clear();
		Thread.sleep(1000);
		text(Postalcode, data.Postalcode2, "the postal code");
		Thread.sleep(1000);
		click(Find_Address, "the find Address");
		waitTime();
//		scrollByElement(CI_next_button, "CI_next_button");
		WebElement Frame = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")); 
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
		String actual_Title2= " We have received your request and will be shortly contacting you. ";
		
		
		   test.info("verify the title");
		   waitTime();
		   waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
		   String title_Expected2= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
		   verifyText(actual_Title2, title_Expected2);
		waitTime();
		 click(ok, "the ok button on Thank You page");
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual3= driver.getTitle();
		 String Expected4 = "EncashOffers";
		 verifyText(Actual3, Expected4);
	     
	return this;
	

}


public Encah_signup_validations verify_the_reg_num_validations_on_EO_reg() throws Exception {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();
	Customer_InformationPage_validations ci = new Customer_InformationPage_validations(driver);
	Bank_Details_Page_Validation bank = new Bank_Details_Page_Validation(driver);
	YBC_Thank_you_And_SocialMediaLink_Validations Thank_you = new YBC_Thank_you_And_SocialMediaLink_Validations(driver);
	YBC_Confirm_Bank_Details_Page_Validations Confirm_Bank = new YBC_Confirm_Bank_Details_Page_Validations(driver);
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
//	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();
    click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
    Thread.sleep(1000);
    scrollByElement(Appliance_Brand1," Appliance_Brand1");
	  selectByText(Appliance_Brand1," AEG ");//temp
 	  click(Next, "the next button to Appliance Details page");
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
  	    click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		String NextButton = "//*[text()=' Next ']";
		String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
		
		String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	    waitTime();
		String actual= Quote_Title.getText();
	    System.out.println(actual);
		String expected = "Quick Quote Overview";
		verifyText(actual, expected);
		System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
		WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
		String classcontain = Xpath.getAttribute("class");
		if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
		System.out.println("Yes radio Button Defaulty Selected");
		test.info("Yes radio Button Defaulty Selected");
		}
		String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
	    waitTime();
	    click(Next_Checkbox, "the Next_Checkbox button on the Quote summary");
    	click(Next, "the next Button to navigate Quote summary Window");
    	waitTime();
    	ci.verifyFieldsHaveMandatoryMarker().CI_Validate_Placeholders_Fields().verifyFieldsHaveInvalidTag();
    	ci.CI_Validation_Message_Fields().Validate_the_Postalcode_Without_Enter_Mobile_Number();
    	bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
		bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_validData2();
		bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
		Confirm_Bank.Bank_details_validation2().Payment_Confirmation2();
		Thank_you.Thank_You_page_Validations().Irresistible_offer_alert();
        Thank_you.Verify_EO_Landing_Without_Mobile_Number_Enter_Reg_Num();
        Thread.sleep(10000);
        waitTime();
        waitTime();
        Thread.sleep(5000);
//		exceptionalWindowHandle3("EncashOffers ");
        setWindow(Ybc);
        waitTime();
		return this;

}

public Encah_signup_validations verify_the_reg_num_validations_on_EO_new() throws Exception {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();
	Customer_InformationPage_validations ci = new Customer_InformationPage_validations(driver);
	Bank_Details_Page_Validation bank = new Bank_Details_Page_Validation(driver);
	YBC_Thank_you_And_SocialMediaLink_Validations Thank_you = new YBC_Thank_you_And_SocialMediaLink_Validations(driver);
	YBC_Confirm_Bank_Details_Page_Validations Confirm_Bank = new YBC_Confirm_Bank_Details_Page_Validations(driver);
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
//	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();
    click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
    Thread.sleep(1000);
    scrollByElement(Appliance_Brand1," Appliance_Brand1");
	  selectByText(Appliance_Brand1," AEG ");//temp
	  waitTime();
 	  click(Next, "the next button to Appliance Details page");
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
  	    click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		String NextButton = "//*[text()=' Next ']";
		String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
		
		String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	    waitTime();
		String actual= Quote_Title.getText();
	    System.out.println(actual);
		String expected = "Quick Quote Overview";
		verifyText(actual, expected);
		System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
		WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
		String classcontain = Xpath.getAttribute("class");
		if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
		System.out.println("Yes radio Button Defaulty Selected");
		test.info("Yes radio Button Defaulty Selected");
		}
		String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
	    waitTime();
	    click(Next_Checkbox, "the Next_Checkbox button on the Quote summary");
    	click(Next, "the next Button to navigate Quote summary Window");
    	waitTime();
    	ci.verifyFieldsHaveMandatoryMarker().CI_Validate_Placeholders_Fields().verifyFieldsHaveInvalidTag();
    	ci.CI_Validation_Message_Fields().Validate_the_Postalcode_Without_Enter_Mobile_Number();
    	bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
		bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_validData();
		bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
		Confirm_Bank.Bank_details_validation().Payment_Confirmation();
		Thank_you.Thank_You_page_Validations().Irresistible_offer_alert();
        Thank_you.Verify_EO_Landing_Without_Mobile_Number_Enter_New_Num();
        waitTime();
        waitTime();
        waitTime();
        Thread.sleep(15000);
		setWindow(Ybc);
        waitTime();		
	    return this;

}

public Encah_signup_validations Verify_the_EO_User_YBC_Journey() throws Exception {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();
	Customer_InformationPage_validations ci = new Customer_InformationPage_validations(driver);
	Bank_Details_Page_Validation bank = new Bank_Details_Page_Validation(driver);
	YBC_Thank_you_And_SocialMediaLink_Validations Thank_you = new YBC_Thank_you_And_SocialMediaLink_Validations(driver);
	YBC_Confirm_Bank_Details_Page_Validations Confirm_Bank = new YBC_Confirm_Bank_Details_Page_Validations(driver);
	Encah_signup_validations sign_up1 = new Encah_signup_validations(driver);
	Your_Selected_applience ysp = new Your_Selected_applience(driver);
	Quote_summary_Validations Quote = new Quote_summary_Validations(driver);
	
	
	
	waitForElementPresent("(//*[contains(text(),'How it works')])[2]");
	Thread.sleep(10000);
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
      System.out.println("monthly_plan Defaulty Selected");
		}else
	  System.out.println("monthly_plan not Defaulty Selected");
//	scrollBybottom();
//	waitTime();
//	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
//	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
     System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
	System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitForElementVisibility(Search_YES, "Search_YES");
	scrollByElement(Search_YES, "Search_YES");
	waitTime();
    click(Search_YES,"Search_YES");
    waitTime();
	Thread.sleep(3000);
	waitTime();
	String actual_Title2= " We have received your request and will be shortly contacting you. ";
	test.info("verify the title");
	waitTime();
	waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
	String title_Expected2= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
	verifyText(actual_Title2, title_Expected2);
	waitTime();
	click(ok, "the ok button on Thank You page");
	waitForElementPresent("//*[@title='EncashOffers']");
	String Actual3= driver.getTitle();
	String Expected4 = "EncashOffers";
	verifyText(Actual3, Expected4);
	scrollBybottom();
	waitTime();
	scrollToView("//*[text()='Color Pencil']".replaceAll("Color Pencil", data.competationName), "perticular competition");
	waitTime();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	driver.navigate().back();
	waitTime();
	waitTime();
	waitForElementPresent("(//*[contains(text(),'How it works')])[2]");
    Thread.sleep(10000);
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	waitForElementVisibility(Search_NO, "Search_NO");
	scrollByElement(Search_NO, "Search_NO");
	click(Search_NO,"Search_NO");  
	waitForElementPresent("//*[@title='EncashOffers']");
	String Actual5= driver.getTitle();
	String Expected5 = "EncashOffers";
	verifyText(Actual5, Expected5);
	scrollBybottom();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	scrollToView("//*[text()='Color Pencil']".replaceAll("Color Pencil", data.competationName), "perticular competition");
	driver.navigate().back();
	Thread.sleep(3000);
	waitTime();
	waitTime();
	scrollToView("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]", "pick you Appliance");
	waitTime();
	waitForElementPresent("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]");
	String actual_Title1= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
	waitTime();
    String title_Expected1= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
	verifyText(actual_Title1, title_Expected1);
    waitTime();
	click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	Thread.sleep(1000);
    scrollByElement(Appliance_Brand1," Appliance_Brand1");
	selectByText(Appliance_Brand1," AEG ");//temp
	click(Next, "the next button to Appliance Details page");
		try {
	String actual= Appliance_title.getText();
	System.out.println(actual);
	String expected = "Selected Appliances";
	verifyText(actual, expected);
	System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");
			}
	     catch (Exception e) {
	System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
				}
	waitTime();
	scrollByElement(Add_More, "Next");
	waitTime();
	click(Next, "the next Button to navigate Selected Appliance Window");
	waitTime();
	String NextButton = "//*[text()=' Next ']";
	String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
				
	String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	waitTime();
	String actual= Quote_Title.getText();
	System.out.println(actual);
	String expected = "Quick Quote Overview";
	verifyText(actual, expected);
	System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
	verifyText(Actual, Expected);
	waitTime();
	scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
	WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
	String classcontain = Xpath.getAttribute("class");
	if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
	System.out.println("Yes radio Button Defaulty Selected");
	test.info("Yes radio Button Defaulty Selected");
			}
	String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
	//verifying the continue button is disable by default
	System.out.println(attribute);
	assertEquals("true", attribute, "verifying the continue button is disable");
	scrollByElement(NO_Radio, "NO_Radio");
	waitTime();
	click(NO_Radio, "the NO_Radio button on the Quote summary");
	waitTime();
	scrollByElement(Declaration_Yes, "Declaration_Yes");
	click(Declaration_Yes, "Declaration_Yes");
	waitTime();
	click(Declaration_checkBox, "Declaration_checkBox");
	waitTime();
	click(Declaration_Next, "Declaration_Next");
	waitTime();
	Thread.sleep(3000);
	String actual_Title3= " We have received your request and will be shortly contacting you. ";	
	test.info("verify the title");
    waitTime();
	waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
	String title_Expected3= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
	verifyText(actual_Title3, title_Expected3);
	waitTime();
	click(ok, "the ok button on Thank You page");
	waitForElementPresent("//*[@title='EncashOffers']");
	String Actual6= driver.getTitle();
	String Expected6 = "EncashOffers";
	verifyText(Actual6, Expected6);
	Thread.sleep(5000);
	scrollBybottom();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	scrollToView("//*[text()='Color Pencil']".replaceAll("Color Pencil", data.competationName), "perticular competition");
	driver.navigate().back();
	Thread.sleep(3000);	
	waitTime();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	Thread.sleep(3000);
	waitForElementPresent("(//*[contains(text(),'How it works')])[2]");
    Thread.sleep(5000);
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	waitForElementPresent("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]");
	String actual_Title7= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
	waitTime();
    String title_Expected7= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
	verifyText(actual_Title7, title_Expected7);
    waitTime();
    waitTime();
	scrollByElement(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	Thread.sleep(1000);
    waitTime();
	click(Next, "the next button to Appliance Details page");
		try {
	String actual2= Appliance_title.getText();
	System.out.println(actual2);
	String expected2 = "Selected Appliances";
	verifyText(actual2, expected2);
	System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");
			}
	     catch (Exception e) {
	System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
				}
	waitTime();
	scrollByElement(Add_More, "Next");
	waitTime();
	click(Next, "the next Button to navigate Selected Appliance Window");
	waitTime();
	String NextButton1 = "//*[text()=' Next ']";
	String Expected1= "//*[text()='The appliance is under 12 years and in good working order']";
				
	String Actual1 = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	waitTime();
	String actual1= Quote_Title.getText();
	System.out.println(actual1);
	String expected1 = "Quick Quote Overview";
	verifyText(actual, expected1);
	System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
	verifyText(Actual1, Expected1);
	waitTime();
	scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
	WebElement Xpath1 = driver.findElement(By.xpath("//*[@value='yes']"));
	String classcontain1 = Xpath1.getAttribute("class");
	if(classcontain1.equalsIgnoreCase("ng-star-inserted")) {
	System.out.println("Yes radio Button Defaulty Selected");
	test.info("Yes radio Button Defaulty Selected");
			}
	String attribute1 = getAttribute(NextButton1, "disabled", "failed to getting the aributed value");
	//verifying the continue button is disable by default
	System.out.println(attribute1);
	assertEquals("true", attribute1, "verifying the continue button is disable");
	waitTime();
	click(NO_Radio, "the NO_Radio button on the Quote summary");
	waitTime();
	click(Declaration_No, "Declaration_No");
	waitTime();
	waitForElementPresent("//*[@title='EncashOffers']");
	String Actual7= driver.getTitle();
	String Expected7 = "EncashOffers";
	verifyText(Actual7, Expected7);
	scrollBybottom();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	scrollToView("//*[text()='Color Pencil']".replaceAll("Color Pencil", data.competationName), "perticular competition");
	waitTime();
	waitForElementPresent_long("//*[contains(text(),'Level 2')]");
	scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
	waitTime();
	driver.navigate().back();
	Thread.sleep(3000);	
	click1("//*[contains(text(),' Go back ')]", "the go back");
	Thread.sleep(3000);
	sign_up1.YBC_LandingPage_validations_EO().Pick_You_Appliance_validations();
	ysp.Select_Applience();	
	Quote.Quotesummary();
//	ci.verifyFieldsHaveMandatoryMarker().CI_Validate_Placeholders_Fields().verifyFieldsHaveInvalidTag();
//	ci.CI_Validation_Message_Fields().Validate_the_postalcode();
	ci.Validate_the_postalcode();
    bank.fields_Validations_Message().verifyFieldsHaveInvalidTag().Bank_Details_Validate_Placeholders_Fields();
	bank.verifyFieldsHave_MandatoryTag().Validate_Bankname_Field_validData();
	bank.Bank_Date_Available_Validations_Message().Submit_concent_Terms();
	Confirm_Bank.Bank_details_validation().Payment_Confirmation();
	Thank_you.Thank_You_page_Validations().Irresistible_offer_alert();
//    Thank_you.Verify_EO_Landing_Without_Mobile_Number_Enter_New_Num();
    waitTime();
   Thread.sleep(5000);
   waitForElementPresent_long("//*[contains(text(),'Level 2')]");
   scrollToView("//*[contains(text(),'Level 2')]", "level of competition");
    waitTime();		
	return this;
	

}


public Encah_signup_validations YBC_LandingPage_validations_Dec_no() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";
	Testdata data = new Testdata();


	
	
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	String Ybc = getCurrentWindow();
	OpenNewTab();
	Thread.sleep(5000);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://ybc-staging.encashoffers.com/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(1000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
	scrollBybottom();
	waitTime();
	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	Thread.sleep(5000);
	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();
    click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
	  selectByText(Appliance_Brand1," AEG ");//temp
 	  click(Next, "the next button to Appliance Details page");
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
  	    click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		String NextButton = "//*[text()=' Next ']";
		String Expected= "//*[text()='The appliance is under 12 years and in good working order']";
		
		String Actual = driver.findElement(By.xpath("//*[text()='The appliance is under 12 years and in good working order']")).getText();
	    waitTime();
		String actual= Quote_Title.getText();
	    System.out.println(actual);
		String expected = "Quick Quote Overview";
		verifyText(actual, expected);
		System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
		verifyText(Actual, Expected);
		waitTime();
		scrollToView("//*[text()='The appliance is under 12 years and in good working order']", "Declaration");
		WebElement Xpath = driver.findElement(By.xpath("//*[@value='yes']"));
		String classcontain = Xpath.getAttribute("class");
		if(classcontain.equalsIgnoreCase("ng-star-inserted")) {
		System.out.println("Yes radio Button Defaulty Selected");
		test.info("Yes radio Button Defaulty Selected");
		}
		String attribute = getAttribute(NextButton, "disabled", "failed to getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute);
		assertEquals("true", attribute, "verifying the continue button is disable");
	    waitTime();
	    click(NO_Radio, "the NO_Radio button on the Quote summary");
	    waitTime();
	    click(Declaration_No, "Declaration_No");
	    waitTime();
	    waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual3= driver.getTitle();
		 String Expected4 = "EncashOffers";
		 verifyText(Actual3, Expected4);
		 Thread.sleep(5000);
		 setWindow(Ybc);
//		 exceptionalWindowHandle3("EncashOffers ");
//         Thread.sleep(5000);
//	     
	     
	return this;
	

}


public Encah_signup_validations YBC_LandingPage_validations_EO() throws InterruptedException, IOException {
	String standardcover = "//*[contains(text(),'Standard Cover')]//parent::button";
	String monthly_plan = "//*[@id=\"home\"]/div[3]/div/div/div[1]/div";
	String page_source= "YBC";

	
//	driver.manage().window().maximize();
//	driver.get("https://ybc-staging.encashoffers.com/#/");
 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    waitForElementPresent("(//*[contains(text(),'How it works')])[2]");
	Thread.sleep(10000);
	String title_acual = driver.getTitle();
	verifyText(page_source, title_acual);
//	click(cookies, "the allow cookies");
	waitTime();
	String monthly_className = driver.findElement(By.xpath(monthly_plan)).getAttribute("class");
	if(monthly_className.equalsIgnoreCase("dashBox active")) {
       System.out.println("monthly_plan Defaulty Selected");
		}else
		  System.out.println("monthly_plan not Defaulty Selected");
	scrollBybottom();
	waitTime();
	scrollByElement(scrool_how_it_works, "scrool_how_it_works");
	waitTime();
	scrollByElement(scrool_how_it_works2, "scrool_how_it_works2");
	waitTime();
	click(GetCoverToday, "GetCoverToday");
	String className = driver.findElement(By.xpath(standardcover)).getAttribute("class");
	if(className.equalsIgnoreCase("btn activeBtn")) {
       System.out.println("Standard Cover Defaulty Selected");
       test.info("Standard Cover Defaulty Selected");
		}else
		  System.out.println("Standard Cover not Defaulty Selected");	
	scrollBybottom();
	click(BTM_GetCoverToday, "BTM_GetCoverToday");
	waitTime();
	click(Plan_GetCoverToday, "Plan_GetCoverToday");
	return this;
	}


 public Encah_signup_validations Pick_You_Appliance_validations() throws InterruptedException, IOException {

	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
 
 
    test.info("verify the title");
    waitTime();
    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
    verifyText(actual_Title, title_Expected);
    waitTime();


  
    for(int i=0;i<=5;i++) {
   	
    	Appliance_check_Box.get(i).click();
    	Thread.sleep(2000);
    	
    }
	  click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
	  //temporary for execution
	  Thread.sleep(1000);
	  String toast= driver.findElement(By.xpath("//*[text()=' Please note this offer is applicable to maximum 6 appliances ']")).getText();
	  System.out.println(toast);
	  assertTrue1(true, toast);
	  waitTime();
  	  click(Next, "the next Button without select Brand");
 	  String toast_Next= driver.findElement(By.xpath("//*[text()=' Please select your brand for Washing Machine ']")).getText();
	  System.out.println(toast_Next);
	  assertTrue1(true, toast_Next);
	  selectByText(Appliance_Brand1," AEG ");
      selectByText(Appliance_Brand2," Don't Know/Not listed ");
      selectByText(Appliance_Brand3," Admiral ");
	  selectByText(Appliance_Brand4," John Lewis ");
	  selectByText(Appliance_Brand5,"  Blomberg  ");
	  selectByText(Appliance_Brand6," Statesman ");
 	  click(Next, "the next button to Appliance Details page");
		 return this;
 }


 public Encah_signup_validations Pick_You_Appliance_validations_Declaration() throws InterruptedException, IOException {

		String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";
	 
	 
	    test.info("verify the title");
	    waitTime();
	    String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
	    verifyText(actual_Title, title_Expected);
	    waitTime();
    
	    
	  //int applliance = Appliance_check_Box.size();
//	    for(int i=0;i<=5;i++) {
//	    	
//	    	Appliance_check_Box.get(i).click();
//	    	Thread.sleep(2000);
//	    	
//	    }
		  click(Select_max_Appliance_Checkbox, "Select_max_Appliance_Checkbox");
		  //temporary for execution
		  selectByText(Appliance_Brand1," AEG ");//temp
//		  String toast= driver.findElement(By.xpath("//*[text()=' Please note this offer is applicable to maximum 6 appliances ']")).getText();
//		  System.out.println(toast);
//		  assertTrue1(true, toast);
//		  waitTime();
//	  	  click(Next, "the next Button without select Brand");
//	 	  String toast_Next= driver.findElement(By.xpath("//*[text()=' Please select your brand for Washing Machine ']")).getText();
//		  System.out.println(toast_Next);
//		  assertTrue1(true, toast_Next);
//		  selectByText(Appliance_Brand1," AEG ");
//	    selectByText(Appliance_Brand2," Don't Know/Not listed ");
//	    selectByText(Appliance_Brand3," Admiral ");
//		  selectByText(Appliance_Brand4," John Lewis ");
//		  selectByText(Appliance_Brand5,"  Blomberg  ");
//		  selectByText(Appliance_Brand6," Statesman ");
	 	  click(Next, "the next button to Appliance Details page");
			 return this;
	 }


public Encah_signup_validations Pick_You_Appliance_validations_Search_YES() throws InterruptedException, IOException {

	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";


   test.info("verify the title");
   waitTime();
   String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
   verifyText(actual_Title, title_Expected);
   scrollByElement(Search_YES, "Search_yes");
   waitTime();
   click(Search_YES,"Search_Appliance");
  
		 return this;

    }
	public Encah_signup_validations EO_Validation_Pick_You_Appliance_validations_Search_YES() throws InterruptedException, IOException {
		String actual_Title= " We have received your request and will be shortly contacting you. ";
	
	
		   test.info("verify the title");
		   waitTime();
		   waitForElementPresent("//*[text()=' We have received your request and will be shortly contacting you. ']");
		   String title_Expected= driver.findElement(By.xpath("//*[text()=' We have received your request and will be shortly contacting you. ']")).getText();
		   verifyText(actual_Title, title_Expected);
		waitTime();
		 click(ok, "the ok button on Thank You page");
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual= driver.getTitle();
		 String Expected = "EncashOffers";
		 verifyText(Actual, Expected);
	     waitTime();

			  
		return null;
	
	}
	
	public Encah_signup_validations EO_Validation_Pick_You_Appliance_validations_Search_NO() throws InterruptedException, IOException {
		String actual_Title= " We have received your request and will be shortly contacting you. ";


		   test.info("verify the title");
		 waitForElementPresent("//*[@title='EncashOffers']");
		 String Actual= driver.getTitle();
		 String Expected = "EncashOffers";
		 verifyText(Actual, Expected);
	     waitTime();
			  
		return null;

	}
	
public Encah_signup_validations Pick_You_Appliance_validations_Search_NO() throws InterruptedException, IOException {

	String actual_Title= "Pick You Appliance To Cover And Get The Free Upgrade!";


   test.info("verify the title");
   waitTime();
   String title_Expected= driver.findElement(By.xpath("//*[contains(text(),'Pick You Appliance To Cover And Get The Free Upgrade!')]")).getText();
   verifyText(actual_Title, title_Expected);
   waitTime();
   scrollByElement(Search_NO, "Search_NO");
   click(Search_NO,"Search_Appliance");
  waitForElementPresent("//*[@title='EncashOffers']");
   String Actual= driver.getTitle();
	  String Expected = "EncashOffers";
   verifyText(Actual, Expected);
	  Thread.sleep(5000);
		 return this;

    }
public Encah_signup_validations Ybc_sign_in() throws InterruptedException, IOException {

//OpenNewTab();
//driver.manage().window().maximize();
Thread.sleep(5000);
driver.get("https://ybc-staging.encashoffers.com/#/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
return this;


  }

public Encah_signup_validations Ybc_sign_in_newtab2() throws InterruptedException, IOException {

driver.get("https://ybc-staging.encashoffers.com/#/");
driver.manage().window().maximize();
Thread.sleep(5000);
String Ybc = getCurrentWindow();
OpenNewTab();
Thread.sleep(5000);
return this;

}

public Encah_signup_validations Ybc_sign_in_newtab() throws InterruptedException, IOException {

//driver.manage().window().maximize();


OpenNewTab();
driver.manage().window().maximize();
Thread.sleep(5000);
driver.get("https://ybc-staging.encashoffers.com/#/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
return this;


  }

}