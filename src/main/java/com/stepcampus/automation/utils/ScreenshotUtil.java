package com.stepcampus.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static void captureScreenshot(WebDriver driver, String scenarioName) {
	try {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String folderPath = "screenshots/";
        new File(folderPath).mkdirs(); // Ensure folder exists

        String fileName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_") + "_" + timestamp + ".png";
        String fullPath = folderPath + fileName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(fullPath));

        System.out.println("✅ Screenshot saved to: " + fullPath);
    } catch (Exception e) {
        System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        e.printStackTrace();
    }
}
}
