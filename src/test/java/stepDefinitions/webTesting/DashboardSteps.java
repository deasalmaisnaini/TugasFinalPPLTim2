package stepDefinitions.webTesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import webTesting.actions.DashboardPageActions;
import webTesting.utils.HelperClass;

public class DashboardSteps {

    private WebDriver driver = HelperClass.getDriver();
    private DashboardPageActions objDashboard = new DashboardPageActions(driver);

    String url = "https://www.saucedemo.com/";

    @Then("There is product catalogue")
    public void there_is_product_catalogue() {
        Assert.assertTrue(objDashboard.isProductCatalogueDisplayed());
    }
    
    @Then("There is an Add To Cart button")
    public void there_is_an_add_to_cart_button() {
        Assert.assertTrue(objDashboard.isAddToCartButtonDisplayed());
    }

    @Then("There is a Swag Labs App logo name")
    public void there_is_a_swag_labs_app_logo_name() {
        Assert.assertTrue(objDashboard.isSwagLabsAppLogoDisplayed());
    }

    
    @When("User press the {string} button on one product")
    public void user_press_the_button_on_one_product(String buttonName) {
        if (buttonName.equals("Add To Cart")) {
            objDashboard.clickAddToCartButton();
        } else if (buttonName.equals("Remove")) {
            objDashboard.clickRemoveButton();
        }
    }

    @Then("Cart Badge Value is updated to {int}")
    public void cart_badge_value_is_updated_to(int expectedValue) {
        int actualValue = objDashboard.getShoppingCartBadgeValue();
        Assert.assertEquals(expectedValue, actualValue);
    }
    
    @Then("Cart Badge is not displayed")
    public void cart_badge_is_not_displayed() {
    	Assert.assertFalse(objDashboard.isShoppingCartBadgeDisplayed());
    }
}
