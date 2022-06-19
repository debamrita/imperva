package com.imperva.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Debamrita
 *
 */

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.ID, using="user-name")
	private WebElement userName;
	
	@FindBy(how=How.ID, using="password")
	private WebElement pwd;
	
	@FindBy(how=How.ID, using="login-button")
	private WebElement loginButton;
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String user, String pwd) {
		  getUserName().clear();
		  getUserName().sendKeys(user);
		  getPwd().clear();
		  getPwd().sendKeys(pwd);
		  getLoginButton().click();
		}

}
