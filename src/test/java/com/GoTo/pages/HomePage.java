package com.GoTo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Watchable;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[@data-testid='chats-menu-item']")
    public WebElement chatMenu;

    @FindBy(xpath = "//span[@class='sc-hBMUJo cRerQJ sc-iQTVEV kZOgXZ']")
    public WebElement userIcon;

    @FindBy(xpath = "//button[@class='sc-bQdwJz jVXKbk']")
    public WebElement signOut;
}
