package com.tando.autotest.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tando.autotest.drivers.Firefox;

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

	// wait time
	public void waitTime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

		UI ui = new UI();

	}

}
