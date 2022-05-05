package com.epam.training.pageobject.yandex;

import com.epam.training.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By login = By.xpath("//input[@id = 'passp-field-login']");
    public By password = By.xpath("//input[@id = 'passp-field-passwd']");
    public By signInButton = By.xpath("//button[@id = 'passp:sign-in' and span[contains(text(),'Войти')]]");
    public By incorrectUsernameMessage = By.xpath("//div[contains(@id, 'field:input-login')]");
    public By incorrectPasswordMessage = By.xpath("//div[contains(@id, 'field:input-passwd')]");

    public String getIncorrectUsernameMessage() {
        return driver.findElement(incorrectUsernameMessage).getText();
    }
    public String getIncorrectPasswordMessage() {
        return driver.findElement(incorrectPasswordMessage).getText();
    }
}