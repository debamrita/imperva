package com.imperva.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Debamrita
 *
 */

public class InventoryPage {
	private WebDriver driver;
	public InventoryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CLASS_NAME, using="shopping_cart_badge")
	private WebElement shoppingCart;
	
	@FindBy(how=How.XPATH, using="//*[@class='cart_item_label']/div/button")
	private WebElement firstItem;
	
	@FindBy(how=How.ID, using="checkout")
	private WebElement checkout;
	
	@FindBy(how=How.ID, using="first-name")
	private WebElement checkoutFirstName;
	
	@FindBy(how=How.ID, using="last-name")
	private WebElement checkoutLastName;
	
	@FindBy(how=How.ID, using="postal-code")
	private WebElement checkoutZip;
	
	@FindBy(how=How.ID, using="continue")
	private WebElement continueButton;
	
	@FindBy(how=How.ID, using="finish")
	private WebElement finish;
	
	@FindBy(how=How.CLASS_NAME, using="complete-header")
	private WebElement thanks;
	
	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public WebElement getfirstItem() {
		return firstItem;
	}


	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getFirstItem() {
		return firstItem;
	}

	public WebElement getCheckoutFirstName() {
		return checkoutFirstName;
	}

	public WebElement getCheckoutLastName() {
		return checkoutLastName;
	}

	public WebElement getCheckoutZip() {
		return checkoutZip;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getFinish() {
		return finish;
	}

	public WebElement getThanks() {
		return thanks;
	}

	public void addItems(int no) {
		for(int i=0;i<no;i++) {
			driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+(i+1)+"]/div[2]/div[2]/button")).click();
		}	
	
	}
	
	public void verifyAndClickCart(int item) {
		Assert.assertEquals(shoppingCart.getText(), String.valueOf(item));
		shoppingCart.click();
	}
	
	public void removeFirstItem() {
		getfirstItem().click();
	}
	
	public void completeCheckOut(String firstName, String lastName, String zip) {
		getCheckout().click();
		getCheckoutFirstName().sendKeys(firstName);
		getCheckoutLastName().sendKeys(lastName);
		getCheckoutZip().sendKeys(zip);
		getContinueButton().click();
		getFinish().click();
		
	}
	

}
