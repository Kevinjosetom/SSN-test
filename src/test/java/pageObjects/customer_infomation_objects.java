package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;

public class customer_infomation_objects  extends ReusableMethods {


	
	
	
			@FindBy(xpath="//*[text()=\"Password (For Verification Purposes)\"]//following::input[1]")
		    WebElement create_password;
			
			@FindBy(xpath="//*[text()=' Edit Details ']")
		    WebElement edit_details;
			
			@FindBy(xpath ="(//*[@class='col-md-12 checkboxList mb-2 mt-2']//child::input)")
			List<WebElement>  check_box_List;

			@FindBy(xpath ="//*[text()=' Back ']")
			WebElement  customer_information_back_button;
			
			@FindBy(xpath ="//*[text()=' Skip ']")
			WebElement  congratulations_Skip_button;
			
			@FindBy(xpath ="//*[text()=' Add More ']")
			WebElement congratutions_addmore_button;
			
			@FindBy(xpath ="//*[@class='checkmark']")
			List<WebElement>  Applience_List;
			
			@FindBy(xpath="//*[text()=' Next ']")
		    WebElement Multi_Choose_Applience_Next;
			
			public customer_infomation_objects(WebDriver driver) {

				this.driver = driver;
				// This initElements method will create all WebElements
				PageFactory.initElements(driver, this);
			}
			

			public customer_infomation_objects customer_information_details() throws IOException {
				click(edit_details, "edit_details");
				text(create_password, "12345", "create_password");
				try {
					for(int i=1;i<=check_box_List.size(); i++) {
						check_box_List.get(i).click();
						Thread.sleep(4000);
						System.out.println(i);
					
						}
					}
				
					catch (Exception e) {
						System.out.println("check boxs not selected");
					}	
				
				
				return this;	
				
			}		
		public customer_infomation_objects quote_Summary_pop_details() {
			waitTime();
			//click(congratulations_Skip_button, "congratulations_Skip_button");
			click(congratutions_addmore_button, "congratutions_addmore_button");
			waitTime();
			try {
				for(int i=1;i<=Applience_List.size(); i++) {
					Applience_List.get(i).click();
					Thread.sleep(1000);
					System.out.println(i);
									
					}
				}
			
				catch (Exception e) {
					System.out.println("more then 6 applience not allowed");
				}	
			
			return this;
			
			
			
		}
}
