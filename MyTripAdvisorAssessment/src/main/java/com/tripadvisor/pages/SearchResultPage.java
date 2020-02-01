package com.tripadvisor.pages;

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
public class SearchResultPage {
	WebDriverUtils weLib = new WebDriverUtils();
	public WebDriver driver;
	@FindBy(xpath = "//span[text() = 'Club Mahindra Madikeri, Coorg']")
	private WebElement resortName;
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to navigate to detail page
	 * @return
	 */
	public ClubMahindraPage navigateToClubMahindraPage() {
		resortName.click();
		weLib.switchToChildwindow(driver);
		return new ClubMahindraPage(driver);
	}

}
