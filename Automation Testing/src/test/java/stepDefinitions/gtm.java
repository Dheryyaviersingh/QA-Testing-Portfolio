package stepDefinitions;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;
import utils.DependIG;

public class gtm {

    DependIG dependig;
	
	Base base;

    int i=0;
    int j=1;
    int temp;

    Boolean result;

    public gtm(DependIG dependig)
	{
		this.dependig=dependig;
	}


    @Given("user will open the website for GTM")
public void user_will_open_the_website_for_gtm() {
   
    dependig.base.driver.get(dependig.base.Siteurl);
}

@When("user will check the site for GTM script")
public void user_will_check_the_site_for_gtm_script() throws InterruptedException, EmailException {
    
           Thread.sleep(5000);

result= dependig.base.driver.getPageSource().contains("gtm.js");

        if (result==true)
        {

            System.out.println("GTM is Added");
Assert.assertTrue(dependig.base.driver.getPageSource().contains("gtm.js")," GTM is working");
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


email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
email.addTo("Dheryyavier@42works.net");
email.addTo("jill@blusharkdigital.com");
email.setFrom("Blusharktesting@gmail.com","Automation");
email.setSubject("[Adams&Bischoff]: GTM Not Found");
email.setMsg("Hi Adams&Bischoff admin,\r\n" + //
"\r\n" + //
"An error was encountered when checking the site for GTM. There is no GTM.\r\n" + //
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

// send the email
email.send();
System.out.println("GTM is not Added");
Assert.fail("GTM is not working");
        }
        
}


@Then("the GTM script should be working.")
public void the_gtm_script_should_be_working() {


}
    
}
