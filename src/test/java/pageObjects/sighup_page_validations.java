package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class sighup_page_validations extends ReusableMethods{
		
//		@FindBy(xpath="//input[@formcontrolname='userId']")
//	    WebElement encash_crm_username;
//
//
//		@FindBy(xpath="//input[@formcontrolname='password']")
//	    WebElement encash_crm_pwd;
			
		@FindBy(id="firstName")
	    WebElement first_name;

		@FindBy(id="lastName")
	    WebElement last_Name;
		
		@FindBy(id="email")
	    WebElement email;

		@FindBy(xpath="//mat-radio-button[@value='male']")
	    WebElement male;
		
		@FindBy(xpath="//mat-radio-button[@value='female']")
	    WebElement female;
		
		@FindBy(id="day")
	    WebElement day;
		
		@FindBy(id="month")
	    WebElement month;
		
		@FindBy(id="year")
	    WebElement year;
		
		@FindBy(id="password")
	    WebElement password;
		
		@FindBy(id="confirmPassword")
	    WebElement confirmPassword;
		
		@FindBy(id="display_name")
	    WebElement display_name;
		
		@FindBy(id="postalCode")
	    WebElement postalCode;
		
		@FindBy(xpath="//span[text()=' Find Address ']")
	    WebElement find_address;
		
		@FindBy(id="addressLine1")
	    WebElement addressLine1;
		
		@FindBy(id="city")
	    WebElement city;
		
		@FindBy(xpath="//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	    WebElement check_box;
		
		@FindBy(xpath="//span[text()=' Continue ']/parent::button[@class='btn btn-success btn-continue mb-3 ladda-button']")
	    WebElement continue_;
		
		
		
			
	public sighup_page_validations(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public sighup_page_validations sign_up_details(String displayname, String pass_word, String email_id, String lastName,
			String first_Name, String pin_code, String city_name, String address,String findaddress) throws IOException {
		
		text(first_name, first_Name, "firstname");
		text(last_Name, lastName, "lastname");
		text(email, email_id, "cust.email_id");
		click(male, "male_radio");
		//click(female, "female_radio");
		selectByvalue(day, "6");
		selectByvalue(month, "AUG");
		selectByvalue(year, "1991");
		text(password, pass_word, "password");
		text(confirmPassword, pass_word, "confirm_password");
		text(display_name, displayname, lastName);
		text(postalCode, pin_code, "postal_code");
		click(find_address, findaddress);
		waitTime();
		text(addressLine1, address," addressLine1");
		text(city, city_name, "city_name");
		click(check_box,"checkbox");
		click(continue_, "continue");
		
		
		
		
		
		
		
		
		return this;	
	
//		  text(encash_crm_username, encash_crm_username_, "encash_crm_username");
//		  text(encash_crm_pwd, encash_crm_pwd_, "encash_crm_pwd");
//          driver.findElement(By.xpath("//button[@title='Register']")).click();
//          driver.findElement(By.id("mobile-number")).sendKeys("7893932115");
//          driver.findElement(By.xpath("//span[text()='Continue ']")).click();

	}

	public Object Encash_home_validations() {
		// TODO Auto-generated method stub
		return null;
	}

}
	

	