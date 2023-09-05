package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class Ybc_home_page_objects extends ReusableMethods {

	@FindBy(xpath="//*[@class='nav-link active']")
    WebElement standard;
	
	@FindBy(xpath="//*[text()=' Proceed ']")
    WebElement proceed;
	
	@FindBy(xpath="//*[text()='Contact us']")
    WebElement contactus;
	
	@FindBy(xpath="//span[text()='Plan 1']//parent::div")
    WebElement plan1;
	
	@FindBy(xpath="	//*[text()='Plan']//following-sibling::div")
    WebElement plan_selections;
	
	@FindBy(xpath="//span[text()='Plan 2']//parent::div")
    WebElement plan2;
	
	@FindBy(xpath="//span[text()='Plan 3']//parent::div")
    WebElement plan3;
	
	@FindBy(xpath="//*[text()=' Claim to get additional 3X points in EO Rewards ']/child::input")
    WebElement additional_3X_points;
	
	@FindBy(xpath="//*[text()=' Proceed ']")
    WebElement PROCEED;
	
	@FindBy(xpath="(//*[@class='checkmark'])[1]")
    WebElement checkMark_Applience;
	
	@FindBy(xpath="(//*[@class='checkmark'])[2]")
    WebElement checkMark_Applience2;
	
	@FindBy(xpath="//*[@class='selectBox']//child::select")
    WebElement select_brand;
	
	@FindBy(xpath="//*[text()=' Next ']")
    WebElement next;
	
	@FindBy(xpath="//*[text()='choose your appliance']")
    WebElement applience_popup;
	
	@FindBy(xpath="//*[text()=' Cancel ']")
    WebElement choose_applience_cancel;
	
	@FindBy(xpath="//*[text()='YBC Terms and conditions']")
    WebElement terms_and_conditions;
	
	
	
	
	public Ybc_home_page_objects(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
public Ybc_home_page_objects cover_plan_objects() {
	waitTime();
	waitTime();
	waitTime();
	scrollByElement(standard, "standard");
	waitTime();
	scrollByElement(proceed, "proceed");
	waitTime();
	scrollBybottom();
	waitTime();
	scrollByElement(contactus, "contactus");
	scrollByElement(standard, "standard");
	scrollByElement(plan1, "plan1");
	return this;
}
public  Ybc_home_page_objects verifyplan1() {

		try {
			click(plan1, "plan1_Selection_3years");
			String actualResult=plan_selections.getText();
			String ExpectedResult="3 Yearly";
	        verifyText(actualResult, ExpectedResult);
	        click(additional_3X_points, "additional_3X_points");
	    	click(PROCEED, "PROCEED");
	   		}
		catch (Exception e) {
			System.out.println("plan1 selections are mismatched not as per selection");
		}
		return this;
		
}

	public  Ybc_home_page_objects verifyplan2() {

		try {
			click(choose_applience_cancel, "choose_applience_cancel");
			waitTime();
			click(plan2, "plan2_Selection_yearly");
			String actualResult=plan_selections.getText();
			String ExpectedResult="Yearly";
	        verifyText(actualResult, ExpectedResult);
	        click(additional_3X_points, "additional_3X_points");
	    	click(PROCEED, "PROCEED");
		}
		catch (Exception e) {
			System.out.println("plan1 selections are mismatched");
		}
		return this;

	}
	public  Ybc_home_page_objects verifyplan3() {

		try {
			click(choose_applience_cancel, "choose_applience_cancel_Button");
			waitTime();
			click(plan3, "plan3_Selection_Monthly");
			String actualResult=plan_selections.getText();
			String ExpectedResult="Monthly";
	        verifyText(actualResult, ExpectedResult);
	       
		}
		catch (Exception e) {
			System.out.println("plan1 selections are mismatched");
		}
		return this;

	}
	
	public  Ybc_home_page_objects  terms_and_conditions_popup_validation() {
		try {
	    click(terms_and_conditions, "terms_and_conditions");
	    windowHandle();
		String actual_title= driver.getTitle();
		String expected_title = "404 Not Found";
		verifyText(actual_title, expected_title);
		System.out.println("Webpage  navigate Sucessfully to the terms_and_conditions webpage ");

		}
		catch (Exception e) {
			System.out.println("Webpage not navigate to the terms_and_conditions webpage ");
		}
		driver.close();
		waitTime();
		return this;
		
	}

	public  Ybc_home_page_objects  Applience_selcetion_popup() {
		try {
	    click(additional_3X_points, "additional_3X_points");
	    click(PROCEED, "PROCEED");
		String actual= applience_popup.getText();
		String expected = "CHOOSE YOUR APPLIANCE ";
		verifyText(actual, expected);
		System.out.println("Webpage  navigate Sucessfully to the CHOOSE YOUR APPLIANCE page ");

		}
		catch (Exception e) {
			System.out.println("Webpage not navigate to the CHOOSE YOUR APPLIANCE page ");
		}
		
		return this;
		
		
		
	}
	
	public  Ybc_home_page_objects  Appilience_selcetion() {
		
//	click(checkMark_Applience2, "checkMark_Applience2");
//	selectBy(select_brand, "Samsung");
	click(checkMark_Applience, "checkMark_Applience");
//	selectBy(select_brand, "Samsung");
	click(next, "next");
	waitTime();
	System.out.println("user can can able to select one appillience at first time");
		return this;
		
	

	
		}}	
	

