package com.tando.autotest.cases;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import com.tando.autotest.core.UI;
import com.tando.autotest.pages.QQZonePage;

public class LoginQQZone {

	  static UI ui = null;
		
	  @BeforeClass
	  public static void setUp() {
		  ui = new UI();
	  }

	  @Test
	  public void testQQZone() throws Exception {
		  ui.open(QQZonePage.url);
		  ui.switchToFrame(QQZonePage.iframe);
		  ui.click(QQZonePage.LoginLink);
		  ui.clear(QQZonePage.QQId);
		  ui.setValue(QQZonePage.QQId, "275934915@qq.com");
		  ui.setValue(QQZonePage.QQPsw, "5i92623Ashin");
		  ui.click(QQZonePage.loginButton);
//		  ui.open("https://user.qzone.qq.com/275934915");
		  ui.click(QQZonePage.personCenter);
	  }
	 
	  @After
	  public void after() {
//		  ui.close();
	  }
	  
}
