package com.vyTrack.pages;

import com.vyTrack.utillities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US4_VehicleOdometers_Page extends Base_Page {

    public US4_VehicleOdometers_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='title title-level-1']")
    public WebElement fleetMenu;

    @FindBy(linkText = "Vehicle Odometer")
    public WebElement vehicleOdometer;

    @FindBy(xpath = "//h1[.='Vehicles Odometers']")
    public WebElement odometerText;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleet;

    @FindBy(xpath = "(//span[@class='title title-level-2'])[5]")
    public WebElement hoverOverOdometer;

    @FindBy(xpath = "//*[@class='message']")
    public WebElement UnAuthorisedMessage;

    @FindBy(xpath = "//p[@class='error-page-description']")
    public WebElement errorPageMessage;




}
