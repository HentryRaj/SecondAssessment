package com.tripadvisor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.generic.WebDriverUtils;
/**
 * 
 * @author HenTryRAj
 *
 */
public class HomePage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils();
		@FindBy(xpath = "//span[text() = 'Search']")
		private WebElement searchBox;
		@FindBy(xpath = "//input[@placeholder ='Search Tripadvisor']")
		private WebElement searchTab;
		@FindBy(xpath = "//input[contains(@placeholder,'Try “boutique hotels in Paris”')]")
		private WebElement searchCenter;
		public WebElement getSearchBox() {
			return searchBox;
		}
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	/**
	 * method to navigate to search list page	
	 * @param place
	 * @return
	 */
		public SearchResultPage navigateToSearchResultPage(String place) {
			try {
			webLib.waitForElementToBeClickable(driver, searchBox);
			searchBox.click();
			searchTab.sendKeys(place, Keys.ENTER);
			}
			catch (Exception e) {
				searchCenter.sendKeys(place, Keys.ENTER);
			}
			return new SearchResultPage(driver);
		}

}
