package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, SECONDS);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

