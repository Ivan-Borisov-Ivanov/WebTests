package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import testData.CompanyTestData;
import testData.ItemTestData;
import testData.LogInData;

public class ClientTest extends BaseTest {

    ItemTestData itemInfo = new ItemTestData();
    CompanyTestData companyInfo = new CompanyTestData();
    LogInData logInInfo = new LogInData();

    private void goToClientPage() {
        LogInPage.goTo();
        LogInPage.login(logInInfo.getLoginMail(), logInInfo.getLoginPass());
        ClientPage.navigate();
    }

    @Test
    public void addClientTest() {
        this.goToClientPage();
        ClientPage.clickNewClientButton();
        ClientPage.insertCompanyNameInTheField(companyInfo.getCompanyName());
        ClientPage.insertCompanyAddress(companyInfo.getCompanyAddress());
        ClientPage.insertTheCityOfTheCompany(companyInfo.getCompanyCity());
        ClientPage.clickAddClientButton();
        ClientPage.assertTheClientWasCreatedSuccessful();
    }

    @Test
    public void addClientWithoutNameTest() {
        this.goToClientPage();
        ClientPage.clickNewClientButton();
        ClientPage.insertCompanyNameInTheField(companyInfo.getCompanyWithoutName());
        ClientPage.insertCompanyAddress(companyInfo.getCompanyAddress());
        ClientPage.insertTheCityOfTheCompany(companyInfo.getCompanyCity());
        ClientPage.clickAddClientButton();
        ClientPage.assertErrMsgAddCompanyAppear();
    }

    @Test
    public void addClientWithEmptyAddressTest() {
        this.goToClientPage();
        ClientPage.clickNewClientButton();
        ClientPage.insertCompanyNameInTheField(companyInfo.getCompanyName());
        ClientPage.insertCompanyAddress(companyInfo.getEmptyCompanyAddress());
        ClientPage.insertTheCityOfTheCompany(companyInfo.getCompanyCity());
        ClientPage.clickAddClientButton();
        ClientPage.assertErrMsgAddressAppear();
    }

    @Test
    public void verifyReadCreatedClientTest() {
        this.goToClientPage();
        ClientPage.clickNewClientButton();
        ClientPage.insertCompanyNameInTheField(companyInfo.getCompanyName());
        ClientPage.insertCompanyAddress(companyInfo.getCompanyAddress());
        ClientPage.insertTheCityOfTheCompany(companyInfo.getCompanyCity());
        ClientPage.clickAddClientButton();
        ClientPage.assertCityWasAddedSuccessful(companyInfo);
        ClientPage.assertAddressWasAddedSuccessful(companyInfo);
    }


    @Test
    public void editClientNameFromCompanyListTest() {
        CompanyTestData newCompany = new CompanyTestData();

        this.goToClientPage();
        ClientPage.editClientFromClientList(companyInfo.getCompanyName());
        ClientPage.editCompanyName(newCompany.getEditCompanyName());
        ClientPage.clickAddClientButton();
        newCompany.setCompanyName(companyInfo.getEditCompanyName());
        ClientPage.assertThatTheCompanyNameWasChangedSuccessful(newCompany);
    }

    @Test
    public void editClientNameTest() {
        CompanyTestData newCompany = new CompanyTestData();

        this.goToClientPage();
        ClientPage.openClientFromCompanyList(companyInfo.getCompanyName());
        ClientPage.clickOnEditCompanyButton();
        ClientPage.editCompanyName(newCompany.getEditCompanyName());
        ClientPage.clickAddClientButton();
        newCompany.setCompanyName(companyInfo.getEditCompanyName());
        ClientPage.assertThatTheCompanyNameWasChangedSuccessful(newCompany);
    }

    @Test
    public void issueInvoiceTest() {
        this.goToClientPage();
        ClientPage.selectClientFromClientList(companyInfo.getEditCompanyName());
        ClientPage.issueInvoiceButton();
        NewInvoicePage.clickOnShowListButton();
        NewInvoicePage.selectItemFromItemList(itemInfo.getNameBg());
        NewInvoicePage.clickOnNoVatCheckBox();
        NewInvoicePage.clickOnButtonCreateInvoice();
        NewInvoicePage.assertThatTheInvoiceWasCreatedSuccessful();
    }

    @Test
    public void deleteClientFromListTest() {
        this.goToClientPage();
        ClientPage.selectClientFromClientList(companyInfo.getEditCompanyName());
        ClientPage.deleteCompanyFromCompanyList();
        ClientPage.assertTheClientFromListWasDeletedSuccessful();
    }

    @Test
    public void deleteClientTest() {
        this.goToClientPage();
        ClientPage.openClientFromCompanyList(companyInfo.getEditCompanyName());
        ClientPage.deleteCompany();
        BasePage.acceptPopUp();
        ClientPage.assertTheClientWasDeletedSuccessful();
    }

}