package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShippingAddressPage extends BasePage {

    @FindBy(xpath = "//div[@class='a-container']")
    public WebElement informationFrame;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private List<WebElement> countryAndStateDropdownMenu;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressFullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressLine1']")
    private WebElement addressLine1Field;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressLine2']")
    private WebElement addressLine2Field;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressCity']")
    private WebElement addressCityField;

    @FindBy(xpath = "//span[@aria-owns='2_dropdown_combobox']")
    private WebElement stateDropdownMenu;

    @FindBy(xpath = "//input[@name='address-ui-widgets-enterAddressPostalCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    private WebElement useThisAddressButton;

    public ShippingAddressPage(WebDriver driver) {super(driver);}

    public boolean isCountryRegionDropdownMenuVisible() {return countryAndStateDropdownMenu.get(0).isDisplayed();}

    public boolean isFullNameFieldVisible() {return fullNameField.isDisplayed();}

    public boolean isPhoneNumberFieldVisible() {return phoneNumberField.isDisplayed();}

    public boolean isAddressLine1FieldVisible() {return addressLine1Field.isDisplayed();}

    public boolean isAddressLine2FieldVisible() {return addressLine2Field.isDisplayed();}

    public boolean isAddressCityFieldVisible() {return addressCityField.isDisplayed();}

    public boolean isStateDropdownMenuVisible() {return countryAndStateDropdownMenu.get(1).isDisplayed();}

    public boolean isZipCodeFieldVisible() {return zipCodeField.isDisplayed();}

    public boolean isUseThisAddressButtonVisible() {return useThisAddressButton.isDisplayed();}
}
