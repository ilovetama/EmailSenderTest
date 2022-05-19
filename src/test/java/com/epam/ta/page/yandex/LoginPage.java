package com.epam.ta.page.yandex;

import com.epam.ta.model.User;
import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://passport.yandex.by";

    private final By inputPassword = By.xpath("//input[@type = 'password']");
    private final By emptyUsernameErrorMessage = By.xpath("//div[contains(@id, 'field:input-login:hint')]");
    private final By emptyPasswordErrorMessage = By.xpath("//div[contains(@id, 'field:input-passwd:hint')]");

    @FindBy(xpath = "//input[@id = 'passp-field-login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//button[@id = 'passp:sign-in' and span[contains(text(),'Войти')]]")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public MailPage login(User user) {
        inputLogin.sendKeys(user.getUsername());
        buttonSubmit.click();
        waitForElementVisible(inputPassword).sendKeys(user.getPassword());
        buttonSubmit.click();
        logger.info("Login performed");
        return new MailPage(driver);
    }

    public LoginPage loginWithEmptyUsername(User user) {
        inputLogin.sendKeys(user.getUsername());
        buttonSubmit.click();
        return this;
    }

    public LoginPage loginWithEmptyPassword(User user) {
        inputLogin.sendKeys(user.getUsername());
        buttonSubmit.click();
        waitForElementVisible(inputPassword).sendKeys(user.getPassword());
        buttonSubmit.click();
        return this;
    }

    public String getEmptyUsernameErrorMessage(String expectedError) {
        String error = waitForElementLocated(emptyUsernameErrorMessage).getText();
        logger.info("Expected error message: " + expectedError + " | " + "Current error message: " + error);
        return error;
    }

    public String getEmptyPasswordErrorMessage(String expectedError) {
        String error = waitForElementLocated(emptyPasswordErrorMessage).getText();
        logger.info("Expected error message: " + expectedError + " | " + "Current error message: " + error);
        return error;
    }

}
