package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import testData.CompanyTestData;
import testData.ItemTestData;
import testData.LogInData;

public class InvoiceTest extends BaseTest {

    ItemTestData itemInfo = new ItemTestData();
    CompanyTestData companyInfo = new CompanyTestData();
    LogInData logInInfo = new LogInData();

    private void goToNewInvoicePage(){
        LogInPage.goTo();
        LogInPage.login(logInInfo.getLoginMail(), logInInfo.getLoginPass());
        NewInvoicePage.navigate();
    }

    @Test
    public void addNewInvoiceTest() {

        this.goToNewInvoicePage();
        NewInvoicePage.clickClientListButton();
        NewInvoicePage.selectClientFirmName();
        NewInvoicePage.clickOnShowListButton();
        NewInvoicePage.selectItemFromItemList(itemInfo.getNameBg());
        NewInvoicePage.clickOnNoVatCheckBox();
        NewInvoicePage.clickOnButtonCreateInvoice();
        NewInvoicePage.assertThatTheInvoiceWasCreatedSuccessful();
    }

    @Test
    public void verifyInvoiceToCalculateItemsCorrectly(){
        this.goToNewInvoicePage();
        NewInvoicePage.clickClientListButton();
        NewInvoicePage.selectClientFirmName();
        NewInvoicePage.clickOnShowListButton();
        NewInvoicePage.selectItemFromItemList(itemInfo.getNameBg());
        NewInvoicePage.assertMoneyAmountTotal();
    }

}
