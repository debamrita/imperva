package com.imperva.assignment.common;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.imperva.common.pages.HomePage;

import java.io.IOException;
import java.net.MalformedURLException;
/**
 * @author Debamrita
 */
public class ConfigParameters {
    public WebDriver driver;
    public static String browserName = "";
    public String platformName = "";
    public String versionName = "";
    public String driverValue = "";
    public String profileValue = "";
    public String nodeUrl = "";
    public String libValue = "";
    public String proxy;
    public String platformValue = "";
    public InvokeDriver id = new InvokeDriver();
    public static SoftAssert softassert = new SoftAssert();
    protected HomePage homePage;


    @Parameters(value = {"browser", "platform", "version", "lib", "profile", "node"})
    @BeforeMethod
    public void setup(@Optional String browser, @Optional String platform, @Optional String version, @Optional String lib, @Optional String profile, @Optional String node) throws MalformedURLException, IOException {
        browserName = browser;
        platformName = platform;
        versionName = version;
        driverValue = lib;
        profileValue = profile;
        nodeUrl = node;
        libValue = lib;
        platformValue = platform;
  	  driver = id.startDriver(driver, browserName, profileValue, nodeUrl, libValue,platformValue, versionName);
    }

    @AfterMethod
    public void postAction(ITestResult testResult) throws IOException {
        TakeScreenshot shot = new TakeScreenshot();
        shot.takeScreenShotOnFailure(testResult, driver);
        driver.close();
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver = null;
    }
}