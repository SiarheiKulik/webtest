package pagefactory.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.page.HomePage;
import pagefactory.page.SingInPage;

public class SingInPageTest {
    private WebDriver webDriver;
    private HomePage homePage;
    private SingInPage singInPage;


    @BeforeTest
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://gmail.com");
        webDriver.manage().window().maximize();
    }

    @Test
    public void signInFunctionTest() {
        homePage = new HomePage(webDriver);
        singInPage = homePage.loginRegistration("siarhei.kulik84@gmail.com");
        Assert.assertTrue(singInPage.verifySignInPageTitle());
    }

    @AfterTest
    public void browserTearDown() {
        webDriver.quit();
        webDriver = null;
    }

}
