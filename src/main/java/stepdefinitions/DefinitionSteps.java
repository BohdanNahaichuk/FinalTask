package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    ShippingAddressPage shippingAddressPage;
    PageFactoryManager pageFactoryManager;
    SignInPage signInPage;
    LanguageAndCurrencyPage languageAndCurrencyPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isHeaderVisible());
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {assertTrue(homePage.isFooterVisible());}

    @And("User checks cart visibility")
    public void checkCartVisibility() {assertTrue(homePage.isCartIconVisible());}

    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {assertTrue(homePage.isRegisterButtonVisible());}

    @And("User checks email field visibility on sign in page")
    public void checkEmailVisibility() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.signInField());
        assertTrue(signInPage.isEmailFieldVisible());
    }

    @When("User input {string} address")
    public void inputValueToEmailField(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.inputValueToEmailField(email);
    }

    @When("User input {string}")
    public void inputValueToPasswordField(final String password) {signInPage.inputValueToPasswordField(password);}

    @And("User checks password field visibility on sign in page")
    public void checkPasswordVisibility() {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.signInField());
        assertTrue(signInPage.isPasswordFieldVisible());
    }

    @Then("User can observe greeting message")
    public void checkHelloMessage() {assertTrue(signInPage.isGreetingMessageVisible());}

    @Then("'There was a problem' message is appear")
    public void checkProblemMessage() {assertTrue(signInPage.isProblemMessageVisible());}

    @And("User clicks 'Continue' button")
    @And("User clicks 'Sign-In' button")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
    }

    @And("User opens shopping cart")
    public void openShoppingCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickCartButton();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @Then("Item added to Shopping List message is displayed")
    public void isItemAddedToShoppingListVisible() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.itemAddedToShoppingListMessage);
        assertTrue(shoppingCartPage.isItemAddedToShoppingListMessageVisible());}

    @When("User clicks language button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
    }

    @And("User clicks on 'Deutsch - DE' radio button")
    public void clickDeutchRadioButton() {
        languageAndCurrencyPage = pageFactoryManager.getLanguageAndCurrencyPage();
        languageAndCurrencyPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        languageAndCurrencyPage.clickRadioButtonDeutsch();
    }

    @And("User clicks on currency dropdown menu")
    public void clickCurrencyDropdownMenu() {
        languageAndCurrencyPage = pageFactoryManager.getLanguageAndCurrencyPage();
        languageAndCurrencyPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        languageAndCurrencyPage.clickCurrencyDropdownMenu();
    }

    @And("User clicks on '€ - EUR - Euro' option in dropdown list")
    public void clickOnEuroCurrencyOption() {languageAndCurrencyPage.clickEuroCurrencyOption();}

    @And("Apply language and currency settings by clicking 'Änderungen speichern' button")
    public void saveLanguageAndCurrencySettings() {languageAndCurrencyPage.clickSaveChangesButton();}

    @When("User clicks 'Sign in' button")
    public void clickSignInButton() {homePage.clickSignInButton();}

    @And("User confirm selected language")
    @And("User confirm selected currency")
    public void confirmSelectedLanguage() {
        languageAndCurrencyPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        languageAndCurrencyPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        languageAndCurrencyPage.clickSaveChangesButton();
    }

    @Then("User checks that current url contains {string}")
    public void checkCurrentUrl(final String string) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(string));
    }

    @And("User checks that shopping cart icon is visible")
    public void checkShoppingCartIconIsVisibility() {
        assertTrue(homePage.isShoppingCartIconIsVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks on search button")
    public void clickSearchButton() throws InterruptedException {
        sleep(1500);//потому что баг, вам так делать нельзя!!!
        homePage.clickSearchButton();
    }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that 'Add to Cart' button is visible")
    public void checkAddToCartButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        assertTrue(productPage.isAddToCartButtonVisible());
    }

    @And("User skips add by clicking 'No Thanks' button")
    public void clickNoThanksButton() {
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickNoThanksButton();
    }

    @And("User clicks 'Proceed to checkout' button")
    public void clickCheckoutButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.cartButton);
        shoppingCartPage.clickProceedToCheckoutButton();
    }

    @Then("All necessary information fields for shipping is visible")
    public void allRequiredForShippingInformationIsVisible() {
        shippingAddressPage = pageFactoryManager.getShippingAddressPage();
        shippingAddressPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shippingAddressPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,shippingAddressPage.informationFrame);
        assertTrue(shippingAddressPage.isCountryRegionDropdownMenuVisible());
        assertTrue(shippingAddressPage.isFullNameFieldVisible());
        assertTrue(shippingAddressPage.isPhoneNumberFieldVisible());
        assertTrue(shippingAddressPage.isAddressLine1FieldVisible());
        assertTrue(shippingAddressPage.isAddressLine2FieldVisible());
        assertTrue(shippingAddressPage.isAddressCityFieldVisible());
        assertTrue(shippingAddressPage.isStateDropdownMenuVisible());
        assertTrue(shippingAddressPage.isZipCodeFieldVisible());
        assertTrue(shippingAddressPage.isUseThisAddressButtonVisible());

    }

    @And("User clicks 'Cart' button")
    public void clickCartButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.cartButton);
        shoppingCartPage.clickCartButton();
    }



    @Then("User checks that cart contains {string} item")
    public void isCartContainsItem(final String string) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        assertEquals(homePage.getCartIconCount(), string);}

    @And("Search results is displayed")
    public void searchResultsIsVisible(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertTrue(searchResultsPage.searchResultsIsVisible());}

    @And("User enters {string} to '$max' price field filter")
    public void enterMaxPriceFilter(final String string) {searchResultsPage.enterValueToMaxPriceField(string);}

    @And("User clicks on '$35 and Above' filter button")
    public void clickOnFilterButton() {searchResultsPage.clickPriceFilterButton();}

    @And("User apply filter by clicking 'go' button")
    public void clickOnGoButton() {searchResultsPage.clickOnGoButton();}

    @When("User clicks on 'steam controller' product")
    public void clickOnSteamControllerProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnSteamControllerProduct();}

    @When("User clicks on 'sony wh-1000xm3' product")
    public void clickOnSonyHeadphonesProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnSonyHeadphonesProduct();}

    @And("User clicks on 'xbox one x' product")
    public void clickOnXBoxOneXProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnXBoxOneXProduct();
    }

    @And("User clicks on 'Add to List' button")
    public void clickOnAddToListButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.addToListButton);
        productPage.clickAddToListButton();
    }

    @Then("User observe 'No results' message")
    public void noResultsMessageIsPresent() {assertTrue(searchResultsPage.searchResultsIsVisible());}

    @And("User clicks 'Deliver to' button")
    public void clickDeliverToButton() {homePage.clickDeliverToButton();}

    @And("User clicks on country dropdown menu")
    public void clickCountryDropdownMenu() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.countryDropdownMenu);
        homePage.clickCountryDropdownMenu();}

    @When("User choice 'Ukraine' option in dropdown country menu")
    public void clickOnUkraineOption() {homePage.clickOnUkraineOption();}

    @And("Confirm by clicking 'Done' button")
    public void clickOnDoneButton() {homePage.clickOnDoneButton();}

    @Then("'Ukraine' option is displayed in 'Deliver to' frame")
    public void deliverToUkraineOptionIsDisplayed() {assertTrue(homePage.deliveryToUkraineOptionIsSet());}

    @After
    public void tearDown() {
        driver.close();
    }

}
