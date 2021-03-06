package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {return new SearchResultsPage(driver);}

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public ShippingAddressPage getShippingAddressPage() {
        return new ShippingAddressPage(driver);
    }

    public LanguageAndCurrencyPage getLanguageAndCurrencyPage() {return new LanguageAndCurrencyPage(driver);}
    public SignInPage getSignInPage() {return new SignInPage(driver);}
}
