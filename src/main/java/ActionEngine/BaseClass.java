import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// ...

public class BaseClass {
    // ...

    @BeforeSuite
    @SuppressWarnings("deprecation")
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup(); // Use WebDriverManager to set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Wait for Chrome to fully initialize (you can adjust the sleep duration as needed)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        htmlreoprter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\YBC.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlreoprter);
    }

    // ...
}

