package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailLocators {
    
    @FindBy(xpath = "//*[@id='item_5_title_link']/div")
    public WebElement SauceLabsFleeceJacket;
    
    @FindBy(css = ".inventory_details_name.large_size")
    public WebElement SauceLabsFleeceJacketNameDetail;
    
    @FindBy(css = ".inventory_details_desc.large_size")
    public WebElement SauceLabsFleeceJacketDescDetail;
    
    @FindBy(css = ".inventory_details_price")
    public WebElement SauceLabsFleeceJacketPriceDetail;
    
    @FindBy(css = ".shopping_cart_link")
    public WebElement CartIcon;
    
    @FindBy(id = "back-to-products")
    public WebElement BtnBack;

}
