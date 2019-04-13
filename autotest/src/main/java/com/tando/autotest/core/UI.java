package com.tando.autotest.core;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tando.autotest.drivers.Firefox;

import org.junit.*;
public class UI {

	public WebDriver driver = null;

	// launch a driver
	public UI() {

		Firefox ff = new Firefox();
		driver = ff.create();
	}

	// open a url
	public void open(String url) {
		driver.get(url);
		waitTime();
	}

	// click element
	public void click(By by) {
		element(by).click();
		waitTime();
	}

	// set element
	public void setValue(By by, String value) {
		element(by).sendKeys(value);
		waitTime();
	}

	// element
	public WebElement element(By by) {
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	//close
	public void close() {
		driver.close();
	}
	
	//quit
	public void quit() {
		driver.quit();
	}
	
	//clear value
	public void clear(By by) {
		element(by).clear();
	}
	
	//get url
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	//verify tag name successful
	public void verifyCurrentUrlOk(String urlExpected) {
		Assert.assertEquals("verify url successful!" + urlExpected, getCurrentUrl());
	}
		
	//verify tag name failed
	public void verifyCurrentUrlFailed(By by,String urlUnexpected) {
		Assert.assertNotEquals("verify url failed!" + urlUnexpected, getTagName(by));
	}
	
	//get attribute
	public String getAttribute(By by, String attributeName) {
		return element(by).getAttribute(attributeName);
	}
	
	//verify attribute successful
	public void verifyAttributeOk(By by,String attributeName,String attributeExpected) {
		Assert.assertEquals(attributeExpected, getAttribute(by, attributeName));
	}
	
	//verify attribute failed
	public void verifyAttributeFailed(By by,String attributeName,String attributeUnexpected) {
		Assert.assertNotEquals(attributeUnexpected, getAttribute(by, attributeName));
	}
		
	//equals
	private boolean equals(By by,Object obj) {
		if(isExisted(by)) {
			return element(by).equals(obj);
		}else {
			return false;
		}
	}
	
	//get tag name
	public String getTagName(By by) {
		return element(by).getTagName();
	}
	
	//verify tag name successful
	public void verifyTagNameOk(By by,String tagNameExpected) {
		Assert.assertEquals("verify tag name successful!" + tagNameExpected, getTagName(by));
	}
	
	//verify tag name failed
	public void verifyTagNameFailed(By by,String tagNameUnexpected) {
		Assert.assertNotEquals("verify tag name failed!" + tagNameUnexpected, getTagName(by));
	}
	
	// get text
	public String getText(By by) {
		return element(by).getText();
	}
	
	//verify text successful
	public void verifyTextOk(By by,String textExpected) {
		Assert.assertEquals("verify text successful!" + textExpected, getText(by));
	}
		
	//verify text failed
	public void verifyTextFailed(By by,String textUnexpected) {
		Assert.assertNotEquals("verify text failed!" + textUnexpected, getText(by));
	}
	
	//get size
	public void getSize(By by) {
		element(by).getSize();
	}
	
	//get title
	public String getTitle() {
		return driver.getTitle();
	}
	
	//verify title successful
	public void verifyTitleOk(String titleExpected) {
		Assert.assertEquals("verify title successful!" + titleExpected, getTitle());
	}
			
	//verify title failed
	public void verifyTitleFailed(String titleUnexpected) {
		Assert.assertNotEquals("verify title failed!" + titleUnexpected, getTitle());
	}
		
	// verify element is existed
	private boolean isExisted(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// verify element is displayed
	private boolean isDisplayed(By by) {
		if (isExisted(by)) {
			return element(by).isDisplayed();
		} else {
			return false;
		}
	}
	

	// verify element is selected
	private boolean isSelected(By by) {
		if (isExisted(by)) {
			return element(by).isSelected();
		} else {
			return false;
		}
	}
	
	// verify element is enabled
	private boolean isEnabled(By by) {
		if (isExisted(by)) {
			return element(by).isEnabled();
		} else {
			return false;
		}
	}
	
	// verify element is existed
	public void verifyExisted(By by) {
		Assert.assertTrue("Element verify exist successful!" + by.toString(), isExisted(by));
	}

	// verify element is not existed
	public void verifyNotExisted(By by) {
		Assert.assertFalse("Element verify not exist failed!" + by.toString(), isExisted(by));
	}
		
	// verify element is displayed
	public void verifyDisplayed(By by) {
		Assert.assertTrue("Element verify display successful!" + by.toString(), isDisplayed(by));
	}
		
	// verify element is not displayed
	public void verifyNotDisplayed(By by) {
		Assert.assertFalse("Element verify display failed!" + by.toString(), isDisplayed(by));
	}
		
	// verify element is selected
	public void verifySelected(By by) {
		Assert.assertTrue("Element verify select successful!" + by.toString(), isSelected(by));
	}
		
	// verify element is not selected
	public void verifyNotSelected(By by) {
		Assert.assertFalse("Element verify select failed!" + by.toString(), isSelected(by));
	}
		
	// verify element is enabled
	public void verifyEnabled(By by) {
		Assert.assertTrue("Element verify select successful!" + by.toString(), isEnabled(by));
	}
				
	// verify element is disabled
	public void verifyDisabled(By by) {
		Assert.assertFalse("Element verify select failed!" + by.toString(), isEnabled(by));
	}
		
	// wait time
	public void waitTime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

		UI ui = new UI();

	}

}
