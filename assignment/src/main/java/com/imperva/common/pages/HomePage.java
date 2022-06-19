package com.imperva.common.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Debamrita
 *
 */

public class HomePage {
	private WebDriver driver;
	public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.CLASS_NAME, using="lh-condensed mb-3")
	private WebElement security;
	@FindBy(how=How.TAG_NAME, using="html")
	private WebElement htmlTag;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'f4') and contains (@class, 'my-3')]")
	private WebElement descr;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'form-control') and contains (@class, 'input-sm') and contains (@class, 'header-search-input') and contains (@class, 'jump-to-field') and contains (@class, 'js-jump-to-field') and contains (@class, 'js-site-search-focus')]")
	private WebElement search;
	@FindAll({@FindBy(xpath = "//*[@class='repo-list']//li[contains (@class, 'repo-list-item hx_hit-repo d-flex') and contains (@class, ' flex-justify-start') and contains (@class, 'py-4') and contains (@class, 'public source')]")})
	private List<WebElement> repos;
	@FindBy(how=How.CLASS_NAME, using="next_page")
	private WebElement nextPage;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'color-fg-default') and contains (@class, 'mr-1')]")
	private WebElement lang;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'octicon') and contains (@class, 'octicon-tag')] /../strong")
	private WebElement tags;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'mr-2') and contains (@class, ' flex-self-stretch')]/a")
	private WebElement title;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'octicon') and contains (@class, 'octicon-star mr-2')]/../strong")
	private WebElement stars;
	@FindBy(how=How.XPATH, using="//*[contains (@class, 'Box-header') and contains (@class, 'position-relative')]/div/div[2]/div[2]/a[2]")
	private WebElement time;
	@FindAll({@FindBy(xpath = "//*[contains (@class, 'octicon-law mr-2') and contains (@class, 'octicon')]/..")})
	private List<WebElement> license;
	

	public WebElement getSecurity() {
		return security;
	}

	public WebElement getHtmlTag() {
		return htmlTag;
	}

	public WebElement getDescr() {
		return descr;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getRepos() {
		return repos;
	}

	public WebElement getNextPage() {
		return nextPage;
	}

	public WebElement getLang() {
		return lang;
	}

	public WebElement getTags() {
		return tags;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getStars() {
		return stars;
	}

	public WebElement getTime() {
		return time;
	}

	public List<WebElement> getLicense() {
		return license;
	}

	

}
