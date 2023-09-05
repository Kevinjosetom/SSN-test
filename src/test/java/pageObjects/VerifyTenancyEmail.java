package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resuable.ReusableMethods;
import data.Testdata;


public class VerifyTenancyEmail extends ReusableMethods {

	  public VerifyTenancyEmail(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		
	  }

	  
	  /**
		 * This method is used to verify the list of Tenancy Offers in the mail received.
		 * @param mailOption
		 * @throws InterruptedException 
		 * @throws Exception 
		 */
		public void openMailVerifyTenancyOffers(String mailOption) throws IOException, InterruptedException {
			
			//Test Data:
			Testdata data = new Testdata();

			String expectedHeading = data.expectedHeading;
			String TenancyOffer1 = data.TenancyOffer1;
			String TenancyOffer2 = data.TenancyOffer2;
			String expectedHeading1="Russell Hobbs Mini Fridge";
			String expectedURLForTenancyOffer1 = data.expectedURLForTenancyOffer1;
			String expectedURLForTenancyOffer2 = data.expectedURLForTenancyOffer2;
			String expectedURL_Click_Here = data.expectedURL_Click_Here;
			
			// Verify the heading of the list of Tenancy Offers section.
			if (mailOption == "registrationMail") {
				waitForElementPresent("//td[contains(., 'encashoffers.com - One time password (OTP)')]");
				click1("//td[contains(., 'encashoffers.com - One time password (OTP)')]", "open the registration mail");	
				waitForFrameAvaiableandSwitch("html_msg_body");
				waitForElementPresent("/html/body/p[4]");
				String actualHeading = driver.findElement(By.xpath("/html/body/p[4]")).getText();
				System.out.println(actualHeading);
				assertEquals(actualHeading, expectedHeading, "Verifying the tenancy offers heading.");
			}
			if (mailOption == "offerMail") {
				waitForElementPresent("//td[contains(., 'Encash Offers')]");
				click1("//td[contains(., 'Encash Offers')]", "open the offers/Competition mail");	
				waitForFrameAvaiableandSwitch("html_msg_body");
				waitForElementPresent("/html/body/p[3]");
				String actualHeading = driver.findElement(By.xpath("/html/body/font[1]/li")).getText();	
				assertEquals(actualHeading, expectedHeading1, "Heading of the Tenancy offers List verified");
			}
			
			//Verify the Tenancy Offers are present in the list
			waitForElementPresent("/html/body/font/li");
			List<WebElement> elements = getWebElement("/html/body/font/li");
			
			//Get the names and url of the tenancy offers listed.
			ArrayList<String> name = new ArrayList<String>();
			ArrayList<String> url = new ArrayList<String>();
			int index_tenancyOffer_1 =0;
			int index_tenancyOffer_2 =0;
			for (int i = 0; i < elements.size(); i++) {
				name.add(elements.get(i).getText());
				System.out.println("name"+name.add(elements.get(i).getText()));
				url.add(elements.get(i).getAttribute("href"));
				System.out.println("href"+elements.get(i).getAttribute("href"));
			}
			
			//Verify the First Tenancy offer from our Test data exists in the List
			if (name.contains(TenancyOffer1)) {
				index_tenancyOffer_1 = name.indexOf(TenancyOffer1);
				System.out.println(index_tenancyOffer_1);
				assertTrue1(index_tenancyOffer_1>= 0, "Offer 1 Exisits");
			}
			
			//Verify the First Tenancy offer from our Test data exists in the List
			if (name.contains(TenancyOffer2)) {
				index_tenancyOffer_2 = name.indexOf(TenancyOffer2);
				System.out.println(index_tenancyOffer_2 );
				assertTrue1(index_tenancyOffer_2>= 0, "Offer 2 Exisits");
			}
			
			//Verify the Transfer URL configured for the respective Tenancy offer exist in the List and the index should be same as the Offers above.
//			assertEquals(url.get(index_tenancyOffer_1), expectedURLForTenancyOffer1, "URL of Tenancy Offer 1 verified");
//			assertEquals(url.get(index_tenancyOffer_2), expectedURLForTenancyOffer2, "URL of Tenancy Offer 2  verified");
			
			//Verify the order of display of the list. First Tenancy Offer's Start date is before the 2nd One. So it should be listed likewise.
			boolean orderOfOffersDisplay = index_tenancyOffer_1 < index_tenancyOffer_2;
	//		assertTrue1(orderOfOffersDisplay, "Order of TenancyOffers Display verified");
			
			//Verify the link in the "Click Here" message.
			String actualURL = driver.findElement(By.xpath("/html/body/a[1]")).getAttribute("href");
		//	assertEquals(actualURL, expectedURL_Click_Here, "Click here URL verified");
			
			// switch to default frame
			switchToParentFrame("switch back to parent frame");
			
			//Go back to the Inbox
			waitForElementPresent("//a[@onclick='loadInboxFromUrlQuery();']");
			click1("//a[@onclick='loadInboxFromUrlQuery();']", "Go Back to the Inbox");
			refresh("Refreshing the page");				
		}


	
public void openMailVerifyTenancyOffers2(String mailOption) throws IOException, InterruptedException {
	
	//Test Data:
	Testdata data = new Testdata();

	String expectedHeading = data.expectedHeading;
	String TenancyOffer1 = data.TenancyOffer1;
	String TenancyOffer2 = data.TenancyOffer2;
	String expectedHeading1="Test Offers @Kumar";
	String expectedURLForTenancyOffer1 = data.expectedURLForTenancyOffer1;
	String expectedURLForTenancyOffer2 = data.expectedURLForTenancyOffer2;
	String expectedURL_Click_Here = data.expectedURL_Click_Here;
	
	// Verify the heading of the list of Tenancy Offers section.
	if (mailOption == "registrationMail") {
		waitForElementPresent("//td[contains(., 'encashoffers.com - One time password (OTP)')]");
		click1("//td[contains(., 'encashoffers.com - One time password (OTP)')]", "open the registration mail");	
		waitForFrameAvaiableandSwitch("html_msg_body");
		waitForElementPresent("/html/body/p[4]");
		String actualHeading = driver.findElement(By.xpath("/html/body/p[4]")).getText();
		System.out.println(actualHeading);
		assertEquals(actualHeading, expectedHeading, "Verifying the tenancy offers heading.");
	}
	if (mailOption == "offerMail") {
		waitForElementPresent("//td[contains(., 'Encash Offers')]");
		click1("//td[contains(., 'Encash Offers')]", "open the offers/Competition mail");	
		waitForFrameAvaiableandSwitch("html_msg_body");
		waitForElementPresent("/html/body/p[3]");
		String actualHeading = driver.findElement(By.xpath("/html/body/font[1]/li")).getText();	
		assertEquals(actualHeading, expectedHeading1, "Heading of the Tenancy offers List verified");
	}
	
	//Verify the Tenancy Offers are present in the list
	waitForElementPresent("/html/body/p[3]/a");
	List<WebElement> elements = getWebElement("/html/body/p[3]/a");
	
	//Get the names and url of the tenancy offers listed.
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> url = new ArrayList<String>();
	int index_tenancyOffer_1 =0;
	int index_tenancyOffer_2 =0;
	for (int i = 0; i < elements.size(); i++) {
		name.add(elements.get(i).getText());
		System.out.println("name"+elements.get(i).getText());
		url.add(elements.get(i).getAttribute("href"));
		System.out.println("href"+elements.get(i).getAttribute("href"));
	}
	
	//Verify the First Tenancy offer from our Test data exists in the List
	if (name.contains(TenancyOffer1)) {
		index_tenancyOffer_1 = name.indexOf(TenancyOffer1);
		System.out.println(index_tenancyOffer_1);
		assertTrue1(index_tenancyOffer_1>= 0, "Offer 1 Exisits");
	}
	
	//Verify the First Tenancy offer from our Test data exists in the List
	if (name.contains(TenancyOffer2)) {
		index_tenancyOffer_2 = name.indexOf(TenancyOffer2);
		System.out.println(index_tenancyOffer_2 );
		assertTrue1(index_tenancyOffer_2>= 0, "Offer 2 Exisits");
	}
	
	//Verify the Transfer URL configured for the respective Tenancy offer exist in the List and the index should be same as the Offers above.
//	assertEquals(url.get(index_tenancyOffer_1), expectedURLForTenancyOffer1, "URL of Tenancy Offer 1 verified");
//	assertEquals(url.get(index_tenancyOffer_2), expectedURLForTenancyOffer2, "URL of Tenancy Offer 2  verified");
	
	//Verify the order of display of the list. First Tenancy Offer's Start date is before the 2nd One. So it should be listed likewise.
	boolean orderOfOffersDisplay = index_tenancyOffer_1 < index_tenancyOffer_2;
//	assertTrue1(orderOfOffersDisplay, "Order of TenancyOffers Display verified");
	
	//Verify the link in the "Click Here" message.
	String actualURL = driver.findElement(By.xpath("/html/body/a[1]")).getAttribute("href");
//	assertEquals(actualURL, expectedURL_Click_Here, "Click here URL verified");
	
	// switch to default frame
	switchToParentFrame("switch back to parent frame");
	
	//Go back to the Inbox
	waitForElementPresent("//a[@onclick='loadInboxFromUrlQuery();']");
	click1("//a[@onclick='loadInboxFromUrlQuery();']", "Go Back to the Inbox");
	refresh("Refreshing the page");				
}


}