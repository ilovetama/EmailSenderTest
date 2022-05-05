package com.epam.training.pageobject.yandex;

import com.epam.training.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public By signInLink = By.xpath("//a[contains(@href, 'passport.yandex')" +
            " and span[contains(text(),'Войти')]]");

}
