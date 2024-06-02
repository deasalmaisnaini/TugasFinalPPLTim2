package stepDefinitions.webTesting;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webTesting.actions.LoginPageActions;
import webTesting.actions.ProductDetailActions;

public class ProductDetailSteps {
	
	LoginPageActions objLogin = new LoginPageActions();
	ProductDetailActions objProductDetail = new ProductDetailActions();
	String url = "https://www.saucedemo.com/";
	

	@When("Select and press the product Sauce Labs Fleece Jacket")
	public void select_and_press_the_product_sauce_labs_fleece_jacket() {
	    objProductDetail.SelectProduct();
	}

	@Then("The product detail page appears with a display containing more detail")
	public void the_product_detail_page_appears_with_a_display_containing_more_detail() {
	    Assert.assertTrue(objProductDetail.isDetaileProductDisplayed());
	}

	@Given("User already on the product detail page")
	public void user_already_on_the_product_detail_page() {
	   Assert.assertTrue(objProductDetail.isProductDetailPage());
	}

	@When("Press the cart icon on the product detail page")
	public void press_the_cart_icon_on_the_product_detail_page() {
	    objProductDetail.clickCartIconInProductDetailPage();
	}

	@Then("The page moves to a page that displays the contents of the cart")
	public void the_page_moves_to_a_page_that_displays_the_contents_of_the_cart() {
	    Assert.assertTrue(objProductDetail.isCartPage());
	}

	@When("Press the left arrow icon on the product detail page.")
	public void press_the_left_arrow_icon_on_the_product_detail_page() {
	    objProductDetail.clickBackIconProductDetailPage();
	}
	
	@Given("User has Select and press the product Sauce Labs Fleece Jacket")
	public void user_has_select_and_press_the_product_sauce_labs_fleece_jacket() {
	    this.select_and_press_the_product_sauce_labs_fleece_jacket();
	}




}
