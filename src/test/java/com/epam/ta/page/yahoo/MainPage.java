package com.epam.ta.page.yahoo;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://www.yahoo.com/";
    private final Logger logger = LogManager.getRootLogger();
    private static final By ALERT_AGREE_BUTTON = By.xpath("//button[@type = 'submit']");

    @FindBy(xpath = "//a[contains(@href,'https://mail.yahoo.com') and @id='ybarMailLink']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        waitForAlert(ALERT_AGREE_BUTTON).click();
        logger.info("Main page opened");
        return this;
    }
}
