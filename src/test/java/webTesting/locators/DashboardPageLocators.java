package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageLocators {

    @FindBy(xpath = "//*[@id='inventory_container']")
    public WebElement productCatalogue;

    @FindBy(className = "app_logo")
    public WebElement swagLabsAppLogo;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='remove-sauce-labs-backpack']")
    public WebElement removeButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;
}
