package com.epam.training.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public void clickSignInLink(By by) {
        driver.findElement(by).click();
    }
    public void enterLogin(By by,String user) {
        driver.findElement(by).sendKeys(user);
    }

    public void enterPassword(By by, String pass) {
        driver.findElement(by).sendKeys(pass);
    }

    public void clickSignInButton(By by) {
        driver.findElement(by).click();
    }
}
