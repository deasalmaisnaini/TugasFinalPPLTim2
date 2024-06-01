package APITesting.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;

public class Utility {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    // method to run driver web, like chrome
    public static void startDriver() {
        // Initiating your chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // running Chrome via console, and UI Chrome not displayed
        options.addArguments("--no-sandbox"); // chrome production version
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*"); // allowing to cross domain, so chrome can remoted by selenium
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // wait element with time while 3 second
    }

    // method to closed drive
    public static void quitDriver() {
        driver.quit();
    }

    // navigate driver to url page
    public static void openPage(String url) {
        driver.get(url);
    }

    // generate randon data email dengan panjang karakter 10
    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); // Panjang email 10 karakter
        email = temp + "@testdata.com";
        return email.toLowerCase();
    }
    
    public static String generateUpdateUserRequestBody(Map<String, String> userData) {
        StringBuilder requestBody = new StringBuilder("{");

        for (Map.Entry<String, String> entry : userData.entrySet()) {
            if (requestBody.length() > 1) {
                requestBody.append(", ");
            }
            requestBody.append("\"").append(entry.getKey()).append("\": ");
            requestBody.append("\"").append(entry.getValue()).append("\"");
        }

        requestBody.append("}");
        return requestBody.toString();
    }
}
