package webTesting.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import webTesting.locators.LoginPageLocators;



public class LoginPageActions {

	webTesting.locators.LoginPageLocators loginPageLocators = null;

	public LoginPageActions() {
		this.loginPageLocators = new LoginPageLocators();
		PageFactory.initElements(webTesting.utils.HelperClass.getDriver(), loginPageLocators);
	}

	public boolean isUsernameFieldDisplayed() {
		WebElement usernameField = loginPageLocators.usernameField;
		boolean isDisplayed = usernameField.isDisplayed();
		boolean isEmpty = usernameField.getText().isEmpty();
		String placeholderText = usernameField.getAttribute("placeholder");

		return isDisplayed && isEmpty && placeholderText.equals("Username");
	}

	public boolean isPasswordFieldDisplayed() {
		WebElement passwordField = loginPageLocators.passwordField;
		boolean isDisplayed = passwordField.isDisplayed();
		boolean isEmpty = passwordField.getText().isEmpty();
		String placeholderText = passwordField.getAttribute("placeholder");

		return isDisplayed && isEmpty && placeholderText.equals("Password");
	}

	public boolean isLogoDisplayed() {
		return loginPageLocators.logoSwaLabs.isDisplayed();
	}

	public boolean isButtonEnable() {
		WebElement loginButton = loginPageLocators.buttonLogin;
		boolean isButtonEnabled = loginButton.isEnabled();
		String buttonColor = loginButton.getCssValue("background-color");
		System.out.print(buttonColor);

		boolean hasColor = buttonColor.equalsIgnoreCase("rgba(61, 220, 145, 1)")
				|| buttonColor.equalsIgnoreCase("#3ddc91");

		return isButtonEnabled && hasColor;
	}

	// action to input data credential
	public void inputCredetial(String username, String password) {
		loginPageLocators.usernameField.sendKeys(username);
		loginPageLocators.passwordField.sendKeys(password);
	}

	// action to click login button
	public void clickLoginButton() {
		loginPageLocators.buttonLogin.click();
	}

	// action to get error message when invalid credential
	public String getErrorMessage() {
		return (loginPageLocators.errorField.getText());
	}

	public boolean isRedXFieldUsernameDisplayed() {
		return (loginPageLocators.xIconUsername.isDisplayed());

	}

	public boolean isRedXFieldPasswordDisplayed() {
		return (loginPageLocators.xIconPassword.isDisplayed());

	}

	public String getCurrentUrl() {
		String currentUrl = webTesting.utils.HelperClass.getDriver().getCurrentUrl();
		return currentUrl;
	}

	public boolean isErrorFieldUsername() {
		WebElement fieldUsername = loginPageLocators.usernameField;
		String fieldUsernameColor = fieldUsername.getCssValue("border-bottom-color");
		System.out.print(fieldUsernameColor);

		boolean hasColor = fieldUsernameColor.equalsIgnoreCase("rgba(226, 35, 26, 1)")
				|| fieldUsernameColor.equalsIgnoreCase("#e2231a");

		return hasColor;
	}

	public boolean isUsernamePlaceholderRed() {
		WebElement fieldUsername = loginPageLocators.usernameField;
		String placeholderColor = fieldUsername.getCssValue("color");
		System.out.println(placeholderColor);

		return placeholderColor.equalsIgnoreCase("rgba(226, 35, 26, 1)")
				|| placeholderColor.equalsIgnoreCase("#e2231a");
	}

	public boolean isErrorFieldPassword() {
		WebElement fieldPassword = loginPageLocators.passwordField;
		String fieldPasswordColor = fieldPassword.getCssValue("border-bottom-color");
		System.out.print(fieldPasswordColor);

		boolean hasColor = fieldPasswordColor.equalsIgnoreCase("rgba(226, 35, 26, 1)")
				|| fieldPasswordColor.equalsIgnoreCase("#e2231a");

		return hasColor;
	}

	public boolean isPasswordPlaceholderRed() {
		WebElement fieldPassword = loginPageLocators.passwordField;
		String placeholderColor = fieldPassword.getCssValue("color");
		System.out.println(placeholderColor);

		return placeholderColor.equalsIgnoreCase("rgba(226, 35, 26, 1)")
				|| placeholderColor.equalsIgnoreCase("#e2231a");
	}

}