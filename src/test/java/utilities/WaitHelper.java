package utilities;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(By locator, int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator, int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPresenceOfElement(By locator, int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForUrlContains(String urlFraction, int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    public void waitForTextPresentInElement(By locator, String text, int timeInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}

