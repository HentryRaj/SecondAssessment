package com.tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.generic.WebDriverUtils;

public class ReviewPage {
	public WebDriver driver;
	WebDriverUtils weLib = new WebDriverUtils();
	@FindBy(xpath = "//span[@id='bubble_rating']")
	private WebElement rating;
	@FindBy(tagName = "title")
	private WebElement title;
	@FindBy(name="ReviewTitle")
	private WebElement reviewTitle;
	@FindBy(id = "ReviewText")
	private WebElement reviewDesc;
	@FindBy(id = "qid12_bubbles")
	private WebElement services;
	@FindBy(id = "qid13_bubbles")
	private WebElement value;
	@FindBy(id = "qid190_bubbles")
	private WebElement quality;
	@FindBy(id = "qid47_bubbles")
	private WebElement location;
	@FindBy(id = "qid14_bubbles")
	private WebElement clean;
	@FindBy(id = "qid11_bubbles")
	private WebElement room;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * method to get the review
	 * @param reviewTit
	 * @param description
	 * @throws InterruptedException
	 */
	public void getReview(  String reviewTit, String description ) throws InterruptedException {
		weLib.actionForMoveToElement(driver, rating);
		reviewTitle.sendKeys(reviewTit);
		reviewDesc.sendKeys(description);
		if(services.isDisplayed()) {
		weLib.actionForMoveToElement(driver, services);
		}
		if(value.isDisplayed()) {
		weLib.actionForMoveToElement(driver, value);
		}
		if(quality.isDisplayed()) {
		weLib.actionForMoveToElement(driver, quality);
		}
		 if(location.isDisplayed()) {
			weLib.actionForMoveToElement(driver, location);
			}
		 if(clean.isDisplayed()) {
			weLib.actionForMoveToElement(driver, clean);
			}
		if(room.isDisplayed())  {
			weLib.actionForMoveToElement(driver, room);
			}
		checkbox.click();
	}
	

}
