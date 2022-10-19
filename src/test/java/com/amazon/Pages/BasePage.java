package com.amazon.Pages;

import com.amazon.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }

}




