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
    
    @After
    public void after() {
    	ui.close();
    }
    
    @AfterClass
    public static void shutDown() {

		
    }
}
