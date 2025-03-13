package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import utils.Base;

import pageObjects.PageObjectManager;

public class DependIG {
	
	public WebDriver driver;
	public PageObjectManager pageobjectmanager;
	public Base base;
	
	public DependIG() throws IOException
	{
		base= new Base();
		pageobjectmanager=new PageObjectManager(base.WebDriverManager());
		
		
	}

}
