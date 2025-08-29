package Pages;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

private final By navButton = By.cssSelector("button[aria-label='Nav Button']");
private final By blogTab = By.cssSelector("a[href='/blog/']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage()
    {
        driver.get("https://www.blink22.com/");
        return new HomePage(driver);
    }

    public BlogPage clickOnBlog(){
        click(navButton);
        click(blogTab);
        return new BlogPage(driver);
    }
}
