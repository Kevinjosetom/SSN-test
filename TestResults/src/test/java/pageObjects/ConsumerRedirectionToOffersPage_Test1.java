package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;

public class ConsumerRedirectionToOffersPage_Test1 extends ReusableMethods{
	

	public ConsumerRedirectionToOffersPage_Test1(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}



		 
 public ConsumerRedirectionToOffersPage_Test1 loginAndParticipateInAutomationCompetition(String competitionName,
		 String emailID) throws Exception {
	 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
			//Login to encashoffers
	  Common_methods common = new Common_methods(driver);
	  Crm_CompetationEdit crm = new Crm_CompetationEdit(driver);
	  Testdata data = new Testdata();
	  Encash_Registration_Validations  registration = new Encash_Registration_Validations(driver);
	 
			crmui_addcategory.stagingUrl_launch();

			common.encashUILogin("7893920410@mailinator.com", "123456");
			common.searchCompetitionAndClick(competitionName);
			crm.playCompetition(); 
			Thread.sleep(5000);
//			try {
//				registration.skipemailverify();				
//			} catch (Exception e) {
//				//Nothing to do. Continue with test
//			}
//	
		return this;

}
 
 public void selectOptionsAndClickContinue() throws Exception {
		// From the dropdown select Buy a car, Treat the family, Go on a domestic
		// location
		String MANDATORY_QUESTION_SINGLE_CHOICE_FIRST_SELECTION = "//fieldset[contains(class,single-choice-questions)]/mat-radio-group//div[@class='mat-radio-label-content']";
	//	driver.findElement(By.xpath(MANDATORY_QUESTION_SINGLE_CHOICE_FIRST_SELECTION)).click();
		// Continue to next questions
//		try {
//			click1("//span[contains(text(),'Next')]/..","Moving on to next question");
//		} catch (Exception e) {
//			click1("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Next"), "Clicking on Next button");
//		}
//		waitForElementInvisibility("//div[@class='ladda-progress']");
////	 
//	 driver.findElement(By.xpath("//*[text()='Select as many as you want']")).click();
//	 Thread.sleep(3000);
//	 driver.findElement(By.xpath("//*[text()=' Red ']//parent::mat-option//child::mat-pseudo-checkbox")).click();
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
//	 Thread.sleep(2000);
//	 scrollToView("//*[text()=' Next ']", "next");
//	 driver.findElement(By.xpath("//*[text()=' Next ']")).click();
//	 
	}
 
 public void answerSurveryQuestion() throws Exception {
		String SURVERY_QUESTION_SINGLE_CHOICE_FIRST_SELECTION = "//fieldset[contains(class,single-choice-questions)]/mat-radio-group//mat-radio-button";
		String NEXT_BUTTON = "//*[contains(text(),'Next')]";
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[text()='Apply Now']//following::mat-radio-button")).click();
		Thread.sleep(5000);
	//	driver.findElement(By.xpath(SURVERY_QUESTION_SINGLE_CHOICE_FIRST_SELECTION)).click();			
		click1(NEXT_BUTTON, "Clicking on next button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@class='mat-select-value ng-tns-c83-12']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[contains(text(),' Talk Talk ')]")).click();
//		Thread.sleep(5000);
//		click1(NEXT_BUTTON, "Clicking on next button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@class='mat-radio-label-content']")).click();
//		Thread.sleep(5000);
//		click1(NEXT_BUTTON, "Clicking on next button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@class='mat-radio-label-content']")).click();
//		Thread.sleep(5000);
//		click1(NEXT_BUTTON, "Clicking on next button");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@class='mat-radio-label-content']")).click();
//		Thread.sleep(5000);
//		click1(NEXT_BUTTON, "Clicking on next button");
//		Thread.sleep(15000);
//		driver.findElement(By.xpath("//*[@class='mat-radio-label-content']")).click();
		Thread.sleep(8000);
		click1("//*[text()='Continue']", "Clicking on continue button");


		
	}
 
 public void verifyContinueDialog() throws Exception {
		String CONTINUE_BUTTON = "//*[text()='Claim now']";
		String LEVEL_COMPLETED_MESSAGE = "//*[text()='Congratulations on Levelling Up! ']";
		String LEVEL_CONGRATULATION_MESSAGE = "//p[contains(text(),'you have more winning probability')]";
		waitForElementVisibility1(CONTINUE_BUTTON);
		assertTrue1(driver.findElement(By.xpath(LEVEL_COMPLETED_MESSAGE)).isDisplayed(), "Level completed message is displayed");
		assertTrue1(driver.findElement(By.xpath(CONTINUE_BUTTON)).isDisplayed(), "Level completed message is not displayed");
	//	assertTrue1(driver.findElement(By.xpath(LEVEL_COMPLETED_MESSAGE)).isDisplayed(), "Level completed message is not displayed");
		//Wait for 30 seconds and continue. If the step fails then redirection happened and test failed.
		Thread.sleep(30000);
		click1(CONTINUE_BUTTON, "Clicking on continue button");
		
		
	}	
 
 public void waitOnThankYouModalAndVerifyRedirection() throws Exception {
//		String Done_BUTTON = "//span[contains(text(),'Done')]";
//		//Wait for done button to show
//		waitForElementVisibility1(Done_BUTTON);
		//Sleep for 40 seconds and verify user is redirected to offers page
		Thread.sleep(40000);
		assertTrue1(driver.getCurrentUrl().equalsIgnoreCase("https://ybc-staging.encashoffers.com/#/"),"User  redirected to the ybc home page ");
	    close("ybc");
	}
 
 public void clickDoneOnThankYouModalDialogAndVerifyRedirection() throws Exception {
		String Done_BUTTON = "//span[contains(text(),'Done')]";
		String SEARCH_BOX = "//input[@placeholder='Search']";
		//Wait for done button to show
		waitForElementVisibility1(Done_BUTTON);
		click1(Done_BUTTON, "Clicking on DONE button");
		//Wait till the offers page loads
		waitForElementVisibility1(SEARCH_BOX);
		assertTrue1(driver.getCurrentUrl().equalsIgnoreCase("http://staging.encashoffers.com/offers/all"),"User not redirected to offers page");
	}
}
 
