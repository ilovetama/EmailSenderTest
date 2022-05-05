package com.epam.training.pageobject.yandex;

import com.epam.training.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    By displayedUserName = By.xpath("//span[contains(@class, 'user-account__subname')" +
            " and contains(text(),'alexey.lutskevich')]");
    By userAccountLink = By.xpath("//a[contains(@class, 'user-account')]");
    By logoutButton = By.xpath("//a[contains(@href, 'passport.yandex')" +
            " and span[contains(text(),'Выйти из сервисов Яндекса')]]");
    By composeButton = By.xpath("//a[contains(@class, 'main-action-compose')]");
    By inputTo = By.xpath("//div[contains(@data-class-bubble, 'yabble-compose')]");
    By inputSubject = By.xpath("//input[contains(@name, 'subject')]");
    By inputText = By.xpath("//div[contains(@class,'cke_wysiwyg_div')]");
    By sendButton = By.xpath("//div[contains(@class,'ComposeSendButton_desktop')]/button[contains(@class,'Button2')]");

    public String getUserName() {
        return driver.findElement(displayedUserName).getText();
    }

    public void clickUserAccountLink() {
        driver.findElement(userAccountLink).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickComposeButton() {
        driver.findElement(composeButton).click();
    }

    public void enterToEmail(String email) {
        driver.findElement(inputTo).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(inputSubject).sendKeys(subject);
    }

    public void enterText(String text) {
        driver.findElement(inputText).sendKeys(text);
    }

    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }
}

