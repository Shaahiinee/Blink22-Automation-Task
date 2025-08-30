package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected final WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(2));
    }

    private WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected final void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected final void sendKeys(By locator , String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected final boolean isElementPresent(By locator) {
        try {
            return !findElements(locator).isEmpty();
        } catch (RuntimeException e) {
            return false;
        }
    }

    protected final String getText(By locator) {
        try {
            return findElement(locator).getText();
        } catch (RuntimeException e) {
            return "";
        }
    }

    protected final String getPlaceholder(By locator) {
        try {
            return findElement(locator).getAttribute("placeholder");
        } catch (RuntimeException e) {
            return "";
        }
    }
}