package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

public class LogInPage {

    @FindBy(id = "loginusername")
    private static WebElement emailAddressInputField;

    @FindBy(id = "loginpassword")
    private static WebElement passwordInputField;

    @FindBy(id = "loginsubmit")
    private static WebElement loginButton;

    @FindBy(id = "persistent")
    private static WebElement checkBoxButton;

    @FindBy(id = "error")
    private static WebElement errorMessage;

    static {
        PageFactory.initElements(Browser.driver, LogInPage.class);
    }

    /**
     * This method redirects you to the 'Main' page.
     */
    public static void goTo() {
        Browser.driver.get("https://mycompany-ood.inv.bg/login");
    }

    /**
     * This method tries to log you in with the provided credentials.
     *
     * @param randomMail The emailaddress that you want to log in with.
     * @param password   The password that you want to log in with.
     */
    public static void login(String randomMail, String password) {
        writeInTheEmailAddressInputField(randomMail);
        writeThePasswordInputField(password);
        clickLoginButton();
    }

    /**
     * This method Writes text in the 'emailAddress' input field.
     *
     * @param randomMail The email that you want to log in with.
     */
    private static void writeInTheEmailAddressInputField(String randomMail) {

        emailAddressInputField.sendKeys(randomMail);
    }

    /**
     * This method Writes text in the 'Password' input field.
     *
     * @param password The password that you want to log in with.
     */
    private static void writeThePasswordInputField(String password) {

        passwordInputField.sendKeys(password);
    }

    /**
     * This method Clicks the 'Login' button.
     */
    private static void clickLoginButton() {
        loginButton.click();
    }

    /**
     * This method assert error message when try to log in with wrong email
     */
    public static void assertErrMsgWrongUserOrPassAppears() {
        Assert.assertTrue(errorMessage.getText().contains("Грешно потребителско име или парола."));
    }

}
