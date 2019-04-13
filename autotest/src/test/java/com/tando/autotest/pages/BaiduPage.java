package com.tando.autotest.pages;

import org.openqa.selenium.By;

public class BaiduPage {

	public static String url = "http://www.baidu.com";

	public static By searchText = By.id("kw");

	public static By searchButton = By.id("su");
	
	public static By clickNews = By.linkText("新闻");
	
	public static By clickText = By.linkText("习近平的心愿：让各族群众都过上好日子");
	
	public static By getText = By.cssSelector("h1:nth-child(1)");
	
	public static By linkText = By.linkText("Android版下载");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
