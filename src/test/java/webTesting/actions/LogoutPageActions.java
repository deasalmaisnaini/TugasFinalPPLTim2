package webTesting.actions;

import org.openqa.selenium.support.PageFactory;


import webTesting.locators.LogoutPageLocators;
import webTesting.utils.HelperClass;

public class LogoutPageActions {
	
	LogoutPageLocators logoutPageLocators = null;

	public LogoutPageActions() {
		this.logoutPageLocators = new LogoutPageLocators();
		PageFactory.initElements(HelperClass.getDriver(), logoutPageLocators);
	}
				
	 public Boolean isLoginPage() {
		return logoutPageLocators.logoLogin.isDisplayed();
	 }
	 
	 public void clickHamburgerMenu() {
		 logoutPageLocators.hamburgerMenu.click();
	 }
	 
	 public void clickLogoutButton() {
		 logoutPageLocators.logoutBtn.click();
	 }
	 
	 

}
