package com.epam.ta.page.yandex;

import com.epam.ta.model.Mail;
import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MailPage extends AbstractPage {

    private final String BASE_URL = "http://mail.yandex.by";
    private final Logger logger = LogManager.getRootLogger();

    private final By currentUserName = By.xpath("//span[@class='username desk-notif-card__user-name']");
    private final By sendIsSuccessful = By.xpath("//div[@class='ComposeDoneScreen-Title']/span[text()='Письмо отправлено']");
    private final By mailLink = By.xpath("//a[contains(@href,'https://mail.yandex.by/')]");
    private final By composeButton = By.xpath("//a[contains(@class, 'mail-ComposeButton js-main-action-compose')]");
    private final By inputTo = By.xpath("//div[contains(@class, 'composeYabbles')]");

    @FindBy(xpath = "//input[contains(@name, 'subject')]")
    private WebElement inputSubject;

    @FindBy(xpath = "//div[contains(@class,'cke_wysiwyg_div')]")
    private WebElement inputText;

    @FindBy(xpath = "//div[contains(@class,'ComposeSendButton_desktop')]/button[contains(@class,'Button2')]")
    private WebElement sendButton;

    public MailPage openPage() {
        logger.info("Mail page opened");
        return this;
    }

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUserName(String username) {
        String userName = waitForElementLocated(currentUserName).getText();
        logger.info("Expected username: " + username + " | " + "Current username: " + userName);
        return userName;
    }

    public String createNewMail(Mail mail) {
        waitForElementLocated(mailLink).click();
        driver.switchTo().window(switchWindow());
        waitForElementLocated(composeButton).click();
        waitForElementLocated(inputTo).sendKeys(mail.getTo());
        inputSubject.sendKeys(mail.getSubject());
        inputText.sendKeys(mail.getText());
        sendButton.click();
        logger.info("Created new mail with To: " + "[" + mail.getTo() + "]" +
                " subject: [" + mail.getSubject() + "] and  text: [" + mail.getText() + "]");
        return waitForElementLocated(sendIsSuccessful).getText();
    }
}
