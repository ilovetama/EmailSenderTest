package com.epam.training.tests.yahoo;

import com.epam.training.pageobject.yahoo.HomePage;
import com.epam.training.pageobject.yahoo.LoginPage;
import com.epam.training.pageobject.yahoo.MailPage;
import com.epam.training.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class YahooTest extends BaseTest {

    @BeforeMethod
    public void openBrowser(){
        driver.get(yahooUrl);
    }

    @Test(priority = 1)
    public void testLoginWithCorrectUsernameAndPassword() throws InterruptedException {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        MailPage mailPage = new MailPage(driver);
        home.clickSignInLink(home.signInLink);
        login.enterLogin(login.login,usernameYahoo);
        login.clickSignInButton(login.signInButton);
        login.enterPassword(login.password,password);
        login.clickSignInButton(login.signInButton);
        Thread.sleep(3000);
        assertTrue(mailPage.emailIsUnread());
        Thread.sleep(3000);
        assertEquals(emailSender, mailPage.getSenderName());
        mailPage.clickUnreadEmail();
        assertEquals(emailSubject, mailPage.getSubject());
        assertEquals(emailContent, mailPage.getMessage());
    }
}


