package com.tando.autotest.drivers;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firefox {

	
	public WebDriver create() {
		
		
		System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
//		File file = new File("C:\\Users\\duanjie\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\ijmggxxj.default");
//		FirefoxProfile profile = new FirefoxProfile(file);
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(profile);
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
	}
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        String s = driver.getTitle();
        System.out.println(s);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.close();
	}

}
