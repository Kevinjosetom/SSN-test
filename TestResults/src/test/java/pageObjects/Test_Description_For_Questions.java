package pageObjects;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;


public class Test_Description_For_Questions extends ReusableMethods {

	public Test_Description_For_Questions(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	   Testdata data=new Testdata();
	   readconfig rconfig = new readconfig();
	
	public Test_Description_For_Questions crmUI_setQuestionDescription(String question, String description) throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		  Common_methods common = new Common_methods(driver);
			crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);

		Testdata data=new Testdata();
		  readconfig rconfig = new readconfig();
		 String username= rconfig.getusername();
			 String crmpwd= rconfig.getcrmPwd();
			// String CRMQuestion="What is your current employment status?";

			// Launch and Login
		     En_sign.Admin_login(username, crmpwd);
		//	waitForElement1(120,"//span[contains(text(),'Question Bank')]", "Wait for Survey Questions to load");
		//	click1("//span[contains(text(),'Question Bank')]", "Expand Question bank");
			test.info("click on the Survey Questions");
			waitForElement1(120,"//span[contains(text(),'Survey Questions')]", "Wait for Survey Questions to load");
		//	click1("//span[contains(text(),'Survey Questions')]", "Goto Survey Questions");
			
			// Search for the 3rd Question
			waitForElementPresent("//input[contains(@placeholder,'Search')]");
			type1("//input[contains(@placeholder,'Search')]", question, "search for the question with nam" + question);
            Thread.sleep(3000);
			waitForElementPresent("//*[text()='Title']//following::mat-row");
			click1("//*[text()='Title']//following::mat-row", "Clicked on Desired Testimonial");
			waitForElementPresent("//input[contains(@placeholder,'Title')]");
			// Edit the Question Description
			waitForElementPresent("//quill-editor/div[2]/div[1]/p");
			clearAndType("//quill-editor/div[2]/div[1]/p", description,
					"Edited Description to -->" + description);
			// 3. Save
			Thread.sleep(5000);
			scrollToView("//span[contains(text(),'SAVE')]","Scroll to the Save Button");
			waitForElement1(60,"//span[contains(text(),'SAVE')]", "waiting for Save button to be enabled");
			click1("//span[contains(text(),'SAVE')]", "Save the Question");
			Thread.sleep(10000);
			common.refresh("Page refreshed");
			Thread.sleep(15000);
			// Logout of Admin
			En_sign.Admin_logout();
	
		
		return this;

    }
	public void registerNewUserForDescritionTest(String phoneNumber, String otp, String email) throws Exception {
		Common_methods common = new Common_methods(driver);
		 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		 Encash_Registration_Validations  registration  = new Encash_Registration_Validations(driver);
		crmui_addcategory.stagingUrl_launch();
		Thread.sleep(15000);
	
	/*	registration.register();
		common.setTitle("Mr.");
		common.setFirstName(phoneNumber);
		common.setLastName(data.lastName);
		common.setEmail(email);
		common.selectGender("Male");
		common.setDOB("12", "jan", "1901");
		common.setPassword(data.password);
		common.setConfirmPassword(data.password);
		common.setDisplayName(phoneNumber);
		common.setPostalCode(data.kw14yt);
		test.info("select the address from drop down");
		selectByIndex("//*[@id='address']", 1, "select the first address");
		common.giveConsent();
		//common.clickContinueButton();
		//registration.skipemailverify();
		// modified for mobile no shortage
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Cancel ']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Menu']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
		Thread.sleep(8000);
		waitTime();*/
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys("soni.sharma@velocis.co.in");
		waitTime();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ssssharma#96");
		waitTime();
		driver.findElement(By.xpath("//*[text()=' Continue ']")).click();
		//waitForElementInvisibility("//mat-dialog-container[@id='mat-dialog-0']");
		
		
		
	}
	
	
	public void searchCompetitionAndClick(String competationName) throws IOException, InterruptedException {
		test.info("click on the competitions hyperlink");
		Thread.sleep(8000);
		waitForElementPresent("(//*[text()='Competitions'])[1]");
		clickHyperlink("Competitions", "cliking on the competitions hyperlink");

		test.info("type on the search box for competitions");
		waitForElementPresent("//input[@placeholder='Search']");
		type1("//input[@placeholder='Search']",competationName, "typing on the search box");
		waitTime();
		waitForElementPresent("//div/a[@title='competitionName']".replaceAll("competitionName", competationName));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		test.info("click on the particualr competitions");
		//scrollToView("//*[contains(text(),'text')]".replaceAll("text", competationName), "click on the particular competitions");
		waitTime();
		//clickHyperlink("//*[contains(text(),'text')]".replaceAll("text", competationName), "click on the particular competitions");
		clickHyperlink(competationName, "click on the particular competitions");
		
	//	driver.findElement(By.linkText(competationName)).click();
	}
	
	public void playCompetitionForDesc() throws Exception {
		Thread.sleep(5000); // Can this be replaced with wait for element ?
		test.info("click on the play now button");
		WebElement play = driver.findElement(By.xpath("//*[contains(text(),'Play now ')]"));
		JavascriptExecutor jsPlay = (JavascriptExecutor) driver;
		jsPlay.executeScript("arguments[0].click()", play);
		try {
			test.info("accept consent");
			Thread.sleep(2000); // Can this be replaced with wait for element ?
			WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'mat-checkbox-persistent')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ele);
			test.info("click on the continue button");
			click1("//span[contains(text(),'Continue')]", "click on the continue button");
			Thread.sleep(4000); // Can this be replaced with wait for element ?
		}catch(Exception e) {
			test.info("Consent Dialog is not displayed. This implies the Story ENCASH2-138 : Change in behavior of consent at the time of availing an offer or participating in a competition");
		}

	}
	
	public void verifyDescription(String state) throws Exception {
		
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		Common_methods common = new Common_methods(driver);
		String expectedDescriptionForQues1 = "<p><strong>Privacy </strong><em>policy </em><u>test </u></p><ol><li><strong><u>a</u></strong></li></ol><ul><li><strong><u>b</u></strong></li><li class=\"ql-indent-1\"><strong><u>g</u></strong></li></ul>";
		// String expectedDescriptionForQues2 = "<p>By selecting an opt in you consent
		// to Marketing Punch Ltd sending you marketing about their products/services
		// that are relevant to you. You can unsubscribe at any time. Read their privacy
		// policy to find out more <a
		// href=\"https://www.offerx.co.uk/documents/privacy\" rel=\"noopener
		// noreferrer\" target=\"_blank\"
		// data-at-href=\"https://www.offerx.co.uk/documents/privacy\">Privacy
		// policy</a>/<a
		// href=\"https://www.offerx.co.uk/documents/terms-and-conditions\"
		// rel=\"noopener noreferrer\" target=\"_blank\"
		// data-at-href=\"https://www.offerx.co.uk/documents/terms-and-conditions\">Terms
		// &amp; conditions</a>. *We are not endorsed by the products that get reviewed
		// and the prizes we give away. We will send you great offers from OfferX and
		// Get Test Keep that we think will interest you. By opting in you are agreeing
		// to receive offers and updates by email, telephone and post from Marketing
		// Punch sites and selected third party companies which we believe will be of
		// interest.</p>";
		String expectedDescriptionForQues2 = "By selecting an opt in you consent to Marketing Punch Ltd sending you marketing about their products/services that are relevant to you. You can unsubscribe at any time. Read their privacy policy to find out more Privacy policy/Terms & conditions. *We are not endorsed by the products that get reviewed and the prizes we give away. We will send you great offers from OfferX and Get Test Keep that we think will interest you. By opting in you are agreeing to receive offers and updates by email, telephone and post from Marketing Punch sites and selected third party companies which we believe will be of interest.";
		String expectedLinkForPrivacyForQues2 = "https://www.offerx.co.uk/documents/privacy";
		String expectedLinkForTCForQues2 = "https://www.offerx.co.uk/documents/terms-and-conditions";

		// Verifying the Description of 1st Question "//label[text()='Do you regularly
		// play the lottery?']"  
//		waitForElement1(60, "//label[text()='Do you regularly play the lottery?']",
//				"Waiting for 1st Question");
//		waitForElement1(60, "//label[text()='What is your home ownership status?",
//				"Waiting for 1st Question");   //class="single-choice-questions ng-star-inserted"
//		String actualDescriptionForQuestion1 = getAttribute("//div[@class='description ng-star-inserted']",
//				"innerHTML", "Getting the Inner text");
//		assertEquals(actualDescriptionForQuestion1, expectedDescriptionForQues1, "Verifying Question Description 1");
//	//	common.selectEligibilityQuestionChoice("Yes");
	//	common.click1("//span[contains(text(),'Next')]/..", "Moving on to next question");

		// Verifying the Description of 2nd Question
	//	waitForElement1(60, "//mat-radio-group/mat-radio-button//div[contains(text(),'choiceName')]".replaceAll("choiceName", "iPhone12"),
	//			"Waiting for 2nd Question");
		// **Defect**
		// String actualDescriptionForQuestion2 =
		// getAttribute(EncashWebLocators.encash_mandatory_question_description_1,
		// "innerHTML","Getting the Inner text");
		// assertEquals(actualDescriptionForQuestion2, expectedDescriptionForQues2,
		// "Verifying Question Description 2");

		// Verifying the Description for Question 2
//		String actualDescriptionForQuestion2 = getText("//div[@class='description ng-star-inserted']",
//				"Getting the Description for Question 2");
//		assertEquals(actualDescriptionForQuestion2, expectedDescriptionForQues2, "Verifying Question Description 2");
//
//		// Verifying the Link of Privacy in Question 2 is intact.
//		String actualLinkForPrivacyForQues2 = getAttribute("//div[@class='description ng-star-inserted']/p"+ "/a[1]", "href",
//				"Getting the Link of Privacy for Question 2");
//		assertEquals(actualLinkForPrivacyForQues2, expectedLinkForPrivacyForQues2,
//				"Verifying Link of Privacy in Ques Description 2");
//
//		// Verifying the Link of T&C in Question 2 is intact.
//		String actualLinkForTCForQues2 = getAttribute("//div[@class='description ng-star-inserted']" + "/a[2]",
//				"href", "Getting the Link of Terms and Conditions for Question 2");
//		assertEquals(actualLinkForTCForQues2, expectedLinkForTCForQues2,
//				"Verifying Link of Privacy in Ques Description 2");
//
//		common.selectEligibilityQuestionChoice("iPhone12");
//		common.click1("//label[text()='toReplaceQuestionName']", "Moving on to next question");
//
//		// Verifying the Description of 3rd Question "//label[text()='What is your
//		// current employment status?']"
//		waitForElement1(60, "//label[text()='What is your current employment status?']",
//				"Waiting for 3nd Question");
		if (state == "original") {
			String actualDescriptionForQuestion3 = getText("//div[@class='description ng-star-inserted']/p",
					"Question Description");
			assertEquals(actualDescriptionForQuestion3, data.originalQuestionDescription,
					"Verifying Question Description 3");
		} else if (state == "edited") {
			String actualDescriptionForQuestion3 = getText("//div[@class='description ng-star-inserted']/p",
					"Question Description");
			assertEquals(actualDescriptionForQuestion3, data.editedQuestionDescription,
					"Verifying edited Question Description 3");
			
		}
	//	common.selectEligibilityQuestionChoice("Full Time Employed");
	//	common.click1("//span[contains(text(),'Next')]/..", "Moving on to next question");

		// Verifying the Description of 4th Question. "//label[text()='Test_without
		// Question Description']"  
//		waitForElement1(60, "//label[text()='Test_without Question Description']",
//				"Waiting for 4th Question");
//		boolean DescriptonPresent = isDisplayed1("//div[@class='description ng-star-inserted']/p",
//				"Verify the Question 4 Description is not there");
//		assertFalse(DescriptonPresent, "Verifying the absense of Description for Question 4");
//		common.selectEligibilityQuestionChoice("Yes");
//		common.click1("//img[@title='Menu']", "Moving on to next question");
//		Thread.sleep(15000); // Was facing difficulty here. So has to use sleep. Can this be replaced with
//		// wait for element ?
//		common.refresh("Refreshing the page");
//		waitForElement1(60, "//img[@title='Menu']", "Waiting for Logout Menu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(5000);
		crmui_addcategory.stagingUrl_logout();
		//En_sign.Admin_logout();
	}

	
}
