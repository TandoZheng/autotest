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

	//clear value
	public void clear(By by) {
		element(by).clear();
	}
	
	//get attribute
	public String getAttribute(By by,String name) {
		if(isExisted(by)) {
			return element(by).getAttribute(name);
		}else {
			return null;
		}
		
	}
	
	//equals
	private boolean equals(By by,Object obj) {
		if(isExisted(by)) {
			return element(by).equals(obj);
		}else {
			return false;
		}
		
	}
	
	//verify value is equals the value we wanted
	private void assertEquals(By by,Object expected,Object actual) {
		Assert.assertEquals(expected, actual);
	}
	
	//get tag name
	public String getTagName(By by) {
		if(isExisted(by)) {
			return element(by).getTagName();
		}else {
			return null;
		}
		
	}
	
	// get text
	public String getText(By by) {
		if(isExisted(by)) {
			return element(by).getText();
		}else {
			return null;
		}
	}
	
	//get size
	public void getSize(By by) {
		element(by).getSize();
	}
	
	//get title
	public String getTitle() {
		return driver.getTitle();
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
		
	// wait time
	public void waitTime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

		UI ui = new UI();

	}

}
