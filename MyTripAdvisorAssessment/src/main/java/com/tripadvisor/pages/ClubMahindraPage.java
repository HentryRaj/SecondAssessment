package com.tripadvisor.pages;

import java.util.Set;

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
public class ClubMahindraPage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils();
	@FindBy(xpath = "//a[text() ='Write a review']")
	private WebElement reviewBtn;
	@FindBy(xpath = "//a[contains(text(), 'Most Booked Properties in Madikeri')]")
	private WebElement properties;
	public ClubMahindraPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to navigate to review page
	 * @return
	 */
	public ReviewPage naviagteToReviewPage() {
		webLib.scrollDown(properties, driver);
		webLib.waitForElementToBeClickable(driver, reviewBtn);
		reviewBtn.click();
		Set<String> whs = driver.getWindowHandles();
		 whs.remove(0);
		 whs.remove(1);		
		 for(String wh :whs)
		driver.switchTo().window(wh);
		return new ReviewPage(driver);
	}
}
