package com.tando.autotest.cases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tando.autotest.core.UI;
import com.tando.autotest.pages.BaiduPage;

public class BaiduTest {

	private static UI ui = null;
	
	@BeforeClass
    public static void setUp() {

		ui = new UI();
    }
    
	@Before
    public void before() {
    }
	
    @Test
    public void testBaidu(){
    	
    	ui.open(BaiduPage.url);
    	ui.setValue(BaiduPage.searchText, "自动化Selenium");
    	ui.click(BaiduPage.searchButton);
    }
    
    public void testBaiduCase2() {
		  ui.open(BaiduPage.url);
		  ui.click(BaiduPage.clickNews);
		  ui.verifyDisplayed(BaiduPage.linkText);
		  ui.scrollToElement(BaiduPage.linkText);
		  ui.click(BaiduPage.linkText);
//		  ui.verifyTitle(BaiduPage.getText,"习近平的心愿：让各族群众都过上好日子");
		  ui.Wait(2);
    }
    
    @After
    public void after() {
    	ui.close();
    }
    
    @AfterClass
    public static void shutDown() {

		
    }
}
