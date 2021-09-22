package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-section attach-desktop-sideSheet']")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    public WebElement cartButton;

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@aria-labelledby='attachSiNoCoverage-announce']")
    private WebElement noThanksButton;

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='a-section wlAddCreatePop']")
    public WebElement itemAddedToShoppingListMessage;

    public ShoppingCartPage(WebDriver driver) {super(driver);}

    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    public void clickProceedToCheckoutButton() {shoppingCartTitle.findElement(By.xpath(
            "//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")) .click();}

    public void clickCartButton() {cartButton.click();}

    public void clickNoThanksButton() {noThanksButton.click();}

    public boolean isItemAddedToShoppingListMessageVisible() {return itemAddedToShoppingListMessage.isDisplayed();}
}
