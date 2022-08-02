package com.GoTo.tests;

import com.GoTo.pages.ChatPage;
import com.GoTo.pages.HomePage;
import com.GoTo.utilities.BrowserUtils;
import com.GoTo.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContactTest extends TestBase{
    Logger logger = (Logger) LogManager.getLogger(ContactTest.class);

    /*Test Case: Add a new contact to "Contacts" and remove it
    1-Click "+" icon from right side of "Contacts" title
    2-Type to search box a unique part of a contact name or email and verify that Testad76a User15984 has been listed each attempt
    3-Click listed contact name
    4-Verify that contact name is visible under "Contacts"
    5-Hover over mouse to new contact name
    6-Click "x" icon
    7-Verify that new contact is not visible anymore*/

    HomePage homePage = new HomePage();
    ChatPage chatPage = new ChatPage();

    @Test
    public void addNewContactAndRemove() throws InterruptedException {
        logger.info("========================================================================");
        logger.info("\"Test Case: Add a new contact to \"Contacts\" and remove it\" STARTED");
        logger.info("========================================================================");

        //Navigate to Chat
        logger.info("Navigating to Chat");
        homePage.chatMenu.click();
        Thread.sleep(2000);

        //1-Click "+" icon from right side of "Contacts" title
        logger.info("1-Click \"+\" icon from right side of \"Contacts\" title");
        chatPage.addContactIcon.click();

        //2-Type to search box a unique part of a contact name or email and verify that "Testad76a User15984" has been listed each attempt
        logger.info("2-Type to search box a unique part of a contact name or email and verify that \"Testad76a User15984\" has been listed each attempt");
        String[]uniquePartsOfContactName={"Testad76a","User15984", "g2messenger-15984", "g2messenger-15984@jedix.com", "Testad76a User15984" };
        String expectedContactName=uniquePartsOfContactName[uniquePartsOfContactName.length-1];

        logger.info("******  SEARCHING DESIRED CONTACT FROM GENERAL LIST  ******");
        logger.info("------------------------------------------------------------------------");
        logger.info("Sending first data: " + uniquePartsOfContactName[0]);
        chatPage.searchContactBox.sendKeys(uniquePartsOfContactName[0]);
        logger.info("Cleared the data and solved synchronization problem");
        chatPage.searchContactBox.clear();
        logger.info("*********************  READY FOR LOOP  *********************");

        for (int i = 0; i < uniquePartsOfContactName.length; i++) {
            chatPage.searchContactBox.sendKeys(uniquePartsOfContactName[i]);
            chatPage.searchContactBox.sendKeys(Keys.ENTER);
            //Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            logger.info("Searching contact name using: " + uniquePartsOfContactName[i]);
            Thread.sleep(2000);
            Assert.assertEquals(chatPage.listedContactName.getText(),expectedContactName);
            logger.info("------------------------------------------------------------------------");
            logger.info("Actual Listed Contact name after search = " + chatPage.listedContactName.getText());
            logger.info("Expected ContactName after search = " + expectedContactName);
            logger.info("------------------------------------------------------------------------");
            chatPage.searchContactBox.clear();
        }

        //3-Click listed contact name
        logger.info("3-Click listed contact name");
        chatPage.searchContactBox.sendKeys(uniquePartsOfContactName[uniquePartsOfContactName.length-1]);
        chatPage.listedContactName.click();

        //4-Verify that contact name is visible under "Contacts"
        String actualListedContactName=chatPage.getRoomElementWithName(expectedContactName).getText();
        logger.info("4-Verify that contact name is visible under \"Contacts\"");
        Assert.assertEquals(actualListedContactName,expectedContactName);
        logger.info("******  AFTER ADDING DESIRED CONTACT TO THE CONTACT LIST  ******");
        logger.info("------------------------------------------------------------------------");
        logger.info("Actual Listed Contact Name under contacts = " + actualListedContactName);
        logger.info("Expected Contact Name under contacts = " + expectedContactName);
        logger.info("------------------------------------------------------------------------");

        //5-Hover over mouse to new contact name
        logger.info("5-Hover over mouse to new contact name");
        Actions action = new Actions(Driver.get());
        action.moveToElement(chatPage.getRoomElementWithName(actualListedContactName)).perform();
        Thread.sleep(1000);

        //6-Click "x" icon
        logger.info("6-Click \"x\" icon");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chatPage.removeIcon.click();

        //7-Verify that new contact is not visible anymore
        logger.info("7-Verify that new contact is not visible anymore");
        List<String> contactsRoomElementsTextList=new ArrayList<>();
        contactsRoomElementsTextList.addAll(BrowserUtils.getElementsText(chatPage.contactsRoomElements));

        for (int i = 0; i < contactsRoomElementsTextList.size(); i++) {
            Assert.assertNotEquals(expectedContactName,contactsRoomElementsTextList.get(i));
            logger.info("Searching "+expectedContactName+" but found: "+contactsRoomElementsTextList.get(i));
        }

        logger.info("========================================================================");
        logger.info("\"Test Case: Add a new contact to \"Contacts\" and remove it\" ENDED");
        logger.info("========================================================================");
    }
}
