package core;

import pages.BlogPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BlogPage blogPage;

    @BeforeMethod
    public final void setup() {
        WebDriver driver = DriverManager.getDriver("edge");
        HomePage homePage = new HomePage(driver);
        homePage = homePage.goToHomePage();
        homePage.closeCookiesPopup();
        blogPage = homePage.clickOnBlog();
        System.out.println(blogPage.getFullNamePlaceholder());
        System.out.println(blogPage.getEmailPlaceholder());
        //The Task only said extract.
    }

    @AfterMethod
    public final void tearDown() {
        DriverManager.quitDriver();
    }
}
