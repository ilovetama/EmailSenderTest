package com.epam.ta.page.yahoo;

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
    private final String PAGE_URL = "https://login.yahoo.com";

    private By inputPassword = By.xpath("//input[contains(@id,'login-passwd')]");

    @FindBy(xpath = "//input[contains(@class,'phone-no ')]")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[contains(@id,'login-signin')]")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openPage() {
        logger.info("Login page opened");
        return this;
    }

    public LoginPage login(User user) {
        inputLogin.sendKeys(user.getUsername());
        buttonSubmit.click();
        waitForElementVisible(inputPassword).sendKeys(user.getPassword());
        buttonSubmit.click();
        logger.info("Login performed");
        return this;
    }

    public MailPage openMailPage(){
        return new MailPage(driver);
    }
}
