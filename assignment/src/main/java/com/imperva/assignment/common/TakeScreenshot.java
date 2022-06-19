/**
 * @author Debamrita
 *
 */
package com.imperva.assignment.common;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

/**
 * @author Debamrita
 *
 */
public class TakeScreenshot {
	public void takeScreenShotOnFailure(ITestResult testResult, WebDriver pDriver) throws IOException {
		File dir = new File("./test-output/ScreenShots");
		/*if(dir.exists()) {
			for (File file: dir.listFiles()) {
				if (!file.isDirectory()) {
					file.delete();
				}
			}
		}*/
		if (testResult.getStatus() == ITestResult.FAILURE) {
			if(!dir.exists()) {
				dir.mkdirs();
			}
			File scrFile = ((TakesScreenshot)pDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./test-output/ScreenShots/"+testResult.getName()+".jpg"));
		}
	}

}
