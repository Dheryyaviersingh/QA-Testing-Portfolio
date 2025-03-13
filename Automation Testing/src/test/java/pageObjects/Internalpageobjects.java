package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Internalpageobjects {
WebDriver driver;
	
	By name= By.name("FullName");
	By email=By.name("EmailAddress");
	By phone=By.name("PhoneNumber");
	By checkbox1=By.xpath("//span[contains(text(),'Real Estate Law')]");
	By message=By.name("Message");
	By submit=By.xpath("//input[@type='submit']");
	
	
	public Internalpageobjects(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement name()
	{
		return(driver.findElement(name));
	}
	public WebElement email()
	{
		return(driver.findElement(email));
	}
	public WebElement phone()
	{
		return(driver.findElement(phone));
	}
	public WebElement checkbox1()
	{
		return(driver.findElement(checkbox1));
	}
	public WebElement message()
	{
		return(driver.findElement(message));
	}
	public WebElement submit()
	{
		return(driver.findElement(submit));
	}


}
