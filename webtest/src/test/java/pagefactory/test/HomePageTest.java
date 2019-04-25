package pagefactory.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.page.HomePage;
import pagefactory.page.SingInPage;

public class HomePageTest {
    private WebDriver webDriver;
    private  SingInPage singInPage;

    @BeforeTest
    public void browserSetup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://gmail.com");
        webDriver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(webDriver);
        singInPage = homePage.clickSignInBtn();
        Assert.assertTrue(homePage.verifyBasePageTitle());
    }


    @AfterTest
    public void browserTearDown() {
        webDriver.quit();
        webDriver = null;
    }


}
