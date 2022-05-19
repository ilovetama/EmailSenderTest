package com.epam.ta.page.yandex;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://www.yandex.by/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(@href, 'passport.yandex') and div[contains(text(),'Войти')]]")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage clickSingInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Main page opened");
        return this;
    }
}
