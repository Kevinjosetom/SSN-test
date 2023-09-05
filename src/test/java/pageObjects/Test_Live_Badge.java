package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;





public class Test_Live_Badge extends ReusableMethods {

	@FindBy(xpath="//div[@class='card-img-container']")
    WebElement Live_Offers;
	
	@FindBy(xpath="//a[@class='secondary-button'][@title='Play']")
    WebElement play;
	
	@FindBy(xpath="//button[contains(text(),'Play now')]")
    WebElement play_now;
	
	@FindBy(linkText ="Competitions")
    WebElement Competitions_Linktext;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search')]")
    WebElement SearchText;
	

  public Test_Live_Badge(WebDriver driver) {
	this.driver = driver;
	// This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
  }
  
  
  public Test_Live_Badge searchCompetition(String competitionName) throws Exception {
	  
	click(Competitions_Linktext, " the competitions hyperlink");
	Thread.sleep(2000);
	waitForElementVisibility(SearchText,"Searchbox");
	Thread.sleep(2000);
	text(SearchText,competitionName, "typing on the search box");
	Thread.sleep(2000);
	waitForElementPresent("//*[contains(text(),'iPhoneX')]".replaceAll("iPhoneX", competitionName));
	
	return this;
	
	 }
  
  public Test_Live_Badge searchCompetitionAndClick(String competitionName) throws Exception {
	  
	    waitForElementVisibility(Competitions_Linktext,"Competitions_Linktext");
		click(Competitions_Linktext, " the competitions hyperlink");
		waitForElementVisibility(SearchText,"Searchbox");
		text(SearchText,competitionName, "typing on the search box");
		waitForElementPresent("//div/a[@title='competitionName']".replaceAll("competitionName", competitionName));
		scrollToView("//*[@id='competition-sticky']", "Scrolling to categories");
		scrollToView("/html/body/app-root/app-public/app-competitions/section/div/div/div[1]", "Scroll to comptition");
		clickHyperlink(competitionName, "click on the particular competitions");
		

		return this;
		
		 }
	  

  public Test_Live_Badge verify_live_badge() throws Exception {
		String actualContent = getPseudoElementsContent("//div[@class='card-img-container live-competition']");
		assertEquals(actualContent, "\"LIVE\"", "Verifying the Live Badge");
		Thread.sleep(2000);
		String actualBGColor =getPseudoElementsBGColor("//div[@class='card-img-container live-competition']");
		assertEquals(actualBGColor, "rgb(255, 0, 0)", "Verifying the Live Badge background colour");
		Thread.sleep(2000);
		//div[@class='card-img-container live-competition']
		return this;
	}
  
  
	  public String getPseudoElementsContent (String locator) throws Exception{
			WebElement pseudoElement = driver.findElement(By.xpath(locator));
			String content;
			content=((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('content');",pseudoElement).toString();
			return content;
		}
	    
	  
	  
	  public String getPseudoElementsBGColor (String locator) throws Exception{
		WebElement pseudoElement = driver.findElement(By.xpath(locator));
		String bg_color;
		bg_color=((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], ':after').getPropertyValue('background-color');",pseudoElement).toString();
		return bg_color;
	}
	  
	 
	  public Test_Live_Badge verify_live_badgeOnCompetitionPage() throws Exception {
		  Testdata data = new Testdata();
	crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);

		crmui_addcategory.stagingUrl_launch();
		searchCompetitionAndClick(data.competitionForLiveBadge);
		String actualContent = getText("//div[@class='live-competition']",
				"Competition Badge validation");
		assertEquals(actualContent, "LIVE", "Verifying Live Badge on Competition Page");

		String actualBGColor = getCSSValue("//div[@class='live-competition']",
					"background-color",	"Competition Badge Colour validation");
		assertEquals(actualBGColor, "rgba(255, 0, 0, 1)", "Verifying the Live Badge background colour");
		
		return this;
		  
		  
	  }}
		  
	
	    