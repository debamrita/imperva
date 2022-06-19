package com.imperva.scrape;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.imperva.assignment.common.ConfigParameters;
import com.imperva.assignment.common.PageWritter;
import com.imperva.common.pages.HomePage;

/**
 * @author Debamrita
 *
 */

public class ScrapeData extends ConfigParameters {
	String descr;
	String language;
	String tags;
	String title;
	String stars;
	String time;
	String license;
	
  @Test(dataProvider = "data",priority=1,enabled=true)
  @Parameters(value = { "browser", "platform", "version", "lib", "profile", "node" })
  public void scrapeGit(String keyWord) {
	  PageWritter wrt = new PageWritter();
	  driver.get(wrt.getProperties("GitUrl"));
	  homePage = new HomePage(driver);
	  homePage.getSearch().sendKeys(keyWord);
	  homePage.getSearch().sendKeys(Keys.RETURN);
	  JSONObject security = new JSONObject();
	  JSONObject jsonObject;
	  JSONArray jsonArray = new JSONArray();
	  List<String> urls = new ArrayList<String>();
		  for(int i=0;i<5;i++) {
			  List<WebElement> repos = homePage.getRepos();
			  for(int j=0;j<repos.size();j++) {
			  	  urls.add(driver.findElement(By.xpath("//*[@class='repo-list']/li["+(j+1)+"]/div[2]/div/div/a")).getAttribute("href"));
		  }
			  WebDriverWait wait=new WebDriverWait(driver, 20);
			  wait.until(ExpectedConditions.elementToBeClickable(By.className("next_page")));
			  homePage.getNextPage().click();
		  }
		  for(int i=0;i<urls.size();i++) {
			  driver.get(urls.get(i));
			  try {
			  	descr = homePage.getDescr().getText();
			  } catch (Exception e) {
			  	// TODO: handle exception
			  	descr = "";
			  }
			  try {
				  	language = homePage.getLang().getText();
				
			} catch (Exception e) {
				// TODO: handle exception
				language = "";
			}
			  try {
					tags = homePage.getTags().getText();
				} catch (Exception e) {
					// TODO: handle exception
				  	tags = "";
				}
			  try {
					title = homePage.getTitle().getText();
					
				} catch (Exception e) {
					// TODO: handle exception
				  	title = "";
				}
			  try {
					stars = homePage.getStars().getText();
					
				} catch (Exception e) {
					// TODO: handle exception
				  	stars = "";
				}
			  try {
					 time = homePage.getTime().getText();
					
				} catch (Exception e) {
					// TODO: handle exception
				  	time = "";
				}
			  try {
				  license = homePage.getLicense().get(1).getText();
			} catch (Exception e) {
				// TODO: handle exception
				license = "";
			}
			  jsonObject = new JSONObject();
			  jsonObject.put("description", descr);
			  jsonObject.put("tags", tags);
			  jsonObject.put("language", language);
			  jsonObject.put("title", title);
			  jsonObject.put("stars", stars);
			  jsonObject.put("UpdateTime", time);
			  jsonObject.put("license", license);
			  jsonArray.put(jsonObject);
		  	 }
		  security.put("Security",jsonArray);
		  wrt.setJson(security); 
		  
  }
	 

@DataProvider(name = "data")
  public Object[][] createData() {
		Object[][] result = null;
			result = new Object[][] {
					{"security"},
					};
		return result;
	}
}
