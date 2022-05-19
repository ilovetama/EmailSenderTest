package com.epam.ta.page.yahoo;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends AbstractPage {

    private final String BASE_URL = "http://mail.yahoo.com";
    private final Logger logger = LogManager.getRootLogger();

    private final By senderName = By.xpath("//a[@role = 'article' and @data-test-read = 'false']//div[@data-test-id = 'senders']/..//*[contains(text(),'Alexey')]");
    private final By mailSubject = By.xpath("//span[@data-test-id='message-group-subject-text']");
    private final By unreadMailLink = By.xpath("//a[@role = 'article' and @data-test-read = 'false']");
    private final By mailText = By.xpath("//div[@data-test-id='message-view-body-content']");

    public MailPage openPage() {
        driver.get(BASE_URL);
        logger.info("Mail page opened");
        return this;
    }

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MailPage openMail(){
        driver.findElement(unreadMailLink).click();
        return this;
    }

    public String getSenderName() {
        String senderName = waitForElementLocated(this.senderName).getText();
        logger.info("Expected sender name: 'Alexey Lutskevich' | " + "Current sender name: " + senderName);
        return senderName;
    }

    public String getMailSubject() {
        String mailSubject = waitForElementLocated(this.mailSubject).getText();
        logger.info("Expected subject: 'subject of a mail' | " + "Current subject: " + mailSubject);
        return mailSubject;
    }

    public String getMailText() {
        String mailText = waitForElementLocated(this.mailText).getText();
        logger.info("Expected text: 'text of a mail' | " + "Current text: " + mailText);
        return mailText;
    }
}
