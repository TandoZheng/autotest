package com.tando.autotest.pages;

import org.openqa.selenium.By;

public class JiumodiaryPage {

	public static String url = "https://www.jiumodiary.com/";
	
	public static By bookSearch = By.id("SearchWord");
	
	public static By searchButton = By.id("SearchButton");
	
	public static By bookLink = By.cssSelector("#forum-div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)");
	
	public static By downloadButton = By.cssSelector("div[class='btn-groups _t4_']>button[class='xui-btn btn _t4_']:nth-child(1)");
	
	public static By xmlyQRCode = By.cssSelector("div[class='qrcode _pHD']>img[class='_pHD']:nth-child(1)");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
