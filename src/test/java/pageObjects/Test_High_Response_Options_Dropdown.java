package pageObjects;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;





public class Test_High_Response_Options_Dropdown extends ReusableMethods{
	
	@FindBy(xpath = "//input[@id='password']")
    WebElement Set_Password;
	
	@FindBy(xpath ="//button[contains(text(),' Verify ')]")
    WebElement verify;
	
	@FindBy(xpath = "//span[contains(@title,'Edit profile')]")
    WebElement Edit_Profile;
	
	@FindBy(xpath = "*//div[@title='Profile name']//span[contains(text(),'kumar')]")
    WebElement Profile_Name;
	
	@FindBy(xpath = "//button[contains(text(),' Cancel ')]")
    WebElement Cancel;
	
	@FindBy(linkText ="Competitions")
    WebElement Competitions_Linktext;
	
	@FindBy(xpath="//div[@class='card-img-container live-competition']")
    WebElement Live_competition;
	
	@FindBy(xpath ="//input[@placeholder='Search']")
    WebElement search;
	
	@FindBy(linkText ="Offers")
    WebElement Offers;
	
	@FindBy(xpath="//div[@class='card-img-container']")
    WebElement Live_Offers;
	
	@FindBy(xpath="//a[@class='secondary-button'][@title='Play']")
    WebElement play;
	
	@FindBy(xpath="//button[contains(text(),'Play now')]")
    WebElement play_now;
	
//	@FindBy(xpath="//button[contains(text(),'Play now')]")
//    WebElement play_now;
	
	

  public Test_High_Response_Options_Dropdown(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
  }
  
  
  public Test_High_Response_Options_Dropdown loginAndSearchForAutomationCompetition() throws Exception {
	     crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
        Testdata data = new Testdata();
     // Login to encashoffers
        crmui_addcategory.stagingUrl_launch();
        Thread.sleep(2000);
        crmui_addcategory.Userlogin();
     // Got to competition Automation Competition 1 
	  	String phone="7700150906";
		String otp=data.otp;
		String continue_Button ="//label[contains(text(),'Enter your mobile number')]//following::button";
		
		test.info("click on the competitions hyperlink");
	    waitForElementVisibility(Competitions_Linktext,"Competitions_Linktext");
	    click(Competitions_Linktext, "Competitions_Linktext with out login");
        waitTime();
		test.info("type on the search box for competitions");
        waitForElementVisibility(search,"search");
        text(search,data.competitionForHighResponseOptionsTest, "typing on the search box");
        scrollBybottom();
        Thread.sleep(1000);
        scrollByElement(search, "search");
        waitForElementPresent("//*[text()='competitionName']".replaceAll("competitionName", data.competitionForHighResponseOptionsTest));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		test.info("click on the particualr competitions");
		click1("//*[text()='Linktext']".replaceAll("Linktext", data.competitionForHighResponseOptionsTest), "click on the particular competitions");
	return this;
	
      }
  public Test_High_Response_Options_Dropdown participateAndVerifyNumberOfChoicesAndDropdown() throws Exception {
	
	  
		// Click on participate and accept the consent
		playCompetition();
		// Check if number of options are greater than 8
		assertEquals(getNumberOfEligibilityQuestionOptionsInDropdown(), 9,"Number of option verification");
//		// Check if options for first question is dropdown
//		assertTrue(isEligibilityQuestionOptionDropdown(), "Verifying if options are in dropdown");
//		// Check if the options have checkbox
//		assertTrue(isEligibilityQuestionOptionMultiSelctDropdown(9),
//		"Verifying if checkboxes appear for all options");
//		// check the place holder text displays, "select as many as you want"
//		assertEquals(getEligibilityQuestionDropdownPlaceHolderText(), "Select as many as you want",
//				"Verifying placeholder text");
//			
	  


	  
	  return this; 
  }
  public void playCompetition() throws Exception {
		waitTime();
		test.info("click on the play now button");
		click(play_now, "click on the play now button");
		Thread.sleep(3000);
		 for(int i=0;i<13;i++) {
			  
			  driver.findElement(By.xpath("//*[@class='mat-radio-label-content']")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[text()=' Next ']")).click();
			  Thread.sleep(3000);
		 }		
	}
  public int getNumberOfEligibilityQuestionOptionsInDropdown() throws InterruptedException, Exception {
	  String loc = "//*[@class='mat-radio-label-content']";
		test.info("Getting number of options in the eligibility question");
		driver.findElement(By.id("mat-select-0")).click();
        waitTime();
       //  int count = getXpathCount("//mat-option", "count of list");
        int count = getXpathCount("//*[@class='mat-radio-label-content']", "count of list");
		pressKey("//mat-option", Keys.ESCAPE, "Collapsing listbox");
		pressKey("//*[@class='mat-radio-label-content']", Keys.ESCAPE, "Collapsing listbox");
		return count;
	}
  public boolean isEligibilityQuestionOptionDropdown() {
		test.info("Checking if the question has dropdown for options");
		try{
			driver.findElement(By.id("mat-select-0"));
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
  public boolean isEligibilityQuestionOptionMultiSelctDropdown(int sizeOfList) throws Exception {
		test.info("Verifying if options have checkboxes for eligibility questions");
		driver.findElement(By.id("mat-select-0")).click();
		Thread.sleep(2000);
		int count = getXpathCount("//mat-option/mat-pseudo-checkbox", "Getting count of checkboxes in options");
		pressKey("//mat-option", Keys.ESCAPE, "Collapsing listbox");
		return (count == sizeOfList);		
	}
  public String getEligibilityQuestionDropdownPlaceHolderText() throws Exception {
		test.info("Getting placeholder text ");
		String text = getText("//mat-select//span[contains(@class,'select-placeholder')]", "Getting placeholder text"); 
		return text;
	}
  
  public boolean isDropdownMultiSelection() throws Exception {
		driver.findElement(By.id("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]")).click();
		String role = driver.findElement(By.xpath("//div[@id='mat-select-0-panel']")).getAttribute("role");
		String multiSelectable = driver.findElement(By.xpath("//div[@id='mat-select-0-panel']")).getAttribute("aria-multiselectable");
		assertEquals(role, "listbox", "Options are not in a listbox");
		if (multiSelectable.equalsIgnoreCase("true")) {
			pressKey("//mat-option", Keys.ESCAPE, "collapsing dropdown");
			return true;
		}else
			pressKey("//mat-option", Keys.ESCAPE, "collapsing dropdown");
		return false;
	}
  
  public Test_High_Response_Options_Dropdown selectOptionsAndClickContinue() throws Exception {
	  
	// From the dropdown select Buy a car, Treat the family, Go on a domestic
				// location
				String[] optionsArray = { "Buy a Car", "Treat the Family", "Go on a Shopping Trip" };
				List<String> options = new ArrayList<String>();
				for (String choice : optionsArray) {
					options.add(choice);
            }
				return this;

           }
  
  
  public Test_High_Response_Options_Dropdown verifyDropdownSingleChoiceOptions() throws Exception {
	// Test choices is > 8 . Check if the list is in dropdown and is multiselectable
				assertFalse(isDropdownMultiSelection(), "List is not single selection");
				// Select an option
				assertTrue(isEligibilityQuestionOptionDropdown(), "Verifying if options are in dropdown");
				// check the place holder text displays, "select as many as you want"
				assertEquals(getEligibilityQuestionDropdownPlaceHolderText(), "Select one",
						"Verifying placeholder text");
				// Verify the number of dropdown options
				assertEquals(getNumberOfEligibilityQuestionOptionsInDropdown(), 21,
						"Number of option verification");
		
	            return this;
  
      }
  
   
  public Test_High_Response_Options_Dropdown verifyOptionsMenu() throws Exception {
	  
	// Select an AVIAV option from the dropdown
				selectElegibilityQuestionsDropdownSingleChoice("Aviva");
				// Verify the option is selected
				assertEquals(getEligibilityQuestionsDropdownSelctedText(), "Aviva",
						"Selected option verification failed");
				// Move onto next question
				click1("//span[contains(text(),'Next')]","Moving on to next question");
				// Choices is == 8, single choice
				// Verify if the choices are not dropdown
				assertFalse(isOptionDropdown(), "Options is a dropdown");
				// Verify the number of choices are 8
				assertEquals(getNumberOfOptions(), 8, "Number of options are not 8");
				// Select EDF
				selectEligibilityQuestionChoice("EDF");
				// Get the selected choice from options
				assertEquals(getSelectedOption(), "EDF", "Selected option is not EDF");
				// End of test
			
		
	  
	  
	  
	  return this;
  
  
  }
  
  public void selectElegibilityQuestionsDropdownSingleChoice(String choiceName) throws Exception {
		test.info("Selecting a choice");
		driver.findElement(By.id("mat-select-0")).click();
		click1("//span[contains(text(),'optionName')]".replaceAll("optionName", choiceName),"Clicking on option");
	}
  public String getEligibilityQuestionsDropdownSelctedText() {
		test.info("Getting dropdown selection");
		return driver.findElement(By.xpath("//mat-select//mat-select-trigger/span")).getText();
	}
  public boolean isOptionDropdown() {
		test.info("Checking if the choices are dropdown");
		String role = driver.findElement(By.xpath("//mat-radio-group")).getAttribute("role");
		if (role.equals("radiogroup")) {
			return false;
		}else
			return true;
	
  }
  public int getNumberOfOptions() {
		test.info("Getting the number of choices");
		return driver.findElements(By.xpath("//mat-radio-group/mat-radio-button")).size();
	
  }
  public void selectEligibilityQuestionChoice(String choice) throws Exception {
		test.info("Select the specified choice");
		click1("//mat-radio-group/mat-radio-button//div[contains(text(),'choiceName')]".replaceAll("choiceName", choice), "Selecting a choice");
	}
  public String getSelectedOption() {
		test.info("Getting the selected option");
		return driver.findElement(By.xpath("//mat-radio-group/mat-radio-button[contains(@class,'radio-checked')]//div[@class='mat-radio-label-content']")).getText();
	}
}