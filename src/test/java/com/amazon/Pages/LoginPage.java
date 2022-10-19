package com.amazon.Pages;

import com.amazon.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (xpath = "(//input[@id='ap_email'])[1]")
    public WebElement enterUsername;

    @FindBy (id = "continue")
    public WebElement continueButton;

    @FindBy (xpath = "(//input[@id='ap_password'])[1]")
    public WebElement enterPassword;

    @FindBy (id = "auth-signin-button")
    public WebElement signInButton;

    @FindBy (id = "nav-link-accountList-nav-line-1")
    public WebElement checkUserName;


    public void login(String username, String password){

        enterUsername.sendKeys(username);
        BrowserUtils.waitFor(1);
        continueButton.click();
        BrowserUtils.waitFor(1);
        enterPassword.sendKeys(password);
        BrowserUtils.waitFor(1);
        signInButton.click();


    }



}
