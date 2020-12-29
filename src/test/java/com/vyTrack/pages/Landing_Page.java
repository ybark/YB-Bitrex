package com.vyTrack.pages;

import com.vyTrack.utillities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page {
    public Landing_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    
   @FindBy(xpath = "//*[@id='user-menu']")
   public WebElement displayedName;




    
}
