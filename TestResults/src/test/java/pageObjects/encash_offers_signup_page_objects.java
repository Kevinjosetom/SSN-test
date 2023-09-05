package pageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;


public class encash_offers_signup_page_objects extends ReusableMethods{
	
	
	@FindBy(xpath="//input[@formcontrolname='userId']")
    WebElement encash_crm_username;

	@FindBy(xpath="//input[@formcontrolname='password']")
    WebElement encash_crm_pwd;
	
	@FindBy(xpath="//span[contains(text(),'LOGIN')]")
    WebElement encash_crm_login;
	
	
	@FindBy(xpath="//button[contains(@class,'user-button')]")
    WebElement encash_crm_userIcon;

	@FindBy(xpath="//span[contains(text(),'My Profile')]")
    WebElement encash_crm_myProfile;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
    WebElement encash_crm_logout;
	
	//encash offers dummy making
	
	@FindBy(xpath ="//a[@title='View all offers']")
    WebElement view_offers;
	
	@FindBy(xpath = "//*[text()='About us']")
    WebElement scroll_privacy_policy;
	
	@FindBy(xpath="//*[@id='testimonial-wrapper']/div/div")
    WebElement encash_UI_testimonials;
	
	@FindBy(xpath="//*[@id='competition-sticky']")
    WebElement encash_UI_competitionCategories;
	
	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(linkText = "Categories")
    WebElement Categories_linktest;
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//*[text()='Add Category']")
    WebElement add_category;
	
	@FindBy(name = "name")
    WebElement add_category_name;
	
	@FindBy(xpath="//*[text()='Choose locations']")
    WebElement choose_Locations_Dropdown;
	
	@FindBy(xpath="//*[@id='mat-option-9']/child::mat-pseudo-checkbox")
    WebElement select_UK;
	
	@FindBy(xpath="//*[text()='ADD']")
    WebElement select_add;
	
	@FindBy(xpath="//*[text()=' Categories ']")
    WebElement caregories_Text;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//*[text()='Test with Stewart']")
    WebElement categories_display;
	
	@FindBy(xpath="//button[contains(@class,'user-button')]")
    WebElement user_icon;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
    WebElement logout;
	
	
	
	
	
	
	


	
	public encash_offers_signup_page_objects(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	Testdata data=new Testdata();
	  readconfig rconfig = new readconfig();
	
	public encash_offers_signup_page_objects Admin_login(String username,String crmpwd) throws Exception {

		  
		  	driver.get(rconfig.getbaseurl());
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			text(encash_crm_username,username,"encash_crm_username");
			text(encash_crm_pwd, crmpwd, "encash_crm_pwd");
			click(encash_crm_login, "encash_crm_login");
			
			return this;
			
					
		}
	/*
	 * String crmURL=PROCONFIG.getProperty("crmURL");
		String crmUsername=PROCONFIG.getProperty("crmUsername");
		//String crmPwd=decryptPwd(PROCONFIG.getProperty("crmPwd"));
		String crmPwd=PROCONFIG.getProperty("crmPwd");

		try {
			driver.get(crmURL);
			driver.navigate().refresh();Thread.sleep(2000);
			typeAndWait(CRMWebLocators.encash_crm_username, crmUsername, "Type username "+crmUsername);
			typeAndWait(CRMWebLocators.encash_crm_pwd, crmPwd, "Type pwd "+crmPwd);
			clickAndWait(CRMWebLocators.encash_crm_login, "Login");

			angularWait();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	
	public encash_offers_signup_page_objects crmUI_createNewCategory() throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		    readconfig rconfig = new readconfig();
		    String username= rconfig.getusername();
		    String crmpwd= rconfig.getcrmPwd();
		    En_sign.Admin_login( username ,crmpwd);
			
			String CRMCategoryName=data.CRMCategoryName;
				
			waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
			click(EncashOffers_linktest, "EncashOffers_linktest");
			click(Categories_linktest, "Categories_linktest");
			waitForElementVisibility(caregories_Text, "caregories_Text");
			click(right_side3Dots, "right_side3Dots");
			click(add_category, "add_category");
			text(add_category_name, CRMCategoryName, "add_category_name");
			click(choose_Locations_Dropdown, "choose_Locations_Dropdown");
			click(select_UK, "select_UK");
			click(select_add, "select_ADD");
		    goBack("kkk");
		    waitTime();
		    text(SearchText, CRMCategoryName, "Categories_linktest");
		    waitTime();
		    isDisplayed1("//*[text()='Test with Stewart']".replaceAll("Test with Stewart", CRMCategoryName), "categorie_display");
			waitTime();
			
			
			En_sign.Admin_logout();
			waitTime();

			
			return this;
			
			
			
			
		}

	public encash_offers_signup_page_objects Admin_logout() throws InterruptedException {
	    waitTime();
		Thread.sleep(5000);

		click(user_icon, "Click on user icon");
		click(logout, "logout");
		waitTime();
		
		return this;	
		
	}}

  

//	public encash_offers_signup_page_objects encashUIVerifyCompetitionInCategory() throws InterruptedException { 
//		Thread.sleep(4000);
//		scrollBybottom();
//		scrollByElement(scroll_privacy_policy, "scroll_privacy_policy");
//		Thread.sleep(4000);
//		scrollByElement(encash_UI_testimonials, "encash_UI_testimonials");
//		Thread.sleep(4000);
//		scrollByElement(encash_UI_competitionCategories, "encash_UI_competitionCategories");
//		Thread.sleep(4000);
//		
//		return this;
//	
		
		

		
	
		
	

