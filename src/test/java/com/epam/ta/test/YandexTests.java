package com.epam.ta.test;

import com.epam.ta.model.Mail;
import com.epam.ta.model.User;
import com.epam.ta.page.yandex.MainPage;
import com.epam.ta.service.MailCreator;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YandexTests extends CommonConditions {

    private static final String EXPECTED_MESSAGE = "Письмо отправлено";
    private static final String EMPTY_LOGIN_ERROR_MESSAGE = "Логин не указан";
    private static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Пароль не указан";

    @Test(description = "JIRA-7566")
    @Ignore
    public void ableToLogin()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String userName = new MainPage(driver)
                .openPage()
                .clickSingInButton()
                .login(testUser)
                .getUserName(testUser.getUsername());
        assertThat(userName, is(containsString(testUser.getUsername())));
    }

    @Test(description = "JIRA-7516")
    public void unableToLoginWithEmptyUsername()
    {
        User testUser = UserCreator.withEmptyUsername();
        String userName = new MainPage(driver)
                .openPage()
                .clickSingInButton()
                .loginWithEmptyUsername(testUser)
                .getEmptyUsernameErrorMessage(EMPTY_LOGIN_ERROR_MESSAGE);
        assertThat(userName, is(containsString(EMPTY_LOGIN_ERROR_MESSAGE)));
    }

    @Test(description = "JIRA-7526")
    public void unableToLoginWithEmptyPassword()
    {
        User testUser = UserCreator.withEmptyPassword();
        String userName = new MainPage(driver)
                .openPage()
                .clickSingInButton()
                .loginWithEmptyPassword(testUser)
                .getEmptyPasswordErrorMessage(EMPTY_PASSWORD_ERROR_MESSAGE);
        assertThat(userName, is(containsString(EMPTY_PASSWORD_ERROR_MESSAGE)));
    }

    @Test(description = "JIRA-6675",groups="integration", priority = 1)
    @Ignore
    public void ableToSendAMail()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        Mail testMail = MailCreator.withCredentialsFromProperty();
        String message = new MainPage(driver)
                .openPage()
                .clickSingInButton()
                .login(testUser)
                .createNewMail(testMail);
        assertThat(message, is(equalTo(EXPECTED_MESSAGE)));
    }
}
