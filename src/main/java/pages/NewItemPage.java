package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testData.ItemTestData;
import utils.Browser;

public class NewItemPage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    private static WebElement itemNameField;

    @FindBy(xpath = "//input[@name='name_en']")
    private static WebElement itemNameFieldEng;

    @FindBy(xpath = "//input[@name='price']")
    private static WebElement priceField;

    @FindBy(xpath = "//input[@name='account']")
    private static WebElement accountField;

    @FindBy(xpath = "//input[@name='do_submit']")
    private static WebElement addItemButton;

    @FindBy(id = "okmsg")
    private static WebElement informationBarSuccessfulAddingItem;

    @FindBy(id = "error")
    private static WebElement errorMessage;

    @FindBy(xpath = "//a[contains(.,'се върни в списъка с артикули')]")
    private static WebElement navigateToItemListButton;


    static {
        PageFactory.initElements(Browser.driver, NewItemPage.class);
    }

    /**
     * This method navigate to New Item Page
     */
    public static void navigate() {
        navigate("objects/add");
    }

    /**
     * This method input in Item name field
     */
    public static void inputInItemNameField(String randomItemName) {

        itemNameField.sendKeys(randomItemName);
    }

    /**
     * This method input in Item name field in English
     */
    public static void inputInItemNameFieldEng(String randomItemNameEn) {
        itemNameFieldEng.sendKeys(randomItemNameEn);
    }

    /**
     * This method input the price of item in the field
     */
    public static void inputPriceOfTheItem(String randomPrice) {
        priceField.clear();
        priceField.sendKeys(randomPrice);

    }

    /**
     * This method input the bank account in the field
     */
    public static void inputBankAccount(String randomBankAccount) {
        accountField.sendKeys(randomBankAccount);
    }

    /**
     * This method click on add item button
     */
    public static void clickOnAddItemButton() {
        addItemButton.click();
    }

    /**
     * This method assert that the item was added Successful
     */
    public static void assertItemWasAddedSuccessful() {
        Assert.assertTrue(informationBarSuccessfulAddingItem.getText().contains("добавен успешно"));
    }

    /**
     * This method Asset for error message when try to add Item without name.
     */
    public static void assertErrMsgAddressNameAppear() {
        Assert.assertTrue(errorMessage.getText().contains("въведете име/номенклатура на артикула"));
    }

    /**
     * This method Assert Item Bg name was added successful
     */
    public static void assertItemNameBgWasAddedSuccessful(ItemTestData item) {
        Assert.assertTrue(getValueFromProperty("Име на артикул:").contains(item.getNameBg()));
    }

    /**
     * This method Assert Item En name was added successful
     */
    public static void assertItemNameEnWasAddedSuccessful(ItemTestData item) {
        Assert.assertTrue(getValueFromProperty("Име на английски език:").contains(item.getNameEn()));
    }

    /**
     * This method Assert Item price was added successful
     */
    public static void assertItemPriceWasAddedSuccessful(ItemTestData item) {
        Assert.assertTrue(getValueFromProperty("Единична цена:").contains(item.getPcPrice()));
    }

    /**
     * This method Assert Bank account was added successful
     */
    public static void assertBankAccountWasAddedSuccessful(ItemTestData item) {
        Assert.assertTrue(getValueFromProperty("Сметка:").contains(item.getBankAccount()));
    }

    /**
     * This method edit Item BG and EN name
     */
    public static void editItemBgAndEnName(String randomItemName, String randomItemNameEn) {
        itemNameField.clear();
        itemNameField.sendKeys(randomItemName);
        itemNameFieldEng.clear();
        itemNameFieldEng.sendKeys(randomItemNameEn);
    }

    /**
     * This method assert that the item was edit Successful
     */
    public static void assertThatTheItemWasEditSuccessful() {
        Assert.assertTrue(informationBarSuccessfulAddingItem.getText().contains("Информацията е редактирана успешно."));
    }

    /**
     * This method navigate to item list
     */
    public static void navigateToItemList() {
        navigateToItemListButton.click();
    }

}