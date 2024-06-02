package stepDefinitions.webTesting;

import org.junit.Assert;

import APITesting.testlogic.APITestProcessGeneric;
import webTesting.actions.LoginPageActions;
import webTesting.actions.LogoutPageActions;
import io.cucumber.java.en.*;
import webTesting.actions.CheckoutActions;
import webTesting.utils.HelperClass;

public class CheckoutSteps {
    CheckoutActions checkoutActions = new CheckoutActions();
    LoginPageActions loginActions = new LoginPageActions();

    // @Given("User has opened swag labs browser")
    // public void userHasOpenedSwagLabsBrowser() {
    // checkoutActions.openSwagLabsBrowser();
    // }

    @Given("User has logged into the application")
    public void userHasLoggedIntoTheApplication() {
        // checkoutActions.loginToApplication("standard_user", "secret_sauce");
        loginActions.inputCredetial("standard_user", "secret_sauce");
        loginActions.clickLoginButton();
    }

    @Given("User find the product {string} and click the add to cart button")
    public void userFindTheProductAndClickTheAddToCartButton(String produkIndex) {
        switch (produkIndex) {
            case "1":
                checkoutActions.addToCart1Process();
                break;
            case "2":
                checkoutActions.addToCart2Process();
                break;
            case "3":
                checkoutActions.addToCart3Process();
                break;
            default:
                throw new IllegalArgumentException("Invalid produk index: " + produkIndex);
        }
    }

    @When("User has navigated to the Cart page")
    public void userHasNavigatedToTheCartPage() {
        checkoutActions.navigateToCartPage();
    }

    @When("User clicks on the checkout button")
    public void userClicksOnTheCheckoutButton() {
        checkoutActions.clickCheckoutButton();
    }

    @Then("The fields for inputting first name, last name, and Zip or Postal Code are displayed and have not been filled in")
    public void theFieldsForInputtingFirstNameLastNameAndZipPostalCodeAreDisplayedAndHaveNotBeenFilledIn() {
        Assert.assertTrue(checkoutActions.areCheckoutFieldsDisplayedAndEmpty());
    }

    @Given("User has navigated to the checkout information page")
    public void userHasNavigatedToTheCheckoutInformationPage() {
        userHasNavigatedToTheCartPage();
        userClicksOnTheCheckoutButton();
    }

    @When("User enters First Name, Last Name, and Zip or Postal Code")
    public void userEntersFirstNameLastNameAndZipPostalCode() {
        checkoutActions.enterCheckoutInformation("Muhammad", "Rafi", "15013");
    }

    @When("User clicks on the continue button")
    public void userClicksOnTheContinueButton() {
        checkoutActions.clickContinueButton();
    }

    @Then("A list of products to be checked out is displayed")
    public void aListOfProductsToBeCheckedOutIsDisplayed() {
        Assert.assertTrue(checkoutActions.isProductListDisplayed());
    }

    @Then("Payment information, shipping information, and the total price are displayed")
    public void paymentInformationShippingInformationAndTheTotalPriceAreDisplayed() {
        Assert.assertTrue(checkoutActions.isPaymentShippingAndTotalPriceDisplayed());
    }

    @Then("There is a cancel button")
    public void thereIsACancelButton() {
        Assert.assertTrue(checkoutActions.isCancelButtonDisplayed());
    }

    @Given("User has navigated to the shipping information page")
    public void userHasNavigatedToTheShippingInformationPage() {
        userHasNavigatedToTheCheckoutInformationPage();
        userEntersFirstNameLastNameAndZipPostalCode();
        userClicksOnTheContinueButton();
    }

    @When("User clicks on finish button")
    public void userClicksOnTheFinishButton() {
        checkoutActions.clickFinishButton();
    }

    @Then("Displays Thank you for your order! message with checklist and circle logo on the top of it")
    public void theCheckoutCompletePageIsDisplayed() {
        Assert.assertTrue(checkoutActions.isCompleteHeaderDisplayed());
    }

}
