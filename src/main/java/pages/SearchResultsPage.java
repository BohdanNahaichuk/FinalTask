package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'results')]")
    private WebElement searchResults;

    @FindBy(xpath = "//div[@class='a-section a-spacing-medium']//span[text()='Steam Controller']")
    private List<WebElement> steamController;

    @FindBy(xpath = "//img[@alt='SONY WH-1000XM3 Wireless Noise canceling Stereo Headset(International Version/Seller Warrant) (Black)']")
    private WebElement sonyHeadphones;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), '(Renewed)')]")
    private WebElement xBoxOneX;

    @FindBy(xpath = "//span[text()='$35 & Above']")
    private WebElement priceFilterButton;

    @FindBy(xpath = "//input[@name='high-price']")
    private WebElement maxPriceField;

    @FindBy(xpath = "//input[@aria-labelledby='a-autoid-1-announce']")
    private WebElement priceFieldFilterConfirmationButton;

    @FindBy(xpath = "//span[text()='No results for ']")
    private WebElement noResultsInformation;

    public SearchResultsPage(WebDriver driver) {super(driver);}

    public boolean searchResultsIsVisible() {return searchResults.isDisplayed();}

    public void clickPriceFilterButton() { priceFilterButton.click();}

    public void clickOnGoButton() {priceFieldFilterConfirmationButton.click();}

    public void enterValueToMaxPriceField(final String maxPrice) {
        maxPriceField.clear();
        maxPriceField.sendKeys(maxPrice);
    }

    public void clickOnSteamControllerProduct() {steamController.get(0).click();}

    public void clickOnSonyHeadphonesProduct() {sonyHeadphones.click();}

    public void clickOnXBoxOneXProduct() {xBoxOneX.click();}

}
