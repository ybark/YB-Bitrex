package com.vyTrack.step_definitions;

import com.vyTrack.pages.US4_VehicleOdometers_Page;
import com.vyTrack.pages.US6_VehicleCosts_Page;
import com.vyTrack.utillities.Driver;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class US6_VehicleCosts_StepDefinition {

    US4_VehicleOdometers_Page US4_VehicleOdometers_Page = new US4_VehicleOdometers_Page();
    US6_VehicleCosts_Page US6_VehicleCosts_Page = new US6_VehicleCosts_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Actions actions = new Actions(Driver.getDriver());
    Logger log = Logger.getLogger(US6_VehicleCosts_StepDefinition.class);



    @Then("User {string} should hoverOver Fleet {string} menu and click Vehicle Costs{string}")
    public void userShouldHoverOverFleetMenuAndClickVehicleCosts(String username, String menu, String subMenu)
            throws InterruptedException {
        US6_VehicleCosts_Page.navigateTo(username,menu,subMenu);
        wait.until(ExpectedConditions.visibilityOf(US6_VehicleCosts_Page.PageTitle));

    }

    @Then("User should access to vehicleCost page")
    public void userShouldAccessToVehicleCostPage() {
        String actualTitle = US6_VehicleCosts_Page.PageTitle.getText();
        Assert.assertTrue(US6_VehicleCosts_Page.PageTitle.isDisplayed());
        log.info("Page Title is displayed !!!" + actualTitle);
    }





    @Then("User should be able to create Vehicle cost")
    public void userShouldBeAbleToCreateVehicleCost() {

        US6_VehicleCosts_Page.createVehicleCostsButton.click();
        wait.until(ExpectedConditions.visibilityOf(US6_VehicleCosts_Page.saveAndCloseButton));

    }

        @Then("User should click the save and close button")
        public void userShouldClickTheSaveAndCloseButton() {

        US6_VehicleCosts_Page.saveAndCloseButton.click();
        wait.until(ExpectedConditions.visibilityOf(US6_VehicleCosts_Page.savedMessageFlashed));
        Assert.assertTrue(US6_VehicleCosts_Page.savedMessageFlashed.isDisplayed());
        log.info("Vehicle Cost Record is created");


    }

    @Then("User should be able to cancel Vehicle Cost")
    public void userShouldBeAbleToCancelVehicleCost() {
        US6_VehicleCosts_Page.cancelButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.info("Vehicle Cost Record is cancelled");

    }


    @Then("User should be able to delete the Vehicle costs")
    public void userShouldBeAbleToDeleteTheVehicleCosts() {
        US6_VehicleCosts_Page.deleteButton.click();
        log.info("Delete button clicked");
        US6_VehicleCosts_Page.okDeleteButton.click();
        log.info("OK Delete button is clicked");
        wait.until(ExpectedConditions.visibilityOf(US6_VehicleCosts_Page.deletedMessageDisplayed));


    }

    @Then("User should be able to edit the Vehicle costs")
    public void userShouldBeAbleToEditTheVehicleCosts() {
        US6_VehicleCosts_Page.editButton.click();
        wait.until(ExpectedConditions.visibilityOf(US6_VehicleCosts_Page.saveAndCloseButton));
        log.info("Editing is completed ");
    }

    @Then("User should click the more action button")
    public void userShouldClickTheMoreActionButton() {
        US6_VehicleCosts_Page.moreActionsButton.click();

    }

    @Then("User should click the Add Attachment choice")
    public void userShouldClickTheAddAttachmentChoice() {
        US6_VehicleCosts_Page.addAttachment.click();

    }
}
