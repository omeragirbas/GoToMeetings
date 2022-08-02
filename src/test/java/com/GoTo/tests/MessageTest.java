package com.GoTo.tests;

import com.GoTo.pages.ChatPage;
import com.GoTo.utilities.ConfigurationReader;
import com.GoTo.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;



public class MessageTest extends TestBase {
    Logger logger = (Logger) LogManager.getLogger(MessageTest.class);

    /*Notes: Those steps are handled in TestBase Class - with the help of @BeforeTest and @AfterTest annotations
    - Navigate to URL
    - Login
    - Navigate to Chat Menu
    - Logout
    */

    /*Test Case: Send a message to a user
      1-Click user name from Contacts List
      2-Click message input box
      3-Text your message to message input box
      4-Click submit button
      5-Verify that your message is listed at the bottom*/

    ChatPage chatPage = new ChatPage();

    @Test
    public void sendMessage(){

        logger.info("========================================================================");
        logger.info("\"Test Case: Send a message to a user\" STARTED");
        logger.info("========================================================================");

        //1-Click user name from Contacts List
        String userName="User 4";
        logger.info("1-Click "+userName+" from Contacts List");
        chatPage.getRoomElementWithName(userName).click();

        //2-Click message input box
        logger.info("2-Click message input box");
        chatPage.messageInputBox.click();

        //3-Text your message to message input box
        logger.info("3-Text your message to message input box");
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(chatPage.messageInputBox));
        chatPage.messageInputBox.sendKeys(ConfigurationReader.get("message"));

        //4-Click submit button
        logger.info("4-Click submit button");
        chatPage.submitButton.click();

        //5-Verify that your message is listed at the bottom
        String expectedMessage = ConfigurationReader.get("message");
        String actualMessage = chatPage.messageElements.get(chatPage.messageElements.size() - 1).getText();
        logger.info("5-Verify that your message is listed at the bottom");
        Assert.assertEquals(actualMessage, expectedMessage);
        logger.info("------------------------------------------------------------------------");
        logger.info("Actual Message = " + actualMessage);
        logger.info("Expected Message = " + expectedMessage);
        logger.info("------------------------------------------------------------------------");

        logger.info("========================================================================");
        logger.info("\"Test Case: Send a message to a user\" ENDED");
        logger.info("========================================================================");
    }
}
