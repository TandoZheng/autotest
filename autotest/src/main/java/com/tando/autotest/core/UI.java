package com.tando.autotest.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.*;

import com.tando.autotest.drivers.Firefox;

import org.apache.commons.lang3.StringUtils;
import org.junit.*;

public class UI {

	public static WebDriver driver = null;

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

	// refresh
	public void refresh() {
		driver.navigate().refresh();
	}
	
	// back
	public void back() {
		driver.navigate().back();
	}
	
	// forward
	public void forward() {
		driver.navigate().forward();
	}
	
	//switches to new frame
	public void switchToFrame(By by) {
		driver.switchTo().frame(element(by));
	}
	
	//switches to new tab
	public void switchToTab(int index) {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		
		//switches to new tab
		driver.switchTo().window(tabs.get(index)); 
	}	

	// click element
	public void click(By by) {
		element(by).click();
	}

	// set element
	public void setValue(By by, String value) {
		element(by).sendKeys(value);
	}

	// element
	public WebElement element(final By by) {

		WebElement e = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(by);
			}
		});
		return e;
	}

	// elements
	public List<WebElement> elements(final By by) {

		return driver.findElements(by);
	}

	// close
	public void close() {
		driver.close();
	}

	// quit
	public void quit() {
		driver.quit();
	}

	// clear value
	public void clear(By by) {
		element(by).clear();
	}

	// get url
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	// verify tag name successful
	public void verifyUrl(String url) {
		Assert.assertTrue("verify url failed!", StringUtils.equals(getUrl(), url));
	}

	// get attribute
	public String getAttribute(By by, String attribute) {
		return element(by).getAttribute(attribute);
	}

	// verify attribute successful
	public void verifyAttribute(By by, String attribute, String value) {
		Assert.assertTrue("verify attribute failed",
				StringUtils.equalsAnyIgnoreCase(getAttribute(by, attribute), value));
	}

	// get tag name
	public String getTagName(By by) {
		return element(by).getTagName();
	}

	// verify tag name successful
	public void verifyTagName(By by, String value) {
		Assert.assertTrue("verify tag name failed", StringUtils.equalsAnyIgnoreCase(getTagName(by), value));
	}

	// get text
	public String getText(By by) {
		return element(by).getText();
	}

	// verify text successful
	public void verifyText(By by, String value) {
		Assert.assertTrue("verify text failed", StringUtils.equalsAnyIgnoreCase(getText(by), value));
	}

	// get size
	public void getSize(By by) {
		element(by).getSize();
	}

	// get title
	public String getTitle() {
		return driver.getTitle();
	}

	// verify text successful
	public void verifyTitle(By by, String value) {
		Assert.assertTrue("verify title failed", StringUtils.equalsAnyIgnoreCase(getTitle(), value));
	}

	// verify element is existed
	public boolean isExisted(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// verify element is existed
	public boolean isExisted(By by, int index) {
		try {
			driver.findElements(by).get(index);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// verify element is displayed
	public boolean isDisplayed(By by) {
		if (isExisted(by)) {
			return element(by).isDisplayed();
		} else {
			return false;
		}
	}
		
	// verify element is displayed
	public boolean isDisplayed(By by, int index) {
		if (isExisted(by,index)) {
			return elements(by).get(index).isDisplayed();
		} else {
			return false;
		}
	}

	// verify element is selected
	public boolean isSelected(By by) {
		if (isExisted(by)) {
			return element(by).isSelected();
		} else {
			return false;
		}
	}
	
	// verify element is selected
	public boolean isSelected(By by,int index) {
		if (isExisted(by,index)) {
			return elements(by).get(index).isSelected();
		} else {
			return false;
		}
	}

	// verify element is enabled
	public boolean isEnabled(By by) {
		if (isExisted(by)) {
			return element(by).isEnabled();
		} else {
			return false;
		}
	}
	
	// verify element is enabled
	public boolean isEnabled(By by,int index) {
		if (isExisted(by,index)) {
			return elements(by).get(index).isEnabled();
		} else {
			return false;
		}
	}

	// verify element is existed
	public void verifyExisted(By by) {
		Assert.assertTrue("Verify Element " + by.toString() + " exist failed!", isExisted(by));
	}
	
	// verify element is existed
	public void verifyExisted(By by,int index) {
		Assert.assertTrue("Verify Element " + by.toString() + " exist failed!", isExisted(by,index));
	}
	
	// verify element is not existed
	public void verifyNotExisted(By by) {
		Assert.assertFalse("Verify Element " + by.toString() + " not exist failed!", isExisted(by));
	}

	// verify element is not existed
	public void verifyNotExisted(By by,int index) {
		Assert.assertFalse("Verify Element " + by.toString() + " not exist failed!", isExisted(by,index));
	}
		
	// verify element is displayed
	public void verifyDisplayed(By by) {
		Assert.assertTrue("Verify Element " + by.toString() + " displayed failed!", isDisplayed(by));
	}
		
	// verify element is displayed
	public void verifyDisplayed(By by, int index) {
		Assert.assertTrue("Verify Element " + by.toString() + " displayed failed!", isDisplayed(by, index));
	}

	// verify element is not displayed
	public void verifyNotDisplayed(By by) {
		Assert.assertFalse("Verify Element " + by.toString() + " not displayed failed!", isDisplayed(by));
	}

	// verify element is not displayed
	public void verifyNotDisplayed(By by,int index) {
		Assert.assertFalse("Verify Element " + by.toString() + " not displayed failed!", isDisplayed(by,index));
	}
		
	// verify element is selected
	public void verifySelected(By by) {
		Assert.assertTrue("Verify Element " + by.toString() + " selected failed!", isSelected(by));
	}

	// verify element is selected
	public void verifySelected(By by,int index) {
		Assert.assertTrue("Verify Element " + by.toString() + " selected failed!", isSelected(by,index));
	}
		
	// verify element is not selected
	public void verifyNotSelected(By by) {
		Assert.assertFalse("Verify Element " + by.toString() + " not selected failed!", isSelected(by));
	}

	// verify element is not selected
	public void verifyNotSelected(By by,int index) {
		Assert.assertFalse("Verify Element " + by.toString() + " not selected failed!", isSelected(by,index));
	}
		
	// verify element is enabled
	public void verifyEnabled(By by) {
		Assert.assertTrue("Verify Element " + by.toString() + " enabled failed!", isEnabled(by));
	}

	// verify element is enabled
	public void verifyEnabled(By by,int index) {
		Assert.assertTrue("Verify Element " + by.toString() + " enabled failed!", isEnabled(by,index));
	}
		
	// verify element is not enabled
	public void verifyNotEnabled(By by) {
		Assert.assertFalse("Verify Element " + by.toString() + " not enabled failed!", isEnabled(by));
	}
	
	// verify element is not enabled
	public void verifyNotEnabled(By by,int index) {
		Assert.assertFalse("Verify Element " + by.toString() + " not enabled failed!", isEnabled(by,index));
	}

	// wait time
	public void waitTime() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		页面加载timeout
//		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
//		找对象的timeout，动态找
//		driver.manage().timeouts().implicitlyWait(waitTimeout, TimeUnit.SECONDS);
	}

	public void scrollToElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element(by));
	}

	public void Wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		UI ui = new UI();

	}

}
