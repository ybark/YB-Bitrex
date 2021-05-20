package com.vyTrack.pages;


import com.vyTrack.utillities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US1_Vehicle_Page extends Base_Page{
    public US1_Vehicle_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement VehiclePageTitle;


}
