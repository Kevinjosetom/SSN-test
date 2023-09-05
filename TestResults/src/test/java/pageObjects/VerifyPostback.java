package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

public class VerifyPostback extends ReusableMethods{

	  public VerifyPostback(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
	  }
	  
	  
	  /**
		 * Play the competition by clicking on the Play now button.
		 * @throws Exception
		 *//**
		 * Play the competition by clicking on the Play now button.
		 * @throws Exception
		 */
	  /**
		 * Play the competition by clicking on the Play now button.
		 * @throws Exception
		 */
		public void playCompetitionForDesc() throws Exception {
			Thread.sleep(2000); // Can this be replaced with wait for element ?
			test.info("click on the play now button");
			WebElement play = driver.findElement(By.xpath("//button[contains(text(),'toReplaceButtonText')]".replaceAll("toReplaceButtonText","Play now")));
			JavascriptExecutor jsPlay = (JavascriptExecutor) driver;
			jsPlay.executeScript("arguments[0].click()", play);
			try {
				test.info("accept consent");
				Thread.sleep(2000); // Can this be replaced with wait for element ?
				WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'mat-checkbox-persistent')]"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", ele);
				test.info("click on the continue button");
				click1("//span[contains(text(),'toReplaceLinkText')]".replaceAll("toReplaceLinkText","Continue"), "click on the continue button");
				Thread.sleep(4000); // Can this be replaced with wait for element ?
			}catch(Exception e) {
				test.info("Consent Dialog is not displayed. This implies the Story ENCASH2-138 : Change in behavior of consent at the time of availing an offer or participating in a competition");
			}

		}
		
		
		public void registerNewUserForPostback() throws Exception {
			Common_methods common = new Common_methods(driver);
			Encash_Registration_Validations registration= new Encash_Registration_Validations(driver);
			Testdata data = new Testdata();
            String phoneNumber="7893932955";
            String email ="kumar1@mailinator.com";
			registration.register();
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
			selectByIndex("//*[@id='toReplaceId']".replaceAll("toReplaceId","address"), 1, "select the first address");
			common.giveConsent();
			common.clickContinueButton();
			common.skipemailverify();
			Thread.sleep(10000);
		}
		
		
		public void playAutomationPostbackComp() throws Exception {
			Common_methods common = new Common_methods(driver);
			//*[contains(@class,'mat-radio-label-content')]
			
			waitForElement1(60, "//label[text()='toReplaceQuestionName']".replaceAll("toReplaceQuestionName","Do you regularly play the lottery?"),
					"Waiting for 1st Question");
			common.selectEligibilityQuestionChoice("Yes");
			click1("//span[contains(text(),'Next')]/..", "Moving on to next question");
			Thread.sleep(5000);
			
		}
		
		
		public void crmUI_checkConversionCount(String phone, String consumerClickID) throws Exception{
			
			Testdata data = new Testdata();
			Common_methods common = new Common_methods(driver);


			// Login to Admin
			String consumerPhone ="07893932955";
			encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		     readconfig rconfig = new readconfig();
		     String CRMCategoryName=data.CRMCategoryName;
		     String username= rconfig.getusername();
		     String crmpwd= rconfig.getcrmPwd();

		  // Launch and Login
			En_sign.Admin_login( username ,crmpwd);
			// Go to Traffic Report
			scrollToView("//span[text()='toReplaceLinkName']".replaceAll("toReplaceLinkName","Reports"), "scroll to Reports");
			clickAndWait("//span[text()='toReplaceLinkName']".replaceAll("toReplaceLinkName","Reports"), "Expand Reports");
			scrollToView("//span[text()='toReplaceLinkName']".replaceAll("toReplaceLinkName","Traffic Report"), "scroll to Traffic Reports");
			clickAndWait("//span[text()='toReplaceLinkName']".replaceAll("toReplaceLinkName","Traffic Report"), "Goto Traffic Report");
			// Traffic Reports
			clickAndVerifyAppTitle("Traffic Report", "Traffic Reports");
            Thread.sleep(5000);
			//Click on the Conversion Count for the Affiliate=Stewart Test and Source= Test26
			
//			clickAndWait("//*[@class='mat-sort-header-stem ng-tns-c167-41']", "Clicking on the conversion count");
			clickAndWait("//mat-cell[4]/a", "Clicking on the conversion count");
			waitForElementPresent("//*[contains(@class,'cdk-column-consumerPhone mat-column-consumerPhone')]/p");

			//Verify the ClickID is present or not
			List<WebElement> clickIds=driver.findElements(By.xpath("//*[contains(@class,'cdk-column-clickId mat-column-clickId')]/p"));
			ArrayList<String> as = new ArrayList<String>();
			int value = clickIds.size();
			for (int i = 0; i < value; i++) {
				as.add(clickIds.get(i).getText());
			}
			int indexOfClicIds = as.indexOf(consumerClickID);
			System.out.println(as);
			boolean clickIDPresent = as.contains(consumerClickID);
			assertTrue1(clickIDPresent, "Click Id is presnet"+consumerClickID);

			//Verify the Consumer Phone no. is present or not
			List<WebElement> consumerPhoneList=driver.findElements(By.xpath("//*[contains(@class,'cdk-column-consumerPhone mat-column-consumerPhone')]/p"));
			ArrayList<String> cs = new ArrayList<String>();
			value = consumerPhoneList.size();
			for (int i = 0; i < value; i++) {
				cs.add(consumerPhoneList.get(i).getText());
			}
			System.out.println(cs);
			int indexOfconsumerPhone = cs.indexOf(consumerPhone);
			boolean consumerPhonePresent = cs.contains(consumerPhone);
			assertTrue1(consumerPhonePresent, "Consumer Phone is presnet"+consumerPhone);

			//Verify the index of both are same
			assertEquals(indexOfClicIds, indexOfconsumerPhone, "Verify Index of both");

		}

		public void clickAndVerifyAppTitle(String appName, String expectedTitle) throws Exception{//fixed 02 feb 2021 as per UI changes
			//logger.info("click on the Questionnaires");
			if (appName=="Configurations") {
				waitForElement1(120, "//div[contains(@class, 'header accent p-24')]", "Wait for "+appName+" title to load");
				waitForTextPresent("//div[contains(@class, 'header accent p-24')]", expectedTitle);
				//Verify Title
				assertEquals(getText("//div[contains(@class, 'header accent p-24')]", "Getting title text of sub-Menu"),expectedTitle, "Verifying the Title");
			}
			
			else {
				String appname_elment = "//span[text()='toReplaceLinkName']".replaceAll("toReplaceLinkName",appName);
				
				scrollToView(appname_elment, "scroll to "+appName);
				waitForElement1(120, appname_elment, "Wait for "+appName+" to load");
				clickAndWait(appname_elment, "Goto "+appName);	
				waitForElement1(120, "//span[contains(@class, 'logo-text h1')]", "Wait for "+appName+" title to load");
				waitForTextPresent("//span[contains(@class, 'logo-text h1')]", expectedTitle);
				//Verify Title
				assertEquals(getText("//span[contains(@class, 'logo-text h1')]", "Getting title text of sub-Menu"),expectedTitle, "Verifying the Title");			
			}
		}
		
	}
		
     
		  
		  
		  
		  
		  

