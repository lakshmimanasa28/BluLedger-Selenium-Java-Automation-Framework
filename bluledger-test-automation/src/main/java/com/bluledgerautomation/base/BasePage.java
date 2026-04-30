package com.bluledgerautomation.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bluledgerautomation.utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.config = new ConfigReader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(config.getTimeout()));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitForUrlContains(String text) {
        return wait.until(ExpectedConditions.urlContains(text));
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}