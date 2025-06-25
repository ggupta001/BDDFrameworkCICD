package com.stepcampus.automation.tests.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features", 
    glue = {"com.stepcampus.automation.tests.stepdefs", "com.stepcampus.automation.tests.hooks"},
    plugin = {"pretty", "html:target/cucumber-html-report"},
    monochrome = true
    )
public class TestRunner extends AbstractTestNGCucumberTests  {
	 @Override
	    @org.testng.annotations.DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
}
}
