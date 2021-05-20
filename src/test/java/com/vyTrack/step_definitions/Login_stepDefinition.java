package com.vyTrack.step_definitions;


import com.vyTrack.pages.Landing_Page;
import com.vyTrack.pages.Login_Page;
import com.vyTrack.utillities.ConfigurationReader;
import com.vyTrack.utillities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_stepDefinition {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Login_Page loginPage = new Login_Page();
    Landing_Page landingPage = new Landing_Page();
    Logger logger = Logger.getLogger(Login_stepDefinition.class);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlVyTrack"));


    }



    @When("User enters correct username {string} and password {string}")
    public void userEntersCorrectUsernameAndPassword(String username, String password) {
        loginPage.login(username,password);
        System.out.println(username);
        System.out.println(password);
    }


    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String expectedName) {
        wait.until(ExpectedConditions.visibilityOf(landingPage.displayedName));

        String DisplayedName = landingPage.displayedName.getText();

        System.out.println(DisplayedName);


        Assert.assertEquals("la oglim calis calis gene yanlis",
                DisplayedName, expectedName);
        logger.info("Displayed name is => " + DisplayedName +
                "\nExpected Name is => " + expectedName);


    }

    @When("User enters incorrect {string} and {string}")
    public void userEntersIncorrectAnd(String username, String password) {
        loginPage.negativeLogin(username, password);
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidMessage));
        String actualInvalidMessage = loginPage.invalidMessage.getText();
        logger.info(actualInvalidMessage + "  " + message);
        System.out.println(actualInvalidMessage);
        System.out.println(message);
        Assert.assertEquals("MAtch olmadi la", message, actualInvalidMessage);
        Assert.assertTrue(loginPage.invalidMessage.isDisplayed());


    }


}
