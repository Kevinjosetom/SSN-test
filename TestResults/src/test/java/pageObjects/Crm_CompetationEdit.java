package pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.QuestionType;
import data.Testdata;

public class Crm_CompetationEdit extends ReusableMethods {
	

	public Crm_CompetationEdit(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	   Testdata data=new Testdata();
	   readconfig rconfig = new readconfig();
	
		/**
		 * This method is used to navigate to feature offers
		 * 
		 * @throws Exception
		 */
 
	 /**
		 * This method is used to Edit the competition
		 * @param competitionName
		 * @throws Exception
		 */
    public void SearchCompetition(String competitionName) throws Exception {
			  Common_methods common = new Common_methods(driver);
				encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
			     readconfig rconfig = new readconfig();
			     String username= rconfig.getusername();
			     String crmpwd= rconfig.getcrmPwd();

                Thread.sleep(10000);
			  // Launch and Login
				En_sign.Admin_login( username ,crmpwd);
			
			test.info("Expand the encash offers to select the competitions");
			String Encashoffers="//*[contains(text(),'Encash Offers')]";
		    waitForElementPresent_long(Encashoffers);
		    clickAndWait(Encashoffers, Encashoffers);
			//WaitForElementInvisibility(CRMWebLocators.encash_crm_competitions_pageload);
			click1("//span[contains(text(),'Competitions')]", "Expand Encash Offers");
			test.info("click on the Competitions");
			waitForElement1(120,"//span[contains(text(),'Competitions')]", "Wait for Competitionsto load");
			click1("//span[contains(text(),'Competitions')]","Goto Competitions");
			//WaitForElementInvisibility(CRMWebLocators.encash_crm_competitions_pageload);

			//search for Competitions 
			waitForElementPresent("//*[text()=' Competitions ']");
			type1("//input[contains(@placeholder,'Search')]", competitionName, "search for the competations -> " + competitionName );

			//click on the table with exect match
			waitForElementPresent("//*[@id='cdk-drop-list-0']/mat-row");
			Thread.sleep(2000);
			tableData("//*[@id='cdk-drop-list-0']/mat-row",competitionName,"2");


}
 
    /**
	 * This method is used to edit the competition 
	 * @param competitiondata
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void EditCompetition(HashMap<String,String> competitiondata) throws IOException, InterruptedException {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);


		
		test.info("competation Edit");
				
		waitForElementPresent("//input[contains(@placeholder,'Name')]");
		//Competitions Name "
		WebElement element = getElement("//input[contains(@placeholder,'Name')]");
		element.clear();
		element.sendKeys(competitiondata.get("Name"));
		
		//Add Description
		waitForElementPresent("//div[contains(@data-placeholder,'Insert text here')]");
		element = getElement("//div[contains(@data-placeholder,'Insert text here')]");
		element.clear();
		element.sendKeys(competitiondata.get("Description"));

		//select the client from dropdown
		driver.findElement(By.xpath("//mat-select[contains(@placeholder,'Client')]")).click();

		
		//scrollToView(crm.appLink(competitiondata.get("client")), "scroll to the client name "+competitiondata.get("client"));
		waitForElementPresent("//*[text()=' testclient ']");
		Thread.sleep(1000);
		click1("//*[text()=' testclient ']","select the client");
		
		//Set Categories as Shopping  
		click1("//mat-select[contains(@placeholder,'Choose categories')]", "Open Category dropdown");
		test.info("open category from dropdown");
		click1("//*[contains(text(),' Test Offers @Kumar ')]", " on the selected categorie");
		Thread.sleep(15000);
		//deselect if already selected the from dropdown 
//		
//		List<WebElement> categerories = getWebElement("//*[starts-with(@id,'mat-option')]");
//		
//		//uncheck the previous selected option 
//		for(WebElement categeour : categerories) {
//			String status = categeour.getAttribute("aria-selected");
//			System.out.println(status);
//			if(status.equalsIgnoreCase("true")){
//				categeour.click();
//			}
//		}
//		// click on check box for new options
//		for(WebElement categeour : categerories) {
//			String categename = categeour.getText();
//			System.out.println(categename);
//			if(categename.equalsIgnoreCase(" ddddd "))
//		   categeour.click();
//			}
//			
//		
//		
//		test.info("clicking on the other area so that drop down go away");
//		//click on other area just to close the drop down 
//		click1("//*[@id=\"mat-tab-content-0-0\"]/div"
//				,"making the drop down");
//		
//		
		test.info("clicking on the data picket");
		click1("//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-0']","clicing on the calender");

		Thread.sleep(2000);
		//select year
		//select month and year button
		click1("//button[@aria-label='Choose month and year']", "click on the month and year");
		waitForElementPresent("//tr/td");
		datePicker("//tr/td", competitiondata.get("EndYear"));

		Thread.sleep(2000);

		//select Month
		waitForElementPresent("//tr/td");
		datePicker("//tr/td", competitiondata.get("EndMonth"));

		Thread.sleep(2000);

		//select date
		waitForElementPresent("//tr/td");
		datePicker("//tr/td", competitiondata.get("Enddate"));
		
		
		//click on the save button 
	
		test.info("click on save button");
		click1("//span[contains(text(),'SAVE')]","clicked on the Add button");
		Thread.sleep(10000);
		//WaitForElementPresent("//nz-notification[starts-with(@class,'ng-tns-c160')]");
//		waitForElementPresent("//nz-notification[starts-with(@class,'ng-tns-c160')]");
//		String status =getText("//nz-notification[starts-with(@class,'ng-tns-c160')]", "getting the text");
//		test.info("Message got from attributed ----->"+status);
		//verification point
		//assertEquals("Update Competition\r\nSuccessfully updated the competition",status , "verify the update status message");
		//WaitForElementInvisibility(CRMWebLocators.encash_crm_competitions_notification);

		//Logout
		test.info("logout the application");
		En_sign.Admin_logout();
		test.info("succefull logout");
	}
   
	
	public void editCompetitionQuestion(String Questionname, String QuestionSelect) throws Exception {
	
		
		//click on the question tab
		
		waitForElementPresent("//*[@id='mat-tab-label-0-1']");
		click1("//*[@id='mat-tab-label-0-1']", "clicking on the Question tab");

		//addition of question click on the Add button i.e. '+'

		waitForElementPresent("//*[text()='add']");
		//click(CRMWebLocators.encash_crm_add,"clicking on add button");
		Thread.sleep(2000);
		click1("//*[text()='add']","clicking on the + symbol");

		Thread.sleep(2000);
		//2nd questionary
		//Set Categories as Shopping
		Thread.sleep(2000);
		click1("(//*[@placeholder=\"Select Questionnaire\"])[2]", "select the second dropdown");
        Thread.sleep(1000);
		/**	click(crm.dropdown("Select Questionnaire"), "Open Category dropdown");
				logger.info("open Questionnaire from dropdown");
		 **/				
		type1("//input[contains(@placeholder,'Search questionnaires')]",Questionname,"searching for the question " + Questionname);
		
		waitForElementPresent("//span[contains(text(),'QuestionSelect')]".replaceAll("QuestionSelect",Questionname));
		click1("//span[contains(text(),'QuestionSelect')]".replaceAll("QuestionSelect", Questionname), "Selected the question type Consumer Questions (1 segments)");
		test.info("selected the Client Questions");
		
		Thread.sleep(2000);
		
		//delete the first questionaries
		click1("//*[@id='cdk-drop-list-1']/div[1]/button[1]","deleted the first questionnaries");
		Thread.sleep(2000);
		click1("//div/button[1]/span[1][contains(text(),'SAVE')]", "Save the Questions");
//		waitForElementPresent("//nz-notification[starts-with(@class,'ng-tns-c160')]");
//		waitForElementInvisibility("//nz-notification[starts-with(@class,'ng-tns-c160')]");
       Thread.sleep(5000);

	}
	
	
	public void verifyEditcompetitionBasic(HashMap<String,String> competitiondata) throws IOException, InterruptedException {
		

		test.info("competation get information ");
		Thread.sleep(5000);
		waitForElementPresent("//input[contains(@placeholder,'Name')]");
		Thread.sleep(5000);	
		//verify Competitions Name
		String competitionname = getText("//*[@id='competition']/div[2]/div[1]/div/div[2]/div[1]", "get the competititon name");
		assertEquals(competitionname, competitiondata.get("Name"), "verify the competition name");
		

		//verify Description  
		waitForElementPresent("//div[contains(@data-placeholder,'Insert text here')]");
		String competitiondescription = getText("//div[contains(@data-placeholder,'Insert text here')]", "get the competitton description name");
		assertEquals(competitiondescription, competitiondata.get("Description"), "verify competition ck editor");
		
		

		//verify the client from dropdown  
		String competitionclient = getText("//mat-select[contains(@placeholder,'Client')]", "get the selected Client name");
		assertEquals(competitionclient, competitiondata.get("client"), "verify the competition client ");
		
		//Verify  the categories   
		String categoriesselect = getText("//mat-select[contains(@placeholder,'Choose categories')]", "get the categories");
		System.out.println("categoriesselect "+ categoriesselect );
		assertEquals(categoriesselect, competitiondata.get("categories"), "verify the competition categories");
		
	}
	public void searchCompetitionAndClick(String competationName) throws IOException, InterruptedException {
	//	String competationName="Test_kumar123";
		test.info("click on the competitions hyperlink");
		clickHyperlink("Competitions", "cliking on the competitions hyperlink");

		test.info("type on the search box for competitions");
		waitForElementPresent("//input[@placeholder='Search']");
		type1("//input[@placeholder='Search']",competationName, "typing on the search box");
		waitForElementPresent("//div/a[@title='competitionName']".replaceAll("competitionName", competationName));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		test.info("click on the particualr competitions");
	//	clickHyperlink(competationName, "click on the particular competitions");
		click1("//*[text()='Test_kumar123']".replaceAll("Test_kumar123", competationName), competationName);
		
		
	}	

	public void playCompetition() throws Exception {
		Thread.sleep(2000);
		test.info("click on the play now button");
		click1("//button[contains(text(),'Play now')]", "click on the play now button");
		Thread.sleep(10000);
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
			test.info("Consent Dialog is not displayed : Change in behavior of consent at the time of availing an offer or participating in a competition");
		}

		
	}
	
	public void SurveyQuestion(HashMap<Integer,QuestionType> questions) throws Exception {

		for(int i=1;i<=questions.size();i++) {

			QuestionType dataquestion  = questions.get(i);
			String storedquestion = dataquestion.getQuestion();
			test.info("storedquestion " + storedquestion);

			if(dataquestion.getQuestionType().equalsIgnoreCase("Single")) {
				waitForElementVisibility1("//app-question/fieldset/label");
				String question = getText("//app-question/fieldset/label", "reading the questions");
				test.info("question got " + question);
				Assert.assertEquals(storedquestion, question);
				//assertEquals(storedquestion, question, "verified the question ");


				List<WebElement> answers = getWebElement("//fieldset[@class='multiple-questions ng-star-inserted']/span");
				for(WebElement answer : answers ) {
					test.info(answer.getText());
					test.info( dataquestion.getAnswer().get(0));
					if(answer.getText().equals(dataquestion.getAnswer().get(0)) ) {
						answer.click();
						test.info("click on the next button");
						click1("//span[contains(text(),'Next')]", "click on next button");
						Thread.sleep(2000);
						break;

					}
					// Assert.assertEquals(dataquestion.getAnswer().get(0), answer.getText());
				}
			}
			if(dataquestion.getQuestionType().equalsIgnoreCase("Multiple")) {
				waitForElementVisibility1("//app-question/fieldset/label");
				String question = getText("//app-question/fieldset/label", "reading the question");
				test.info("question got " + question);
				Assert.assertEquals(storedquestion, question);

				List<WebElement> answers = getWebElement("//mat-checkbox[contains(@id,'mat-checkbox')]");
				int index = 0;
				List<String> dataanswer = dataquestion.getAnswer();
				for(String ans : dataanswer) {
					for(WebElement liveanswer :answers) {
						test.info("Liveanswer " + liveanswer.getText());
						test.info("selecting answer  "+ ans);
						if(liveanswer.getText().equals(ans)) {
							liveanswer.click();
							break;
						}
					}
				}
				//verify message "select as many as you like
				String message = getText("//fieldset[@class='multiple-questions ng-star-inserted']/span", "getting the text");

				//verification
				assertEquals("Select as many as you like", message, "text verification");

				test.info("click on the next button");
				click1("//span[contains(text(),'toReplaceButtonText')]", "click on next button");
				Thread.sleep(2000);
			}

		}
	}
	
	public void competationQuestion(HashMap<Integer,QuestionType> questions) throws Exception {


		int initialScore = 106;
		int  liveScore = Integer.parseInt(getText("//div[@class='score-progress']/strong", "fetching the initital score"));

		//verify the intial score
		Assert.assertEquals(initialScore, liveScore);
		//verifying the text contain
		String extrascore = getText("//div[@class='competition-timer d-flex align-items-center ng-star-inserted']/p", "getting the extra score text");
		assertContains(extrascore,"Get 10 more score. Finish this level under", "extra score message verification");


		for(int i=1;i<=questions.size();i++) {
			QuestionType dataquestion  = questions.get(i);
			String storedquestion = dataquestion.getQuestion();
			test.info("storedquestion " + storedquestion);

			if(dataquestion.getQuestionType().equalsIgnoreCase("Single")) {
				waitForElementVisibility1("//form[@class='ng-untouched ng-pristine ng-invalid']/fieldset/div | //form[@class='ng-invalid ng-untouched ng-pristine']/fieldset/div");
				String question = getText("//form[@class='ng-untouched ng-pristine ng-invalid']/fieldset/div | //form[@class='ng-invalid ng-untouched ng-pristine']/fieldset/div",
						"reading the questions");
				test.info("question got " + question);
				Assert.assertEquals(storedquestion, question);
				//assertEquals(storedquestion, question, "verified the question ");


				List<WebElement> answers = getWebElement("//*[starts-with(@id,'mat-radio-')]");
				for(WebElement answer : answers ) {
					test.info(answer.getText());
					test.info( dataquestion.getAnswer().get(0));
					if(answer.getText().equals(dataquestion.getAnswer().get(0)) ) {
						answer.click();
						test.info("click on the next button");
						click1("//button[contains(text(),'Next')]", "click on next button");
						
						Thread.sleep(2000);
						break;

					}
					// Assert.assertEquals(dataquestion.getAnswer().get(0), answer.getText());
				}
			}
			if(dataquestion.getQuestionType().equalsIgnoreCase("Multiple")) {
				waitForElementVisibility1("//form[@class='ng-invalid ng-untouched ng-pristine']/fieldset/div");
				String question = getText("//form[@class='ng-invalid ng-untouched ng-pristine']/fieldset/div", "reading the question");
				test.info("question got " + question);
				Assert.assertEquals(storedquestion, question);

				List<WebElement> answers = getWebElement("//*[starts-with(@id,'mat-checkbox-')]");
				int index = 0;
				List<String> dataanswer = dataquestion.getAnswer();
				for(String ans : dataanswer) {
					for(WebElement liveanswer :answers) {
						test.info("Liveanswer " + liveanswer.getText());
						test.info("selecting answer  "+ ans);
						if(liveanswer.getText().equals(ans)) {
							liveanswer.click();
							break;
						}
					}
				}
				//verify message "select as many as you like
				String message = getText("//fieldset[@class='multiple-questions ng-star-inserted']/span", "getting the text");

				//verification
				assertEquals("Select as many as you like", message, "text verification");

				test.info("click on the next button");
				click1("//button[contains(text(),'Next')]", "click on next button"); 
				Thread.sleep(2000);
			}

			//verifying the score after each answer 
			//verification has to be done still last but one question, in last question live score is not displayed
			if(i!= questions.size()) {
				int answerscored = dataquestion.getScore();
				int totalscore = initialScore+answerscored;

				Thread.sleep(2000);
				String livescore = "//form[@class='ng-untouched ng-pristine ng-invalid']/fieldset/div | //form[@class='ng-invalid ng-untouched ng-pristine']/fieldset/div";
				liveScore = Integer.parseInt(getText(livescore, "fetching the initital score"));

				test.info("live score " + liveScore);
				test.info("total score " + totalscore);
				assertEquals(liveScore,totalscore, "verifed the live score");
				initialScore = totalscore;
				Thread.sleep(2000);
			}
		}
	}
}

	
	
