package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPageLocators {
	
	@FindBy(id = "react-burger-menu-btn")
	public WebElement hamburgerMenu;
	
	@FindBy(id = "logout_sidebar_link")
	public WebElement logoutBtn;

	@FindBy(className = "login_logo")
	public WebElement logoLogin;
}
