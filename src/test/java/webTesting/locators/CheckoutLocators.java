package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutLocators {
    // Cart Page
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addToCart1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addToCart2;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addToCart3;

    // Find icon cart
    @FindBy(className = "shopping_cart_link")
    public WebElement CartIcon;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    // Checkout Information Page
    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    // Checkout Overview Page
    @FindBy(className = "cart_item")
    public WebElement productList;

    @FindBy(className = "summary_total_label")
    public WebElement totalPrice;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "checkout_complete_container")
    public WebElement completeHeader;

}
