package pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private SingInPage singInPage;
    private WebDriver webDriver;
    private By login = By.id("identifierId");


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SingInPage loginRegistration(String email) {
        WebElement loginText = waitforElementLocatedBy(webDriver,login);
        loginText.sendKeys(email);
        return new SingInPage(webDriver);
    }

    private WebElement waitforElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getPageTitle() {
        String title = webDriver.getTitle();
        return title;
    }

    public boolean verifyBasePageTitle() {
        String expectedPageTitle = "Gmail";
        return getPageTitle().contains(expectedPageTitle);
    }
}
