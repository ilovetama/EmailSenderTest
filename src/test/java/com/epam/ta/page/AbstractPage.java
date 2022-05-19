package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 5;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementLocated(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForAlert(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String switchWindow() {
        String window1 = driver.getWindowHandle();
        Set<String> currentWindow = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindow) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }
        return window2;
    }
}
