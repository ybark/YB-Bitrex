package com.vyTrack.pages;

import com.github.javafaker.Faker;
import com.vyTrack.utillities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US6_VehicleCosts_Page extends Base_Page {

    public US6_VehicleCosts_Page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement PageTitle;

    @FindBy(xpath = "//*[@class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleCostsButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement savedMessageFlashed;

    @FindBy(xpath = "//a[@data-action='cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//a[@title='Delete Vehicle Costs']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@class='btn ok btn-danger']")
    public WebElement okDeleteButton;

    @FindBy(xpath = "//div[@class='flash-messages-frame']")
    public WebElement deletedMessageDisplayed;

    @FindBy(xpath = "//a[@title='Edit Vehicle Costs']")
    public WebElement editButton;

    @FindBy(xpath = "//a[@class='btn dropdown-toggle']")
    public WebElement moreActionsButton;

    @FindBy(xpath = "//a[@title='Add attachment']")
    public WebElement addAttachment;

    @FindBy(xpath = "//a[@title='Add note']")
    public WebElement addNote;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEvent;





}
