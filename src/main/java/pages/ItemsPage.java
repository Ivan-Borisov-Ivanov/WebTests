package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;

import javax.xml.xpath.XPath;

public class ItemsPage extends BasePage {
    @FindBy(css = ".newbtn")
    private static WebElement newItemButton;

    @FindBy(id = "headline2")
    private static WebElement headLineNewItem;

    @FindBy(id = "delete-item-button")
    private static WebElement deleteItemButton;

    @FindBy(id = "delbtn")
    private static WebElement deleteSelectedItemButton;

    @FindBy(id = "okmsg")
    private static WebElement informationBarSuccessfulDeletedItem;

    @FindBy(xpath = "//a[contains(.,' Редактирай')]")
    private static WebElement editItemButton;

    private static String objectName = "//a[contains(text(),'%s')]/parent::td/parent::tr//input";

    private static String item = "//a[contains(text(),'%s')]/parent::td/a";


    static {
        PageFactory.initElements(Browser.driver, ItemsPage.class);
    }

    /**
     * This method navigate to Items page
     */
    public static void navigate() {
        navigate("objects/manage");
    }

    /**
     * This method click on New client button
     */
    public static void clickOnNewItemButton() {
        newItemButton.click();
    }

    /**
     * This method assert that we are in new item page
     */
    public static void assertWeAreInNewItemPage() {
        Assert.assertEquals(headLineNewItem.getText(), "Нов артикул");
    }

    /**
     * This method click on item name
     */
    public static void selectItem(String itemName) {
        selectItemFromItemList(itemName);
    }

    /**
     * This method click on edit item button
     */
    public static void clickOnEditItemButton() {
        editItemButton.click();
    }

    /**
     * This method delete item
     */
    public static void deleteItem() {
        deleteItemButton.click();
    }

    /**
     * This method delete selected item
     */
    public static void deleteSelectedItem() {
        deleteSelectedItemButton.click();
    }

    /**
     * This method open chosen item
     *
     * @param itemName
     */
    public static void openItem(String itemName) {
        WebElement itemElement = Browser.driver.findElement(By.xpath(item.replace("%s", itemName)));
        itemElement.click();
    }

    /**
     * This method select item from list
     * @param itemName
     */
    public static void selectItemFromItemList(String itemName) {
        String loc = objectName.replace("%s", itemName);
        WebElement newElement = Browser.driver.findElement(By.xpath(loc));
        newElement.click();
    }

    /**
     * This method assert that the item was deleted from list Successful
     */
    public static void assertItemWasDeletedFromListSuccessful() {
        Assert.assertTrue(informationBarSuccessfulDeletedItem.getText().contains("Избраните артикули бяха изтрити успешно."));
    }

    /**
     * This method assert that the item was deleted successful
     */
    public static void assertItemWasDeletedSuccessful() {
        Assert.assertTrue(informationBarSuccessfulDeletedItem.getText().contains("Артикулът беше изтрит успешно."));
    }

//    public static void assertElementIsDeleted(WebElement item) {
//        hardWait(3000);
//        WebElement itemElement = Browser.driver.findElement(By.xpath(item.replace("%s", itemName)));
//        elementDoesNotPresent(item);
//    }
//
//    public static WebElement getItemAsWebElementByName(String itemName) {
//
//        return Browser.driver.findElement(By.xpath(item.replace("%s", itemName)));
//    }
}