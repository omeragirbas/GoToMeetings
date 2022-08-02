package com.GoTo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yaml.snakeyaml.events.Event;

public class LoginPage extends BasePage{
    @FindBy(id = "emailAddress")
    public WebElement emailInputBox;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

}
