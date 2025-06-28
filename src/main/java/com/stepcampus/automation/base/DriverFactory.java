package com.stepcampus.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.stepcampus.automation.config.ConfigReader;
public class DriverFactory {
	  private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	    public static WebDriver initDriver() {
	        String browser = ConfigReader.getProperty("browser");

	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            tlDriver.set(new ChromeDriver());
	        }
	        else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            tlDriver.set(new EdgeDriver());
	        }
	        else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            tlDriver.set(new FirefoxDriver());
	        }
	        getDriver().manage().window().maximize();
	        getDriver().get(ConfigReader.getProperty("url"));
	        return getDriver();
	    }

	    public static WebDriver getDriver() {
	        return tlDriver.get();
	    }

	    public static void quitDriver() {
	        getDriver().quit();
	        tlDriver.remove();
	    }
}
