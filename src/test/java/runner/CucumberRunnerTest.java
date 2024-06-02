package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
        "stepDefinitions" }, monochrome = true, tags = "@webtesting and @cart", plugin = { "pretty",
                "html:target/HtmlReports/report.html",
                "json:target/JSonReports/report.json",
                "junit:target/JUnitReports/report.xml", })
public class CucumberRunnerTest {

}
