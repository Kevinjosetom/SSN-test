package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;


public class CompetitionsWeb extends ReusableMethods {
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//*[contains(text(),'Add Competition')]")
    WebElement add_competition;

	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(linkText = "Competitions")
    WebElement Competitions_linktest;
	
	@FindBy(xpath="//*[text()=' Categories ']")
    WebElement caregories_Text;
	
	@FindBy(xpath="//*[contains(text(),' Competitions ')]")
    WebElement Competition_Text;
	
	@FindBy(xpath ="//input[contains(@placeholder,'Competition Name')]")
    WebElement Competition_Name;
	
	@FindBy(xpath ="//mat-select[contains(@placeholder,'Client')]")
    WebElement client_Dropdown;
	
	@FindBy(xpath ="//mat-select[contains(@placeholder,'Location')]")
    WebElement client_location;
	
	@FindBy(xpath ="//*[@placeholder='Choose categories']")
    WebElement categories_DropDown;
	
	@FindBy(xpath ="//*[text()=' Gaming ']/parent::mat-option/mat-pseudo-checkbox")
    WebElement categories_DropDown_Gaming;
	
	@FindBy(xpath ="//button[@class=\"mat-focus-indicator mat-icon-button mat-button-base\"]")
    WebElement date_picker;
		
	@FindBy(xpath ="//*[@id='mat-tab-content-0-0']/div")
    WebElement Escape_categories_DropDown;
	
	@FindBy(xpath ="//*[text()='ADD']")
    WebElement Categorie_Add;
	
	@FindBy(xpath ="//*[text()=' New Competition ']")
    WebElement New_Competition;
	
	@FindBy(xpath ="//*[text()=' SSN Internal ']")
    WebElement client_Dropdown_List;
	
	@FindBy(xpath ="//*[text()=' UK ']")
    WebElement client_location_UK;
	
	@FindBy(xpath ="(//*[@id='mat-slide-toggle-7']//following-sibling::div)[1]")
    WebElement Status_toggle;
	
	@FindBy(xpath ="//*[text()='Status']")
    WebElement Status;
	
	@FindBy(xpath ="//*[text()='SAVE']")
    WebElement save;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//*[@id='mat-tab-label-0-3']")
    WebElement levels;
	
	@FindBy(xpath="//*[text()='add']")
    WebElement Add_levels;
	
	@FindBy(xpath="//*[text()='Level 1']/following::mat-select") 
    WebElement select_questionnaries_dropdown;
	
	@FindBy(xpath="//*[text()=' Save Levels ']")
    WebElement save_levels;
	
	@FindBy(xpath="//span[text()=' Shopping-lvl1-Rohit(lvl1)-26-12-2019-Saurabh (From Staging) (2 segments) ']")
    WebElement select_questionnaries;
	
	@FindBy(xpath="(//*[@class='mat-option-text'])[6]")
    WebElement select_questionnaries1;
	
	
    Testdata data=new Testdata();
    readconfig rconfig = new readconfig();

	
	public CompetitionsWeb(WebDriver driver) {
			this.driver = driver;
			// This initElements method will create all WebElements
			PageFactory.initElements(driver, this);
			
			}
	   
	
	

	public CompetitionsWeb Competition_Create() throws Exception {
		//Test data;
			String competationName = "testing123";
			
			encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
			readconfig rconfig = new readconfig();
			String username= rconfig.getusername();
			String crmpwd= rconfig.getcrmPwd();
			waitTime();
			En_sign.Admin_login(username ,crmpwd);
			
			waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
			click(EncashOffers_linktest, "EncashOffers_linktest");
			click(Competitions_linktest, "Competitions_linktest");
			waitForElementVisibility(Competition_Text, "Competition_Text");
			click(right_side3Dots, "right_side3Dots");
			click(add_competition, "add_competition");
			waitTime();
			text(Competition_Name, competationName, "competationName");
			click(client_Dropdown, "client_Dropdown");
			click(client_Dropdown_List,"client_Dropdown_List");
			click(client_location, "client_Dropdown");
			click(client_location_UK, "client_location_UK");
			waitTime();
			click(categories_DropDown, "categories_DropDown");
			click(categories_DropDown_Gaming,"categories_DropDown_Gaming");
			waitTime();
			escape();
			//click(Escape_categories_DropDown, "Escape_categories_DropDown");
			click(date_picker, "date_picker");
			waitTime();
			driver.findElement(By.xpath("//*[@id='mat-datepicker-0']/div/mat-month-view/table/tbody/tr[5]/td[5]/div[1]")).click();
			waitTime();
			
			waitTime();
			scrollByElement(Escape_categories_DropDown, "Escape_categories_DropDown");
			click(Categorie_Add, "Categorie_Add");
			waitTime();
			click(Status_toggle, "Status_toggle");
			waitForElementVisibility(save, "save_New_Catrgorie");
			click(save, "save");
			waitTime();
			En_sign.Admin_logout();
			return this;
			
	}
	public CompetitionsWeb Competition_Questions() throws Exception {
		String competationName = "testing123";
		String object_name ="//*[contains(text(),'Name')]/following::mat-row";
		String colum_no="2"; 
		
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
		readconfig rconfig = new readconfig();
		String username= rconfig.getusername();
		String crmpwd= rconfig.getcrmPwd();
		waitTime();
		En_sign.Admin_login(username ,crmpwd);
		
		
		waitForElementVisibility(EncashOffers_linktest,"EncashOffers_linktest");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		click(Competitions_linktest, "Competitions_linktest");
		waitForElementVisibility(Competition_Text, "Competition_Text");
		text(SearchText, competationName, "competationName_testing123");
		waitTime();
		try {		
		List<WebElement> tablerow = driver.findElements(By.xpath(object_name));
		
		for(int i = 1;i<=tablerow.size();i++) {
			String row = object_name+"["+i+"]"+"/mat-cell["+colum_no+"]";
			String get_text = driver.findElement(By.xpath(row)).getText();
			System.out.println(get_text);
			if(get_text.equalsIgnoreCase(competationName)) {
				driver.findElement(By.xpath(row)).click();
				System.out.println(row);
				break;
			}}}
			
		  catch (Exception e) 
		{
			  test.fail("compitation name not visible"+competationName);
			  e.printStackTrace();
				Assert.fail();
		  }  
		   return this;
	        }
	     
    public CompetitionsWeb Competition_Level() throws Exception {
    encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
	System.out.println("Competition_Level");
	
	
	//span[contains(text(),'Add Level')]
	click1("(//*[text()='Competition Details']//following::mat-tab-header//div)[9]", "click on the Level");
	waitForElement1(60, "//*[(text()='add')]", 
			"waiting for the Add Level button");
	click1("//*[(text()='add')]", " on the Add level");
	
	
	
	click1("//*[@class='mat-select-arrow ng-tns-c120-52']", "Open Questionnaire dropdown");
	waitTime();
    mouseHoverAndClick(select_questionnaries1, " select questionnaires");
    waitTime();
	driver.findElement(By.xpath("//*[text()=' SAVE ']")).click();
	test.info("successfully save the questionnaire ");
	En_sign.Admin_logout();
	
	return this;
	
    }}
    

  
   
  

