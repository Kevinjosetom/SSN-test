package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resuable.ReusableMethods;
import data.Testdata;




public class Common_methods extends ReusableMethods{
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continue_text;
	
	@FindBy(xpath = "//*[@id='search']")
    WebElement Search_Mail;
	
	@FindBy(xpath = "//*[text()='GO']")
    WebElement click_public;
	
	public Common_methods(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public void playCompetition() throws Exception {
		Thread.sleep(2000);
		test.info("click on the play now button");
		click1(buttonWithtext("Play now"), "click on the play now button");
		
	}

	public void  mandatoryQuestion() throws IOException, InterruptedException {

		//first mandatory question
//		test.info("click on the check box");
//		driver.findElement(By.xpath("//*[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
//		test.info("click on the first drop down question");
//		driver.findElement(By.xpath("//*[text()=' Continue ']")).click();
		Thread.sleep(5000);
		waitForElementPresent("//*[text()='Apply Now']/following::mat-radio-button");
//		logger.info("click on the next button");
		click1("//*[text()='Apply Now']/following::mat-radio-button", "cick on the first option");
		Thread.sleep(5000);

		click1("//span[contains(text(),' Next ')]", "click on next button");
		Thread.sleep(5000);
	//	click1("//*[text()='Apply Now']/following::mat-radio-button", "cick on the first option");
		Thread.sleep(5000);
		click1("//*[text()='Apply Now']/following::mat-checkbox", "cick on the first option");
		Thread.sleep(5000);
		click1("//span[contains(text(),' Next ')]", "click on next button");
		Thread.sleep(5000);

		//3rd mandatory question
		for(int i =0;i<=10;i++) {
		//	waitForElementPresent("//*[text()='Apply Now']/following::mat-radio-button");
			//click(id("mat-radio-5"), "select the first option");
			Thread.sleep(1000);
			click1("//*[text()='Apply Now']/following::mat-radio-button", "cick on the  option");
			//*[text()='Apply Now']/following::mat-checkbox
			//click on the next button
			Thread.sleep(2000);
			test.info("click on the next button");
			click1("//span[contains(text(),' Next ')]", "click on next button");
			Thread.sleep(7000);
			//angularWait();
			
		}
		//	click1("//*[text()='Continue']","contnue");
		//	driver.findElement(By.xpath("//*[text()='Continue']")).click();
		//	Thread.sleep(2000);
			waitForElementPresent("//*[starts-with(@id,'mat-radio-')]");
		for(int i =0;i<=3;i++) {
			waitForElementPresent("//*[starts-with(@id,'mat-radio-')]");
			//click(id("mat-radio-5"), "select the first option");
			Thread.sleep(1000);
			click1("//*[starts-with(@id,'mat-radio-')]", "cick on the first option");

			//click on the next button
			Thread.sleep(1000);
			test.info("click on the next button");
			click1("//*[contains(text(),'Next')]", "click on next button");
			Thread.sleep(2000);
			
	}
			click1("//*[text()='Continue']","contnue");
			Thread.sleep(5000);
		    click1("//*[text()='Skip']", "click on skip button");
		    Thread.sleep(1000);
		
		   click1("//*[text()=' Done ']", "click on done button");
		   Thread.sleep(4000);

		
	}
	
	public boolean isUserRegistrationDialogFieldMandatory(String fieldName) {
		
		// TODO Auto-generated method stub
		String xpath = "//label[contains(text(),'textToReplace')]/span".replaceAll("textToReplace", fieldName);
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		String className = driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(text.equals("*") && className.equalsIgnoreCase("mandatory-fields")) {
			return true;
		}else
			return false;

	}
	public void mailOpen(String mailid) throws IOException, InterruptedException {

		 
		String[] mail = mailid.split("@");
		
		text(Search_Mail,"7893920421@mailinator.com", "Enter the mail id");
		Thread.sleep(4000);
		click(click_public, "click on the Go button");
		
		
		
		//*[@id='search']	

	}	

	
	public void clickAndVerifyAppTitle(String appName, String expectedTitle) throws Exception{//fixed 02 feb 2021 as per UI changes
		//logger.info("click on the Questionnaires");
		Thread.sleep(4000);
		if (appName=="Configurations") {
			waitForElement1(120, "//div[contains(@class, 'header accent p-24')]", "Wait for "+appName+" title to load");
			waitForTextPresent("//div[contains(@class, 'header accent p-24')]", expectedTitle);
			//Verify Title
			assertEquals(getText("//div[contains(@class, 'header accent p-24')]", "Getting title text of sub-Menu"),expectedTitle, "Verifying the Title");
		}
		
		else {  
			scrollToView("//span[text()='appName']".replaceAll("appName",appName ), "scroll to "+appName);
	//		waitForElement1(120, "//span[text()='appName']".replaceAll("appName",appName)+" to load"," appName");
			clickAndWait("//span[text()='appName']".replaceAll("appName",appName),"appname");	
			waitForElement1(120,"//span[contains(@class, 'logo-text h1')]", "Wait for "+appName+" title to load");
			waitForTextPresent("//span[contains(@class, 'logo-text h1')]", expectedTitle);
			//Verify Title
			assertEquals(getText("//span[contains(@class, 'logo-text h1')]", "Getting title text of sub-Menu"),expectedTitle, "Verifying the Title");			
		}
	}
	public void encashUILogin(String emailID, String password) throws Exception {
		Thread.sleep(5000);
		click1("//button[contains(text(),'Login')]", "Click on Login");
		typeAndWait("//input[@placeholder='Email id']", emailID, "entering email");
		typeAndWait("//input[@placeholder='Password']", password, "entering pwd");
		clickAndWait(buttonWithtext("Continue"),"click on the continue button");
		waitForElementInvisibility("//mat-dialog-container[@id='mat-dialog-0']");
		
	}
	
	public void searchCompetitionAndClick(String competationName) throws IOException, InterruptedException {
		test.info("click on the competitions hyperlink");
		clickHyperlink("Competitions", "cliking on the competitions hyperlink");

		test.info("type on the search box for competitions");
		waitForElementPresent("//input[@placeholder='Search']");
		type1("//input[@placeholder='Search']",competationName, "typing on the search box");
		waitForElementPresent("//div/a[@title='competitionName']".replaceAll("competitionName", competationName));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		test.info("click on the particualr competitions");
		click1("//*[text()='XBOX']".replaceAll("XBOX", competationName), "click on the particular competitions");
	}
	
	
	public void searchCompetitionAndClick() throws IOException, InterruptedException {
		String competationName = "OnePlus Phone";
		test.info("click on the competitions hyperlink");
		clickHyperlink("Competitions", "cliking on the competitions hyperlink");

		test.info("type on the search box for competitions");
		waitForElementPresent("//input[@placeholder='Search']");
		type1("//input[@placeholder='Search']",competationName, "typing on the search box");
		Thread.sleep(3000);
		waitForElementPresent("//div/a[@title='competitionName']".replaceAll("competitionName", competationName));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		test.info("click on the particualr competitions");
		click1("//*[text()='XBOX']".replaceAll("XBOX", competationName), "click on the particular competitions");
	}
	
	public void setTitle(String title) throws Exception {
		waitForElementPresent("//*[@id='title']");
		selectByVisibleText1("//*[@id='title']", title, "select Mr");
	}
	
	public void setFirstName(String firstName) throws IOException {
		test.info("Entering firstname");
		clearAndType("//*[@id='firstName']", firstName, "typing first name");
	}
	public void giveConsent() throws Exception {
		test.info("accept the consent by clicking onthe checkbox");
		click1("//*[@id='customCheck']/label/div", "click on the consent checkbox");
	}
	
	
	public void skipemailverify() throws Exception {
		test.info("skip the email verification");
		waitForElement1(20, buttonWithtext("Skip"), "Wait for skip to appear");
		click1(buttonWithtext("Skip"), "Skip the email verification");
	}
	public void setLastName(String lastName) throws IOException {
		test.info("Entering lastname");
		clearAndType("//*[@id='lastName']", lastName, "typing last name");
	}
	public void setPhoneNumber(String phoneNumber) throws Exception {
		clearAndType("//input[@id='mobile-number']", phoneNumber, "Setting phone number");

	}
	public void setEmail(String email) throws IOException {
		test.info("Entering email id");
		clearAndType("//*[@id='email']", email, "typing email id name");
	}
	public void selectGender(String gender) throws Exception {
		if (gender.equalsIgnoreCase("male")) {
			test.info("Selecting Male gender");
			click1("//*[@id='mat-radio-2']/label/div[2]", "selecting Male");
		} else {
			test.info("Selecting Female gender");
			click1("//*[@id='mat-radio-58']/label/div[2]", "selecting Female");
		}
		}
		public void setPostalCode(String postalCode) throws Exception {
			test.info("Postal Code");
			clearAndType("//*[@id='postalCode']",postalCode,"Enter the postal code");
			test.info("click on the Find address button");
			click1("//span[contains(text(),'Find Address')]/..", "Click on the find address button");
			scrollToView("//span[contains(text(),'Find Address')]/..", "scrolling to find address");
		}
		   
		public void OpenNewTab() {
			newTab();


		}
		
		public void setEnterVerifyPasswordText(String password) throws Exception {
			Thread.sleep(5000); //slowing down the execution
			clearAndType("//input[@id='password']", password, "Entering password into verify your password text box");
			waitTime();
		}
		
		public void selectEligibilityQuestionChoice(String choice) throws Exception {
			test.info("Select the specified choice");
			click1("//mat-radio-group/mat-radio-button//div[contains(text(),'choiceName')]".replaceAll("choiceName", choice), "Selecting a choice");
		}
		
		public boolean isElementDisplayed(String xpath) {
			try {
				driver.findElement(By.xpath(xpath));
				return true;
			}catch(Exception e) {
				return false;
			}
		}
		
		
		public void setLoginOTP(String opt) throws Exception {	
		//captcha();
				Testdata data = new Testdata();
				String phone="7700150906";
				String otp=data.otp;
				
			String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
			System.out.println(CaptchaCode);
			char[] otpchar = CaptchaCode.toCharArray();

//			//OTP
			String locator = "//*[contains(text(),'6 digit verification code has been sent to your mobile number')]//following::input";
			for(int i=1;i<7;i++) {
			String OTP = locator+"["+i+"]";
			Thread.sleep(500);
				String OTPnumber = Character.toString(otpchar[i-1]);
			driver.findElement(By.xpath(OTP)).sendKeys(OTPnumber);
			}
			waitTime();
			click1("//span[contains(text(),'Continue')]", "click_on_the_continue");
			
			
			
		}

		/**
		 * Sets password on the passwrod reset dialog
		 * @param password
		 * @throws Exception
		 */
		public void setPasswordInResetDialog(String password) throws Exception {
			clearAndType("//input[@formcontrolname='password']", password, "Entering password");
		}
		
		
		public void clickVerifyButton() throws Exception {
			click1("//button[contains(text(),'Verify')]", "Clicking on verify button");

		}
		
		public void verifyFeatureoffer(List<String> CRMadminfeatureoffers) throws Exception {

			test.info("clicking on the offers button in home page" );
			//waitForElementPresent(normalLink("Competitions"));
			clickHyperlink("Offers", "clicking on the Offers button with out login");

			waitForElementVisibility1("//div[@class='card wow slideInUp']");

			//get the list of all the feature offers 
			List<WebElement> offerscard = getWebElement("//div[@class='card wow slideInUp']");

			//List to store the featured tag name for later verification 
			List<String> encashfeaturelist = new ArrayList<String>();
			
			
			
			
			
			
			for(WebElement eachoffers : offerscard) {
				test.info("inside the each loop");
				//get the webelelements list which is having only featured tag in offers
				//verifyin the Feature tag are present
				Thread.sleep(1000);
				try {
					//feature tag verification
					WebElement featuretag = eachoffers.findElement(By.xpath("span"));
					Thread.sleep(1000);
					test.info("featuretag name -- "+ featuretag.getText());
					assertEquals("FEATURED", featuretag.getText(), "Verify the feature tag");
					// feature name are stored in the list
					WebElement offersname = eachoffers.findElement(By.xpath("div[2]/a/span"));
					scrollByElement(offersname, "scroll each offers");
					encashfeaturelist.add(offersname.getText());
					test.info("offersname are :- " + offersname.getText());

				}catch (Exception e) {

					//an element not found exception are through because feature tag will be present for few element 
					//so break the each 			
					break;

				}
			}
			//System.out.println("end of the feature vinod");
			//verify both the list that is encashfeaturelist and CRMadminfeatureoffers are same
//			System.out.println("Size of CRMadminfeatureoffers -- "+CRMadminfeatureoffers.size());
//			System.out.println("Size of encashfeaturelist -- "+encashfeaturelist.size());
//	//		assertTrue(encashfeaturelist.equals(CRMadminfeatureoffers), "verify the offerfeature list are same");
		}

		
	public String getUserRegistrationDialogFieldPlaceHolderText(String fieldName) {
		String xpath = "//label[contains(text(),'textToReplace')]/../input".replaceAll("textToReplace", fieldName);
		String text = driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
		return text;
	}
	public String getPostalCodePlaceholderText() {
		String text = driver.findElement(By.xpath("//input[@id='postalCode']")).getAttribute("placeholder");
		return text;
	}
	public String getUserRegistrationDialogTitleSelctedText() {
		List<WebElement> elements = driver.findElements(By.xpath("//label[contains(text(),'TITLE')]/../select/option"));
		String text=null;
		for(WebElement element : elements) {
			if (element.isSelected())
				text=element.getText();
		}
		return text;	
	}
	public boolean isButtonEnabled(String xpath) {
		return driver.findElement(By.xpath(xpath)).isEnabled();
	}
	
	public void selectAddressFromList(Integer index) throws Exception {
		test.info("select the address from drop down");
		selectByIndex("//*[@id='address']",index , "select the first address");
	}
	
	public void optOutOfMarketingMessages() throws Exception {
		test.info("Opting out of marketing messages");
		click1("//a[contains(text(),'click here')]","Opting out of marketing messages");
	}
	
	public void clickCancelButton() throws Exception {
		test.info("clicking on the cancel button in Registering page");
		scrollToView("//button/span[contains(text(),'Continue')]", "scrolling to continue button");
		click1("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText", "Cancel"), "clicked on the cancel button");
	}
	
	
	public boolean isEmailErrorMessageDisplayed() throws Exception {
		test.info("Check if message saying email is already in use is displayed");
		try {
			driver.findElement(By.xpath("//span[contains(text(),'Email is already in use. Use a different email id.')]"));
			return true;   
		} catch (Exception e) {
			return false;
		}
	}
	
	public void navigateToAccountprofile(String profileName) throws Exception {
		waitForElementVisibility1("*//div[@title='Profile name']//span[contains(text(),'phoneNumber')]".replaceAll("phoneNumber", profileName));
		click1("*//div[@title='Profile name']//span[contains(text(),'phoneNumber')]".replaceAll("phoneNumber", profileName), "Clicking on navigation bar user profile");
		//click(EncashWebLocators.encash_UI_navBar_profileName.replaceAll("phoneNumber", profileName), "Clicking on navigation bar user profile");
	}
	public String getProfileNameFromSumamry() throws Exception {
		test.info("Getting display name from summary");
		return getText("//div[contains(@class,'PersonDetails')]/h3", "Getting person details");
	}

	/**
	 * Clicks on change password button on user profile page
	 * @throws Exception
	 */
	public void clickChangePasswordButton() throws Exception {
		waitTime();
		waitForElementVisibility1("//span[contains(@title,'Change password')]");
		click1("//span[contains(@title,'Change password')]", "Clicking on change password button");
		waitForElementVisibility1("//input[@id='password']");
	}
	
	public String getProfileDisplayName() throws Exception {
		test.info("Getting display name");
		return getText("//div[@title='Profile name']//div[contains(@class,'username')]/span", "Getting display name text");
	}

	public String buttonWithtext(String buttonText) {
		String locator="//button[contains(text(),'toReplaceButtonText')]";
		return locator.replaceAll("toReplaceButtonText", buttonText);
	}
	public String getProfileName2FromSummary() throws Exception {
		test.info("Getting person name2 from summary page");
		return getText("//div[contains(@class,'PersonDetails')]/p", "Getting person details");
	}
	
	public String getPersonPhoneNumberFromSummary() throws Exception {
		test.info("Getting person phone number from summary page");
		return getText("//body/app-root[1]/app-private[1]/app-user-profile[1]/section[1]/div[1]/div[1]/div[1]/mat-card[1]/div[3]/div[1]/ul[1]/li[1]",
				"Getting phone number");
	}

	public String getPersonEmailFromSummary() throws Exception {
		test.info("Getting person email from summary page");
		return getText("//body/app-root[1]/app-private[1]/app-user-profile[1]/section[1]/div[1]/div[1]/div[1]/mat-card[1]/div[3]/div[1]/ul[1]/li[2]",
				"Getting email");
	}

	public void clickEditProfile() throws Exception {
		waitForElementVisibility1("//span[contains(@title,'Edit profile')]");
		click1("//span[contains(@title,'Edit profile')]","clicking on edit profile link");
	}

	public boolean isPersonalDetailsFieldEmpty(String label) {
		if (label.equalsIgnoreCase("POSTAL CODE") || label.equalsIgnoreCase("GENDER")) {
			try {
				driver.findElement(By.xpath("//label[contains(text(),'textToReplace')]/..//*[contains(@class,'ng-pristine')]".replaceAll("textToReplace", label)));
				return true;
			} catch (Exception e) {
				return false;
			}
		}else {
			try {
				driver.findElement(By.xpath("//label[contains(text(),'textToReplace')]/../*[contains(@class,'ng-pristine')]".replaceAll("textToReplace", label)));
				return true;
				
			} catch (Exception e) {
				return false;
			}
		}
	}

	
	
	public boolean isUserRegistrationDialogFieldInvalid(String label) {
		String xpath = null;
		if (label.equalsIgnoreCase("TITLE")) {
			xpath = "//label[contains(text(),'TITLE')]/..//select";
		}else if (label.equalsIgnoreCase("ADDRESS")) {
			xpath = "//label[contains(text(),'ADDRESS')]/..//select";
		}else if (label.equalsIgnoreCase("GENDER")) {
			xpath = "//label[contains(text(),'GENDER')]/..//mat-radio-group";
		}else if (label.equalsIgnoreCase("DATE OF BIRTH")) {
			xpath = "//label[contains(text(),'DATE OF BIRTH')]/..//div";
		}else
			xpath = "//label[contains(text(),'textToReplace')]/..//input".replaceAll("textToReplace", label);

		String text = driver.findElement(By.xpath(xpath)).getAttribute("class");

		if(text.contains("error-input") || text.contains("ng-invalid")){
			return true;
		}else
			return false;

	}
	public void clickContinueButton() throws Exception {
		click(continue_text, "clicked on the continue button");
		Thread.sleep(4000);
		waitForElementInvisibility("//div[@class='ladda-progress']");
	}
	public void searchCompetitions() throws IOException, InterruptedException {
		String competitionName="";
		test.info("click on the competitions hyperlink");
		clickHyperlink("Competitions", "cliking on the competitions hyperlink");

		test.info("type on the search box for competitions");
		waitForElementPresent("//input[@placeholder='Search']");
		type1("//input[@placeholder='toReplacePlacholder']".replaceAll("toReplacePlacholder","Search"),competitionName, "typing on the search box");

		Thread.sleep(5000);
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "scroll");
		//scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]/div[2]", "scroll");

		test.info("click on the particualr competitions");
		clickHyperlink(competitionName, "click on the particular competitions");
	}
	
	/**
	 * Checks the consent check box in a user detail form. Can be used in user registration from
	 * or in edit profile.
	 * @throws Exception
	 */
	
	
	public boolean isDOBAgeErrorDisplayed() {
		test.info("Checking if age related DOB error is displayed");
		try{
			driver.findElement(By.xpath("//div[contains(text(),'You must be at least 18 years old')]"));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public void setDOB(String dd, String mmm, String yyyy) throws Exception {
		test.info("Setting the date");
		selectByVisibleText1("//*[@id='day']", dd, "Setting the Date");
		
		test.info("Setting the month");
		selectByVisibleText1("//*[@id='month']", mmm.toUpperCase(), "Setting the Month");
		
		test.info("Setting the year");
		selectByVisibleText1("//*[@id='year']", yyyy, "Setting the Year");

	}
	public boolean isDOBInvalidErrorDisplayed() {
		test.info("Checking if incalid DOB error is displayed");
		try{
			driver.findElement(By.xpath("//div[contains(text(),'Enter a valid date of birth')]"));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
		public void setPassword(String password) throws IOException {
			test.info("Entering the password");
			clearAndType("//*[@id='password']",password,"Entering the password");
		}
		public boolean isPasswordLengthValidationErrorDisplayed() {
			test.info("Checking if incalid DOB error is displayed");
			try{
				driver.findElement(By.xpath("//div[contains(text(),'Password must have minimum of 6 characters')]"));
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		public void setConfirmPassword(String password) throws IOException {
			test.info("Entering confirm password");
			clearAndType("//*[@id='confirmPassword']",password,"Entering confirm password");
		}
		
		public void setDisplayName(String displayName) throws Exception {
			test.info("Type the display name");
			clearAndType("//*[@id='display_name']",displayName,"Typing the display name");

		}
		public boolean isDisplayNameNotAvailableMessageDisplayed() throws Exception {
			
			test.info("Check if name is available");
			Thread.sleep(5000);
			String status = driver.findElement(By.className("displayName")).getText();
			if (status.equalsIgnoreCase("not available"))
				return false;
			else
				return true;
		}
		public boolean isPasswordMismatchErrorDisplayed() {
			test.info("Checking if incalid DOB error is displayed");
			try{
				driver.findElement(By.xpath("//div[contains(text(),'Password does not match')]"));
				return true;
			}catch (Exception e) {
				return false;
			}			

		}
		public boolean isConsentChecked() throws Exception {
			test.info("Checking if concent is checked");
			return isChecked("//*[@id='customCheck']/label/div", "click on the consent checkbox");
		}
		public boolean isConsentCheckboxMessageDisplayed() throws Exception {
			test.info("Check if message asking user to check the conset box is displayed");
			scrollToView("//button/span[contains(text(),'Continue')]", "Scrolling to continue button");
			try {
				driver.findElement(By.xpath("//div[contains(text(),'Please check the box to receive money saving oppor')]"));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		/**
		 * This method is used to get the list of all offers feature name in list
		 * 
		 * @throws IOException
		 * @throws InterruptedException 
		 */
		public List getOfferFeaturelist() throws IOException, InterruptedException {
			
			List<WebElement> elements = getWebElement("//*[starts-with(@id,'mat-select-value-')]");
			List<String> featurenamelist = new ArrayList<String>();
			for (WebElement featurename : elements) {
				scrollByElement(featurename, "scroll to name");
				System.out.println("featurename " + featurename.getText());
				featurenamelist.add(featurename.getText());
			}
		return featurenamelist;
		}

		
		
		
		/**
		 * this method is used to created the Featured offers in CRM admin page
		 * 
		 * @throws Exception
		 */
		public void createFeaturedOffers(String offername) throws Exception {

			// click on the create feature offers button
		//	 click1("//button[@class='mat-focus-indicator ng-tns-c282-28 mat-fab mat-button-base mat-accent ng-trigger ng-trigger-animate'][1]"
		//			 , "click on the create new offers featured button");
			
		//	clickAndWait("//mat-icon[contains(text(),'add')]", "Add featured offer");
			
			 // wait for feature offers created
			 // WebElement stateless = getElement(CRMWebLocators.waitFeatureofferscreation);
		    // waitForElementstaleness(stateless);
		   // waitForElementPresent(CRMWebLocators.waitFeatureofferscreation);
		  // waitForElementInvisibility(CRMWebLocators.waitFeatureofferscreation);

			Thread.sleep(10000);
			// get the list of featured created newly
	//		List<WebElement> elements = getWebElement("mat-select-value-");
	//		List<WebElement> elements = getWebElement("//img[@_ngcontent-hxg-c282]/following::mat-select");
			List<WebElement> elements = driver.findElements(By.xpath("//*[text()=' Featured Offers ']/following::mat-select//span/span"));

			System.out.println("total feature list"+elements.size());
			
			
//
//			// get the new created featured list from list as it is added at the end
//			WebElement createdfeatured = elements.get(elements.size() - 1);
//			
//	//		int createdfeatured = elements.size()-1;
//			System.out.println(createdfeatured);
//		
//		  //  String feature=	createdfeatured.getText();
//		  //  if(feature.equalsIgnoreCase(feature))
			
//			driver.findElement(By.xpath("(//*[text()=' Featured Offers ']/following::mat-select//following-sibling::div)"+createdfeatured)).click();
//			scrollToView("(//*[text()=' Featured Offers ']/following::mat-select//following-sibling::div)"+createdfeatured,"feature");
			
			System.out.println(elements.size());
			elements.size();
			scrollToView("(//*[text()=' Featured Offers ']/following::mat-select//following-sibling::div)[31]", "last feature");
			driver.findElement(By.xpath("(//*[text()=' Featured Offers ']/following::mat-select//following-sibling::div)[31]")).click();
			Thread.sleep(5000);
            driver.findElement(By.xpath("//*[text()=' Test Offers @Kumar ']")).click();
//			for(int i=0;i<elements.size();i++) {
//				System.out.println(elements.get(i).getText());
//				if(elements.get(i).getText().contains(offername)) {
//					driver.findElement(By.xpath("(//*[text()=' Featured Offers ']/following::mat-select//following-sibling::div)[31]")).click();
//				}else {
//						System.out.println("not clicked");
//					}
//				}
//				
			
            Thread.sleep(2000);
			// in the search box enter the text
//	typeAndWait("//*[contains(@placeholder,'Search offers & competitions...')]"
 //			+ "", offername, "typing the search offers");

			// click on the first options
//			click1("//span[contains(text(),'offername')]".replaceAll("offername", offername)
//					, "select the first resultoutput");
            waitTime();
			// click on the Save featured button
			click1("//mat-icon[contains(text(),'save')]", "click on the save feature");
            waitTime();
		 }
		public void dragDropFeturedoffers(String Sourcefeaturenametodrag, String DestinationFeaturenamedrop)
				throws IOException {

			// get the list of all feature offers
			List<WebElement> elements = getWebElement("mat-select-value-");
			// get the sourcefeature webelement
			WebElement sourcefeaturename = null, destinationfeaturename = null;

			// get the sourcefeature webelement
			for (WebElement sourcefeature : elements) {
				scrollByElement(sourcefeature, "scroll featuredoffers");
				if (sourcefeature.getText().equals(Sourcefeaturenametodrag)) {
					test.info("sourcefeaturename " + sourcefeature.getText());
					sourcefeaturename = sourcefeature;
					test.info("assign to sourde " + sourcefeaturename.getText());
					break;
				}
			}

		}
		public void deleteFeatureOffers(String offerfeaturednamed) throws IOException, InterruptedException {

			// get the list of all feature offers
			List<WebElement> elements = getWebElement("mat-select-value-");

			// get the sourcefeature webelement
			for (WebElement sourcefeature : elements) {
				scrollByElement(sourcefeature, "scroll featuredoffers");
				if (sourcefeature.getText().equals(offerfeaturednamed)) {
					test.info("sourcefeaturename " + sourcefeature.getText());
					WebElement close = sourcefeature.findElement(By.xpath("//div[@class='card wow slideInUp']"));
					scrollByElement(close, "scroll to close button");
					close.click();
					test.info("Deleted the Featured offers");

					break;
				}
			}
	
		}
		
}
	

