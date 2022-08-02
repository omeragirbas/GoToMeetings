package com.GoTo.tests;

import com.GoTo.pages.HomePage;
import com.GoTo.pages.LoginPage;
import com.GoTo.utilities.ConfigurationReader;
import com.GoTo.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.*;
import java.time.Duration;

public class TestBase {

    Logger logger = (Logger) LogManager.getLogger(TestBase.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeTest
    public void setUp(){
        //Navigate to url
        logger.info("====================================================");
        logger.info("Welcome to Go To Automation Task. By \"Mutlu Bilge\"");
        logger.info("====================================================");
        logger.info("Navigating to url");
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //login
        logger.info("Login...");
        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("email"));
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.nextButton.click();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("pwd"));
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.submitButton.click();

        //Navigate to Chat
        logger.info("Navigating to Chat");
        homePage.chatMenu.click();



    }

    @AfterTest
    public void tearDown(){
        logger.info("Logout..");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage.userIcon.click();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage.signOut.click();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        logger.info("Close driver");
        Driver.closeDriver();
        logger.info("========================");
        logger.info("Task has been completed!");
        logger.info("========================");
    }
}
