package com.qa.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.AutoConstant;

public class MetricUnitsPage implements AutoConstant  {

	WebDriver driver;

	public MetricUnitsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='cage']")
	private  WebElement age;

	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'female')]//span")
	private  WebElement femaleradio;

	@FindBy(how = How.XPATH, using = "//input[@id='cheightmeter']")
	private  WebElement height;

	@FindBy(how = How.XPATH, using = "//input[@id='ckg']")
	private  WebElement weight;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private  WebElement calculate;

	@FindBy(how = How.XPATH, using = "//select[@id='cactivity']")
	private  WebElement Dropdown;

	@FindBy(how = How.XPATH, using = "//input[@value='Clear']")
	private  WebElement Reset;

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='Result']")
	private  WebElement Result;

	@FindBy(how = How.XPATH, using = "//div//font")
	private  WebElement errormessage;

	public WebElement errormessage() {
		return errormessage;
	}

	public WebElement Age() {
		return age;
	}

	public WebElement Reset() {
		return Reset;
	}

	public WebElement femaleradio() {
		return femaleradio;
	}

	public WebElement height() {
		return height;
	}

	public WebElement weight() {
		return weight;
	}

	public WebElement calculate() {
		return calculate;
	}

	public WebElement Dropdown() {
		return Dropdown;
	}

	public WebElement Result() {
		return Result;
	}

	public void setMetrics(String age, String height, String weight) {
		WebDriverWait wait=new WebDriverWait(driver,ExplicitWaitTime);
		wait.until(ExpectedConditions.visibilityOf(Age()));
		Age().clear();
		Age().sendKeys(age);
		wait.until(ExpectedConditions.visibilityOf(height()));
		height().clear();
		height().sendKeys(height);
		wait.until(ExpectedConditions.visibilityOf(weight()));
		weight().clear();
		weight().sendKeys(weight);


	}

}
