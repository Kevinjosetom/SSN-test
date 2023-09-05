package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

public class crmUI_AddCategoryToExistingCompetition extends ReusableMethods {
	
	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(xpath="//*[text()=' Categories ']")
    WebElement caregories_Text;
	
	@FindBy(xpath="//*[text()=' Competitions ']")
    WebElement Competitions_Text;
	  
	@FindBy(linkText = "Categories")
    WebElement Categories_linktest;
	
	@FindBy(linkText = "Competitions")
    WebElement Competitions_linktest;
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//*[@id=\"cdk-drop-list-0\"]/mat-row/mat-cell[2]/p")
    WebElement existing_compitation_name;
	
	@FindBy(xpath="//*[text()='Choose categories']")
    WebElement choose_categories;
	
	@FindBy(xpath="//*[@class='mat-option-text']")
    List<WebElement> categories_list;
	
	@FindBy(xpath="//input[@formcontrolname='productEndDateTime']")
    WebElement END_date;
	
	@FindBy(xpath="//*[contains(text(),'SAVE')]")
    WebElement save_category;
	
	@FindBy(xpath = "//*[text()='About us']")
    WebElement scroll_privacy_policy;
	
	@FindBy(xpath="(//*[text()=' EncashOffers has always been one of my favorites.WWWss '])[2]")
    WebElement encash_UI_testimonials;
	
	@FindBy(xpath="//*[@id='competition-sticky']")
    WebElement encash_UI_competitionCategories;
	
	@FindBy(xpath="//*[contains(text(),' Free Test with Stewart ')]")
    WebElement Free_Test_with_Stewart;
	
	@FindBy(xpath="//mat-icon[contains(text(),'delete')]")
    WebElement delete_category;
	
	@FindBy(xpath="(//*[contains(text(),'Confirm')])[2]")
    WebElement confirm_delete;
	
	@FindBy(xpath="//img[@title='Menu']")
    WebElement logout_menu;
	
	@FindBy(xpath="//button[contains(text(),'Logout')]")
    WebElement logout;
	
	@FindBy(xpath="(//button[contains(text(),'Login')])[2]")
    WebElement user_login;
	
	@FindBy(xpath="//input[@placeholder='Email id']")
    WebElement email_id;
	
	@FindBy(xpath="//input[@placeholder='Password']")
    WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
    WebElement Continue;
	
	public  String url= rconfig.getstagingUrl();

	  Testdata data=new Testdata();

	
	
	public crmUI_AddCategoryToExistingCompetition(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		
		}

	
	
	public crmUI_AddCategoryToExistingCompetition crmUI_AddCategoryToExisting_Competition() throws Exception {
		 String CRM_existingCompetitionName= data.CRM_existingCompetitionName;
		// String CRM_categoryForCompetition = "Test with Stewart";
		 String CRM_categoryForCompetition=data.CRMCategoryName;
		 Testdata data=new Testdata();
		 encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		 readconfig rconfig = new readconfig();
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();
		
		En_sign.Admin_login( username ,crmpwd);
		waitForElementVisibility(EncashOffers_linktest, "caregories_Text");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		click(Competitions_linktest, "Competitions_linktest");
		//driver.get("https://staging-admin.encashoffers.com/admin/#/apps/encash-offers/competitions");
		Thread.sleep(12000);
		waitForElementVisibility(Competitions_Text, "caregories_Text");
		waitForElementVisibility(right_side3Dots, "right_side3Dots");
		text(SearchText, CRM_existingCompetitionName, "CRM_existingCompetitionName");
		waitTime();
	    clickAndWait("//*[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRM_existingCompetitionName),"Goto "+CRM_existingCompetitionName);
		waitTime();
		//Assign category
		scrollToView("//mat-select[contains(@placeholder,'toReplaceDropdownName')]".replaceAll("toReplaceDropdownName","categories"), "Scroll to view categories");
		clickAndWait("//mat-select[contains(@placeholder,'toReplaceDropdownName')]".replaceAll("toReplaceDropdownName","categories"),"Open Categories dropdown");
	    clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName",CRM_categoryForCompetition),"Add Category "+CRM_categoryForCompetition);
		pressKey("//input[@formcontrolname='productEndDateTime']", Keys.ESCAPE, "Escape key");
		//click1("//*[text()='Status']//following-sibling::mat-slide-toggle","toggle switch");
		waitTime();
	    Thread.sleep(10000);
	    try {
		clickAndWait("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","SAVE"), "SAVE");
     //   driver.findElement(By.xpath("//span[contains(text(),'SAVE')]")) ;
	    }
	    catch (Exception e) {
			// TODO: handle exception
		}
	    
		waitTime();
		En_sign.Admin_logout();
		
		return this;
			
	
	}
	
	public crmUI_AddCategoryToExistingCompetition stagingUrl_launch() throws InterruptedException {
		String stagingUrl= rconfig.getstagingUrl();
		driver.get(stagingUrl);
		//angularWait();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(15000);

		return this;
		
		
	}
	public crmUI_AddCategoryToExistingCompetition stagingUrl_logout() throws Exception {
		
		waitForElementVisibility(logout_menu, "logout");
		click(logout_menu, "logout_menu");
		click(logout, "logout");
		waitTime();
		
		
		return this;
		
	}
	public void Userlogin() throws Exception{

		//		waitForElementVisibility(jishiImage("flying-jishi wow zoomIn ng-star-inserted"));
		//		click(buttonWithtext("No, I’ll explore myself"), "click on button Yes, Continue");

		click(user_login, "Click on User_Login");

		text(email_id, "7893920459@mailinator.com", "enter email");
		waitTime();
		text(password, "123456", "enter pwd");

		click(Continue,"click on the continue button");

	}

	public crmUI_AddCategoryToExistingCompetition encashUIVerifyCompetitionInCategory() throws InterruptedException, IOException  { 
		waitTime();
		scrollBybottom();
		Thread.sleep(2000);
		scrollByElement(scroll_privacy_policy, "scroll_privacy_policy");
		waitTime();
//		scrollByElement(encash_UI_testimonials, "encash_UI_testimonials");
//        waitTime();
//        scrollByElement(encash_UI_competitionCategories, "encash_UI_competitionCategories");
//        waitTime();	
        scrollToView("//*[text()=' Free Test Category 008 ']", "Free_Test_with_Stewart");
        waitTime();
//		click1("//*[text()=' Free Test Category 008 ']","Free_Test_with_Stewart");
//		Thread.sleep(7000);
		return this;

 }
	public crmUI_AddCategoryToExistingCompetition crmUI_deleteCategory() throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		//Test data
		String CRMCategoryName=data.CRMCategoryName;	
		
		readconfig rconfig = new readconfig();
	     String username= rconfig.getusername();
	     String crmpwd= rconfig.getcrmPwd();
		
		En_sign.Admin_login( username ,crmpwd);
		
	   click(EncashOffers_linktest, "EncashOffers_linktest");
	   click(Categories_linktest, "Categories_linktest");
	   waitForElementVisibility(caregories_Text, "caregories_Text");
	   text(SearchText, CRMCategoryName, "CRMCategoryName");
	   waitTime();
	   click(delete_category, "delete_category");
	   click(confirm_delete, "confirm_delete");
	   waitTime();
	   En_sign.Admin_logout();
	return this;
	
}
	}