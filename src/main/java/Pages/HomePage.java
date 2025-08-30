package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By navButton = By.cssSelector("button[aria-label='Nav Button']");
    private By blogTab = By.cssSelector("a[href='/blog/']");
    private By closeIcon = By.cssSelector("span[style*='cursor: pointer'] > svg");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public final void closeCookiesPopup() {
        if (isElementPresent(closeIcon)) {
            click(closeIcon);
        }
    }

    public final HomePage goToHomePage() {
        driver.get("https://www.blink22.com/");
        return new HomePage(driver);
    }

    public final BlogPage clickOnBlog() {
        click(navButton);
        click(blogTab);
        return new BlogPage(driver);
    }
}
