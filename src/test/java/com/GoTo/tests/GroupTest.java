package com.GoTo.tests;

import com.GoTo.pages.ChatPage;
import com.GoTo.pages.HomePage;
import com.GoTo.utilities.BrowserUtils;
import com.GoTo.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GroupTest extends TestBase{
    Logger logger = (Logger) LogManager.getLogger(GroupTest.class);

    /*Test Case: Create a new group, add some users and delete
    1-Click "+" icon from right side of "Groups" title
    2-Click "New group" button
    3-Type a name for new group to "New group name input box"
    4-Type contacts name to "Group members" text box and select listed user
    5-Click "Create group" button
    6-Verify that new group name is listed at top
    7-Click human icon at top right in new group window
    8-Verify that members' name are correct
    9-Click gear icon left side of human icon in new group window
    10-Click "Delete Group" button
    11-Verify that new group name is not visible anymore*/

    HomePage homePage = new HomePage();
    ChatPage chatPage = new ChatPage();

    @Test(priority = 3)
    public void createNewGroupAddUsersAndDelete() throws InterruptedException {

        logger.info("========================================================================");
        logger.info("\"Test Case: Create a new group, add some users and delete\" STARTED");
        logger.info("========================================================================");

        //Navigate to Chat
        logger.info("Navigating to Chat");
        homePage.chatMenu.click();
        Thread.sleep(2000);

        //1-Click "+" icon from right side of "Groups" title
        logger.info("1-Click \"+\" icon from right side of \"Groups\" title");
        chatPage.addGroupIcon.click();

        //2-Click "New group" button
        logger.info("2-Click \"New group\" button");
        chatPage.crateNewGroupButton.click();

        //3-Type a name for new group to new group name input box
        logger.info("Type a name for new group to \"New group name input box\"");
        String newGroup="My Awesome Group";
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chatPage.newGroupNameInputBox.sendKeys(newGroup);

        //4-Type contacts name to "Group members" text box and select listed user
        logger.info("4-Type contacts name to \"Group members\" text box and select listed user");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String[]newGroupUserNames= {"User 2", "User 3", "User 4"};
        logger.info("******  SEARCHING DESIRED CONTACT FROM GENERAL LIST  ******");
        logger.info("------------------------------------------------------------------------");
        chatPage.selectUserForNewGroup.click();
        logger.info("*********************  READY FOR LOOP  *********************");

        for (int i = 0; i < newGroupUserNames.length; i++) {
            logger.info("Searching contact name using: " + newGroupUserNames[i]);
            Thread.sleep(1000);
            chatPage.selectUserForNewGroupInputBox.sendKeys(newGroupUserNames[i]);
            Thread.sleep(1000);
            chatPage.selectUserForNewGroupInputBox.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            logger.info(newGroupUserNames[i] +" added to "+newGroup);
            logger.info("------------------------------------------------------------------------");

        }

        //5-Click "Create group" button
        logger.info("5-Click \"Create group\" button");
        chatPage.createNewGroupButton2.click();

        //6-Verify that new group name is listed at top
        String actualNewGroupName=chatPage.newGroupTitle.getText();
        String expectedNewGroupName=newGroup;

        logger.info("6-Verify that new group name is listed at top");

        Assert.assertEquals(actualNewGroupName,expectedNewGroupName);
        logger.info("------------------------------------------------------------------------");
        logger.info("Expected New Group Name = " + expectedNewGroupName);
        logger.info("Actual New Group Name = " + actualNewGroupName);
        logger.info("------------------------------------------------------------------------");

        //7-Click human icon at top right in new group window
        logger.info("7-Click human icon at top right in new group window");
        chatPage.humanIcon.click();

        //8-Verify that members' name are correct
        List<String> expectedMembers = new ArrayList<>();
        expectedMembers.add("User 1 (you)");
        expectedMembers.add("User 2");
        expectedMembers.add("User 3");
        expectedMembers.add("User 4");

        List<String>actualMembers= BrowserUtils.getElementsText(chatPage.groupMemberList);
        logger.info("8-Verify that members' name are correct");
        Thread.sleep(2000);
        Assert.assertEquals(actualMembers,expectedMembers);
        logger.info("------------------------------------------------------------------------");
        logger.info("Actual Members = " + actualMembers);
        logger.info("Expected Members = " + expectedMembers);
        logger.info("------------------------------------------------------------------------");

        //9-Click gear icon left side of human icon in new group window
        logger.info("9-Click gear icon left side of human icon in new group window");
        chatPage.groupSettingsIcon.click();

        //10-Click "Delete Group" button
        logger.info("10-Click \"Delete Group\" button");
        chatPage.deleteGroupButton.click();

        //11-Verify that new group name is not visible anymore
        logger.info("11-Verify that new group name is not visible anymore");
        List<String>groupRoomElementsTextList=new ArrayList<>();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        groupRoomElementsTextList.addAll(BrowserUtils.getElementsText(chatPage.groupsRoomElements));

        for (int i = 0; i < groupRoomElementsTextList.size(); i++) {
            Assert.assertNotEquals(expectedNewGroupName,groupRoomElementsTextList.get(i));
            logger.info("Searching "+expectedNewGroupName+" but found: "+groupRoomElementsTextList.get(i));
        }

        logger.info("========================================================================");
        logger.info("\"Test Case: Create a new group, add some users and delete\" ENDED");
        logger.info("========================================================================");

    }
}
