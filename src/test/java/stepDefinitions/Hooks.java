package stepDefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webTesting.utils.HelperClass;
import APITesting.helper.SetUpEndPoint;

public class Hooks {

    // This method will run once before any API test scenario.
    @Before("@api")
    public static void setUpApi() {
        System.out.println("Before API test");
        SetUpEndPoint.setUpApi();
    }

    // This method will run once before any web test scenario.
    @Before("@webtesting")
    public void setUpWeb() {
        System.out.println("Before web test");
        HelperClass.setUpDriver();
    }

    // This method will run after each web test scenario.
    @After("@webtesting")
    public void tearDownWeb(Scenario scenario) {
        System.out.println("After web test");
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        HelperClass.tearDown();
    }

    // This method will run once after all API tests have been executed.
    @After("@api")
    public static void tearDownApi() {
        System.out.println("After API test");
        // API teardown logic if any
    }

    // This method will run once after all tests have been executed.
    @AfterClass
    public static void tearDownAll() {
        System.out.println("After all tests");
    }
}
