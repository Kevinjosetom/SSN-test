
package ActionEngine;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass  {

	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public ExtentHtmlReporter htmlreoprter;
	public ExtentReports extent;
	public static ExtentTest test;
	public readconfig rconfig = new readconfig();
	public  String chromepath= rconfig.getchromepath();
	public  String url= rconfig.getbaseurl();


	

	
	@BeforeSuite
	@SuppressWarnings("deprecation")
	public void beforeSuite() {
		//WebDriverManager.chromedriver().create();
		//System.setProperty("webdriver.chrome.driver",rconfig.getchromepath());

                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
/*
 * ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
WebDriver driver = new ChromeDriver(options);

 */
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		
                options.addArguments("--headless");
		options.addArguments();
		WebDriver driver = new ChromeDriver(options);
		//driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.get(rconfig.getbaseurl());
	//	driver.get("https://ybc-staging.encashoffers.com/#/");
		//driver.get(appConfiguration.getbaseurl());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		htmlreoprter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Reports\\YBC.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreoprter);

	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		// driver.quit();
	}

	public WebDriverWait explicitWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}
	
	
}


//package ActionEngine;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class BaseClass {
//
//	protected WebDriver driver;
//	protected WebDriverWait wait;
//	public ExtentHtmlReporter htmlreoprter;
//	public ExtentReports extent;
//	public static ExtentTest test;
//
//	//@SuppressWarnings("deprecation")
//	@Parameters({"browser"})
//	@BeforeTest
//		public void setup(String browser) throws Exception{
//		if(browser.equalsIgnoreCase("firefox")){
//			System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			System.out.println("successfully open the firefox browser");
//
//	   }
//		else if(browser.equalsIgnoreCase("chrome")){
//			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
//		driver = new ChromeDriver();
//		System.out.println("successfully open the chrome browser");
//
//	   }
//		else if(browser.equalsIgnoreCase("Edge")){
//			System.setProperty("webdriver.edge.driver", "G:\\msedgedriver.exe");
//					driver = new EdgeDriver();
//					System.out.println("successfully open the edge browser");
//	   }
//		
//		driver.get("https://www.redbus.com/");
//		driver.manage().window().maximize();
//		//driver.get("https://www.redbus.in/railways/travellerInfo?src=HYB&dst=NZM&doj=20230131&trainNo=12721&cls=SL&q=TQ&train=DAKSHIN%20EXP&avlT=3&index=0");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		htmlreoprter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\redbus.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlreoprter);
//
//       }
//
//	@AfterTest
//	//@AfterSuite
//	public void afterSuite() {
//		extent.flush();
//		// driver.quit();
//	   }
//
//	public WebDriverWait explicitWait() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		return wait;
//	   }
//   }
