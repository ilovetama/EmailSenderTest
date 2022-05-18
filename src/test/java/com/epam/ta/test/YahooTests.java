package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.yahoo.MainPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YahooTests extends CommonConditions {

    @Test(description = "JIRA-7566", groups = "integration", priority = 2)
    public void mailChecking()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String userName = new MainPage(driver)
                .openPage()
                .openLoginPage()
                .login(testUser)
                .openMailPage()
                .getUserNameCorrect(testUser.getUsername());
        assertThat(userName, is(containsString(testUser.getUsername())));
    }

}
