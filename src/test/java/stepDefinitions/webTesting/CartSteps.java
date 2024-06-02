package stepDefinitions.webTesting;

import org.junit.Assert;

import APITesting.testlogic.APITestProcessGeneric;
import webTesting.actions.LoginPageActions;
import webTesting.actions.LogoutPageActions;
import io.cucumber.java.en.*;
import webTesting.actions.CartActions;
import webTesting.utils.HelperClass;

public class CartSteps {
    CartActions cartActions = new CartActions();
    LoginPageActions loginActions = new LoginPageActions();

    @Given("User has log in to the application")
    public void userHasLoggedIntoTheApplication() {
        loginActions.inputCredetial("standard_user", "secret_sauce");
        loginActions.clickLoginButton();
    }

    @When("User clicks on the cart icon at the top right of the dashboard page")
    public void userClicksOnTheCartIconAtTheTopRightOfTheDashboardPage() {
        cartActions.navigateToCartPage();
    }

    @Then("Displays the list of product with remove button under each product")
    public void displaysTheListOfProductWithRemoveButtonUnderEachProduct() {
        Assert.assertTrue(cartActions.isCartListDisplayed());
    }

    @Then("There is a continue shopping button")
    public void displaysTheContinueShoppingButton() {
        Assert.assertTrue(cartActions.isContinueShoppingButtonDisplayed());
    }

    @Then("There is a checkout button")
    public void displaysTheCheckoutButton() {
        Assert.assertTrue(cartActions.isButtonCheckoutDisplayed());
    }

    @When("User clicks on continue shopping button")
    public void userClicksOnContinueShoppingButton() {
        cartActions.navigateToDashboardFromCart();
    }

    @Then("The user sees the name swag labs")
    public void theUserSeesTheNameSwagLabs() {
        Assert.assertTrue(cartActions.isAppLogoDisplayed());
    }

    @Then("Displays the product catalogue")
    public void displaysTheProductCatalogue() {
        Assert.assertTrue(cartActions.isCatalogueDisplayed());
    }

    @When("User clicks add to cart button on product {string} once")
    public void userClicksAddToCartButtonOnProductOnce(String produkIndex) {
        switch (produkIndex) {
            case "1":
                cartActions.addToCart1Process();
                break;
            case "2":
                cartActions.addToCart2Process();
                break;
            case "3":
                cartActions.addToCart3Process();
                break;
            default:
                throw new IllegalArgumentException("Invalid produk index: " + produkIndex);
        }
    }

    @Then("Displays the list of 3 products with remove button under each product")
    public void displaysTheListOfProducts() {
        Assert.assertTrue(cartActions.isCartListDisplayed());
    }
}
