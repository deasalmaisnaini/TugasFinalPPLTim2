package webTesting.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/* Create a Helper class where we are initializing the web driver, initializing the web driver wait, 
 * defining the timeouts, and creating a private constructor of the class, it will declare the web driver, 
 * so whenever we create an object of this class, a new web browser is invoked. 
 */
public class HelperClass {
    private static HelperClass helperClass;

    private static WebDriver driver;
    private static JavascriptExecutor js;
    public final static int TIMEOUT = 30; // waiting time

    //start chrome driver
    private HelperClass() {
        //Initiating your chromedriver
    	WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();

        //Initiating your chromedriver
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*"); // allowing to cors (lintas origin/domain), sumber : //https://www.rumahweb.com/journal/cors-adalah/
		driver = new ChromeDriver(options);
        System.out.println("bebas");        
        driver.manage().window().maximize(); //maximize window
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    //navigate driver to url page
    public static void openPage(String url) {
        driver.get(url);
    }

    //get current state driver
    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver(); // Inisialisasi driver jika belum diinisialisasi
        }
        return driver;
    }

    //first time run driver
    public static void setUpDriver() {
        if (helperClass==null) {
            helperClass = new HelperClass();
        }
    }

    //closed driver after test case finish execution
    public static void tearDown() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }

}

