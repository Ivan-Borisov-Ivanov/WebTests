package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromdriver106\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    public static void tearDown() {
//        driver.quit();
//    }
}