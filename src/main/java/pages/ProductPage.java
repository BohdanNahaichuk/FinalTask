package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@name='submit.add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@name='submit.buy-now']")
    private WebElement buyNowButton;

    @FindBy(xpath = "//input[@title='Add to List']")
    public WebElement addToListButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {addToCartButton.click();}

    public void clickAddToListButton() {addToListButton.click();}

    public boolean isAddToCartButtonVisible() {return addToCartButton.isDisplayed();}

    public WebElement getAddToCartButton() {return addToCartButton;}
}
