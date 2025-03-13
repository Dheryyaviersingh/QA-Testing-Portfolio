package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.DependIG;

public class Hooks {
	
	DependIG dependig;
	
	WebDriver driver;

	public Hooks(DependIG dependig) throws IOException
	{
		this.dependig=dependig;
		this.driver=dependig.base.WebDriverManager();
	}
	
	@After
	public void afterscenario()
	{
		driver.quit();
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] filecontent=FileUtils.readFileToByteArray(source);
		scenario.attach(filecontent, "image/png", "image");
		}
	}

	
}
