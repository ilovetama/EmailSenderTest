package com.epam.training.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected String password;
    protected String usernameYandex;
    protected String usernameYahoo;
    protected String driverPath;
    protected String usernameVerify;
    protected String incorrectPassword;
    protected String incorrectUsername;
    protected String incorrectPasswordMessage;
    protected String incorrectUsernameMessage;
    protected String emptyPasswordMessage;
    protected String emptyUsernameMessage;
    protected String emailTo;
    protected String emailSubject;
    protected String emailContent;
    protected String yandexUrl;
    protected String yahooUrl;
    protected String emailSender;

    @BeforeClass
    public void getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/webdriver_/src/main/resources/config.properties"));
        password = properties.getProperty("password");
        usernameYandex = properties.getProperty("usernameYandex");
        usernameYahoo = properties.getProperty("usernameYahoo");
        driverPath = properties.getProperty("driverPath");
        usernameVerify = properties.getProperty("usernameVerify");
        incorrectPassword = properties.getProperty("incorrectPassword");
        incorrectUsername = properties.getProperty("incorrectUsername");
        incorrectPasswordMessage = properties.getProperty("incorrectPasswordMessage");
        incorrectUsernameMessage = properties.getProperty("incorrectUsernameMessage");
        emptyPasswordMessage = properties.getProperty("emptyPasswordMessage");
        emptyUsernameMessage = properties.getProperty("emptyUsernameMessage");
        emailTo = properties.getProperty("emailTo");
        emailSubject = properties.getProperty("emailSubject");
        emailContent = properties.getProperty("emailContent");
        yahooUrl = properties.getProperty("yahooHomepage");
        yandexUrl = properties.getProperty("yandexHomepage");
        emailSender = properties.getProperty("emailSender");
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
