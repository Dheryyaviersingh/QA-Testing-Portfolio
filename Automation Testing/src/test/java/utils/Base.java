package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
    public WebDriver driver;
	public String Browser;
	public String Siteurl;
	public String browser_maven;
	public String finalbrowser;
	
	public WebDriver WebDriverManager() throws IOException
	
	{
		FileInputStream fis= new FileInputStream("src/test/resources/global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		Browser=prop.getProperty("browser");
		Siteurl=prop.getProperty("siteurl");
		browser_maven=System.getProperty("browser");
		finalbrowser=browser_maven!=null ? browser_maven : Browser;
				
		
		if(driver==null)
		{
			if(finalbrowser.equalsIgnoreCase("chrome"))
				{
				
				System.setProperty("webdriver.chrome.driver","/bin/chromedriver/chromedriver");
				ChromeOptions options = new ChromeOptions() ;
                options.addArguments("--headless");
				options.addArguments("--incognito");

				driver= new ChromeDriver(options);	
				}
		
			
		
		else if(finalbrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		//	driver.get(Siteurl);
			
		}
		}
		
		return driver;
		
	}

	 public static int solveMathCaptcha(String mathProblem) {
	        // Example: if the CAPTCHA is in a text format like "What is 5 + 3?"
	        Pattern pattern = Pattern.compile("(\\d+)\\s*\\+\\s*(\\d+)");
	        Matcher matcher = pattern.matcher(mathProblem);

	        if (matcher.find()) {
	            int num1 = Integer.parseInt(matcher.group(1));
	            int num2 = Integer.parseInt(matcher.group(2));
	            return num1 + num2;
	        }
	        throw new IllegalArgumentException("Unsupported CAPTCHA format: " + mathProblem);
	    }

}
