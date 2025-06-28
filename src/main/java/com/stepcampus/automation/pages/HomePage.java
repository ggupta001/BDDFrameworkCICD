package com.stepcampus.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	   WebDriver driver;
	   
	   
	   public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	   @FindBy(id = "username")
	    WebElement username;

	    @FindBy(id = "password")
	    WebElement password;

	    @FindBy(id = "submit")
	    WebElement loginBtn;

	    public void login(String user, String pass) {
	        username.sendKeys(user);
	        password.sendKeys(pass);
	        loginBtn.click();
	    }
	   
	   @FindBy(xpath="//a[text()='Home']")
	   WebElement homebtn;
	   
	   @FindBy(xpath="//h1[text()='Hello']")
	   WebElement welcomemsg;
	   
	   public void clickOnHomeButton() {
		   homebtn.click();
	   }
	   public void seeHomeProfile() {
		   welcomemsg.isDisplayed();
		   welcomemsg.getText().contains("Hello");
	   }
}
