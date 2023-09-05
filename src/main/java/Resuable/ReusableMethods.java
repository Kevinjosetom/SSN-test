package Resuable;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import org.apache.commons.io.FileUtils;



import ActionEngine.BaseClass;

public class ReusableMethods extends BaseClass {
	
	public ExtentTest extennttest;
	
	
	public static String screenshotfolder = System.getProperty("user.dir") + "/screenshots/";
	String ChildWindow = "";
	public void click(WebElement element, String elementName) {
		try {
			// explicitWait().until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			System.out.println("sucessfully clicked " + elementName);
			test.pass("sucessfully clicked ON  " + elementName);
			Thread.sleep(2000);
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not clicked ON " + elementName);
			test.info("not clicked ON " + elementName);
			try {
				test.log(Status.FAIL, "not clicked " +elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void selectFrame(String frameLocator, String stepDescription) throws IOException {	
		try {
			driver.switchTo().frame(frameLocator);
			test.log(Status.PASS, stepDescription+" for "+frameLocator);
		}
		catch(Exception e) {
			System.out.println("not clicked ON " + stepDescription);
			test.info("not clicked ON " + stepDescription);
			//String error = captureScreenshot1();
			//test.fail("Click failed"+ error);
			test.log(Status.FAIL, "not clicked " +stepDescription + test.addScreenCaptureFromPath(captureScreenshot(stepDescription)));
			e.printStackTrace();

			}}

	/**
	 * 
	 * @param desc
	 */
	//switchToParentFrame
	public void switchToParentFrame(String desc) {
		driver.switchTo().defaultContent();
		test.log(Status.PASS, desc);
	}
	
	
	
	public String spanLink(String linkText) {
		String locator="//span[contains(text(),'toReplaceLinkText')]";
		return locator.replaceAll("toReplaceLinkText", linkText);
	}
	

	public void click1(String locator,String desc) throws IOException {
		try {
			driver.findElement(By.xpath(locator)).click();
			test.pass("Successfuly Click on  "+ desc);
			System.out.println("successfully click on " + desc);
		}
		
         catch(Exception  e) {
				System.out.println("not clicked ON " + desc);
				test.info("not clicked ON " + desc);
				//String error = captureScreenshot1();
				//test.fail("Click failed"+ error);
				test.log(Status.FAIL, "not clicked " +desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
				e.printStackTrace();

				}
	        }
    
	
	public void clickHyperlink(String Linkname,String desc) throws IOException {
		try {
			driver.findElement(By.linkText(Linkname)).click();
			test.pass("Sucessfully click the linkname of"+ desc);
		}

		catch(Exception e) {
			System.out.println("not clicked ON " + desc);
			test.info("not clicked ON " + desc);
			//String error = captureScreenshot1();
			//test.fail("Click failed"+ error);
			test.log(Status.FAIL, "not clicked " +desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			e.printStackTrace();

			}
        }

		
		
	

	public void OpenNewTab() {
		newTab();


	}
	
	public void newTab() {
		String a = "window.open('about:blank','_blank');";
		((JavascriptExecutor)driver).executeScript(a);
		
		Set<String> handles = driver.getWindowHandles();
	    String currentWindowHandle = driver.getWindowHandle();
	    for (String handle : handles) {
	        if (!currentWindowHandle.equals(handle)) {
	            driver.switchTo().window(handle);
	        }
	    }
		
	}
     public  void waitForElementInvisibility(String StringParam) throws Exception {
		
		  try {
			String ObjectName = StringParam;
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
					.withTimeout(Duration.ofMinutes(1))   
					.pollingEvery(Duration.ofSeconds(1))   
					.ignoring(NoSuchElementException.class);	
	
			test.info("Waiting for the Element Invisibility "+ ObjectName);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ObjectName)));
		}
			catch(Exception e) {
					String error = captureScreenshot("error");
					System.out.println(error);
					test.fail("Wait for element not invisibility");
					System.out.println("element continuously visible ");
					//test.log(LogStatus.INFO,test.addScreenCapture(error)+"doubleClick failed");
					try {
						test.log(Status.FAIL,
								"failed to view invisibility " + StringParam + test.addScreenCaptureFromPath(captureScreenshot(StringParam)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
	
			}	}
	}
		
	public void launchMailinator() {
		driver.get("https://www.mailinator.com/");

	}
	
	public void refresh(String desc) throws IOException {
		try {
			driver.navigate().refresh();
			test.pass("refresh"+ desc);
		}
		catch (Exception e) {
	    e.printStackTrace();
			System.out.println("not Refreshed on " + desc);
			test.fail("not Refreshed on " + desc);
			try {
				test.log(Status.FAIL,
						"Refresh failed " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
     }
			
	
	
	public String getCurrentWindow() {
		return driver.getWindowHandle();
	}
	
	
	
      public List<WebElement> getWebElement (String ObjectName){
		
		List<WebElement> element = driver.findElements(By.xpath(ObjectName));
		return element;
		
		
		
	}
      public int dateDifference (String firstDate, String secondDate) throws Exception{
  		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
  		// 1st date:
  		Date date = formatter.parse(firstDate);

  		// 2nd date:
  		Date date1 = formatter.parse(secondDate);
  		
  		// difference
  		int diffInDays = (int)( (date.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) );
  		return diffInDays;
  	}
      public String getCurrentDate() {
  		Calendar cal = Calendar.getInstance();
  		int day = cal.get(Calendar.DATE);
  		int month = cal.get(Calendar.MONTH) + 1;
  		int year = cal.get(Calendar.YEAR);
  		String datevalue=day+"/"+month+"/"+year;
  		datevalue=datevalue.replaceAll("/", "-");
  		return datevalue;
  	}
      
	//getText
		public String getText(String locator,String desc) throws IOException{
			try{
				String value= driver.findElement(By.xpath(locator)).getText();
				test.pass("get text passed "+ desc);
				System.out.println("sucessfully get text of" + desc);
				return value;
			} 
			 catch (Exception e) {
					e.printStackTrace();
					System.out.println("failed to get text of" + desc);
					test.fail("failed to get text"+e);
					try {
						test.log(Status.FAIL,
								"not clicked " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	throw new WebDriverException(e);

		        }
	    }
		        
	    
	
			
		
		//getCSSValue
		public String getCSSValue(String locator,String attribute, String desc) throws IOException{
			String value=null;
			try{
				value= driver.findElement(By.xpath(locator)).getCssValue(attribute);
				test.pass("Sucessfully get the CSS Value"+ desc);

			} 
			catch(Exception e) {
				String error = captureScreenshot1();
				test.fail("getCSSValue failed"+ error);
				//test.log(LogStatus.INFO,test.addScreenCapture(error)+"getAttribute failed");
				test.log(Status.FAIL,
						"not clicked " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
				throw new WebDriverException(e);
			}
			return value;
		}
		
		
	public void clickAndWait2(WebElement element, String elementName) {
		try {
			// explicitWait().until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			System.out.println("sucessfully clicked " + elementName);
			test.pass("sucessfully clicked " + elementName);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not clicked on " + elementName);
			test.fail("not clicked on " + elementName);
			try {
				test.log(Status.FAIL,
						"not clicked " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void clickAndWait(String locator,String desc) throws IOException {
		try {
			driver.findElement(By.xpath(locator)).click();
			Thread.sleep(2000);
			test.pass("sucessfully clicked " +locator);
			System.out.println("successfully clicked ON " + desc);

		}
	  catch (Exception e) {
		//e.printStackTrace();
		System.out.println("successfully clicked ON " + desc);
		test.fail("not clicked ON " + desc);
		test.log(Status.FAIL,
					"not clicked " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			         e.printStackTrace();
		    }
	    }

	
	public void typeAndWait(String locator,String textToType, String desc) throws IOException {
		try {
			driver.findElement(By.xpath(locator)).sendKeys(textToType);
			Thread.sleep(1000);
			test.pass("pass type text"+ desc);
		}

		catch(Exception e) {
			String error = captureScreenshot1();
			test.fail("Type failed"+ error);
			test.log(Status.FAIL, "text entering failed " +desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
		}	
	}

	public String getAttribute(String locator,String attribute, String desc) throws IOException{
		String value=null;
		try{
			value= driver.findElement(By.xpath(locator)).getAttribute(attribute);
			test.pass("Sucessfully get the Attribute of " +attribute);
		} 
		catch (Exception e) {
			test.fail("unableto get the Attribute of"+desc);
			test.log(Status.FAIL, "getfaild attribute " +desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			e.printStackTrace();
			throw new WebDriverException(e);
		}
		return value;
	}
	
	public void goBack(String location) throws IOException {
		try {
			driver.navigate().back();
			test.pass("sucessfully navigate back"+ location);
		}
		catch (Exception e) {
			 e.printStackTrace();
				System.out.println("not navigate "+ location);
				test.fail("not scrollIntoView ");
				
		}		
	}
	public void escape() throws IOException {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			System.out.println("sucessfully Escape done");
		}
		catch (Exception e) {
			 e.printStackTrace();
				System.out.println("sucessfully Escape not happen");
				test.fail(" ");
				
		}		
	}
	public void tableData(String ObjectName,String Texttomatch,String Columnnumber) {
		List<WebElement> tablerow = driver.findElements(By.xpath(ObjectName));
		
		for(int i = 1;i<=tablerow.size();i++) {
			String row = ObjectName+"["+i+"]"+"/mat-cell["+Columnnumber+"]";
			if(driver.findElement(By.xpath(row)).getText().equalsIgnoreCase(Texttomatch)) {
				driver.findElement(By.xpath(row)).click();
				break;
			}
		}
	}
	public void waitForElement(int timeinSeconds,WebElement element, String elementName) throws IOException{
		try{
			WebDriverWait wait=new WebDriverWait(driver, timeinSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			test.pass("Waiting for the Element visibility "+elementName);
		}
		catch (Exception e) {
			
			
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"waitForElement failed");
			test.fail("Waiting for the Element visibility "+elementName);
			test.log(Status.FAIL, "getfaild attribute " +elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			e.printStackTrace();
			throw new WebDriverException(e);
		}
	}
	 /**
     * This method is used to Wait until an element is no longer attached to the DOM.
     * @param StringParam
     * @throws Exception
     */

    public  void waitForElementstaleness(WebElement element) throws Exception {

  	  try {


  		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
  				  .withTimeout(Duration.ofMinutes(1))   
  				  .pollingEvery(Duration.ofSeconds(1))   
  				  .ignoring(NoSuchElementException.class);	

  		  test.info("Waiting for the Element staleness "+ element);
  		  wait.until(ExpectedConditions.stalenessOf(element));

  	  }
  	  catch(Exception | Error e) {
  		 // String error = captureScreenshot();
  		 // test.writeInfo("Wait for element staleness", error);
			test.log(Status.FAIL, "getfaild attribute " +element + test.addScreenCaptureFromPath(captureScreenshot("element")));
			e.printStackTrace();

			throw new WebDriverException(e);
  	  }

    }      


	public void waitForElement1(int timeinSeconds,String locator, String desc) throws IOException{
		try{
			WebDriverWait wait=new WebDriverWait(driver, timeinSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			test.pass("sucessfully waitForElement"+ desc);
			System.out.println("sucessfully waitForElement"+ desc);
		}
		catch(Exception | Error e) {
			System.out.println("failed to waitForElement"+ desc);
			String error = captureScreenshot1();
			test.fail("waitForElement failed"+ error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"waitForElement failed");
			test.log(Status.FAIL, "getfaild attribute " +desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			e.printStackTrace();

		}
	}
public void waitForElementVisibility(WebElement element, String elementName) throws Exception {
		
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
					.withTimeout(Duration.ofMinutes(3))   
					.pollingEvery(Duration.ofSeconds(1))   
					.ignoring(NoSuchElementException.class);	
			System.out.println("waiting for element to visible "+elementName);
			test.info("Waiting for the Element visibility "+ elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			}
		 catch (Exception e) {
			 test.info("failed Element visibility "+ elementName);
			 System.out.println("unable to waiting for element to visible "+elementName);
			// test.fail("failed element visibility ");
			 test.log(Status.FAIL, "failed ElementVisibility " +elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
				e.printStackTrace();
				//System.out.println("unable to waiting for element to visible "+elementName);				
			}	
	}




public void waitForElementVisibility1(String locator) throws Exception {
	
	try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
				.withTimeout(Duration.ofMinutes(3))   
				.pollingEvery(Duration.ofSeconds(1))   
				.ignoring(NoSuchElementException.class);	
		System.out.println("element visible"+locator);

		test.info("Waiting for the Element visibility "+ locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
	 catch (Exception e) {
		 System.out.println("not visible " + locator);
			test.info("not clicked ON " + locator);
			//String error = captureScreenshot1();
			//test.fail("Click failed"+ error);
			test.log(Status.FAIL, "not clicked " +locator + test.addScreenCaptureFromPath(captureScreenshot(locator)));
			e.printStackTrace();

			}
     }

public void waitForElementPresent(String ObjectName) throws IOException {

	try {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
			.withTimeout(Duration.ofMinutes(3))   
			.pollingEvery(Duration.ofSeconds(1))   
			.ignoring(NoSuchElementException.class);	

	test.info("Waiting for the Element Present "+ ObjectName);
	System.out.println("element present"+ObjectName);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectName)));
	}
	catch (Exception e) {
		
		test.info("Element no present"+e);
		System.out.println(" waiting for element to visible failed "+ObjectName);				
		test.fail("waiting for element to visible failed "+ObjectName);	
		test.log(Status.FAIL, "waiting failed " +ObjectName + test.addScreenCaptureFromPath(captureScreenshot(ObjectName)));
		e.printStackTrace();
		throw new WebDriverException(e);
	}	
}

public void waitForElementPresent_long(String ObjectName) throws IOException {

	try {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
			.withTimeout(Duration.ofMinutes(7))   
			.pollingEvery(Duration.ofSeconds(1))   
			.ignoring(NoSuchElementException.class);	

	test.info("Waiting for the Element Present "+ ObjectName);
	System.out.println("element present"+ObjectName);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectName)));
	}
	catch (Exception e) {
		
		test.info("Element no present"+e);
		System.out.println(" waiting for element to visible failed "+ObjectName);				
		test.fail("waiting for element to visible failed "+ObjectName);	
		test.log(Status.FAIL, "waiting failed " +ObjectName + test.addScreenCaptureFromPath(captureScreenshot(ObjectName)));
		e.printStackTrace();
		throw new WebDriverException(e);
	}	
}
public void waitForTextPresent(String locator, String text) throws Exception {
	try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
				.withTimeout(Duration.ofMinutes(1))   
				.pollingEvery(Duration.ofSeconds(1))   
				.ignoring(NoSuchElementException.class);	
		System.out.println("sucessfully waited" + text);

		test.info("Waiting for the Text Present "+ locator);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(locator),text));
	
		}
		catch(Exception | Error e) {
			System.out.println("failed to waited" + text);
			//String error = captureScreenshot();
			//test.writeInfo("waiting for text to be present", error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"doubleClick failed");
			test.info("Waiting for the Text Present Failed "+ text);
			test.log(Status.FAIL, "Waiting for the Text Present Failed " +text + test.addScreenCaptureFromPath(captureScreenshot(text)));
			e.printStackTrace();
			throw new WebDriverException(e);
		}
}


  public void waitForFrameAvaiableandSwitch(String frameLocator) throws IOException {
	
	try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)    
				.withTimeout(Duration.ofMinutes(1))   
				.pollingEvery(Duration.ofSeconds(1))   
				.ignoring(NoSuchElementException.class);	

		test.info("Waiting for Frame and switch to it "+ frameLocator);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
	}
		catch (Exception e) {
			test.log(Status.FAIL, "not clicked " +frameLocator + test.addScreenCaptureFromPath(captureScreenshot(frameLocator)));
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"doubleClick failed");
			System.out.println("Waiting for Frame failed "+frameLocator);				
			//test.fail("not scrollIntoView ");
			throw new WebDriverException(e);
		}	
   }
  
    public void setWindow(String handle) {
		driver.switchTo().window(handle);
	}
    
	public void DrawBoarder(WebElement element, String elementName) {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			System.out.println("sucessfully DrawBorder");
			test.pass("sucessfully DrawBorder ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not able to DrawBorder  " );
			test.fail("not able to DrawBorder " );
					}

	}
	public void reloadpage() {
		driver.navigate().refresh();
	}
//	public void genrateAlert(WebElement element, String message) {
//		try {
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].style.border='3px solid red'", message);
//			System.out.println("sucessfully display alert message");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("not able to display alert message");
//					}
//
//	}

	
	public void scrollByElement(WebElement element, String elementName) {
		try {
			explicitWait().until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			System.out.println("sucessfully scrollIntoView " + elementName);
			test.pass("sucessfully scrollIntoView " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not scrollIntoView " + elementName);
			test.fail("not scrollIntoView " + elementName);
			try {
				test.log(Status.FAIL, "not scrollIntoView " +elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	public void scrollToView1(WebElement element,String desc) throws IOException {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
			test.pass(Status.PASS+ desc);

			//Thread.sleep(1000);
		} 
		catch(Exception | Error e) {
			String error = captureScreenshot1();
			test.fail("scrollToView failed"+ error);
			test.log(Status.INFO,test.addScreencastFromPath(error)+"scrollToView failed");
			throw new WebDriverException(e);
		}

	}
	public void scrollBybottom() {
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);
			System.out.println("sucessfully scrollIntoView ");
			test.pass("sucessfully scrollIntoView ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not scrollIntoView ");
			test.fail("not scrollIntoView ");
			
		}

	}
	public void close(String desc) throws IOException {
		try {
			driver.close();
			test.pass(desc);
		}
		catch (Exception e)  {


			test.fail("close failed" );
			
			throw new WebDriverException(e);
		}		
	}
	

		/*	public void selectDate(String dateVal ) {
				// dynamic - date selection
						String monthYearDisplayed = driver.findElement(("monthyear_css")).getText();
		
						
						System.out.println("monthYearDisplayed -"+monthYearDisplayed);
						SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
						try {
							Date dateToBeSelected = sd.parse(dateVal);
							Date currentDate = new Date();
							String day = new SimpleDateFormat("d").format(dateToBeSelected);
							System.out.println(day);
							String month= new SimpleDateFormat("MMMM").format(dateToBeSelected);
							System.out.println(month);
							String year= new SimpleDateFormat("yyyy").format(dateToBeSelected);
							System.out.println(year);
							String monthYearToBeSelected = month+" "+year;
							System.out.println("monthYearToBeSelected -"+monthYearToBeSelected);
							
							while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
								// click on forward or back icon
								if(dateToBeSelected.compareTo(currentDate) == 1) {//
									//forward icon
									driver.findElement(getObjectLocator("calendar_forward_xpath")).click();
								}else if(dateToBeSelected.compareTo(currentDate) == -1){
									// back icon
									driver.findElement(getObjectLocator("calendar_back_xpath")).click();
								}
								 monthYearDisplayed = driver.findElement(getObjectLocator("monthyear_css")).getText();
							     System.out.println("monthYearDisplayed -"+monthYearDisplayed);
							     
							}
							
							 //day
						     driver.findElement(By.xpath("//a[text()='"+day+"']")).click();

						}catch (Exception e) {
							
							e.printStackTrace();
						}
						
			}*/
			
	//pressKey
		public void pressKey(String locator,Keys keyName,String...key) throws IOException
		{
			try {		
				driver.findElement(By.xpath(locator)).sendKeys(keyName);	
				test.pass("Successfully pressed key "+key[0]);
			}

			catch(Exception e) {
				String error = captureScreenshot1();
				test.fail("pressKey failed"+ error);
				//test.log(LogStatus.INFO,test.addScreenCapture(error)+"pressKey failed");
				test.fail("Status.FAIL"+ e);
				throw new WebDriverException(e);
			}
		}



	
	public String isDisplayed(WebElement element, String elementName) {
		boolean displayElement;

		try {
			explicitWait().until(ExpectedConditions.visibilityOf(element));
			displayElement = element.isDisplayed();
			System.out.println("successfully displayed " + elementName);
			test.pass("successfully displayed " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not displayed " + elementName);

			try {
				test.log(Status.FAIL, "not displayed " + elementName+ test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
			}

		}
		return elementName;
	}
	//isDisplayed_encash
		public boolean isDisplayed1(String locator, String desc) throws IOException{
			boolean isDisplayed=false;
			try{
				isDisplayed = driver.findElement(By.xpath(locator)).isDisplayed();
				test.pass("successfully displayed Element" + desc);
			
			} 
			catch(Exception e) {
				//String error = captureScreenshot();
				test.fail("Element not displayed"+e);
				test.log(Status.FAIL, "not displayed " + desc+ test.addScreenCaptureFromPath(captureScreenshot(desc)));

				//test.log(LogStatus.INFO,test.addScreenCapture(error)+"isDisplayed failed");
				//test.writeLog(Status.INFO, e);
				throw new WebDriverException(e);
			    }
			return isDisplayed;
	          }

		/**
		 * Checks if the given button is enabled
		 * @param xpath
		 * @return
		 */
		public boolean isButtonEnabled(String xpath) {
			return driver.findElement(By.xpath(xpath)).isEnabled();
		}

		public void clear(String locator, String desc) throws IOException {		
			try{
				driver.findElement(By.xpath(locator)).clear();
				test.pass("sucessfully cleared"+ desc);
			}
			catch(Exception | Error e) {
				String error = captureScreenshot1();
				test.fail("clear failed"+ error);
				//	test.log(LogStatus.INFO,test.addScreenCapture(error)+"clear failed");
				try {
					test.log(Status.FAIL, "not cleared " + desc+ test.addScreenCaptureFromPath(captureScreenshot(desc)));
				} catch (IOException e1) {
				}
				throw new WebDriverException(e);
			}
		}

		//Sometimes the clear option doesnt work. Alternatively, this method is uses the Sendkeys to clear.
		public void clearAlt(String locator, String desc) throws IOException {		
			try{
				
				WebElement element=driver.findElement(By.xpath(locator));
				element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				test.pass("successfully cleared"+ desc);
			}
			catch(Exception | Error e) {
				String error = captureScreenshot1();
				test.fail("clear failed"+ error);
				//	test.log(LogStatus.INFO,test.addScreenCapture(error)+"clear failed");
				try {
					test.log(Status.FAIL, "not cleared " + desc+ test.addScreenCaptureFromPath(captureScreenshot(desc)));
				} catch (IOException e1) {
				}
				throw new WebDriverException(e);
			}
		}

		
	public   boolean isDisplayed2(String locator, String desc) throws IOException{
		boolean isDisplayed=false;
		try{
			isDisplayed = driver.findElement(By.xpath(locator)).isDisplayed();
			System.out.println("successfully displayed " + desc);
			test.pass("successfully displayed " + desc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not displayed " + desc);
           throw new WebDriverException(e);
           
		}
		return isDisplayed;
	}
	

	public void assertTrue(boolean element1, String elementName) throws IOException
	{		
		try{
			Assert.assertFalse(element1);
			System.out.println("text validated");
			test.pass("<br>"+elementName+"</br>"+" Expected :  true and Actual : "+element1);			
		} 
		catch(Exception  e) {
			
			test.fail("assertTrue failed");
			System.out.println("text not validated");
			test.log(Status.FAIL,
					"not clicked " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			throw new WebDriverException(e);
			
		}
	}
	public void assertTrue1(Boolean inputCondition, String desc) throws IOException
	{		
		try{
			Assert.assertTrue(inputCondition);
			test.pass("<br>"+inputCondition+"</br>"+" Expected :  true and Actual : "+inputCondition);					
		} 
            catch(Exception  e) {
			
			test.fail("assertTrue failed");
			System.out.println("text not validated"+e);
			test.log(Status.FAIL,
					"both conditions mismatched  " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
			
		}
	}
	public void selectByIndex(String locator, int index, String desc) throws IOException {
		try{

			Select droplist = new Select(driver.findElement(By.xpath(locator)));
			droplist.selectByIndex(index);			
			test.pass("Select the index"+ desc+locator+index);
		}
		catch(Exception e) {
			String error = captureScreenshot1();
			test.fail("selectByIndex failed"+ error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"selectByIndex failed");
			test.log(Status.FAIL,
					"both conditions mismatched  " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
		}
	}

	//selectByValue, selectByVisibleText, selectByIndex
		public void selectByVisibleText1(String locator, String label, String desc) throws IOException {
			try{

				Select droplist = new Select(driver.findElement(By.xpath(locator)));
				
				droplist.selectByVisibleText(label);			
				test.pass(" select the VisibleText" +desc);
			}
			catch(Exception e) {
				test.fail("selecyByVisibleText failed"+ e);
				//test.log(LogStatus.INFO,test.addScreenCapture(error)+"selecyByVisibleText failed");
				test.log(Status.FAIL,
						"selecyByVisibleText failed" + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
				throw new WebDriverException(e);
			}
		}
		public boolean isChecked(String locator,String desc) throws IOException {

			boolean value = false;
			try{
				value=driver.findElement(By.xpath(locator)).isSelected();
				test.pass("sucessfully uncheked"+ desc);
				return value;
			}
			catch(Exception e) {
				String error = captureScreenshot1();
				test.fail("uncheck failed"+ error);
				//test.log(LogStatus.INFO,test.addScreenCapture(error)+"uncheck failed");
				test.log(Status.FAIL,
						"selecyByVisibleText failed" + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
				throw new WebDriverException(e);
			}
		}

	
	public void assertFalse(Boolean inputCondition, String desc) throws IOException
	{		
		try{
			Assert.assertFalse(inputCondition);
			test.pass( "<br>"+desc+"</br>"+" Expected :  false and Actual : "+inputCondition);			
		} 
		catch(Exception e) {
			String error = captureScreenshot1();
			test.fail("assertFalse failed"+ error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"assertFalse failed");
			test.log(Status.FAIL,
					"not clicked " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
		}
	}

	public void isenabled(WebElement element, String elementName) {
		boolean displayElement;

		try {
			explicitWait().until(ExpectedConditions.visibilityOf(element));
			displayElement = element.isEnabled();
			System.out.println("Element is enabled " + elementName);
			test.pass("Element is enabled " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not enabled " + elementName);

			try {
				test.log(Status.FAIL, "not enabled " + elementName+ test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
			}

		}
	}
	
	public void isselected(WebElement element, String elementName) {
		boolean displayElement;

		try {
			explicitWait().until(ExpectedConditions.visibilityOf(element));
			displayElement = element.isSelected();
			System.out.println("Element is selected " + elementName);
			test.pass("Element is selected " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not selected " + elementName);

			try {
				test.log(Status.FAIL, "not selected " + elementName+ test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
			}

		}
		
	}


	public void text(WebElement element, String textInput, String elementName) throws IOException {
		try {
			// explicitWait().until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(textInput);
			System.out.println("successfully entered " + elementName);
			test.pass("successfully entered " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("data not entered " + elementName);
			try {
				test.log(Status.FAIL,
						"text enter failed " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
			} catch (IOException e1) {
			}
		}
	}
	
	public String jsGetTextById(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String value= (String) jse.executeScript("return arguments[0].value", element);
		return value;
	}
	
	public void clearAndType(WebElement element, String textInput, String elementName) throws IOException {		
		try{
			clear(element, elementName);
			text(element, textInput, elementName);
			test.pass("sucessfully clear and enter the text"+elementName);
		}
			
			
		catch(Exception e) {
			String error = captureScreenshot1();
			test.fail("clearAndType failed"+ error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"clearAndType failed");
			test.log(Status.FAIL,
					"type failed " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));	
			throw new WebDriverException(e);
		}
	}
	public void type1(String locator,String textToType, String desc) throws IOException {
		try {
			driver.findElement(By.xpath(locator)).sendKeys(textToType);
			test.pass(desc);
			
		}

		catch(Exception e) {
			String error = captureScreenshot1();
			//test.writeInfo("Type failed", error);
			test.log(Status.FAIL,
					"type failed " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
		}
		}		
	
	public WebElement getElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	}
	
	public void dragAndDrop(WebElement source, WebElement target) throws IOException {
		Actions dragdrop = new Actions(driver);
		
		dragdrop.clickAndHold(source).build().perform();
	    dragdrop.moveByOffset(0,10).build().perform();
	    dragdrop.moveToElement(target).build().perform();
	    dragdrop.release().build().perform();
	    target.click();
	}
	

	/**
	 * This method is used to select the calendar 
	 * @param locator
	 * @param select
	 */
	public void datePicker(String locator, String select) {
		
		List<WebElement> elements = getWebElement(locator);
		
		for(WebElement calender : elements) {
			if(calender.getText().equalsIgnoreCase(select)) {
				calender.click();
				break;
			}
				
		}
	}
	
	public void assertContains(String fullText, String expectedText, String desc) throws IOException
	{	
		if (fullText.contains(expectedText))
			test.log(Status.PASS, "<br>"+desc+"</br>"+ "The given text contains the expected text. Full Text : "+fullText+" . Expected Containg Text : "+expectedText);		
		else {
			String error = captureScreenshot1();
			test.info("assertContains failed"+ error);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"assertContains failed");
			test.log(Status.FAIL, "<br>"+desc+"</br>"+ "The given text doesn not contain the expected text. Full Text : "+fullText+" . Expected Containg Text : "+expectedText);	
			throw new WebDriverException("assertContains - "+desc+" - Full Text : "+fullText+". Expected Contaning Text : "+expectedText);
		}
	}
	
	public void scrollToView(String locator,String desc) throws IOException {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
			test.pass("scrollToView"+ desc);
            System.out.println("successfully scroll into view"+desc);
			Thread.sleep(1000);
		} 
		catch(Exception e) {
			//String error = captureScreenshot1();
            System.out.println("failed to scroll into view"+desc);
		    test.fail(" Not Able to scrollToView "+ e);
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"scrollToView failed");
			test.log(Status.FAIL,
					"not scrollToView " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
			throw new WebDriverException(e);
		}

	}
	public void jsClick(String locator,String stepDescription) throws IOException{
		try{
			JavascriptExecutor jse = (JavascriptExecutor)driver;            
			jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(locator)));
		}
		catch(Exception e) {
			//String error = captureScreenshot();
			test.fail("JSclick failed"+ e);
			test.log(Status.FAIL,
					"not clicked " + stepDescription + test.addScreenCaptureFromPath(captureScreenshot(stepDescription)));
			throw new WebDriverException(e);
		}

	}

	
	public void clearAndType(String locator, String textToType, String desc) throws IOException {		
		try{
			clear1(locator, desc);
			type1(locator, textToType, desc);
			test.pass(desc);
		}
		catch(Exception e) {
			//String error = captureScreenshot();
			test.fail("clearAndType failed");
			//test.log(LogStatus.INFO,test.addScreenCapture(error)+"clearAndType failed");
			//test.writeLog(Status.FAIL, e);
			throw new WebDriverException(e);
		}
	}

	
	public String captureScreenshot(String locatorName) throws IOException {
		String filepath = screenshotfolder + locatorName + ".png";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(filepath));
		return filepath;
	}
	
	
	public String captureScreenshot1() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File f = new File(scrFile.toString()+File.separator+"Screenshots");
		f.mkdir();

		File Dest = new File(f + File.separator + System.currentTimeMillis() +".png");
		//String errflpath = Dest.getAbsolutePath();
		String filepath = screenshotfolder + " nothing"+".png";
		Files.copy(scrFile, Dest);
		System.out.println(filepath);
		return filepath;
	}
	
	public int getXpathCount(String locator,String desc) throws IOException{
		int value=0;
		
		try{
			List<WebElement> xpathCount = driver.findElements(By.xpath(locator));
			value = xpathCount.size();
	}
		catch (Exception e){
			
		throw new WebDriverException(e);
		}
		
		return value;
	}

	
	public void mouseHover(WebElement element, String elementName) {
		try {
		explicitWait().until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

		System.out.println("sucessfully hovered on the " + elementName);
		test.pass("sucessfully hovered on the " + elementName);

		// test.pass("sucessfully clicked on " + elementName);
		} catch (Exception e) {
		System.out.println("unable to hover" + elementName);
		test.fail("unable to hover" + elementName);
		e.printStackTrace();
		Assert.fail();

		}
		}

		public void selectByvalue(WebElement element, String elementName) {
		try {
		explicitWait().until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByValue(elementName);

		System.out.println("sucessfully selected the value " + elementName);
		test.pass("sucessfully selected the value " + elementName);

		// test.pass("sucessfully clicked on " + elementName);
		} catch (Exception e) {
		System.out.println("unable to select the value " + elementName);
		test.fail("unable to select the value " + elementName);
		e.printStackTrace();
		Assert.fail();

		}
		}


		public void selectByText(WebElement element, String elementName) {
		try {
		explicitWait().until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(elementName);

		System.out.println("sucessfully selected the text " + elementName);
		test.pass("sucessfully selected the value " + elementName);

		// test.pass("sucessfully clicked on " + elementName);
		} catch (Exception e) {
		System.out.println("unable to select the text " + elementName);
		test.fail("unable to select the value " + elementName);
		e.printStackTrace();
		Assert.fail();

		}
		}

		public void selectByIndex(WebElement element, int x) {
		try {
		explicitWait().until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByIndex(x);

		System.out.println("sucessfully selected the value " + x);
		test.pass("sucessfully selected the value " + x);

		// test.pass("sucessfully clicked on " + elementName);
		} catch (Exception e) {
		System.out.println("unable to select the value " + x);
		test.fail("unable to select the value " + x);
		e.printStackTrace();
		Assert.fail();

		}
		}

	
		public void waitTime() {
			try {
			Thread.sleep(2000);
			} catch (Exception e) {
			}
			}
		
		
		public void long_waitTime() {
			try {
			Thread.sleep(15000);
			} catch (Exception e) {
			}
			}
		
		
		public void mouseHoverAndClick(WebElement element, String elementName) {
			try {
				explicitWait().until(ExpectedConditions.visibilityOf(element));
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				actions.click().build().perform();
				
				System.out.println("sucessfully hovered on the " + elementName);
				test.pass("sucessfully hovered on the " + elementName);

				// test.pass("sucessfully clicked on " + elementName);
			} catch (Exception e) {
				System.out.println("unable to hover" + elementName);
				test.fail("unable to hover" + elementName);
				e.printStackTrace();
				Assert.fail();

			}
		}
		public void rightClick(WebElement element, String elementName) throws IOException
		{
			try {
				Actions action = new Actions(driver);
				action.contextClick().build().perform();
				test.pass("sucessfully right click on the " + elementName);

			}
			catch (Exception e) {
				System.out.println("unable to hover" + elementName);
				test.fail("not clicked on the" + elementName);
				e.printStackTrace();
				Assert.fail();

			}}
		public void doubleClick(WebElement element, String elementName) throws IOException
		{
			try {
				Actions action = new Actions(driver);
				action.doubleClick().build().perform();
				test.pass("sucessfully double click on the " + elementName);

			}
			catch (Exception e) {
				System.out.println(" not double " + elementName);
				test.fail("not double clicked on the" + elementName);
				e.printStackTrace();
				Assert.fail();

			}}
		public void mouseRightClick(WebElement element, String elementName) {
			try {
				explicitWait().until(ExpectedConditions.visibilityOf(element));
				Actions actions = new Actions(driver);
				actions.contextClick(element).build().perform();
				
				System.out.println("sucessfully right on the " + elementName);
				test.pass("sucessfully hovered on the " + elementName);

				// test.pass("sucessfully clicked on " + elementName);
			} catch (Exception e) {
				System.out.println("unable to right click" + elementName);
				test.fail("unable to hover" + elementName);
				e.printStackTrace();
				Assert.fail();

			}
		}


		public void exceptionalWindowHandle() {
			for (String handle : driver.getWindowHandles()) {
				try {
					driver.switchTo().window(handle);
				} catch (NoSuchWindowException e) {
					System.out.println("an exceptional case");}}
		}
		
			public void exceptionalWindowHandle1() {
				for (String handle : driver.getWindowHandles()) {
					try {
					String wind = driver.switchTo().window(handle).getTitle();
					System.out.println("windowid"+wind);
					} catch (NoSuchWindowException e) {
						System.out.println("an exceptional case");}}
							
				} 
			
			public void exceptionalWindowHandle2(String title) {
				for (String handle : driver.getWindowHandles()) {
					String wind = driver.switchTo().window(handle).getTitle();
					if(wind.equalsIgnoreCase(title)) {
						driver.close();
						}
					}
				} 
			public void exceptionalWindowHandle3(String title) {
				for (String handle : driver.getWindowHandles()) {
					String wind = driver.switchTo().window(handle).getTitle();
					System.out.println(wind);
					if(wind.contains(title)) {
						driver.close();
						}
					}
			
			}
			
		
		public void switchtomain()
		{
			for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
			
		}

}
		public void alertAccept() {
			boolean present = false;
			try {
				Alert alert = driver.switchTo().alert();
				present = true;
				System.out.println(alert.getText());
				test.pass("The alert is- " + alert.getText());
				alert.accept();

			} catch (NoAlertPresentException ex) {
//				ex.printStackTrace();
				System.out.println(present);
			}
	
		}
		public void alertDismiss() {
			boolean present = false;
			try {
				Alert alert = driver.switchTo().alert();
				present = true;
				System.out.println(alert.getText());
				test.pass("The alert is- " + alert.getText());
				alert.dismiss();

			} catch (NoAlertPresentException ex) {
//				ex.printStackTrace();
				System.out.println(present);
				
			}
	
		}

		public static String getCurrentDay() {
			// Create a Calendar Object Calendar
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); // Get Current Day as a number
			int todayInt = calendar.get(Calendar.DAY_OF_YEAR);
			System.out.println("Today Int: " + todayInt + "\n");
			// Integer to String Conversion
			String todayStr = Integer.toString(todayInt);
			// System.out.println("Today Str: " + todayStr + "\n");
			return todayStr;
		}
		
		
		public void verifyText(String actualResult, String ExpectedResult) throws IOException {

			try {
				if (actualResult.equalsIgnoreCase(ExpectedResult)) {

					System.out.println("text verified successfully " + actualResult + " with " + ExpectedResult);
					test.pass("text verified successfully " + actualResult + " with " + ExpectedResult);
				}
			} catch (Exception e) {
				System.out.println("text not verified" + actualResult + " with " + ExpectedResult);
				
					test.log(Status.FAIL, "text not verified\" +actualResult +\" with \" +ExpectedResult"
							+ test.addScreenCaptureFromPath(captureScreenshot(actualResult)));
								e.printStackTrace();
				                Assert.fail();
			}
		}
		public void assertEquals(Object actual, Object expected, String desc) throws IOException 
		{		
			try{
				Assert.assertEquals(actual, expected);
				test.pass("<br>"+""+"</br>"+" - Expected Value : "+expected+" and Actual Value : "+actual);
				System.out.println("text verified" + expected + " with " + actual);
			} 
		catch (Exception e) {
				System.out.println("text not verified" +e);

				try {
					test.log(Status.FAIL, "not enabled " + desc+ test.addScreenCaptureFromPath(captureScreenshot(desc)));
				} catch (IOException e1) {
				
				test.log(Status.FAIL, "text not verified\" +actualResult +\" with \" +ExpectedResult"
						+ test.addScreenCaptureFromPath(captureScreenshot(desc)));
				        e1.printStackTrace();

			}}
			
		}
		public static String captcha() {
			String CaptchaCode = JOptionPane.showInputDialog("Enter CODE Here");
			
				return CaptchaCode;
		}

		public String mainwindow() {
			// Get handles of the windows
			String mainWindowHandle = driver.getWindowHandle();

			return mainWindowHandle;
		}

		
		
		public void windowHandle() {
			waitTime();
			Set<String> allWindowHandles = driver.getWindowHandles();

			Iterator<String> iterator = allWindowHandles.iterator();
			// Here we will check if child window has other child windows and will fetch the
			// heading of the child window
			while (iterator.hasNext()) {

				ChildWindow = iterator.next();
				 System.out.println("Main Window" + mainwindow());
				System.out.println("child Window" + ChildWindow);
				// System.out.println("child Window" +
				// driver.switchTo().window(ChildWindow).getTitle();
				if (!mainwindow().equalsIgnoreCase(ChildWindow)) {
					System.out.println("@@@@@@@@@@@@@@@" + ChildWindow);
					driver.switchTo().window(ChildWindow);
					//driver.switchTo().window(allWindowHandles);
				}
			}
			}
		
		
			
			public void clickwithoutJS(WebElement element, String elementName) {
				try {
					// explicitWait().until(ExpectedConditions.visibilityOf(element));
					element.click();
					System.out.println("sucessfully clicked " + elementName);
					test.pass("sucessfully clicked " + elementName);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("not clicked on " + elementName);
					test.fail("not clicked on " + elementName);
					try {
						test.log(Status.FAIL,
								"not clicked " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}


				    public void clickAndHold(WebElement element, String elementName,int x,int y) throws IOException {
					try {
						explicitWait().until(ExpectedConditions.visibilityOf(element));
						Actions actions = new Actions(driver);
						actions.moveToElement(element,x,y);
						actions.clickAndHold().moveByOffset(x,y);
						Thread.sleep(2000);
						actions.release().click().perform();
						System.out.println("sucessfully move_offset on the " + elementName);
						test.pass("sucessfully hovered on the " + elementName);
				
						// test.pass("sucessfully clicked on " + elementName);
					} catch (Exception e) {
						System.out.println("unable move_offset to hover" + elementName);
						test.fail("unable to hover" + elementName);
						test.log(Status.FAIL,
								"not clicked " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
						e.printStackTrace();
						
						Assert.fail();
				
					}
				}
				 public void MouseShift(WebElement element, String elementName,int x,int y) throws IOException {
					try {
						explicitWait().until(ExpectedConditions.visibilityOf(element));
						Actions actions = new Actions(driver);
						actions.moveToElement(element,x,y);
						actions.clickAndHold().moveByOffset(x,y);
						Thread.sleep(2000);
						actions.release().click().perform();
						System.out.println("sucessfully move_offset on the " + elementName);
						test.pass("sucessfully hovered on the " + elementName);
				
						// test.pass("sucessfully clicked on " + elementName);
					} catch (Exception e) {
						System.out.println("unable move_offset to hover" + elementName);
						test.fail("unable to hover" + elementName);
						test.log(Status.FAIL,
								"not clicked " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
						e.printStackTrace();
						e.printStackTrace();
						Assert.fail();
				
					  }
					
				      }
				 public void refresh() throws IOException {
						try {
							driver.navigate().refresh();
							test.pass("sucessfully refreshed ");
						}
						catch (Exception e) {
							System.out.println("unable refreshed");
							test.fail("unable to Refresh");
							e.printStackTrace();
							Assert.fail();
						}		
					}
				 public void clear1(String locator, String desc) throws IOException {		
						try{
							driver.findElement(By.xpath(locator)).clear();
							test.pass(desc);
						}
						catch(Exception e) {
							//String error = captureScreenshot();
							test.fail("clear failed");
							test.log(Status.FAIL,
									"not cleared " + desc + test.addScreenCaptureFromPath(captureScreenshot(desc)));
							e.printStackTrace();
							//test.writeLog(Status.FAIL, e);
							throw new WebDriverException(e);
						}
					}
				 
				 public void clear(WebElement element, String elementName) throws IOException {		
						try{
							element.clear();
							test.pass("sucessfully cleared on the "+ elementName);
						}
						catch(Exception  e) {
							System.out.println("unable cleared on the "+ elementName);
							test.fail("unable to clear");
							test.log(Status.FAIL,
									"not cleared " + elementName + test.addScreenCaptureFromPath(captureScreenshot(elementName)));
							e.printStackTrace();
							Assert.fail();
						}	}
				}
