package com.stepcampus.automation.tests.hooks;

import org.openqa.selenium.WebDriver;

import com.stepcampus.automation.base.DriverFactory;
import com.stepcampus.automation.utils.Log;
import com.stepcampus.automation.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
        Log.info("Browser launched");
        
    }

    @After
    public void tearDown(Scenario scenario) {
    	 WebDriver driver = DriverFactory.getDriver();
    	 if (scenario.isFailed() && driver != null) {
             ScreenshotUtil.captureScreenshot(driver, scenario.getName());
         }

         if (driver != null) {
             driver.quit(); // or DriverFactory.quitDriver(); for cleanup
         }
        Log.info("Browser closed");
    }
}
