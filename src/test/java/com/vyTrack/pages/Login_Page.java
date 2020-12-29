package com.vyTrack.pages;

import com.vyTrack.utillities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login_Page {
    public Login_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    Logger logger = Logger.getLogger(Login_Page.class);

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement ForgotYourPassword;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    private WebElement InvalidUsername_or_password;

    @FindBy(xpath = "//*[@class='alert alert-error']/div")
    public WebElement invalidMessage;

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        login.click();
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        logger.info("Login with " + user + " and " + pass);
    }

    public void negativeLogin(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        login.click();
//        wait.until(ExpectedConditions.titleIs("Dashboard"));
        logger.info("Login with " + user + " and " + pass);
    }

}
