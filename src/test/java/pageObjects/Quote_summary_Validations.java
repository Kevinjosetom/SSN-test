package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class Quote_summary_Validations extends ReusableMethods {
	
	@FindBy(xpath="//*[@type='checkbox']")
    WebElement Next_Checkbox;
	
	@FindBy(xpath="//*[text()='Quick Quote Overview']")
    WebElement Quote_Title;
	
	@FindBy(xpath="//*[text()=' Next ']")
    WebElement Next;
	
	
	@FindBy(xpath="//*[@type=\"checkbox\"]")
    WebElement check_box;
	
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
	
	public Quote_summary_Validations(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
public Quote_summary_Validations Quotesummary() throws InterruptedException, IOException {
	
	        String NextButton = "//*[text()=' Next ']";
		    waitTime();
			String actual= Quote_Title.getText();
		    System.out.println(actual);
			String expected = "Quick Quote Overview";
			verifyText(actual, expected);
			System.out.println(" Navigate Sucessfully to the Quick Quote Overview page ");
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
			String EO_Points=   getText("//*[text()=' Additional 8000 score points in EncashOffers Rewards ']", "E.O_points");
		    waitTime();
		//    String EO_Points= driver.findElement(By.xpath("//*[text()=' Additional 8000 score points in EncashOffers Rewards ']")).getText();
		    System.out.println(EO_Points);
		    String Eo_Points_expected="Additional 8000 score points in EncashOffers Rewards	";
		    verifyText(EO_Points, Eo_Points_expected);
		    click(Next_Checkbox, "the Next_Checkbox button on the Quote summary");
	    	click(Next, "the next Button to navigate Quote summary Window");
	    	waitTime();
    	
	    
		return this;

    }

    public Quote_summary_Validations Quotesummary_Declaration() throws InterruptedException, IOException {
	 
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
	return this;

       }
     

public Quote_summary_Validations Quotesummary_Declaration_Yes() throws InterruptedException, IOException {
	 
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
    return this;

   }
 }


