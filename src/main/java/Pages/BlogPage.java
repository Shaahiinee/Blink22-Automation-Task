package Pages;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    By fullNameField = By.id("fullname");
    By emailField = By.id("email");
    By subscribeBtn = By.id("_form_5_submit");
    By formContent = By.className("_form-content");
    By thankYouMsgField = By.className("_form-thank-you");
    By fullNameErr = By.cssSelector("#fullname + div._error ._error-inner");
    By emailErr = By.cssSelector("#email + div._error ._error-inner");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void subscribe(String fullName, String email) {
        sendKeys(fullNameField, fullName);
        sendKeys(emailField, email);
        click(subscribeBtn);
        getThankYouMsg();
    }

    public boolean isFormContentVisible() {
        return isElementPresent(formContent);
    }

    public boolean isThankYouMsgVisible() {
        return isElementPresent(thankYouMsgField);
    }

    public boolean isFullNameErrMsgVisible() {
        return isElementPresent(fullNameErr);
    }

    public boolean isEmailErrMsgVisible() {
        return isElementPresent(emailErr);
    }

    public String getFullNamePlaceholder() {
        return getPlaceholder(fullNameField);
    }

    public String getEmailPlaceholder() {
        return getPlaceholder(emailField);
    }

    public String getThankYouMsg() {
        return getText(thankYouMsgField);
    }

    public String getFullNameErrMsg() {
        return getText(fullNameErr);
    }

    public String getEmailErrMsg() {
        return getText(emailErr);
    }
}