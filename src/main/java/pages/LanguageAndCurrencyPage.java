package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageAndCurrencyPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Deutsch - DE')]")
    private WebElement radioButtonDeutsch;

    @FindBy(xpath = "//span[@class='a-dropdown-container']")
    private WebElement currencyDropdownMenu;

    @FindBy(xpath = "//input[@class='a-button-input' and @type='submit']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//a[text()='€ - EUR - Euro']")
    private WebElement euroCurrencyOption;

    @FindBy(xpath = "//span[contains(text(), 'Select the language')]")
    public WebElement languageSettings;

    public LanguageAndCurrencyPage(WebDriver driver) {super(driver);}

    public void clickRadioButtonDeutsch() {radioButtonDeutsch.click();}

    public void clickCurrencyDropdownMenu() {currencyDropdownMenu.click();}

    public void clickEuroCurrencyOption() {euroCurrencyOption.click();}

    public void clickSaveChangesButton() {saveChangesButton.click();}
}
