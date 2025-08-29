package Core;

import Pages.BlogPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected BlogPage blogPage;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver("edge");
        homePage = new HomePage(driver);
        homePage = homePage.goToHomePage();
        blogPage = homePage.clickOnBlog();
        System.out.println(blogPage.getFullNamePlaceholder());
        System.out.println(blogPage.getEmailPlaceholder());
        //The Task only said extract.
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
