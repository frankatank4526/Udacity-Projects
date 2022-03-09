package com.udacity.jwdnd.c1.review;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(id = "login-link")
    private WebElement loginLink;

    @FindBy(id = "submit-button")
    private WebElement signupButton;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;


    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void signup(String firstName, String lastName, String username, String password){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signupButton.click();

    }
    public void goToLogin(){
        loginLink.click();
    }

}
