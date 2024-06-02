package webTesting.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webTesting.locators.DashboardPageLocators;

import java.time.Duration;

public class DashboardPageActions {

    private DashboardPageLocators dashboardPageLocators;
    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPageActions(WebDriver driver) {
        this.driver = driver;
        this.dashboardPageLocators = new DashboardPageLocators();
        PageFactory.initElements(driver, dashboardPageLocators);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductCatalogueDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dashboardPageLocators.addToCartButton));
        return element.isDisplayed();
    }
    
    public boolean isAddToCartButtonDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dashboardPageLocators.productCatalogue));
        return element.isDisplayed();
    }

    
    public boolean isSwagLabsAppLogoDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dashboardPageLocators.swagLabsAppLogo));
        return element.isDisplayed();
    }

    public void clickAddToCartButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocators.addToCartButton));
        element.click();
    }

    public void clickRemoveButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocators.removeButton));
        element.click();
    }

    public boolean isShoppingCartBadgeDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(dashboardPageLocators.shoppingCartBadge));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public int getShoppingCartBadgeValue() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dashboardPageLocators.shoppingCartBadge));
        String badgeValueText = element.getText().trim();
        return Integer.parseInt(badgeValueText);
    }
}
