package com.autodesk.generic;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author HenTryRAj
 *
 */
public class WebDriverUtils {
	

	/**
	 * used for implicitly wait
	 * @param driver
	 */
	public void woitForElementToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is use to wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
/**
 * This method is used to move from one element to another element in x axis
 * @param driver
 * @param element
 * @param lenght
 * @param height
 * @param max
 * @throws InterruptedException 
 */
	public void actionForMoveToElement(WebDriver driver, WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		int i ;
		for( i = 0 ; i <50 ; ) {
		 act.moveToElement(element, i , 1).perform();
		 Thread.sleep(1000);
		 i = i + 10;
		}
		if(i<=50) {
			act.moveToElement(element, i, 1).click().perform();
		}
	}
	/**
	 * This method is use to move to particular element
	 * @param driver
	 * @param element
	 */
	public void actionForMoveTo(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;
	}
	
		static String parentWind;
	    static String childWind;
	/**
	 * This method is use to switch from parent window to child window
	 * @param driver
	 */
	public void switchToChildwindow(WebDriver driver) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> is = set.iterator();
		parentWind	= is.next();
		childWind	= is.next();
		driver.switchTo().window(childWind);
	}
	/**
	 * This method is use to switch from child window to parent window 
	 * @param driver
	 */
	public void switchToParentwindow(WebDriver driver) {
		driver.switchTo().window(parentWind);
	}
	
	/**
	 * This method is used to perform scroll down action in web page
	 * @param element
	 * @param driver
	 */
	public void scrollDown(WebElement element, WebDriver driver) {
		int yax = element.getLocation().getY();
		JavascriptExecutor jse  = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0, " + yax + ")");
	}
}

