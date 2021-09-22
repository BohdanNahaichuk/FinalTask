package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    private WebElement signInField;

    @FindBy(xpath = "//input[contains(@name, 'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(), 'Hello, ')]")
    private WebElement greetingMessage;

    @FindBy(xpath = "//h4[text()='There was a problem']")
    private WebElement problemMessage;

    public SignInPage(WebDriver driver) {super(driver);}

    public WebElement signInField() {return signInField;}

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public void clickContinueButton() {
        try {
            sleep(3500); // I have to =/ #CaptchaAgainstQATesting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton.click();
    }

    public void inputValueToEmailField(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void inputValueToPasswordField(final String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public boolean isGreetingMessageVisible() {return greetingMessage.isDisplayed();}

    public boolean isProblemMessageVisible() {return problemMessage.isDisplayed();}
}
