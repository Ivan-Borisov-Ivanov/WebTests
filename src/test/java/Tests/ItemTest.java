package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import testData.ItemTestData;
import testData.LogInData;

public class ItemTest extends BaseTest {

    ItemTestData itemInfo = new ItemTestData();
    LogInData logInInfo = new LogInData();

    private void goToItemsPage() {
        LogInPage.goTo();
        LogInPage.login(logInInfo.getLoginMail(), logInInfo.getLoginPass());
        ItemsPage.navigate();
    }

    @Test
    public void addItemTest() {
        this.goToItemsPage();
        ItemsPage.clickOnNewItemButton();
        ItemsPage.assertWeAreInNewItemPage();
        NewItemPage.inputInItemNameField(itemInfo.getNameBg());
        NewItemPage.inputInItemNameFieldEng(itemInfo.getNameEn());
        NewItemPage.inputPriceOfTheItem(itemInfo.getPcPrice());
        NewItemPage.inputBankAccount(itemInfo.getBankAccount());
        NewItemPage.clickOnAddItemButton();
        NewItemPage.assertItemWasAddedSuccessful();
    }

    @Test
    public void addItemWithoutNameTest() {
        this.goToItemsPage();
        ItemsPage.clickOnNewItemButton();
        ItemsPage.assertWeAreInNewItemPage();
        NewItemPage.inputInItemNameField(itemInfo.getNameBgEmptyString());
        NewItemPage.inputInItemNameFieldEng(itemInfo.getNameEnEmptyString());
        NewItemPage.inputPriceOfTheItem(itemInfo.getPcPrice());
        NewItemPage.inputBankAccount(itemInfo.getBankAccount());
        NewItemPage.clickOnAddItemButton();
        NewItemPage.assertErrMsgAddressNameAppear();
    }

    @Test
    public void deleteItemFormItemListTest() {
        this.goToItemsPage();
        ItemsPage.selectItem(itemInfo.getNameBg());
        ItemsPage.deleteSelectedItem();
        BasePage.acceptModal();
        ItemsPage.assertItemWasDeletedSuccessful();
    }

    @Test
    public void verifyReadCreatedItemTest() {
        this.goToItemsPage();
        ItemsPage.clickOnNewItemButton();
        ItemsPage.assertWeAreInNewItemPage();
        NewItemPage.inputInItemNameField(itemInfo.getNameBg());
        NewItemPage.inputInItemNameFieldEng(itemInfo.getNameEn());
        NewItemPage.inputPriceOfTheItem(itemInfo.getPcPrice());
        NewItemPage.inputBankAccount(itemInfo.getBankAccount());
        NewItemPage.clickOnAddItemButton();
        NewItemPage.assertItemNameBgWasAddedSuccessful(itemInfo);
        NewItemPage.assertItemNameEnWasAddedSuccessful(itemInfo);
        NewItemPage.assertItemPriceWasAddedSuccessful(itemInfo);
        NewItemPage.assertBankAccountWasAddedSuccessful(itemInfo);
    }


    @Test
    public void editItemNameTest() {
        this.goToItemsPage();
        ItemsPage.openItem(itemInfo.getNameBg());
        ItemsPage.clickOnEditItemButton();
        NewItemPage.editItemBgAndEnName(itemInfo.getOtherNameBg(), itemInfo.getOtherNameEn());
        NewItemPage.clickOnAddItemButton();
        NewItemPage.assertThatTheItemWasEditSuccessful();
    }


    @Test
    public void deleteEditedItemFromItemListTest() {
        this.goToItemsPage();
        ItemsPage.selectItem(itemInfo.getOtherNameBg());
        ItemsPage.deleteSelectedItem();
        BasePage.acceptModal();
        ItemsPage.assertItemWasDeletedSuccessful();
    }

    @Test
    public void addOtherItemTest() {
        this.goToItemsPage();
        ItemsPage.clickOnNewItemButton();
        ItemsPage.assertWeAreInNewItemPage();
        NewItemPage.inputInItemNameField(itemInfo.getOtherItemNameBg());
        NewItemPage.inputInItemNameFieldEng(itemInfo.getOtherItemNameEn());
        NewItemPage.inputPriceOfTheItem(itemInfo.getPcPrice());
        NewItemPage.inputBankAccount(itemInfo.getBankAccount());
        NewItemPage.clickOnAddItemButton();
        NewItemPage.assertItemWasAddedSuccessful();
    }

    @Test
    public void deleteItemTest() {
        this.goToItemsPage();
        ItemsPage.openItem(itemInfo.getOtherItemNameBg());
        ItemsPage.deleteItem();
        BasePage.acceptModal();
        ItemsPage.assertItemWasDeletedSuccessful();
    }
}