package com.amazon.Pages;

import org.bouncycastle.asn1.esf.SPuri;
import org.bouncycastle.crypto.agreement.jpake.JPAKEUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy (xpath = "(//span[normalize-space()='Hesap ve Listeler'])[1]")
    public WebElement accountAndList;

    @FindBy (xpath = "(//span[contains(text(),'Liste Oluşturun')])[1]")
    public WebElement createList;

    @FindBy (xpath = "//input[@class='a-button-input']")
    public WebElement inputListInformation;

    @FindBy(xpath = "(//input[@id='list-name'])[1]")
    public WebElement enterNameOfList;

    @FindBy (xpath = "//span[@class='a-button a-button-primary']")
    public WebElement clickListCreateButton;

    @FindBy (xpath = "//select[@id='searchDropdownBox']")
    public WebElement dropDownMenu;

    @FindBy (xpath = "(//input[@id='twotabsearchtextbox'])[1]")
    public  WebElement searchBox;

    @FindBy (id = "nav-search-submit-button")
    public WebElement searchButtonClick;

    @FindBy (xpath = "(//span[@class='a-color-state a-text-bold'])[1]")
    public  WebElement searchedItem;

    @FindBy (xpath = "(//a[@aria-label='2 sayfasına git'])[1]")
    public  WebElement secondPage;

    @FindBy (xpath = "(//span[@aria-label='Geçerli sayfa, sayfa 2'])[1]")
    public  WebElement currentPage;

    @FindBy (xpath = "//div[@data-index='6']")
    public WebElement secondItem;

}
