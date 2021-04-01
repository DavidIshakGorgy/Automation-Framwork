package tests;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void initTest() {
        driver.set(BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME));
        BrowserActions.navigateToURL(getDriver(), "https://www.google.com", "https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        if(getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
