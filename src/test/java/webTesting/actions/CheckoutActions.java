package webTesting.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webTesting.locators.CheckoutLocators;
import webTesting.utils.HelperClass;

public class CheckoutActions {

    CheckoutLocators checkoutLocators;

    public CheckoutActions() {
        this.checkoutLocators = new CheckoutLocators();
        PageFactory.initElements(HelperClass.getDriver(), checkoutLocators);
    }

    public void addToCart1Process() {
        checkoutLocators.addToCart1.click();
    }

    public void addToCart2Process() {
        checkoutLocators.addToCart2.click();
    }

    public void addToCart3Process() {
        checkoutLocators.addToCart3.click();
    }

    public void navigateToCartPage() {
        checkoutLocators.CartIcon.click();
    }

    public void clickCheckoutButton() {
        checkoutLocators.checkoutButton.click();
    }

    public boolean areCheckoutFieldsDisplayedAndEmpty() {
        return checkoutLocators.firstNameInput.isDisplayed() &&
                checkoutLocators.lastNameInput.isDisplayed() &&
                checkoutLocators.postalCodeInput.isDisplayed() &&
                checkoutLocators.firstNameInput.getText().isEmpty() &&
                checkoutLocators.lastNameInput.getText().isEmpty() &&
                checkoutLocators.postalCodeInput.getText().isEmpty();
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        checkoutLocators.firstNameInput.sendKeys(firstName);
        checkoutLocators.lastNameInput.sendKeys(lastName);
        checkoutLocators.postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        checkoutLocators.continueButton.click();
    }

    public void clickFinishButton() {
        checkoutLocators.finishButton.click();
    }

    public boolean isProductListDisplayed() {
        return checkoutLocators.productList.isDisplayed();
    }

    public boolean isPaymentShippingAndTotalPriceDisplayed() {
        return checkoutLocators.totalPrice.isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {
        return checkoutLocators.cancelButton.isDisplayed();
    }

    public boolean isCompleteHeaderDisplayed() {
        return checkoutLocators.completeHeader.isDisplayed();
    }
}
