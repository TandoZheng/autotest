package com.tando.autotest.pages;

import org.openqa.selenium.By;

public class QQZonePage {

	public static String url = "https://i.qq.com/";
	
	public static By iframe = By.id("login_frame");
	
	public static final By LoginLink = By.id("switcher_plogin");
	
	public static By QQId = By.id("u");
	
	public static By QQPsw = By.id("p");
	
	public static By loginButton = By.id("login_button");
	
	public static By personCenter = By.cssSelector("#aIcenter > span:nth-child(2)");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
