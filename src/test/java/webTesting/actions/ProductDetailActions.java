package webTesting.actions;

import org.openqa.selenium.support.PageFactory;

import webTesting.locators.ProductDetailLocators;
import webTesting.utils.HelperClass;

public class ProductDetailActions {
	
	ProductDetailLocators ProductDetailLocators = null;

	public ProductDetailActions() {
		this.ProductDetailLocators = new ProductDetailLocators();
		PageFactory.initElements(HelperClass.getDriver(), ProductDetailLocators);
	}
	
	public void SelectProduct() {
		ProductDetailLocators.SauceLabsFleeceJacket.click();
	}
	
	public boolean isDetaileProductDisplayed() {
		boolean isNameDetailDisplayed = ProductDetailLocators.SauceLabsFleeceJacketNameDetail.isDisplayed();
		boolean isDescDetailDisplayed = ProductDetailLocators.SauceLabsFleeceJacketDescDetail.isDisplayed();
		boolean isPriceDetailDisplayed = ProductDetailLocators.SauceLabsFleeceJacketPriceDetail.isDisplayed();
		
		return isNameDetailDisplayed && isDescDetailDisplayed && isPriceDetailDisplayed;
	}
	
	public boolean isProductDetailPage() {
		 String currentUrl = webTesting.utils.HelperClass.getDriver().getCurrentUrl();
		 System.out.println(currentUrl);
	     return currentUrl.startsWith("https://www.saucedemo.com/inventory-item.html?id=");
	}
	
	public void clickCartIconInProductDetailPage() {
		ProductDetailLocators.CartIcon.click();
	}
	
	public void clickBackIconProductDetailPage() {
		ProductDetailLocators.BtnBack.click();
	}
	
	public boolean isCartPage() {
		 String currentUrl = webTesting.utils.HelperClass.getDriver().getCurrentUrl();
	     return currentUrl.equalsIgnoreCase("https://www.saucedemo.com/cart.html");
	}
	

}
