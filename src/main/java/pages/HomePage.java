package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    protected Actions actions = new Actions(driver);

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//div[contains(@class, 'navFooterLine navFooterLinkLine navFooterPadItemLine')]")
    private WebElement footer;

    @FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
    private WebElement accountAndListButton;

    @FindBy(xpath = "//span[@class='nav-action-inner'][text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(@class, 'nav-cart-icon nav-sprite')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@class='nav-cart-count nav-cart-1 nav-progressive-attribute nav-progressive-content']")
    private WebElement cartIconCount;

    @FindBy(xpath = "//a[@aria-label='Choose a language for shopping.']")
    private WebElement languageButton;

    @FindBy(xpath = "//a [text()='Start here.']")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@name='field-keywords']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-declarative nav-progressive-attribute']")
    private WebElement deliverToButton;

    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    public WebElement countryDropdownMenu;

    @FindBy(xpath = "//a[text()='Ukraine']")
    private WebElement countryOptionUkraine;

    @FindBy(xpath = "//span[@class='a-button a-button-primary']")
    private WebElement doneButton;

    @FindBy(xpath = "//span[text()='Ukraine']")
    private WebElement deliveryToUkraineOption;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isHeaderVisible() {return header.isDisplayed();}

    public boolean isFooterVisible() {return footer.isDisplayed();}

    public boolean isCartIconVisible() {return cartIcon.isDisplayed();}

    public boolean isRegisterButtonVisible() {
        actions.moveToElement(accountAndListButton).build().perform();
        return registerButton.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public boolean isShoppingCartIconIsVisible() {return cartIcon.isDisplayed();}

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickLanguageButton() {languageButton.click();}

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInButton() {
        actions.moveToElement(accountAndListButton).build().perform();
        signInButton.click();
    }

    public void clickDeliverToButton() {deliverToButton.click();}

    public void clickCountryDropdownMenu() {countryDropdownMenu.click();}

    public void clickOnUkraineOption() {countryOptionUkraine.click();}

    public void clickOnDoneButton() {doneButton.click();}

    public boolean deliveryToUkraineOptionIsSet() {return deliveryToUkraineOption.isDisplayed();}

    public String getCartIconCount() {return cartIconCount.getText();}

}
