package pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private WebDriver webDriver;
    private By headerPageTxt = By.cssSelector(".signuponepage.main.content.clearfix>h1");

    public CreateAccountPage(WebDriver driver) {
        this.webDriver=driver;
    }

    public String getPageTitle() {
        String title = webDriver.getTitle();
        return title;
    }

    public boolean verifyPageTitle() {
        String pageTitle = "Create your Google Account";
        return getPageTitle().contains(pageTitle);
    }
    public boolean verifyCreateAccountPageText() {
        WebElement element = webDriver.findElement(headerPageTxt);
        String pageText ="Create your Google Account";
        return element.getText().contains(pageText);
    }

    public void createAccount() {
//need to write steps for creating an account
    }
}
