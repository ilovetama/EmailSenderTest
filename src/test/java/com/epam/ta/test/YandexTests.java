package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.yandex.LoginPage;
import com.epam.ta.page.yandex.MainPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YandexTests extends CommonConditions {

    private final String TO = "alexey.lutskevich@yahoo.com";
    private final String SUBJECT = "subject of a mail";
    private final String TEXT = "text of a mail";
    private final String EXPECTED_MESSAGE = "Письмо отправлено";

    @Test(description = "JIRA-7566")
    public void ableToLogin()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String userName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .openMailPage()
                .getUserNameCorrect(testUser.getUsername());
        assertThat(userName, is(containsString(testUser.getUsername())));
    }

    @Test(description = "JIRA-6675",groups="integration", priority = 1)
    public void ableToSendAMail()
    {
        User testUser = UserCreator.withCredentialsFromProperty();

        String message = new MainPage(driver)
                .openPage()
                .openLoginPage()
                .login(testUser)
                .openMailPage()
                .createNewMail(TO,SUBJECT,TEXT);
        assertThat(message, is(equalTo(EXPECTED_MESSAGE)));
    }
}
