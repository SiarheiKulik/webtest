package pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SingInPage {
    private WebDriver webDriver;

    private By headerPageText = By.cssSelector(".hidden-small");
    private By createAccountLink = By.id("link-signup");
    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("password");
    private By loginBtn = By.id("signIn");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");

    public SingInPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getSignInPageTitle() {
        String pageTitle = webDriver.getTitle();
        System.out.println(pageTitle);
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "Sign in — Google Accounts";
        return getSignInPageTitle().contains(expectedTitle);
    }

    public boolean verifySignInPageText() {
        WebElement element = webDriver.findElement(headerPageText);
        String pageText = element.getText();
        String expectedPageText = "Sign in with your Google Account";
        return pageText.contains(expectedPageText);
    }

    public CreateAccountPage clickonCreateAnAccount() {
        WebElement element = webDriver.findElement(createAccountLink);
        if (element.isDisplayed() || element.isEnabled())
            element.click();
        return new CreateAccountPage(webDriver);
    }

    public boolean verifySignIn() {
        enterUserName("test");
        enterPassword("pass");
        clickOnSignIn();
        return getErrorMessage().contains("incorrect");
    }

    public void enterUserName(String userName) {
        WebElement emailTxtBox = webDriver.findElement(emailTextBox);
        if (emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordTxtBox = webDriver.findElement(passwordTextBox);
        if (passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public void clickOnSignIn() {
        WebElement signInBtn = webDriver.findElement(loginBtn);
        if (signInBtn.isDisplayed())
            signInBtn.click();
    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = webDriver.findElement(errorMsgTxt);
        if (errorMsg.isDisplayed() && errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }
}


