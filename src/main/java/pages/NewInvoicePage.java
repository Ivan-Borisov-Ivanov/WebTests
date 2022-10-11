package pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

public class NewInvoicePage extends BasePage {

    @FindBy(xpath = "//a[@data-search='#clbulstat']")
    private static WebElement clientListButton;

    @FindBy(xpath = "//a[contains(@class,'client-popup-client-63')]")
    private static WebElement selectClientFirmNameField;

    @FindBy(xpath = "//a[@data-search-field='input[name=obj_0_name]']")
    private static WebElement showListButton;

//    @FindBy(xpath = "//a[contains(.,'%s')]")
//    private static WebElement selectItem;

    @FindBy(id = "no_vat")
    private static WebElement noVatCheckbox;

    @FindBy(id = "act_create")
    private static WebElement createInvoiceButton;

    @FindBy(id = "headline")
    private static WebElement headLineInvoiceNumber;

    @FindBy(xpath = "//b[@id='money_amount_total']")
    private static WebElement moneyAmountTotalField;

    static {
        PageFactory.initElements(Browser.driver, NewInvoicePage.class);
    }

    /**
     * This method navigate to New Invoice Page
     */
    public static void navigate() {
        navigate("invoices/new");
    }

    /**
     * This method click on Client List Button.
     */
    public static void clickClientListButton() {
        clientListButton.click();
    }

    /**
     * This method select client firm name.
     */
    public static void selectClientFirmName() {
        selectClientFirmNameField.click();
    }

    /**
     * This method click on show list button.
     */
    public static void clickOnShowListButton() {
        showListButton.click();
    }

    /**
     * This method select item from item list
     */
    public static void selectItemFromItemList(String itemName) {
        selectItemFromItemList(itemName);
    }

    /**
     * This method click on no VAT checkbox
     */
    public static void clickOnNoVatCheckBox() {
        if (!noVatCheckbox.isSelected()) {
            noVatCheckbox.click();
        }
    }

    /**
     * This method click on button create invoice
     */
    public static void clickOnButtonCreateInvoice() {
        createInvoiceButton.click();
    }

    /**
     * This method check that we are created invoice successful
     */

    public static void assertThatTheInvoiceWasCreatedSuccessful(){
        Assert.assertTrue(headLineInvoiceNumber.getText().contains("Фактура №"));
    }

    /**
     * This method assert money amount total is calculate correct
     */
    public static void assertMoneyAmountTotal(){
        Assert.assertEquals(moneyAmountTotalField.getText(), "2500.00");
    }
}
