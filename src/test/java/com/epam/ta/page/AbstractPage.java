package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;

	public abstract AbstractPage openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver)
	{
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
}
