package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testData.CompanyTestData;
import utils.Browser;

import javax.xml.xpath.XPath;

public class ClientPage extends BasePage {

    @FindBy(xpath = "//a[@class='newbtn selenium-add-client-button']")
    private static WebElement newClientButton;

    @FindBy(xpath = "//*[@name='firm_name']")
    private static WebElement companyNameField;

    @FindBy(xpath = "//*[@name='firm_addr']")
    private static WebElement companyAddressField;

    @FindBy(xpath = "//*[@name='firm_town']")
    private static WebElement cityOfTheCompany;

    @FindBy(xpath = "//*[@name='do_submit']")
    private static WebElement addClientButton;

    @FindBy(id = "okmsg")
    private static WebElement informationBar;

    @FindBy(id = "error")
    private static WebElement errorMessage;

    @FindBy(xpath = "//a[text()='ИТ Магазин ООД']")
    private static WebElement choseCompanyField;

    @FindBy(xpath = "//div[@id='headline2']")
    private static WebElement confirmationCompanyNameBar;

    @FindBy(xpath = "//span[contains(text(),'Редактирай')]")
    private static WebElement editCompanyButton;

    @FindBy(id = "cl_delbtn")
    private static WebElement deleteCompanyButtonFromList;

    @FindBy(id = "delete--btn")
    private static WebElement deleteCompanyButton;

    @FindBy(id = "submit-clients-delete")
    private static WebElement deleteConfirmationButton;

    @FindBy(id = "cl_invbtn")
    private static WebElement invoiceButton;


    private static String client = "//a[contains(text(),'%s')]/parent::td/parent::tr//input";

    private static String clientEditButton = "//td[contains(.,'%s')]/parent::tr//a[contains(.,'Редактирай')]";

    private static String choseClient = "//a[contains(text(),'%s')]";


    static {
        PageFactory.initElements(Browser.driver, ClientPage.class);
    }

    /**
     * This method navigate to Client page
     */
    public static void navigate() {
        navigate("clients/manage");
    }

    /**
     * This method click on newClientButton.
     */
    public static void clickNewClientButton() {
        newClientButton.click();
    }

    /**
     * This method insert company name in the input field.
     */
    public static void insertCompanyNameInTheField(String randomCompanyName) {
        companyNameField.sendKeys(randomCompanyName);
    }

    /**
     * This method insert company address in the input field.
     */
    public static void insertCompanyAddress(String randomCompanyAddress) {
        companyAddressField.sendKeys(randomCompanyAddress);
    }

    /**
     * This method insert the city of the company in the input field.
     */
    public static void insertTheCityOfTheCompany(String randomCity) {
        cityOfTheCompany.sendKeys(randomCity);
    }

    /**
     * This method click add client button.
     */
    public static void clickAddClientButton() {
        addClientButton.click();
    }

    /**
     * This method Assert the client was created successful.
     */
    public static void assertTheClientWasCreatedSuccessful() {
        Assert.assertTrue(informationBar.getText().contains("успешно"), "Клиентът е добавен успешно.");
    }

    /**
     * This method Asset for error message when try to add client without name
     */
    public static void assertErrMsgAddCompanyAppear() {
        Assert.assertTrue(errorMessage.getText().contains("въведете име на фирмата."));
    }

    /**
     * This method Asset for error message when try to add client with empty address
     */
    public static void assertErrMsgAddressAppear() {
        Assert.assertTrue(errorMessage.getText().contains("въведете адрес по регистрация на фирмата."));
    }

    /**
     * This method Assert city was added successful.
     */
    public static void assertCityWasAddedSuccessful(CompanyTestData company) {
        Assert.assertTrue(getValueFromProperty("Град:").contains(company.getCompanyCity()));
    }

    /**
     * This method Assert company address was added successful
     */
    public static void assertAddressWasAddedSuccessful(CompanyTestData company) {
        Assert.assertTrue(getValueFromProperty("Адрес по регистрация:").contains(company.getCompanyAddress()));
    }

    /**
     * This method edit company name in the input field.
     */
    public static void editCompanyName(String randomCompanyName) {
        companyNameField.clear();
        companyNameField.sendKeys(randomCompanyName);
    }

    /**
     * This method assert that the company name was changed successful
     */
    public static void assertThatTheCompanyNameWasChangedSuccessful(CompanyTestData company) {
        Assert.assertTrue(confirmationCompanyNameBar.getText().contains(company.getCompanyName()));
    }

    /**
     * This method select client from client list
     *
     * @param clientName
     */
    public static void selectClientFromClientList(String clientName) {
        String loc = client.replace("%s", clientName);
        WebElement newSelectedElement = Browser.driver.findElement(By.xpath(loc));
        newSelectedElement.click();
    }

    /**
     * This method edit client from client list
     *
     * @param clientName
     */
    public static void editClientFromClientList(String clientName) {
        String loc = clientEditButton.replace("%s", clientName);
        WebElement newEditedElement = Browser.driver.findElement(By.xpath(loc));
        newEditedElement.click();
    }

    /**
     * This method click client from company list
     *
     * @param clientName
     */
    public static void openClientFromCompanyList(String clientName) {
        String loc = choseClient.replace("%s", clientName);
        WebElement choseClientElement = Browser.driver.findElement(By.xpath(loc));
        choseClientElement.click();
    }

    /**
     * This method click on edit company button
     */
    public static void clickOnEditCompanyButton() {
        editCompanyButton.click();
    }

    /**
     * This method issue invoice button
     */
    public static void issueInvoiceButton(){
        invoiceButton.click();
    }

    /**
     * This method delete company from company list
     */
    public static void deleteCompanyFromCompanyList() {
        deleteCompanyButtonFromList.click();
        deleteConfirmationButton.click();
    }

    /**
     * This method delete company
     */
    public static void deleteCompany() {
        deleteCompanyButton.click();
    }


    /**
     * This method Assert the client from list was deleted successful.
     */
    public static void assertTheClientFromListWasDeletedSuccessful() {
        Assert.assertTrue(informationBar.getText().contains("Избраните клиенти бяха изтрити успешно."), "Избраните клиенти бяха изтрити успешно.");
    }

    /**
     * This method Assert the client was deleted successful.
     */
    public static void assertTheClientWasDeletedSuccessful() {
        Assert.assertTrue(informationBar.getText().contains("Клиентът беше изтрит успешно."));
    }
}