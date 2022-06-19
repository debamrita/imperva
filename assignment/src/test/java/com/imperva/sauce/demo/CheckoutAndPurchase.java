package com.imperva.sauce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.imperva.assignment.common.ConfigParameters;
import com.imperva.assignment.common.PageWritter;
import com.imperva.common.pages.InventoryPage;
import com.imperva.common.pages.LoginPage;

/**
 * @author Debamrita
 *
 */

public class CheckoutAndPurchase extends ConfigParameters {
	 int count;
	
  @Test(dataProvider = "data",priority=1,enabled=true, groups="sanity")
  @Parameters(value = { "browser", "platform", "version", "lib", "profile", "node" })
  public void login(String user, String pwd, String firstName, String lastName, String zip) {
	  PageWritter wrt = new PageWritter();
	  driver.get(wrt.getProperties("SauseDemoUrl"));
	  LoginPage login = new LoginPage(driver);
	  login.login(user, pwd);
  }
  @Test(dataProvider = "data", priority=2,enabled=true, dependsOnMethods = { "login" }, groups = "sanity")
  @Parameters(value = { "browser", "platform", "version", "lib", "profile", "node" })
  public void addAndCheckout(String user, String pwd, String firstName, String lastName, String zip) {
	  login(user, pwd, firstName, lastName, zip);
	  InventoryPage inventoryPage = new InventoryPage(driver);
	  inventoryPage.addItems(2);
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_badge")));
	  inventoryPage.verifyAndClickCart(2);
	  inventoryPage.removeFirstItem();
	  inventoryPage.completeCheckOut(firstName, lastName, zip);
	  Assert.assertEquals(inventoryPage.getThanks().getText(), "THANK YOU FOR YOUR ORDER");
  }
	 
  @DataProvider(name = "data")
  public Object[][] createData() {
		Object[][] result = null;
			result = new Object[][] {
					{"standard_user", "secret_sauce","Demo", "User", "56010"},
					};
		return result;
	}
}
