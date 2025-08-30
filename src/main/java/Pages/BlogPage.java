package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    private By fullNameField = By.id("fullname");
    private By emailField = By.id("email");
    private By subscribeBtn = By.id("_form_5_submit");
    private By formContent = By.className("_form-content");
    private By thankYouMsgField = By.className("_form-thank-you");
    private By fullNameErr = By.cssSelector("#fullname + div._error ._error-inner");
    private By emailErr = By.cssSelector("#email + div._error ._error-inner");

    BlogPage(WebDriver driver) {
        super(driver);
    }

    public final void subscribe(String fullName , String email) {
        sendKeys(fullNameField , fullName);
        sendKeys(emailField , email);
        click(subscribeBtn);
        getThankYouMsg();
    }

    public final boolean isFormContentVisible() {
        return isElementPresent(formContent);
    }

    public final boolean isThankYouMsgVisible() {
        return isElementPresent(thankYouMsgField);
    }

    public final boolean isFullNameErrMsgVisible() {
        return isElementPresent(fullNameErr);
    }

    public final boolean isEmailErrMsgVisible() {
        return isElementPresent(emailErr);
    }

    public final String getFullNamePlaceholder() {
        return getPlaceholder(fullNameField);
    }

    public final String getEmailPlaceholder() {
        return getPlaceholder(emailField);
    }

    public final String getThankYouMsg() {
        return getText(thankYouMsgField);
    }

    public final String getFullNameErrMsg() {
        return getText(fullNameErr);
    }

    public final String getEmailErrMsg() {
        return getText(emailErr);
    }
}