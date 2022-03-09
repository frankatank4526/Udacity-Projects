package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageInputField;

    @FindBy(id = "messageType")
    private WebElement messageTypeSelector;


    @FindBy(id = "submit-button")
    private WebElement sendMessage;

    @FindBy(id = "logout")
    private WebElement logoutButton;

    @FindAll({
            @FindBy(id = "chatMessage")
    })
    private List<WebElement> chatMessage;

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    public void postMessage(String message, String messageType){
        Select selectMessageType = new Select(messageTypeSelector);
        switch(messageType) {
            case "Say":
                messageInputField.sendKeys(message);
                sendMessage.click();
                messageInputField.clear();
                break;
            case "Shout":
                messageInputField.sendKeys(message);
                selectMessageType.selectByVisibleText("Shout");
                sendMessage.click();
                messageInputField.clear();
                break;
            case "Whisper":
                messageInputField.sendKeys(message);
                selectMessageType.selectByVisibleText("Whisper");
                sendMessage.click();
                messageInputField.clear();
                break;

        }
    }
    public List<WebElement> getChatMessages(){
        return chatMessage;

    }
}
