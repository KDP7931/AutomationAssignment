package TestScript;




import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.Base.BaseClass;
import com.qa.Config.PropertyFileData;
import com.qa.Pages.MetricUnitsPage;

public class MetricUnit_Script extends BaseClass {
	static PropertyFileData propertyFile; 
	MetricUnitsPage metricpage;
	WebDriverWait wait;
	String ageErrorMessage="Please provide an age between 18 and 80.";
	String heightErrorMessage="Please provide positive height value.";
	String weightErrorMessage="Please provide positive weight value.";


	@Test(enabled=true, description="Verify that the User is able to Calculate with Valid input Data")
	public void TC_001() throws Exception {
		metricpage = new MetricUnitsPage(driver);
		wait = new WebDriverWait(driver, ExplicitWaitTime);
		metricpage.Age().clear();
		metricpage.Age().sendKeys("59");
		Assert.assertEquals(metricpage.Age().getAttribute("value"), "59", "Age input incorrect");

		wait.until(ExpectedConditions.visibilityOf(metricpage.femaleradio()));
		metricpage.femaleradio().click();

		metricpage.height().clear();
		metricpage.height().sendKeys("180");
		Assert.assertEquals(metricpage.height().getAttribute("value"), "180", "Height input incorrect");

		metricpage.weight().clear();
		metricpage.weight().sendKeys("50");
		Assert.assertEquals(metricpage.weight().getAttribute("value"), "50", "Weight input incorrect");

		Select activitySelect = new Select(metricpage.Dropdown());
		activitySelect.selectByVisibleText("Moderate: exercise 4-5 times/week");
		String selectedOptionText = activitySelect.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOptionText, "Moderate: exercise 4-5 times/week", "input incorrect");

		metricpage.calculate().click();
		wait.until(ExpectedConditions.visibilityOf(metricpage.Result()));
		Assert.assertEquals(metricpage.Result().getText(), "Result");
	}

	@Test(enabled=true, description="Verify that the User is able to Reset all fields")
	public void TC_002() throws Exception {
		metricpage = new MetricUnitsPage(driver);
		wait = new WebDriverWait(driver, ExplicitWaitTime);
		metricpage.Age().clear();
		metricpage.Age().sendKeys("59");
		Assert.assertEquals(metricpage.Age().getAttribute("value"), "59", "Age input incorrect");

		wait.until(ExpectedConditions.visibilityOf(metricpage.femaleradio()));
		metricpage.femaleradio().click();

		metricpage.height().clear();
		metricpage.height().sendKeys("180");
		Assert.assertEquals(metricpage.height().getAttribute("value"), "180", "Height input incorrect");

		metricpage.weight().clear();
		metricpage.weight().sendKeys("50");
		Assert.assertEquals(metricpage.weight().getAttribute("value"), "50", "Weight input incorrect");

		Select activitySelect = new Select(metricpage.Dropdown());
		activitySelect.selectByVisibleText("Moderate: exercise 4-5 times/week");
		String selectedOptionText = activitySelect.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOptionText, "Moderate: exercise 4-5 times/week", "input incorrect");

		metricpage.Reset().click();

		String ageFieldValue = metricpage.Age().getAttribute("value");
		Assert.assertEquals(ageFieldValue, "", "Age field should be cleared after reset");

		String HightFieldValue = metricpage.height().getAttribute("value");
		Assert.assertEquals(HightFieldValue, "", "height field should be cleared after reset");

		String WeightFieldValue = metricpage.weight().getAttribute("value");
		Assert.assertEquals(WeightFieldValue, "", "weight field should be cleared after reset");

	}

	@Test(enabled=true, description="Verify that the User Should not be able to Calculate with invalid input data")
	public void TC_003() throws Exception {
		metricpage = new MetricUnitsPage(driver);
		wait = new WebDriverWait(driver, ExplicitWaitTime);

		metricpage.setMetrics("3", "180", "78");
		metricpage.calculate().click();
		wait.until(ExpectedConditions.visibilityOf(metricpage.errormessage()));
		Assert.assertEquals(metricpage.errormessage().getText(), ageErrorMessage);


		metricpage.setMetrics("19", "-9", "78");
		metricpage.calculate().click();
		wait.until(ExpectedConditions.visibilityOf(metricpage.errormessage()));
		Assert.assertEquals(metricpage.errormessage().getText(), heightErrorMessage);

		metricpage.setMetrics("19", "180", "-8");
		metricpage.calculate().click();
		wait.until(ExpectedConditions.visibilityOf(metricpage.errormessage()));
		Assert.assertEquals(metricpage.errormessage().getText(), weightErrorMessage);


		metricpage.setMetrics("19", "180", "78");
		metricpage.calculate().click();
		wait.until(ExpectedConditions.visibilityOf(metricpage.Result()));
		Assert.assertEquals(metricpage.Result().getText(), "Result");

	}
}
