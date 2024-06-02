package webTesting.actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTesting.locators.MenuLocators;
import webTesting.utils.HelperClass;

public class MenuActions {

    private MenuLocators menuLocators;
    private WebDriver driver;
    private WebDriverWait wait;

    public MenuActions() {
        this.driver = HelperClass.getDriver();
        this.menuLocators = new MenuLocators();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, menuLocators);
    }

    public void pressHamburgerIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(menuLocators.BtnMenu)).click();
    }

    public void pressXIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(menuLocators.Btnx)).click();
    }

    public boolean isMenuDisplayed() {
        List<WebElement> elementsToCheck = Arrays.asList(menuLocators.Btnx, menuLocators.MenuSidebar,
                menuLocators.About, menuLocators.Logout, menuLocators.Reset);
        return elementsToCheck.stream().allMatch(element -> wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
    }

    public boolean isSidebarDisplayed() {
        return menuLocators.Sidebar.isDisplayed();
    }

    public void selectAboutMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuLocators.About)).click();
    }

    public boolean isOnSauceLabsPage() {
        String expectedUrl = "https://saucelabs.com/";
        return navigateToUrl(expectedUrl);
    }

    public boolean navigateToUrl(String expectedUrl) {
        return wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
