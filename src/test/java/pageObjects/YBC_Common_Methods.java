package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class YBC_Common_Methods extends ReusableMethods {
	
	public YBC_Common_Methods(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean isCustomer_INformation_DialogFieldMandatory(String fieldName) {
		
		// TODO Auto-generated method stub
		String xpath = "//label[contains(text(),'textToReplace')]/sup".replaceAll("textToReplace", fieldName);
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
//		String className = driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(text.equalsIgnoreCase("*")) {
			return true;
		}else
			return false;

	}
	
public boolean EO_Signup_Validations(String fieldName,String fielsText) {
		
		// TODO Auto-generated method stub
		String xpath = "//*[@formcontrolname='textToReplace']".replaceAll("textToReplace", fieldName);
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
//		String className = driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(text.contains(fielsText)) {
			return true;
		}else
			return false;

	}

	
public boolean isCustomer_INformation_DialogFieldMandatory_mobile(String fieldName) {
		
		// TODO Auto-generated method stub
		String xpath = "//label[contains(text(),'textToReplace')]".replaceAll("textToReplace", fieldName);
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
//		String className = driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(text.equalsIgnoreCase("*")) {
			return true;
		}else
			return false;

	}
	public boolean isUserRegistrationDialogFieldInvalid(String label) {
		String xpath = null;
//		if (label.equalsIgnoreCase("TITLE")) {
//			xpath = "//label[contains(text(),'TITLE')]/..//select";
//		}else if (label.equalsIgnoreCase("ADDRESS")) {
//			xpath = "//label[contains(text(),'ADDRESS')]/..//select";
//		}else if (label.equalsIgnoreCase("GENDER")) {
//			xpath = "//label[contains(text(),'GENDER')]/..//mat-radio-group";
//		}else if (label.equalsIgnoreCase("DATE OF BIRTH")) {
//			xpath = "//label[contains(text(),'DATE OF BIRTH')]/..//div";
//		}else
			xpath = "//*[@formcontrolname='textToReplace']".replaceAll("textToReplace", label);

		String text = driver.findElement(By.xpath(xpath)).getAttribute("class");

		if(text.contains("error-input") || text.contains("ng-invalid")){
			return true;
		}else
			return false;

	}
	
	public boolean is_Validation_Displayed(String text) {
	//	test.info("Checking if age related DOB error is displayed");
		try{
			driver.findElement(By.xpath("//*[contains(text(),'You must be at least 18 years old')]".replaceAll("You must be at least 18 years old", text)));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public String getUserRegistrationDialogFieldPlaceHolderText(String formcontrolname) {
		String xpath = "//input[@formcontrolname='TEXT']".replaceAll("TEXT", formcontrolname);
		String text = driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
		return text;
	}
	public boolean is_Text_Displayed(String text) {
		//	test.info("Checking if age related DOB error is displayed");
			try{
				driver.findElement(By.xpath("//*[contains(text(),'You must be at least 18 years old')]".replaceAll("You must be at least 18 years old", text)));
				return true;
			}catch (Exception e) {
				return false;
			}
		}
}
