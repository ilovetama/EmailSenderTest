package com.epam.ta.test;

import com.epam.ta.model.Mail;
import com.epam.ta.model.User;
import com.epam.ta.page.yahoo.LoginPage;
import com.epam.ta.page.yahoo.MailPage;
import com.epam.ta.service.MailCreator;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YahooTests extends CommonConditions {

    @Test(description = "JIRA-7566", groups = "integration", priority = 2)
    public void mailChecking()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        Mail testMail = MailCreator.withCredentialsFromProperty();
        String senderName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .openMailPage()
                .openPage()
                .getSenderName();
        assertThat(senderName, is(containsString("Alexey Lutskevich")));
        String mailSubject = new MailPage(driver)
                .openMail()
                .getMailSubject();
        assertThat(mailSubject, is(containsString(testMail.getSubject())));
        String mailText = new MailPage(driver)
                .getMailText();
        assertThat(mailText, is(containsString(testMail.getText())));
    }

}
