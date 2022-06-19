/**
 * @author Debamrita
 */
package com.imperva.assignment.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author Debamrita
 */
public final class InvokeDriver {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	String env = System.getProperty("env");
	public WebDriver startDriver(WebDriver pDriver, final String browser, final String pProfile,
	String pNode, final String pLib, final String pPlatform, final String pVersion) {
		if(pNode!=null && pNode.equalsIgnoreCase("grid")) {
			PageWritter wrt = new PageWritter();
			pNode = wrt.getProperties("Node");
			if(browser.equalsIgnoreCase("chrome")) {
				Boolean isPrivate=true;
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				if(pPlatform.equalsIgnoreCase("windows")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/browsers/win/chromedriver.exe");
				}
				else if(pPlatform.equalsIgnoreCase("mac")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/mac/browsers/chromedriver");
				} else if(pPlatform.equalsIgnoreCase("linux")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/linux/browsers/chromedriver");
				}
				ChromeOptions options = new ChromeOptions();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				try {
					pDriver = new RemoteWebDriver(new URL(pNode), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pDriver.manage().window().maximize();
				pDriver.manage().timeouts().pageLoadTimeout(7200, TimeUnit.SECONDS);
				pDriver.manage().timeouts().setScriptTimeout(7200, TimeUnit.SECONDS);
			}
			
			
		}  else if((pNode==null) || (pNode.isEmpty() || (pNode.equalsIgnoreCase("localhost")))) {
			if(browser.equalsIgnoreCase("chrome")) {
				Boolean isPrivate=true;
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				if(pPlatform.equalsIgnoreCase("windows")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/browsers/win/chromedriver.exe");
				}
				else if(pPlatform.equalsIgnoreCase("mac")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/browsers/mac/chromedriver");
				} else if(pPlatform.equalsIgnoreCase("linux")) {
					System.setProperty("webdriver.chrome.driver","./resources/drivers/browsers/linux/chromedriver");
				}
				ChromeOptions options = new ChromeOptions();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				pDriver = new ChromeDriver(capabilities);
				pDriver.manage().window().maximize();
				pDriver.manage().timeouts().pageLoadTimeout(7200, TimeUnit.SECONDS);
				pDriver.manage().timeouts().setScriptTimeout(7200, TimeUnit.SECONDS);
			}
			
		}
		return pDriver;
	}
	
}
