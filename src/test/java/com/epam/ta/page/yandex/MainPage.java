package com.epam.ta.page.yandex;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://www.mail.yandex.ru/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(@href, 'passport.yandex')" +
            " and span[contains(text(),'Войти')]]")
    private WebElement SignInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openLoginPage() {
        SignInButton.click();
        return new LoginPage(driver);
    }

    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
        return this;
    }
}
