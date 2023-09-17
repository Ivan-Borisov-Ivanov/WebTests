package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import testData.LogInData;


public class LogInTest extends BaseTest {

    LogInData logInInfo = new LogInData();


    @Test
    public void loginInLoginToPageTest() {
        LogInPage.goTo();
        LogInPage.login(logInInfo.getLoginMail(), logInInfo.getLoginPass());
        HomePage.clickAcceptPopupButton();
        HomePage.assertThatWeWereNavigatedOnTheHomePageSuccessful();
    }

    @Test
    public void loginInLoginPageWithWrongEmailTest() {
        LogInPage.goTo();
        LogInPage.login(logInInfo.getWrongLoginMail(), logInInfo.getLoginPass());
        LogInPage.assertErrMsgWrongUserOrPassAppears();
    }

    @Test
    public void loginInLoginPageWithWrongPasswordTest() {
        LogInPage.goTo();
        LogInPage.login(logInInfo.getLoginMail(), logInInfo.getWrongLoginPass());
        LogInPage.assertErrMsgWrongUserOrPassAppears();
    }

}
