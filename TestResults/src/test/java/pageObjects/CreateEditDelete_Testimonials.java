package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import Resuable.readconfig;
import data.Testdata;

public class CreateEditDelete_Testimonials extends ReusableMethods {
	
	@FindBy(xpath="//*[@id='testimonial-wrapper']/div/div")
    WebElement encash_UI_testimonials;
	
	@FindBy(xpath ="//*[text()='Encash Offers']")
    WebElement EncashOffers_linktest;
	
	@FindBy(linkText = "Testimonials")
    WebElement Testimonials_linktest;
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    WebElement right_side3Dots;
	
	@FindBy(xpath="//*[text()='Add Testimonial']")
    WebElement Add_Testimonial_link;
	
	@FindBy(xpath="//*[@placeholder='Testimonial']")
    WebElement Add_Testimonial_Text;
	
	@FindBy(xpath="//*[@placeholder='Consumer Name']")
    WebElement add_Consumer_name;
	
	@FindBy(xpath="//*[text()='Choose locations']")
    WebElement choose_Locations_Dropdown;
	
	@FindBy(xpath="//*[contains(text(),' UK ')]")
    WebElement select_UK;
	
	@FindBy(xpath="//*[text()='ADD']")
    WebElement select_add;
	
	@FindBy(xpath="//*[text()=' Testimonials ']")
    WebElement Testimonials_Text;
	
	@FindBy(xpath="//*[contains(@placeholder,'Search...')]")
    WebElement SearchText;
	
	@FindBy(xpath="//*[text()='Test with Stewart']")
    WebElement categories_display;
	
	@FindBy(xpath="//button[contains(@class,'user-button')]")
    WebElement user_icon;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
    WebElement logout;
	
	@FindBy(xpath="//*[contains(text(),' 28 ')]")
    WebElement Select_date;
	
	@FindBy(xpath="//input[@formcontrolname='submittedOn']")
    WebElement calender_icon;
	
	@FindBy(xpath="//span[contains(text(),'Consent Mode')]")
    WebElement concent;
	
	@FindBy(xpath="//span[contains(text(),' Email ')]")
    WebElement concent_Email;
	
	@FindBy(xpath="//*[text()='Top competitions ']")
    WebElement Top_competitions;
	
	@FindBy(xpath="//div[@class='desktop-carousel ng-star-inserted']//div[@class='owl-next']//img")
    WebElement Banner_Next;
	
	@FindBy(xpath="//*[text()='Test EncashUser']")
    WebElement customerName;
	
	@FindBy(xpath="//span[contains(text(),'Is Active?')]/../..//input[@role='switch']/..")
    WebElement De_select_Is_Active;
	
	@FindBy(xpath="//span[contains(text(),'SAVE')]")
    WebElement save;
	
	@FindBy(xpath="//*[text()='Consumer Description']")
    WebElement Consumer_Description;
	
	Testdata data=new Testdata();
	readconfig rconfig = new readconfig();
	public String username= rconfig.getusername();
	public String crmpwd= rconfig.getcrmPwd();


	
	public CreateEditDelete_Testimonials(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
		}
	
	
	public CreateEditDelete_Testimonials crmUI_createNewTestimonial() throws Exception {
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
        readconfig rconfig = new readconfig();
        String username= rconfig.getusername();
        String crmpwd= rconfig.getcrmPwd();
      
		

		String CRMConsumerName=data.CRMConsumerName;
		String CRMTestimonial=data.CRMTestimonial;
		String consent="Email";
		
		En_sign.Admin_login( username ,crmpwd);		

		waitForElementVisibility(EncashOffers_linktest, "EncashOffers_linktest");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		click(Testimonials_linktest, "Testimonials_linktest");
		waitForElementVisibility(Testimonials_Text, "Testimonials_Text");
	    click(right_side3Dots, "right_side3Dots");
		waitTime();
		click(Add_Testimonial_link, "click on Add_Testimonial_link");
		text(add_Consumer_name, CRMConsumerName, "add_Consumer_name");
		click(choose_Locations_Dropdown, "choose_Locations_Dropdown");
		click(select_UK, "select_UK");
		text(Add_Testimonial_Text,CRMTestimonial ,"Enter_Add_Testimonial");
		//waitForElementVisibility(calender_icon, "calender_icon");
		click(concent, "click on concent");
		click(concent_Email, "click on concent_Email");
		click(calender_icon, "click on the calender_icon");
		//click(Select_date, "Select_date");
		waitTime();
		waitForElementVisibility(select_add, "calender_icon");
		click(select_add,"Add_Testimonial");
		Thread.sleep(5000);
		En_sign.Admin_logout();
		return this;

   }
	public CreateEditDelete_Testimonials encashUIVerifyTestimonial()  throws Exception {
		 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		String ConsumerName = data.CRMConsumerName;
		String Testimonial = data.CRMTestimonial;
		String TestimonialSubmittedDate = "22-10-2020";
//		String testimonial_desc = "//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//p";
//		String testimonial_name = "//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//div/div[2]/div[2]//span[1]";
//		String testimonial_date ="//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//div/div[2]/div[2]//span[2]";
		// Scroll to the testimonial
		crmui_addcategory.stagingUrl_launch();
		Thread.sleep(10000);
		// Scroll to the testimonial
				scrollToView("//*[@id='testimonial-wrapper']/div/div", "Scroll to Testimonials");
				scrollToView("//div[@class='desktop-carousel ng-star-inserted']//div[@class='owl-next']//img", "Scroll");

				// 1. Verify Testimonial DEscription       "//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//p"
				List<WebElement> elements = getWebElement("//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//p");
				ArrayList<String> as = new ArrayList<String>();
				int value = elements.size();
				System.out.println(value);
				for (int i = 0; i < value; i++) {
					as.add(elements.get(i).getAttribute("innerText"));
					System.out.println(as);
				}

				int indexOfTestimonial = as.indexOf(Testimonial);
				boolean testimonialPresent = as.contains(Testimonial);
				assertTrue1(testimonialPresent, "Verify Testimonial Description");

				// 2. Verify Testimonial Name
				List<WebElement> elements_names = getWebElement("//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//div/div[2]/div[2]//span[1]");
				ArrayList<String> as1 = new ArrayList<String>();
				for (int i = 0; i < value; i++) {
					as1.add(elements_names.get(i).getAttribute("innerText"));
				}

				String TestimonialName = as1.get(indexOfTestimonial);
				if (TestimonialName.equals(ConsumerName)) {
					boolean testimonialNamePresent = true;
					assertTrue1(testimonialNamePresent, "Verify Testimonial Name");
				} else {
					boolean testimonialNamePresent = false;
					assertTrue1(testimonialNamePresent, "Verify Testimonial Name");
				}

				// 3. Verify Testimonial Submitted Date
				List<WebElement> elements_date = getWebElement("//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//div/div[2]/div[2]//span[2]");
				ArrayList<String> as2 = new ArrayList<String>();
				for (int i = 0; i < value; i++) {
					as2.add(elements_date.get(i).getAttribute("innerText"));
				}

				String TestimonialDate = as2.get(indexOfTestimonial);
				// String numberOfDate = TestimonialDate.replaceAll("[^0-9]", "");
				int numberOfDate = Integer.parseInt(TestimonialDate.replaceAll("[^0-9]", ""));
				int noOfDaysAgo = dateDifference(getCurrentDate(), TestimonialSubmittedDate);
				//assertEquals(noOfDaysAgo, numberOfDate, "Verify Testimonial Submitted Date");
				return this;
			}
	
	public CreateEditDelete_Testimonials crmUI_editTestimonial()  throws Exception {
		
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
        readconfig rconfig = new readconfig();
        String username= rconfig.getusername();
        String crmpwd= rconfig.getcrmPwd();
        
        En_sign.Admin_login( username ,crmpwd);
		
        
		String CRMConsumerName=data.CRMConsumerName;
		String CRMConsumerNameEdited=data.CRMConsumerName+"EditedName_kumar";
		
		test.info("Expand the encash offers to select the Tetimonials");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		click(Testimonials_linktest, "Testimonials_linktest");
		waitForElementVisibility(Testimonials_Text, "Testimonials_Text");
	     
	   //search for Testimonial
		waitForElementVisibility(SearchText, "SearchText");
		text(SearchText, CRMConsumerName, "Search for "+CRMConsumerName);
		click(Consumer_Description, "Consumer Description");
		waitTime();
		waitForElementVisibility(customerName, "waiting for Desired Testimonial");
		click(customerName, "Clicked on Desired Testimonial");
		add_Consumer_name.clear();
		text(add_Consumer_name,CRMConsumerNameEdited+"_OLD", "Edited Consumer Name");
		//2. Disable Testimonial
		click(De_select_Is_Active, "De_select_Is_Active");
		waitTime();
		//3. Save
	    click(save, "on the save button");
		Thread.sleep(2000);
		refresh("Page refreshed");
		waitTime();
		En_sign.Admin_logout();
		return this;
	}
	public CreateEditDelete_Testimonials encashUIVerifyEditedTestimonial()  throws Exception {
		 crmUI_AddCategoryToExistingCompetition crmui_addcategory = new crmUI_AddCategoryToExistingCompetition(driver);
		String ConsumerName = data.CRMConsumerName;
		String Testimonial = data.CRMTestimonial;
		String testimonial_desc = "//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//p";
		String testimonial_name = "//*[@id='testimonial-wrapper']/div/div/owl-carousel-o/div/div[1]/owl-stage/div/div//div/div[2]/div[2]//span[1]";
		// Scroll to the testimonial
		
		crmui_addcategory.stagingUrl_launch();
		scrollBybottom();       
		
		scrollByElement(Top_competitions, "scroll to Top_competitions");
		waitTime();
		waitForElementPresent_long("//*[@id='testimonial-wrapper']/div/div");
		scrollByElement(encash_UI_testimonials, "encash_UI_testimonials");
		waitTime();
		// 1. Verify Testimonial DEscription
		List<WebElement> elements = getWebElement(testimonial_desc);
		ArrayList<String> as = new ArrayList<String>();
		int value = elements.size();
		for (int i = 0; i < value; i++) {
		as.add(elements.get(i).getAttribute("innerText"));
		 }

		int indexOfTestimonial = as.indexOf(Testimonial);
		boolean testimonialPresent = as.contains(Testimonial);
		assertTrue1(testimonialPresent, "Verify Testimonial Description");

		// 2. Verify Testimonial Name
		List<WebElement> elements_names = getWebElement(testimonial_name);
		ArrayList<String> as1 = new ArrayList<String>();
		for (int i = 0; i < value; i++) {
		as1.add(elements_names.get(i).getAttribute("innerText"));
			}

	    String TestimonialName = as1.get(indexOfTestimonial);
		if (TestimonialName.equals(ConsumerName)) {
			boolean testimonialNamePresent = true;
			assertTrue1(testimonialNamePresent, "Verify Testimonial Name");
			} else {
			boolean testimonialNamePresent = false;
			assertTrue1(testimonialNamePresent, "Verify Testimonial Name");
				}
		return this;
  
	 }
	public CreateEditDelete_Testimonials crmUI_editAndDisableTestimonial()  throws Exception {
		String CRMConsumerNameEdited=data.CRMConsumerName+"EditedName_kumar_OLD";
		encash_offers_signup_page_objects	En_sign = new encash_offers_signup_page_objects(driver);
        readconfig rconfig = new readconfig();
        String username= rconfig.getusername(); //  Test EncashUserEditedName
        String crmpwd= rconfig.getcrmPwd();
        En_sign.Admin_login( username ,crmpwd);
				

		test.info("Expand the encash offers to select the Tetimonials");
		click(EncashOffers_linktest, "EncashOffers_linktest");
		click(Testimonials_linktest, "Testimonials_linktest");
		waitForElementVisibility(Testimonials_Text, "Testimonials_Text");
	     
	 
		//search for Testimonial
		waitForElementPresent("//*[contains(@placeholder,'Search...')]");
		type1("//*[contains(@placeholder,'Search...')]", CRMConsumerNameEdited, "search for the testimonial with Consumer name -> " + CRMConsumerNameEdited );
		waitForElementVisibility1("//*[contains(text(),'EncashUserEditedName')]".replaceAll("EncashUserEditedName",CRMConsumerNameEdited) );
		
		click1("//*[contains(text(),'EncashUserEditedName')]".replaceAll("EncashUserEditedName",CRMConsumerNameEdited), "Clicked on Desired Testimonial");
		waitForElementPresent("//input[contains(@placeholder,'toReplacePlaceholder')]".replaceAll("toReplacePlaceholder","Consumer Name"));
		
		//1. Edit the Consumer Name
		clearAndType("//input[contains(@placeholder,'toReplacePlaceholder')]".replaceAll("toReplacePlaceholder","Consumer Name"), CRMConsumerNameEdited+"_OLD", "Edited Consumer Name");
		//2. Disable Testimonial
		click1("//span[contains(text(),'Is Active?')]/../..//input[@role='switch']/..","De-select Is Active");
		
		//3. Save
		scrollToView("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","SAVE"), "Scroll to the Save Button");
		waitForElement1(60, "//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","SAVE"), "waiting for Save button to be enabled");
		click1("//span[contains(text(),'toReplaceLinkName')]".replaceAll("toReplaceLinkName","SAVE"), "Save the Testimonial");
		Thread.sleep(2000);
		refresh("Page refreshed");
		En_sign.Admin_logout();
		
		return this;
		
		
	}	
}
