package webTesting.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webTesting.locators.CartLocator;
import webTesting.utils.HelperClass;

public class CartActions {
    CartLocator cartLocators;

    public CartActions() {
        this.cartLocators = new CartLocator();
        PageFactory.initElements(HelperClass.getDriver(), cartLocators);
    }

    public void addToCart1Process() {
        cartLocators.addToCart1.click();
    }

    public void addToCart2Process() {
        cartLocators.addToCart2.click();
    }

    public void addToCart3Process() {
        cartLocators.addToCart3.click();
    }

    public void navigateToCartPage() {
        cartLocators.CartIcon.click();
    }

    public void navigateToDashboardFromCart() {
        cartLocators.continueShoppingButton.click();
    }

    public boolean isButtonCheckoutDisplayed() {
        return cartLocators.checkoutButton.isDisplayed();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return cartLocators.continueShoppingButton.isDisplayed();
    }

    public boolean isAppLogoDisplayed() {
        return cartLocators.appLogo.isDisplayed();
    }

    public boolean isCatalogueDisplayed() {
        return cartLocators.Catalogue.isDisplayed();
    }

    public boolean isCartListDisplayed() {
        return cartLocators.cartList.isDisplayed();
    }

}
