package pagefactory.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagefactory.page.HomePage;

public class CreateAccountPageTest {
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void openHomePageTest() {
        HomePage homePage = new HomePage(webDriver);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        webDriver.quit();
        webDriver = null;
    }

}
