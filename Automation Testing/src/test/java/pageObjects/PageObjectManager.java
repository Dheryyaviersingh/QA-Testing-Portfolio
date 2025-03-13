package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	

   public WebDriver driver;
   public Internalpageobjects internalpageobjects;
   public formsobject formsobjects;
   public header headerobjects;
   
   public PageObjectManager(WebDriver driver)
   {
	   this.driver=driver;
   }
	
	
	public Internalpageobjects getinternalpageobjects()
	{
		internalpageobjects = new Internalpageobjects(driver);
		return internalpageobjects;
	}

	public formsobject getformsobject()
	{
		formsobjects = new formsobject(driver);
		return formsobjects;
	}

	public header getheaderobject()
	{
		headerobjects = new header(driver);
		return headerobjects;
		
	}


	
	
	
	
}
