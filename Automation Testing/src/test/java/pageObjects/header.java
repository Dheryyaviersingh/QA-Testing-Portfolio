package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class header {

 public WebDriver driver;

   By headermenu= By.xpath("//div[@class='menu_icon menu-button']");
   By headerpractice=By.xpath("//li[@id='menu-item-208']");
   By headerpracticesubmenu= By.xpath("//li[@id='menu-item-611']");
   By headercontactus= By.xpath("//li[@id='menu-item-206']");
   

  public header(WebDriver driver)
 {
     this.driver=driver;
     
 }

  public WebElement  headermenu()
    {
        return(driver.findElement(headermenu));

    }

    public WebElement  headerpractice()
    {
        return(driver.findElement(headerpractice));

    }

    public WebElement  headerpracticesubmenu()
    {
        return(driver.findElement(headerpracticesubmenu));

    }

    public WebElement  headercontactus()
    {
        return(driver.findElement(headercontactus));

    }





}
