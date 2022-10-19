package com.amazon.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{

    @FindBy (xpath = "(//input[@id='add-to-wishlist-button'])[1]")
    public WebElement addToWishListButton;

    @FindBy (xpath ="//span[@class='a-size-mini a-color-secondary atwl-hz-popover-secondary atwl-hz-dd-list-privacy']")
    public WebElement addToVirgosolListOptions;

    @FindBy (xpath ="(//span[@class='a-size-medium-plus huc-atwl-header-main'])[1]")
    public WebElement checklist1;

    @FindBy (xpath = "(//span[@class='a-size-medium-plus huc-atwl-header-main'])[2]")
    public WebElement checklist2;

    @FindBy (xpath = "(//a[@class='a-button-text'])[3]")
    public WebElement showMyListButton;

    @FindBy (xpath = "(//button[contains(@class,'a-button-close a-declarative')])[1]")
    public  WebElement closePopUp;

    @FindBy (xpath = "//span[@class='nav-text']")
    public WebElement virgosolListLink;

}
