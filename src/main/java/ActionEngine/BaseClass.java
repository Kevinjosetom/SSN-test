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

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public ExtentHtmlReporter htmlreporter;
    public ExtentReports extent;
    public static ExtentTest test;
    public readconfig rconfig = new readconfig();
    public String chromepath = rconfig.getchromepath();
    public String url = rconfig.getbaseurl();

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	//System.setProperty("webdriver.chrome.driver", chromepath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\YBC.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        driver.quit();
    }

    public WebDriverWait explicitWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }
}

