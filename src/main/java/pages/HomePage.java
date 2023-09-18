package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class HomePage {

    @FindBy(className = "newFeatureOKbutton")
    private static WebElement acceptPopUpButton;

    @FindBy(id = "logo")
    private static WebElement logoHeader;

    static {
        PageFactory.initElements(Browser.driver, HomePage.class);
    }

    /**
     * This method click on Accept Popup button
     */

    public static void clickAcceptPopupButton() {
        acceptPopUpButton.click();
        WebDriverWait driverWait = new WebDriverWait(Browser.driver, 5);

    }

    /**
     * This method check that we were navigated on the home page successful.
     */
    public static void assertThatWeWereNavigatedOnTheHomePageSuccessful() {
        Assert.assertTrue(logoHeader.getText().contains("MyCompany"));
    }
}