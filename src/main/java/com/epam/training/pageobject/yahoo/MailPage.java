package com.epam.training.pageobject.yahoo;

import com.epam.training.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    By unreadEmail = By.xpath("//a[contains(@role,'article') and contains(@data-test-read,'false')]");
    By sender = By.xpath("//a[contains(@role,'article')" +
            " and contains(@data-test-read,'false')" +
            " and contains(@aria-label,'Alexey Lutskevich')]");
    By subject = By.xpath("//span[contains(@data-test-id,'message-group-subject-text')]/font/font");
    By message =By.xpath("//div[contains(@data-test-id,'message-body-container')]");

    public String getSenderName() {
        return driver.findElement(sender).getText();
    }

    public boolean emailIsUnread() {
       return driver.findElement(unreadEmail).isDisplayed();
    }

    public String getSubject() {
        return driver.findElement(subject).getText();
    }

    public void clickUnreadEmail() {
        driver.findElement(unreadEmail).click();
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }

}
