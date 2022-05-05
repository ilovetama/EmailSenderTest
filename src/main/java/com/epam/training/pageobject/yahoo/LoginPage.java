package com.epam.training.pageobject.yahoo;

import com.epam.training.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By login = By.xpath("//input[contains(@class,'phone-no ')]");
    public By password = By.xpath("//input[contains(@id,'login-passwd')]");
    public By signInButton = By.xpath("//input[contains(@id,'login-signin')]");

}