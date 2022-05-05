package com.epam.training.tests.yandex;

import com.epam.training.pageobject.yandex.HomePage;
import com.epam.training.pageobject.yandex.LoginPage;
import com.epam.training.pageobject.yandex.MailPage;
import com.epam.training.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class YandexTest extends BaseTest {

    @BeforeMethod
    public void openBrowser(){
        driver.get(yandexUrl);
    }

    @Test(priority = 5)
    public void testLoginWithCorrectUsernameAndPassword() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        MailPage mailPage = new MailPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login, usernameYandex);
        login.clickSignInButton(login.signInButton);
        login.enterPassword(login.password, password);
        login.clickSignInButton(login.signInButton);
        Thread.sleep(3000);
        mailPage.clickUserAccountLink();
        Thread.sleep(3000);
        assertEquals(usernameVerify, mailPage.getUserName());
        mailPage.clickLogoutButton();
    }

    @Test(priority = 4)
    public void testLoginWithInCorrectUsername() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.password, incorrectUsername);
        login.clickSignInButton(login.signInButton);
        assertEquals(incorrectUsernameMessage, login.getIncorrectUsernameMessage());
    }

    @Test(priority = 3)
    public void testLoginWithCorrectUsernameAndIncorrectPassword() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login, usernameYandex);
        login.clickSignInButton(login.signInButton);
        login.enterPassword(login.password, incorrectPassword);
        login.clickSignInButton(login.signInButton);
        assertEquals(incorrectPasswordMessage, login.getIncorrectPasswordMessage());
    }

    @Test(priority = 2)
    public void testLoginWithEmptyUsername() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login, "");
        login.clickSignInButton(login.signInButton);
        assertEquals(emptyUsernameMessage, login.getIncorrectUsernameMessage());
    }

    @Test(priority = 1)
    public void testLoginWithCorrectUsernameAndEmptyPassword() {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login, usernameYandex);
        login.clickSignInButton(login.signInButton);
        login.enterPassword(login.password, "");
        login.clickSignInButton(login.signInButton);
        assertEquals(emptyPasswordMessage, login.getIncorrectPasswordMessage());
    }

    @Test(priority = 1)
    public void testComposeAMail() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        MailPage mailPage = new MailPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login, usernameYandex);
        login.clickSignInButton(login.signInButton);
        login.enterPassword(login.password, password);
        login.clickSignInButton(login.signInButton);
        Thread.sleep(3000);
        mailPage.clickComposeButton();
        mailPage.enterToEmail(emailTo);
        mailPage.enterSubject(emailSubject);
        mailPage.enterText(emailContent);
        mailPage.clickSendButton();
    }
}
