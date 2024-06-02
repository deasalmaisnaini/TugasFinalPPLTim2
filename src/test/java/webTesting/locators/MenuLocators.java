package webTesting.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuLocators {
	
	@FindBy(id = "react-burger-menu-btn")
	public WebElement BtnMenu;
	
	@FindBy(id= "react-burger-cross-btn")
	public WebElement Btnx;
	
	@FindBy(xpath = "//*[@id=\"inventory_sidebar_link\"]")
	public WebElement MenuSidebar;
	
	@FindBy(xpath = "//*[@id=\"about_sidebar_link\"]")
	public WebElement About;
	
	@FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	public WebElement Logout;
	
	@FindBy(xpath = "//*[@id=\"reset_sidebar_link\"]")
	public WebElement Reset;
	
	@FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")
	public WebElement Sidebar;
	

}
