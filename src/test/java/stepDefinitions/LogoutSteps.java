package stepDefinitions;

import org.junit.Assert;

import webTesting.actions.LogoutPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	LogoutPageActions objLogout = new LogoutPageActions();

@Given("User has logged in to swag labs")
public void user_has_logged_in_to_swag_labs() throws InterruptedException {
	LoginSteps loginSteps = new LoginSteps();
	loginSteps.user_has_opened_swag_labs_browser();
	loginSteps.user_enter_username_as_and_passwrod_as("standard_user", "secret_sauce");
	loginSteps.user_click_login_button();
}

	@When("User clicks on humberger icon at top left corner")
	public void user_clicks_on_humberger_icon_at_top_left_corner() {
		objLogout.clickHamburgerMenu();

	}

	@When("clicks on logout button")
	public void clicks_on_logout_button() {
		objLogout.clickLogoutButton();
	}

	@Then("User should be able to logged out successfully")
	public void user_should_be_able_to_logged_out_successfully() {
		Assert.assertTrue(objLogout.isLoginPage());
	}

}
