package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Browser;

public class HeaderComponentPage extends BasePage {

    @FindBy(id = "tabs_clients")
    private static WebElement clientMenu;

    @FindBy(id = "tabs_invoices/new")
    private static WebElement invoiceMenu;

    @FindBy(id = "tabs_objects")
    private static WebElement itemsMenu;

    static {
        PageFactory.initElements(Browser.driver, HeaderComponentPage.class);
    }

    /**
     * This method navigate to HeaderComponentPage
     */
    public static void navigate() {
        navigate("home");
    }

    /**
     * This method click on Clients Header Menu.
     */
    public static void clickOnClientsMenu() {
        BasePage.waitForElementToBeClickable(clientMenu);
        clientMenu.click();
    }

    /**
     * This method click on Invoices Header Menu.
     */
    public static void clickOnInvoicesMenu() {
        BasePage.waitForElementToBeClickable(invoiceMenu);
        invoiceMenu.click();
    }

    /**
     * This method click on Items Header Menu.
     */
    public static void clickOnItemsMenu() {
        itemsMenu.click();
    }
}
