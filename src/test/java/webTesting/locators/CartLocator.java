package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartLocator {
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

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(id = "inventory_container")
    public WebElement Catalogue;

    @FindBy(className = "cart_list")
    public WebElement cartList;

}
