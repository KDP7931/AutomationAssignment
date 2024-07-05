package com.qa.Base;


import java.io.IOException;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.Config.PropertyFileData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements AutoConstant {

	public WebDriver driver;
	static PropertyFileData pf;
	public static ChromeOptions options;

	@BeforeMethod
	public void initialization() throws IOException, Exception {

		pf = new PropertyFileData();
		String url = pf.GetPropertyString("url");
		WebDriverManager.chromedriver().setup();

		String chrome_key = pf.GetPropertyString("ChromeDriverKey");
		String chrome_value = pf.GetPropertyString("ChromeDriverPath");

		System.setProperty(chrome_key, chrome_value);
		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		driver = new ChromeDriver(options);

		driver.manage().timeouts().pageLoadTimeout(PageLoaderTime);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}


	@AfterMethod
	public void Teardown() throws IOException {

		driver.quit();
	}


}
