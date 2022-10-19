package com.amazon.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage extends BasePage{

    @FindBy (xpath = "(//h1[contains(text(),'Giriş yap')])[1]")
    public WebElement signOutInformation;
}
