package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import static org.testng.Assert.assertFalse;

public class BasePage {

    public static void navigate(String url) {
        Browser.driver.get("https://mycompany-ood.inv.bg/" + url);
    }

    private static final String objectValue = "//div[@class='simplebox']//td[contains(.,'%s')]/following-sibling::td";

    public static void waitForElementToBeClickable(WebElement webElement) {
        WebDriverWait driverWait = new WebDriverWait(Browser.driver, 10);
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitForElementToBeVisible(WebElement webElement) {
        WebDriverWait driverWait = new WebDriverWait(Browser.driver, 10);
        driverWait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

    @SneakyThrows
    public static void hardWait(long milliseconds) {
        Thread.sleep(milliseconds);
    }

    public static String getValueFromProperty(String property) {
        String loc = objectValue.replace("%s", property);
        WebElement newElement = Browser.driver.findElement(By.xpath(loc));

        return newElement.getText();
    }


    public static void acceptPopUp() {
        Browser.driver.switchTo().alert().accept();
    }

    public static void acceptModal() {
        Browser.driver.findElement(By.xpath("//button[contains(.,'Да')]")).click();
    }

    public static void elementDoesNotPresent(WebElement webElement) {
        assertFalse(webElement.isDisplayed());
    }
}
