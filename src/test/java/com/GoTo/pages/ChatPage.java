package com.GoTo.pages;

import com.GoTo.utilities.BrowserUtils;
import com.GoTo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ChatPage extends BasePage {

    @FindBy(xpath = "//div[@class='rooms-group contacts']/ul/li")
    public List<WebElement> contactsRoomElements;

    @FindBy(xpath = "//div[@class='message-body message-editable']")
    public List<WebElement> messageElements;

    @FindBy(xpath = "//div[@class='message-input-editor']/div/div/div[2]/div/div/div/div")
    public WebElement messageInputBox;

    @FindBy(xpath = "//button[@data-testid='message-submit-button']")
    public WebElement submitButton;

    @FindBy(xpath = "(//i[@class='togo-icon togo-icon-add'])[2]")
    public WebElement addContactIcon;

    @FindBy(xpath = "//input[@placeholder='Type a name or email address']")
    public WebElement searchContactBox;

    @FindBy(xpath = "//div[@class='name']")
    public WebElement listedContactName;

    @FindBy(xpath = "(//button[@data-testid='room-remove-button']/i)[1]")
    public WebElement removeIcon;

    @FindBy(xpath = "(//i[@class='togo-icon togo-icon-add'])[1]")
    public WebElement addGroupIcon;

    @FindBy(xpath = "//button[@class='btn btn-primary create-group-button']")
    public WebElement crateNewGroupButton;

    @FindBy(xpath = "//div[@class='create-group-input']/input")
    public WebElement newGroupNameInputBox;

    @FindBy(xpath = "//div[@class='react-select__placeholder css-1wa3eu0-placeholder']")
    public WebElement selectUserForNewGroup;

    @FindBy(id = "react-select-2-input")
    public WebElement selectUserForNewGroupInputBox;

    @FindBy(xpath = "//button[@class='btn btn-primary create-group-button']")
    public WebElement createNewGroupButton2;

    @FindBy(xpath = "//div[@class='group-name']")
    public WebElement newGroupTitle;

    @FindBy(xpath = "//button[@class='group-member-list btn btn-link']")
    public WebElement humanIcon;

    @FindBy(xpath = "//ul[@class='member-list']/li")
    public List<WebElement>groupMemberList;

    @FindBy(xpath = "//button[@data-testid='group-settings']")
    public WebElement groupSettingsIcon;

    @FindBy(xpath = "//button[@class='btn btn-link settings-option delete-group']")
    public WebElement deleteGroupButton;

    @FindBy(xpath = "//div[@class='rooms-group groups']/ul/li")
    public List<WebElement> groupsRoomElements;


    /**
     * Clicks to room name by the exact room name.
     *
     * @param roomName
     */

    public WebElement getRoomElementWithName(String roomName) {
       WebElement roomElement=null;
        for (WebElement el : contactsRoomElements) {
            if(el.getText().equals(roomName)){
                roomElement=el;
            }
        }
        return roomElement;
    }






}
