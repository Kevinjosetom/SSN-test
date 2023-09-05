package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class Your_Selected_applience extends ReusableMethods {

	
	
	@FindBy(xpath="//*[text()='Unlock Extra Savings']/following::input[@type='checkbox']")
    List<WebElement> select_all_Checkboxes;
	
	@FindBy(xpath="//*[text()='Selected Appliances']")
    WebElement Appliance_title;
	
	@FindBy(xpath="//*[text()='+ Add More ']")
    WebElement Add_more;
	
	@FindBy(xpath="(//*[@title='Delete'])[4]")
    WebElement Appliance_Delete;
	
	@FindBy(xpath="(//*[@title='Delete'])[5]")
    WebElement Appliance_Delete_5;

	@FindBy(xpath="(//select[@formcontrolname='plan_id'])[2]")
    WebElement Select_plan;

	@FindBy(xpath="(//select[@formcontrolname='plan_id'])[3]")
    WebElement Select_plan1;

	@FindBy(xpath="(//*[text()='7 day repair promise included! EXTRA SAVING of £36']/following::input)[1]")
    WebElement Select_EO_points;
	
	@FindBy(xpath="(//*[text()='7 day repair promise included! EXTRA SAVING of £36']/following::input)[5]")
    WebElement Select_EO_points2;
	
	@FindBy(xpath="//*[text()=' Next ']")
    WebElement Next;
	
	@FindBy(xpath="//*[text()='+ Add More ']")
    WebElement Add_More;
	
	@FindBy(xpath="//*[text()=' Additional 4000 score points in EncashOffers Rewards ']")
    WebElement EO_points;
	
	@FindBy(xpath="//*[text()='Quick Quote Overview']")
    WebElement Quote_Title;
	
	@FindBy(xpath="(//*[@class='checkmark'])[4]")
    WebElement Select_Appliance;
	
	@FindBy(xpath="(//select[@class='form-select'])[4]")
    WebElement Appliance_Brand4;
	
	@FindBy(xpath="(//select[@formcontrolname='cover_id'])[4]")
    WebElement cover_select4;
	
	@FindBy(xpath="(//select[@formcontrolname='cover_id'])[5]")
    WebElement cover_select5;
	
	@FindBy(xpath="(//select[@formcontrolname='cover_id'])[6]")
    WebElement cover_select6;
	
	@FindBy(xpath="(//select[@formcontrolname='plan_id'])[4]")
    WebElement Select_plan4;
	
	@FindBy(xpath="(//select[@formcontrolname='plan_id'])[5]")
    WebElement Select_plan5;
	
	@FindBy(xpath="(//select[@formcontrolname='plan_id'])[6]")
    WebElement Select_plan6;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[1]")
    WebElement Select_STN_7drp;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[3]")
    WebElement Select_STN_3yr;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[5]")
    WebElement Select_STN_1yr;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[6]")
    WebElement Select_Pre_7drp;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[8]")
    WebElement Select_Pre_3yr;
	
	@FindBy(xpath="(//*[text()='Unlock Extra Savings']/following::input[@type='checkbox'])[10]")
    WebElement Select_Pre_1yr;
	
	public Your_Selected_applience(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
 
	
	public Your_Selected_applience Select_Applience() throws IOException, InterruptedException {
		
		
		
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		waitTime();
		assertFalse(false, " Add_more");
		waitTime();
		click(Appliance_Delete, "the Delete 6th Appliance for Visibility of ADD More Button");
		assertTrue1(true," Add_more");
		waitTime();
        scrollByElement(Add_more, "Add_more button");
		waitTime();
        click(Add_more, "the ADD more button to Add 6th Apliance");
		waitTime();
        click(Select_Appliance, "the Select 6th Appliance");
		waitTime();
		selectByText(Appliance_Brand4," John Lewis ");
		waitTime();
    	click(Next, "the next Button to navigate Selected Appliance Window");
		waitTime();
		assertFalse(false, "Add_more");
		waitTime();
        selectByText(Select_plan, " 3 Yearly (Elite) ");
        
        selectByText(Select_plan1, " Yearly (Ultra) ");
        selectByText(cover_select4, " Premium Cover ");
        selectByText(cover_select5, " Premium Cover ");
        selectByText(cover_select6, " Premium Cover ");
        selectByText(Select_plan4, " Monthly (Basic) ");
        selectByText(Select_plan5, " 3 Yearly (Elite) ");
        selectByText(Select_plan6, " Yearly (Ultra) ");
        waitTime();
        String MONTH_7DRP= "(//*[text()='Unlock Extra Savings']//following::input)[1]";
		waitForElementPresent(MONTH_7DRP);
//		String attribute = getAttribute(MONTH_7DRP, "disabled", "getting the aributed value");
//		//verifying the continue button is disable by default
//		System.out.println(attribute);
//		assertEquals("null", attribute, "verifying the continue button is disable");
//		waitTime();
		String STN_threeyearly_7DRP= "(//*[text()='Unlock Extra Savings']//following::input)[4]";
		waitForElementPresent(STN_threeyearly_7DRP);
		String attribute1 = getAttribute(STN_threeyearly_7DRP, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute1);
		assertEquals("true", attribute1, "verifying the CheckBox is disable");
		waitTime();
		String STN_yearly_7DRP= "(//*[text()='Unlock Extra Savings']//following::input)[8]";
		waitForElementPresent(STN_yearly_7DRP);
		String attribute2 = getAttribute(STN_yearly_7DRP, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute2);
		assertEquals("true", attribute2, "verifying the CheckBox is disable");
		waitTime();
		String PRE_threeyearly_7DRP= "(//*[text()='Unlock Extra Savings']//following::input)[15]";
		waitForElementPresent(PRE_threeyearly_7DRP);
		String attribute3 = getAttribute(PRE_threeyearly_7DRP, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute3);
		assertEquals("true", attribute3, "verifying the CheckBox is disable");
		waitTime();
		String PRE_yearly_7DRP= "(//*[text()='Unlock Extra Savings']//following::input)[19]";
		waitForElementPresent(PRE_yearly_7DRP);
		String attribute4 = getAttribute(PRE_yearly_7DRP, "disabled", "getting the aributed value");
		//verifying the continue button is disable by default
		System.out.println(attribute4);
		assertEquals("true", attribute4, "verifying the CheckBox is disable");
		waitTime();
		click(Select_STN_7drp, "the Standard cover 7DRP");
		Thread.sleep(1000);
		click(Select_STN_3yr, "the Standard cover 3yearly E.O points");
		Thread.sleep(1000);
		click(Select_STN_1yr, "the Standard cover yearly E.O points");
		Thread.sleep(1000);
		scrollByElement(Select_Pre_7drp, "Select_Pre_7drp");
		Thread.sleep(1000);
		click(Select_Pre_7drp, "the Premium cover 7DRP");
		Thread.sleep(1000);
		click(Select_Pre_3yr, "the Premium cover 3yearly E.O points");
		Thread.sleep(1000);
		click(Select_Pre_1yr, "the Premium cover yearly E.O points");
		waitTime();
    	click(Next, "the next Button to navigate Quote summary Window");	
    	return this;
	}
public Your_Selected_applience Select_Applience_Dclaration() throws InterruptedException, IOException {
		
		
		
		try {
			String actual= Appliance_title.getText();
		    System.out.println(actual);
			String expected = "Selected Appliances";
			verifyText(actual, expected);
			System.out.println("Webpage  navigate Sucessfully to the SELECTED APPLIANCE page ");

		
			}
			catch (Exception e) {
				System.out.println("Webpage not navigate to the YOUR SELECTED APPLIANCE page ");
			}
		

		waitTime();
		scrollByElement(Add_More, "Next");
		waitTime();
    	click(Next, "the next Button to navigate Selected Appliance Window");

		waitTime();

    	return this;
	
		
	}
	
	
}

	




