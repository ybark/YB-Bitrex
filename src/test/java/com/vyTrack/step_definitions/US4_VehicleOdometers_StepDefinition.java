package com.vyTrack.step_definitions;

import com.vyTrack.pages.Login_Page;
import com.vyTrack.pages.US4_VehicleOdometers_Page;
import com.vyTrack.pages.US6_VehicleCosts_Page;
import com.vyTrack.utillities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class US4_VehicleOdometers_StepDefinition {
    Login_Page loginPage = new Login_Page();
    US4_VehicleOdometers_Page us4Page = new US4_VehicleOdometers_Page();
    US6_VehicleCosts_Page us6Page = new US6_VehicleCosts_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    Actions actions = new Actions(Driver.getDriver());


    @When("User enters correct {string} and {string}")
    public void user_enters_correct_and(String username, String password) {
        loginPage.login(username, password);


    }


    @Then("User should click the fleet menu")
    public void userShouldClickTheFleetMenu() throws InterruptedException {
        us4Page.fleetMenu.click();
        Thread.sleep(3000);
    }


    @Then("User {string} should hoverOver Fleet {string} menu and click VehicleOdometer {string}")
    public void userShouldHoverOverFleetMenuAndClickVehicleOdometer
                            (String username, String menu, String subMenu) throws InterruptedException {

        us4Page.navigateTo(username, menu, subMenu);
        wait.until(ExpectedConditions.visibilityOf(us4Page.odometerText));
//        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    }



    @Then("User should access to odometer page{string}")
    public void userShouldAccessToOdometerPage(String expectedTitle) {
        String actualTitle = us4Page.odometerText.getText();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("Title not matched !!!",expectedTitle,actualTitle);

    }


    @Then("User should not access to odometer page")
    public void userShouldNotAccessToOdometerPage() {

        try {

            actions.moveToElement(us4Page.hoverOverOdometer).click().perform();
            // wait.until(ExpectedConditions.visibilityOf(us4Page.UnAuthorisedMessage));
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Assert.assertTrue(us4Page.UnAuthorisedMessage.isDisplayed());

        } catch (Exception e) {
          Assert.assertTrue(us4Page.errorPageMessage.isDisplayed());
            System.out.println(" Error Page Message is Displayed");

            e.printStackTrace();
        }


    }


    @Then("unAuthorised User {string} should hoverOver Fleet {string} menu " +
                                "and click VehicleOdometer {string} and can not reach the page")
    public void unauthorisedUserShouldHoverOverFleetMenuAndClickVehicleOdometerAndCanNotReachThePage
                                     (String username, String menu, String subMenu) throws InterruptedException {

//        us4Page.navigateTo(username, menu, subMenu);
//
//        Assert.assertTrue(us4Page.UnAuthorisedMessage.isDisplayed());
        try {

            us4Page.navigateTo(username, menu, subMenu);
            wait.until(ExpectedConditions.visibilityOf(us4Page.UnAuthorisedMessage));

            Assert.assertTrue(us4Page.UnAuthorisedMessage.isDisplayed());

        } catch (Exception e) {
            Assert.assertTrue(us4Page.errorPageMessage.isDisplayed());
            System.out.println(" Error Page Message is Displayed");

            e.printStackTrace();
        }


    }
}
