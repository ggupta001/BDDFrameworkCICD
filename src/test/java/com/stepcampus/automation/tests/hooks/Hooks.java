package com.stepcampus.automation.tests.hooks;

import com.stepcampus.automation.base.DriverFactory;
import com.stepcampus.automation.utils.Log;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
        Log.info("Browser launched");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        Log.info("Browser closed");
    }
}
