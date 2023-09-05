//package ActionEngine;


	/*Set up Spark Reports: First, make sure you have Spark Reports configured in your Selenium project. Spark Reports is an open-source reporting library that provides enhanced reporting capabilities for Selenium tests.

	Capture Screenshots: Implement a mechanism to capture screenshots when a test fails. This can be done using the WebDriver's built-in screenshot functionality. You can add the following code within your test methods or in a utility class:

	java
	Copy code*/
//	import org.openqa.selenium.OutputType;
//	import org.openqa.selenium.TakesScreenshot;
//	import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import Resuable.ReusableMethods;
//
//import java.io.File;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.hc.core5.http.Method;
//
//public class ScreenshotUtils extends ReusableMethods{
//
//	public ScreenshotUtils(WebDriver driver) {
//		this.driver = driver;
//		// This initElements method will create all WebElements
//		PageFactory.initElements(driver, this);
//		
//		}
//	 
//      	public static ExtentReports extent;
//        public static ExtentTest test;
//        public static WebDriver driver;
//	    public static void captureScreenshot(WebDriver driver, String screenshotName) {
//	        try {
//	            TakesScreenshot ts = (TakesScreenshot) driver;
//	            File source = ts.getScreenshotAs(OutputType.FILE);
//	            String destination = "path/to/screenshots/folder/" + screenshotName + ".png";
//	            FileUtils.copyFile(source, new File(destination));
//	            System.out.println("Screenshot captured: " + screenshotName);
//	        } catch (Exception e) {
//	            System.out.println("Failed to capture screenshot: " + e.getMessage());
//	        }
//	    }
//	
//	
//
////
////	   public void TestClass() {
////	   private static ExtentReports extent;
////	    private static ExtentTest test;
////	    private static WebDriver driver;
////	} 
//	    @BeforeSuite
//	    public void setUp() {
//	        // Initialize Spark Reports
//	        extent = new ExtentReports();
//	    }
//	   
////	    @BeforeMethod
////	    public String startTest(Method method) {
//////	    	String str = new String();
//////	        // Start a new test
//////	        test = extent.startTest(method.getName(), "Test Description");
//////	        // Initialize WebDriver and perform necessary setup
//////	        driver = new FirefoxDriver();
////    }
//	    private transient String name;
//	    private native String initClassName();
//	    public String getName() {
//	    	
//	        String name = this.name;
//	        return name != null ? name : initClassName();
//	    }
//
//
//		@AfterMethod
//	    public void afterMethod(ITestResult result, Object LogStatus) {
//	        // Check if the test failed
//	        if (result.getStatus() == ITestResult.FAILURE) {
//	            // Capture screenshot
//	            String screenshotName = result.getName();
//	            ScreenshotUtils.captureScreenshot(driver, screenshotName);
//	            // Attach the screenshot to the report
//	            test.log(Status.FAIL, "Test Failed"+
//	                    test.addScreenCaptureFromPath("path/to/screenshots/folder/" + screenshotName + ".png"));
//	                    
//	        }
//	        
//	        // Quit the WebDriver and end the test
//	       // driver.quit();
//	       // extent.endTest(test);
//	    }
//	    
//	    @AfterSuite
//	    public void tearDown() {
//	        // Generate the Spark report
//	        extent1.flush();
//	        //extent.close();
//	    }
//	}
	/*Make sure to update the paths and customize the report as per your requirements.

	Run Tests and Generate Report: With the setup complete, you can now run your Selenium tests. The failed tests will automatically capture screenshots and attach them to the Spark report. Once all tests have completed, the report will be generated and saved at the specified location (path/to/spark/report.html).
	Note: Ensure that you have the required dependencies added to your project's build file (e.g., Maven, Gradle) to use Spark Reports and other Selenium dependencies.

	By following these steps, you can capture screenshots for failed tests in Selenium Java*/

