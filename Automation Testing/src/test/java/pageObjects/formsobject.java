package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class formsobject {

    public WebDriver driver;

    By homepagefirstname= By.xpath("//input[@id='fname']");
    By homepagelastname= By.xpath("//input[@id='lname']");
	By homepageemail=By.xpath("//input[@id='mail']");
	By homepagephone=By.xpath("//input[@id='phn']");
	By homepagemessage=By.xpath("//textarea[@id='detail']");
    By homepagesubmit=By.xpath("(//input[@type='submit'])[1]");
    By footerfirstname= By.xpath("//input[@id='f-name']");
    By footerlastname= By.xpath("//input[@id='l-name']");
	By footeremail=By.xpath("//input[@id='email']");
	By footerphone=By.xpath("//input[@id='phone']");
	By footermessage=By.xpath("//textarea[@id='c-detail']");
    By footersubmit=By.xpath("(//input[@value='Tell Us About Your Case'])[2]");
    By sidebarfirstname= By.xpath("//input[@placeholder='First Name*']");
    By sidebarlastname= By.xpath("//input[@placeholder='Last Name*']");
    By sidebaremail= By.xpath("//input[@placeholder='Email Address*']");
    By sidebarphone= By.xpath("//input[@placeholder='Phone Number*']");
    By sidebarsubmit= By.id("submitside");
    By sidebarmessage= By.xpath("//textarea[@placeholder='Case Details*']");
    By contactusfirstname = By.xpath("//input[@placeholder='First Name*']");
    By contactuslastname = By.xpath("//input[@placeholder='Last Name*']");
    By contactusphone= By.xpath("//input[@placeholder='Phone Number*']");
    By contactusemail=  By.xpath("//input[@placeholder='Email Address*']");
    By contactusmessage= By.xpath("//textarea[@placeholder='Case Details*']");
    By contactussubmit= By.xpath("//input[@value='Submit']");
    By errorfirst= By.id("404first");
    By errorlast= By.id("404last");
    By errorphone= By.id("404phone");
    By erroremail= By.id("404email");
    By errormessage= By.id("404message");



    public formsobject(WebDriver driver)
	{
		this.driver=driver;
		
	}

    public WebElement  homepagefirstname()
    {
        return(driver.findElement(homepagefirstname));

    }

    public  WebElement  homepagelastname()
    {
        return(driver.findElement(homepagelastname));

    }

    public WebElement  homepageemail()
    {
        return(driver.findElement(homepageemail));

    }

    public WebElement  homepagephone()
    {
        return(driver.findElement(homepagephone));

    }


    public WebElement  homepagemessage()
    {
        return(driver.findElement(homepagemessage));

    }

    public  WebElement  homepagesubmit()
    {
        return(driver.findElement(homepagesubmit));

    }


    public WebElement  sidebarfirstname()
    {
        return(driver.findElement(sidebarfirstname));

    }

    public WebElement  sidebarlastname()
    {
        return(driver.findElement(sidebarlastname));

    }

    public WebElement  sidebaremail()
    {
        return(driver.findElement(sidebaremail));

    }

    public WebElement  sidebarphone()
    {
        return(driver.findElement(sidebarphone));

    }

    public WebElement  sidesidebarmessage()
    {
        return(driver.findElement(sidebarmessage));

    }

   

    public WebElement  sidebarsubmit()
    {
        return(driver.findElement(sidebarsubmit));

    }

    public WebElement  contactusfirstname()
    {
        return(driver.findElement(contactusfirstname));

    }

    public WebElement  contactuslastname()
    {
        return(driver.findElement(contactuslastname));

    }

    public WebElement  contactusphone()
    {
        return(driver.findElement(contactusphone));

    }

    public WebElement  contactusemail()
    {
        return(driver.findElement(contactusemail));

    }

    public WebElement  contactusmessage()
    {
        return(driver.findElement(contactusmessage));

    }

    public WebElement  contactussubmit()
    {
        return(driver.findElement(contactussubmit));

    }


    public WebElement  errorfirst()
    {
        return(driver.findElement(errorfirst));

    }


    public WebElement  errorlast()
    {
        return(driver.findElement(errorlast));

    }

    public WebElement  errorphone()
    {
        return(driver.findElement(errorphone));

    }

    public WebElement  erroremail()
    {
        return(driver.findElement(erroremail));

    }

    public WebElement  footerfirstname()
    {
        return(driver.findElement(footerfirstname));

    }


    public WebElement  footerlastname()
    {
        return(driver.findElement(footerlastname));

    }

    public WebElement  footeremail()
    {
        return(driver.findElement(footeremail));

    }

    public WebElement  footerphone()
    {
        return(driver.findElement(footerphone));

    }

    public WebElement  footermessage()
    {
        return(driver.findElement(footermessage));

    }

    public WebElement  footersubmit()
    {
        return(driver.findElement(footersubmit));

    }


}
