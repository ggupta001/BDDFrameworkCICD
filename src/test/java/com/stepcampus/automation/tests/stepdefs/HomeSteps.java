package com.stepcampus.automation.tests.stepdefs;

import org.testng.Assert;

import com.stepcampus.automation.base.DriverFactory;
import com.stepcampus.automation.pages.HomePage;
import com.stepcampus.automation.utils.ExcelUtils;

import io.cucumber.java.en.*;

public class HomeSteps {
	HomePage homePage=new HomePage(DriverFactory.getDriver());
	String excelFilePath = "src/main/resources/webcred.xlsx";
	String sheetName = "credentials";
	String username = ExcelUtils.getValue(excelFilePath, sheetName, "username");
	String password = ExcelUtils.getValue(excelFilePath, sheetName, "Password");
	@When("User enters username and password")
	public void user_enter_username_pasword() {
		homePage.login(username, password);
	}
	@Then("User is on Home Page")
	public void user_is_on_HomePage() {
	 	String title=DriverFactory.getDriver().getTitle();
	 	Assert.assertTrue(title.contains("Logged In Successfully | Practice Test Automation"));
	}
	@When("User clicks on Home button")
	public void user_click_on_HomeButton() {
	 	homePage.clickOnHomeButton();
	}
	@Then("User can see the Home Profile")
	public void user_can_see_the_HomeProfile() {
		homePage.seeHomeProfile();
	}

}
