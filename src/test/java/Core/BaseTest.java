package Core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {
    @BeforeMethod
    public void setupBrowser() {

        Browser.setup();
    }

    @AfterMethod
    public void quitBrowser() {

        Browser.tearDown();
    }
}
