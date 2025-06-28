package com.stepcampus.automation.tests.stepdefs;


import io.cucumber.java.en.*;
import org.junit.Assert;

import com.stepcampus.automation.base.DriverFactory;
import com.stepcampus.automation.pages.LoginPage;
import com.stepcampus.automation.utils.Log;
import io.cucumber.java.en.*;

public class LoginSteps {
	LoginPage loginPage;

    @Given("User launches the application")
    public void user_launches_application() {
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.login(username, password);
        Log.info("Login attempted with: " + username);
    }

    @Then("User should land on Home Page")
    public void user_should_land_on_home_page() {
    	String title=DriverFactory.getDriver().getTitle();
    	Assert.assertEquals(title,"Logged In Successfully");
        Log.info("Landed on Dashboard page");
    }
}
