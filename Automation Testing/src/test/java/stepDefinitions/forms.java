package stepDefinitions;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;
import utils.DependIG;

public class forms {

     DependIG dependig;
	
	Base base;

    public forms(DependIG dependig)
	{
		this.dependig=dependig;
	}

    @Given("user will open the website for homepage form")
public void user_will_open_the_website_for_homepage_form() {
    
    dependig.base.driver.manage().window().setSize(new Dimension(1920,1000));
    dependig.base.driver.get(dependig.base.Siteurl);
  //  dependig.base.driver.manage().window().maximize();

   // System.out.print(dependig.base.driver.manage().window().getSize());

}

@When("user will check the site for homepage form")
public void user_will_check_the_site_for_homepage_form() throws InterruptedException {

    Thread.sleep(5000);
	        
    JavascriptExecutor js = (JavascriptExecutor) dependig.base.driver;
    js.executeScript("window.scrollBy(0,500)", "");

        Thread.sleep(10000);

    dependig.pageobjectmanager.getformsobject().homepagefirstname().click();
    dependig.pageobjectmanager.getformsobject().homepagefirstname().sendKeys("david");
    dependig.pageobjectmanager.getformsobject().homepagelastname().sendKeys("brenton");
    dependig.pageobjectmanager.getformsobject().homepageemail().sendKeys("brenton@blusharkdigital.com");
    dependig.pageobjectmanager.getformsobject().homepagephone().sendKeys("1234567890");
    dependig.pageobjectmanager.getformsobject().homepagemessage().sendKeys("Testing phase");

    Thread.sleep(2000);
   

}

@Then("the homepage form should be working")
public void the_homepage_form_should_be_working() throws InterruptedException {

    WebElement captcha_element = dependig.base.driver.findElement(By.xpath("(//span[@class='wpcf7-quiz-label'])[1]"));
		        
    String mathProblem  = captcha_element.getText();
      
//     int result = solveMathCaptcha(mathProblem);	     
      int mathresult = Base.solveMathCaptcha(mathProblem);   		         
      
   Thread.sleep(8000);
      
    // driver.findElement(By.id("home6")).sendKeys("Testing phase");
      
    WebElement  captchaInput = dependig.base.driver.findElement(By.xpath("(//input[@name='quizMath'])[1]"));
    captchaInput.sendKeys(String.valueOf(mathresult));
    
   Thread.sleep(5000);
   
  Actions action= new Actions(dependig.base.driver);

  action.moveToElement(dependig.pageobjectmanager.getformsobject().homepagesubmit()).click().build().perform();


    Thread.sleep(8000);

    Boolean result= dependig.base.driver.getTitle().contains("Thank");

    Boolean result2= true;

    if(result.equals(result2))
    {
       // Assert.assertTrue(dependig.base.driver.getTitle().contains("thank"));

       System.out.println("Homepage Form is working");
    }

    else{


			MultiPartEmail email = new MultiPartEmail();

email.setHostName("smtp.gmail.com");
email.setSSLCheckServerIdentity(true);
email.setSmtpPort(587);

email.setAuthenticator(new DefaultAuthenticator(
        "blusharktesting@gmail.com",
        "oweh cngc vget yycn\n"));
email.setStartTLSRequired(true);
// email.setSSLOnConnect(true);
// email.setStartTLSEnabled(true);

try {
	email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.addTo("Dheryyavier@42works.net");
email.addTo("jill@blusharkdigital.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.setFrom("Blusharktesting@gmail.com","Automation");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


email.setSubject("[Adams&Bischoff]: Homepage Form Submission Failed");

try {
	email.setMsg("Hi Adam&Bischoff admin,\r\n" + //
	        "\r\n" + //
	        "An error was encountered when submitting the below contact form:\r\n" + //
	        "\r\n" + //
	        "Page URL:"+dependig.base.driver.getCurrentUrl()+ //
	        "\r\n" + //
	        "Date & Time of Submission:"+java.time.LocalDate.now()+ //
	        "\r\n" + //
	        "Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
	                        "\r\n" + //
	                        "Regards,\r\n" + //
	                        "BluShark Automation Testing Team\r\n" + //
	                        "\r\n" + //
	                        "Note: This email is automatically generated by our system. \r\n" + //
	                        "Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
	                        "If you have received this email in error, please notify the sender immediately and delete this email from your system.");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
// send the email
email.send();
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Homepage Form is not working");
Assert.fail("Homepage form is not working");
    }
}


@Given("user will open the website for footer form")
public void user_will_open_the_website_for_footer_form() throws InterruptedException {

    dependig.base.driver.manage().window().setSize(new Dimension(1920,1000));
    dependig.base.driver.get(dependig.base.Siteurl);

    Thread.sleep(5000);
    
}

@When("user will check the site for footer form")
public void user_will_check_the_site_for_footer_form() throws InterruptedException {

	        
	      ((JavascriptExecutor) dependig.base.driver).executeScript(
	              "arguments[0].scrollIntoView();",dependig.base.driver.findElement(By.xpath("//div[@class='title h3']")));

                  Thread.sleep(8000);
	          
                  dependig.pageobjectmanager.getformsobject().footerfirstname().sendKeys("David");
                  dependig.pageobjectmanager.getformsobject().footerlastname().sendKeys("Brenton");
                  dependig.pageobjectmanager.getformsobject().footerphone().sendKeys("1234567890");
                  dependig.pageobjectmanager.getformsobject().footeremail().sendKeys("brenton@blusharkdigital.com");
                  dependig.pageobjectmanager.getformsobject().footermessage().sendKeys("This is testing phase");
              

                  Thread.sleep(8000);
    
}

@Then("the footer form should be working")
public void the_footer_form_should_be_working() throws InterruptedException {

             WebElement captcha_element = dependig.base.driver.findElement(By.xpath("(//span[@class='wpcf7-quiz-label'])[2]"));
		        
		      String mathProblem  = captcha_element.getText();
		        
		 //     int result = solveMathCaptcha(mathProblem);	     
                int mathresult = Base.solveMathCaptcha(mathProblem);   		         
	            
	         Thread.sleep(8000);
	            
	          // driver.findElement(By.id("home6")).sendKeys("Testing phase");
	            
	          WebElement  captchaInput = dependig.base.driver.findElement(By.xpath("(//input[@name='quizMath'])[2]"));
	          captchaInput.sendKeys(String.valueOf(mathresult));
	          
	         Thread.sleep(5000);
	         
	        Actions action= new Actions(dependig.base.driver);

            action.moveToElement(dependig.pageobjectmanager.formsobjects.footersubmit()).click().build().perform();
		        
            Thread.sleep(5000);

            Boolean result= dependig.base.driver.getTitle().contains("Thank");

            Boolean result2= true;
        
            if(result.equals(result2))
            {
               // Assert.assertTrue(dependig.base.driver.getTitle().contains("thank"));
        
               System.out.println("Homefooter Form is working");
            }
        
            else{
        
                    MultiPartEmail email = new MultiPartEmail();
        
        email.setHostName("smtp.gmail.com");
        email.setSSLCheckServerIdentity(true);
        email.setSmtpPort(587);
        
        email.setAuthenticator(new DefaultAuthenticator(
                "blusharktesting@gmail.com",
                "oweh cngc vget yycn\n"));
        email.setStartTLSRequired(true);
        // email.setSSLOnConnect(true);
        // email.setStartTLSEnabled(true);
        
        try {
            email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
        email.addTo("Dheryyavier@42works.net");
        email.addTo("jill@blusharkdigital.com");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
        email.setFrom("Blusharktesting@gmail.com","Automation");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        email.setSubject("[Adams&Bischoff]: Homepage Footer Form Submission Failed");
        
        try {
        	email.setMsg("Hi Adams&Bischoff admin,\r\n" + //
	        "\r\n" + //
	        "An error was encountered when submitting the below contact form:\r\n" + //
	        "\r\n" + //
	        "Page URL:"+dependig.base.driver.getCurrentUrl()+ //
	        "\r\n" + //
	        "Date & Time of Submission:"+java.time.LocalDate.now()+ //
	        "\r\n" + //
	        "Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
	                        "\r\n" + //
	                        "Regards,\r\n" + //
	                        "BluShark Automation Testing Team\r\n" + //
	                        "\r\n" + //
	                        "Note: This email is automatically generated by our system. \r\n" + //
	                        "Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
	                        "If you have received this email in error, please notify the sender immediately and delete this email from your system.");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
        // send the email
        email.send();
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Homefooter Form is not working");
        Assert.fail("Homefooter form is not working");
            }

   
}



@Given("user will open the website for contactus form")
public void user_will_open_the_website_for_contactus_form() throws InterruptedException {

    dependig.base.driver.manage().window().setSize(new Dimension(1920,1000));
    dependig.base.driver.get(dependig.base.Siteurl);

    Thread.sleep(5000);

    dependig.pageobjectmanager.getheaderobject().headercontactus().click();
    
    ((JavascriptExecutor) dependig.base.driver).executeScript(
        "arguments[0].scrollIntoView();",dependig.pageobjectmanager.getformsobject().contactusfirstname());
   
        Thread.sleep(5000);

    
}

@When("user will check the site for contactus form")
public void user_will_check_the_site_for_contactus_form() throws InterruptedException {
   
    dependig.pageobjectmanager.getformsobject().contactusfirstname().sendKeys("David");
    dependig.pageobjectmanager.getformsobject().contactuslastname().sendKeys("Brenton");
    dependig.pageobjectmanager.getformsobject().contactusemail().sendKeys("Brenton@blusharkdigital.com");
    dependig.pageobjectmanager.getformsobject().contactusphone().sendKeys("1234567890");
    dependig.pageobjectmanager.getformsobject().contactusmessage().sendKeys("This is a testing phase");

    WebElement captcha_element = dependig.base.driver.findElement(By.xpath("//span[@class='wpcf7-quiz-label']"));
		        
    String mathProblem  = captcha_element.getText();
      
    int mathresult = Base.solveMathCaptcha(mathProblem);          		         
      
   Thread.sleep(8000);
      
    // driver.findElement(By.id("home6")).sendKeys("Testing phase");
      
    WebElement  captchaInput = dependig.base.driver.findElement(By.xpath("(//input[@name='quizMath'])[1]"));
    captchaInput.sendKeys(String.valueOf(mathresult));
    
   Thread.sleep(5000);
   
  Actions action= new Actions(dependig.base.driver);
      
  action.moveToElement(dependig.base.driver.findElement(By.xpath("(//input[@name='quizMath'])[1]"))).click().build().perform();

  dependig.pageobjectmanager.getformsobject().contactussubmit().click();

}

@Then("the contactus form should be working")
public void the_contactus_form_should_be_working() throws InterruptedException {


   Thread.sleep(8000);

    Boolean result= dependig.base.driver.getTitle().contains("Thank");

    Boolean result2= true;

    if(result.equals(result2))
    {
       // Assert.assertTrue(dependig.base.driver.getTitle().contains("thank"));

       System.out.println("Contactus Form is working");
    }

    else{


			MultiPartEmail email = new MultiPartEmail();

email.setHostName("smtp.gmail.com");
email.setSSLCheckServerIdentity(true);
email.setSmtpPort(587);

email.setAuthenticator(new DefaultAuthenticator(
        "blusharktesting@gmail.com",
        "oweh cngc vget yycn\n"));
email.setStartTLSRequired(true);
// email.setSSLOnConnect(true);
// email.setStartTLSEnabled(true);

try {
	email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.addTo("Dheryyavier@42works.net");
email.addTo("jill@blusharkdigital.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.setFrom("Blusharktesting@gmail.com","Automation");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


email.setSubject("[Adams&Bischoff]: ContactUs Form Submission Failed");

try {
	email.setMsg("Hi Adams&Bischoff admin,\r\n" + //
	        "\r\n" + //
	        "An error was encountered when submitting the below contact form:\r\n" + //
	        "\r\n" + //
	        "Page URL:"+dependig.base.driver.getCurrentUrl()+ //
	        "\r\n" + //
	        "Date & Time of Submission:"+java.time.LocalDate.now()+ //
	        "\r\n" + //
	        "Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
	                        "\r\n" + //
	                        "Regards,\r\n" + //
	                        "BluShark Automation Testing Team\r\n" + //
	                        "\r\n" + //
	                        "Note: This email is automatically generated by our system. \r\n" + //
	                        "Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
	                        "If you have received this email in error, please notify the sender immediately and delete this email from your system.");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
// send the email
email.send();
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Contactus Form is not working");
Assert.fail("Contactus form is not working");
    }
}

@Given("user will open the website for sidebar form")
public void user_will_open_the_website_for_sidebar_form() throws InterruptedException {

    dependig.base.driver.manage().window().setSize(new Dimension(1920,1000));
    dependig.base.driver.get(dependig.base.Siteurl); 

    Thread.sleep(5000);

      Actions action= new Actions(dependig.base.driver);

      action.moveToElement(dependig.pageobjectmanager.getheaderobject().headerpractice()).build().perform();

      dependig.pageobjectmanager.getheaderobject().headerpracticesubmenu().click();
	        
}

@When("user will check the site for sidebar form")
public void user_will_check_the_site_for_sidebar_form() throws InterruptedException {


    Thread.sleep(5000);

    JavascriptExecutor js = (JavascriptExecutor) dependig.base.driver;
	        js.executeScript("window.scrollBy(0,250)", "");
    
                      Thread.sleep(8000);

    dependig.pageobjectmanager.getformsobject().sidebarfirstname().sendKeys("David");
    dependig.pageobjectmanager.getformsobject().sidebarlastname().sendKeys("Brenton");
    dependig.pageobjectmanager.getformsobject().sidebaremail().sendKeys("Brenton@blusharkdigital.com");
    dependig.pageobjectmanager.getformsobject().sidebarphone().sendKeys("1234567890");
    dependig.pageobjectmanager.getformsobject().sidesidebarmessage().sendKeys("This is a testing phase");
    
   
    
}

@Then("the sidebar form should be working")
public void the_sidebar_form_should_be_working() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) dependig.base.driver;
    WebElement captcha_element = dependig.base.driver.findElement(By.xpath("//span[@class='wpcf7-quiz-label']"));
		        
    String mathProblem  = captcha_element.getText();
      
    int mathresult = Base.solveMathCaptcha(mathProblem);          		         
      
   Thread.sleep(8000);
      
    // driver.findElement(By.id("home6")).sendKeys("Testing phase");
      
    WebElement  captchaInput = dependig.base.driver.findElement(By.xpath("(//input[@name='quizMath'])[1]"));
    captchaInput.sendKeys(String.valueOf(mathresult));
    
   Thread.sleep(5000);
   
  Actions action= new Actions(dependig.base.driver);
      
 // action.moveToElement(dependig.base.driver.findElement(By.xpath("//input[@name='quiz-math']"))).click().build().perform();

  // js.executeScript("window.scrollBy(0,250)", "");

  //Thread.sleep(5000);

  action.moveToElement( dependig.pageobjectmanager.getformsobject().sidebarsubmit()).click().build().perform();

  //dependig.pageobjectmanager.getformsobject().sidebarsubmit().click();
    
    Thread.sleep(8000);

    Boolean result= dependig.base.driver.getTitle().contains("Thank");

    Boolean result2= true;

    if(result.equals(result2))
    {
       // Assert.assertTrue(dependig.base.driver.getTitle().contains("thank"));

       System.out.println("sidebar Form is working");
    }

    else{


			MultiPartEmail email = new MultiPartEmail();

email.setHostName("smtp.gmail.com");
email.setSSLCheckServerIdentity(true);
email.setSmtpPort(587);

email.setAuthenticator(new DefaultAuthenticator(
        "blusharktesting@gmail.com",
        "oweh cngc vget yycn\n"));
email.setStartTLSRequired(true);
// email.setSSLOnConnect(true);
// email.setStartTLSEnabled(true);

try {
	email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.addTo("Dheryyavier@42works.net");
email.addTo("jill@blusharkdigital.com");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
email.setFrom("Blusharktesting@gmail.com","Automation");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


email.setSubject("[Adams&Bischoff]: Sidebar Form Submission Failed");

try {
	email.setMsg("Hi Adams&Bischoff admin,\r\n" + //
	        "\r\n" + //
	        "An error was encountered when submitting the below contact form:\r\n" + //
	        "\r\n" + //
	        "Page URL:"+dependig.base.driver.getCurrentUrl()+ //
	        "\r\n" + //
	        "Date & Time of Submission:"+java.time.LocalDate.now()+ //
	        "\r\n" + //
	        "Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
	                        "\r\n" + //
	                        "Regards,\r\n" + //
	                        "BluShark Automation Testing Team\r\n" + //
	                        "\r\n" + //
	                        "Note: This email is automatically generated by our system. \r\n" + //
	                        "Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
	                        "If you have received this email in error, please notify the sender immediately and delete this email from your system.");
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
// send the email
email.send();
} catch (EmailException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("Sidebar is not working");
Assert.fail("Sidebar form is not working");
    }
}

    
}
