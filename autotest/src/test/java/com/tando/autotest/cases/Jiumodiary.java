package com.tando.autotest.cases;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import com.tando.autotest.core.UI;
import com.tando.autotest.pages.JiumodiaryPage;;

public class Jiumodiary {

	static UI ui = null;
	
	  @BeforeClass
	  public static void setUp() {
		  ui = new UI();
	  }

	  @Test
	  public void jiumodiaryPage(){
		  ui.open(JiumodiaryPage.url);
		  ui.setValue(JiumodiaryPage.bookSearch, "历史");
		  ui.click(JiumodiaryPage.searchButton);
		  ui.click(JiumodiaryPage.bookLink);
		  ui.Wait(3);
		  ui.switchToTab(1);
		  ui.refresh();
		  ui.verifyDisplayed(JiumodiaryPage.downloadButton);
		  ui.click(JiumodiaryPage.downloadButton);
		  ui.verifyDisplayed(JiumodiaryPage.xmlyQRCode);
	  }
	 
	  @After
	  public void after() {
//		  ui.close();
	  }

}
