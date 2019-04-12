package com.tando.autotest.drivers;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
        options.addArguments("--test-type", "--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.baidu.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.close();
	}

}
