package com.amazon.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage{

    @FindBy (xpath = "(//li[@id='my-lists-tab'])[1]")
    public WebElement pageInfo;

    @FindBy(xpath = "(//input[@name='submit.deleteItem'])[1]")
    public WebElement deleteItem;

    @FindBy (xpath = "//div[@class='a-alert-content' and text()='Silindi']")
    public  WebElement warningAlert;

    @FindBy (xpath = "(//img[@aria-label='Daha fazlası'])[1]")
    public WebElement moreThanButton;

    @FindBy (id = "editYourList")
    public WebElement editYourList;

    @FindBy (xpath = "//span[@class='a-button-text' and text()='Listeyi sil']")
    public WebElement deleteList;

    @FindBy(xpath = "(//input[@name='submit.save'])[1]")
    public WebElement yesButton;

    @FindBy (xpath = "//span[@class='nav-text' and text()='Çıkış Yap']")
    public WebElement signOutButton;

}
