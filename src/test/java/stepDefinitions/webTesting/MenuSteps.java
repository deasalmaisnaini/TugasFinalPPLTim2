package stepDefinitions.webTesting;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webTesting.actions.LoginPageActions;
import webTesting.actions.LogoutPageActions;
import webTesting.actions.MenuActions;

public class MenuSteps {

	MenuActions objMenu = new MenuActions();
	LoginPageActions objLogin = new LoginPageActions();

	@Given("User has logged in by entering valid credential data")
	public void user_has_logged_in_by_entering_valid_credential_data() {
		objLogin.inputCredetial("standard_user", "secret_sauce");
		objLogin.clickLoginButton();
	}

	@When("Press the three line icon or hamburger icon")
	public void press_the_three_line_icon_or_hamburger_icon() {
		objMenu.pressHamburgerIcon();
	}

	@Then("The sidebar appears displaying several menus")
	public void the_sidebar_appears_displaying_several_menus() {
		Assert.assertTrue(objMenu.isMenuDisplayed());
	}

	@When("Pressing the {string} button on the sidebar")
	public void pressing_the_button_on_the_sidebar(String icon) {
		objMenu.pressXIcon();
	}

	@Then("The sidebar that appears will close and display the product detail page again")
	public void the_sidebar_that_appears_will_close_and_display_the_product_detail_page_again() throws InterruptedException {
		// Verifikasi bahwa sidebar tidak ditampilkan
		 Thread.sleep(5000);
		Assert.assertFalse("Menu should be closed", objMenu.isSidebarDisplayed());

	}

	@When("Press the {string} menu in the sidebar")
	public void press_the_menu_in_the_sidebar(String string) {
		objMenu.selectAboutMenu();
	}

	@Then("The page moves to the sauce lab website page")
	public void the_page_moves_to_the_sauce_lab_website_page() {
		objMenu.isOnSauceLabsPage();
	}

}
