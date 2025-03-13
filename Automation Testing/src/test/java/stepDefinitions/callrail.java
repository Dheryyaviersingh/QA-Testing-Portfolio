package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.log.Log;
import org.openqa.selenium.devtools.v125.log.model.LogEntry;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.devtools.v125.network.model.Response;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import utils.Base;
import utils.DependIG;
import org.testng.Assert;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class callrail {

    DependIG dependig;
	
	Base base;
	
	String hometitle;

	int i=0;
	int j=1;
	int temp;

	private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_FILE_PATH = "src/main/resources/credentials.json";

	String call1;

	public callrail(DependIG dependig)
	{
		this.dependig=dependig;
	}

	 public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
	    	
	    	GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_FILE_PATH))
	                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
	        // Create an HttpRequestInitializer using the credentials
	        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);
	        // Build the Sheets service
	        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, requestInitializer)
	                .setApplicationName(APPLICATION_NAME)
	                .build();
	    }

	
    
@Given("user will open the website for callrail")
public void user_will_open_the_website_for_callrail() {
    
}

@When("user will check the site for callrail script")
public void user_will_check_the_site_for_callrail_script() throws InterruptedException, IOException, GeneralSecurityException , EmailException {
 

	 System.setProperty("webdriver.chrome.driver", "/bin/chromedriver/chromedriver");

      ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=");
	  options.addArguments("--headless");
		
	  ChromeDriver driver = new ChromeDriver(options);
    
        
	    DevTools devTools = driver.getDevTools();
	    devTools.createSession();
	    devTools.send(Network.enable(Optional.of(1000000), Optional.of(1000000), Optional.of(1000000)));

	    
	    devTools.addListener(Network.responseReceived(), response ->
	    
	    {
	           Response r1=	response.getResponse();
	       
	              
	           if((r1.getUrl()+r1.getStatus()).contains("https://cdn.callrail.com/companies/240220864/ef116c8f6ace9e4e4881/12/swap.js200"))
	                   {
	                	    
	           
						System.out.println("callrail is active");

						temp=i;

						


	                   }
	                   
	                   else if ((r1.getUrl()+r1.getStatus()).contains("https://cdn.callrail.com/companies/240220864/ef116c8f6ace9e4e4881/12/swap.js404") || ((r1.getUrl()+r1.getStatus()).contains("https://cdn.callrail.com/companies/240220864/ef116c8f6ace9e4e4881/12/swap.js403")) || ((r1.getUrl()+r1.getStatus()).contains("https://cdn.callrail.com/companies/240220864/ef116c8f6ace9e4e4881/12/swap.js500")))
	                   {

	                	temp=j;

						System.out.println("callrail is not active");

						   Assert.fail("Callrail is not active");

						   
	                   }
	                       	           
	    });

		driver.get(dependig.base.Siteurl);
		
		driver.manage().window().maximize();	
		
		Thread.sleep(8000);

		// System.out.println(temp);
		
		driver.quit();

		
		if(temp==1)
		{

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


email.setSubject("[Adams&Bischoff]: CallRail is not working");

try {
	email.setMsg("Hi Adams&Bischoff admin,\r\n" + //
	        "\r\n" + //
	        "An error was encountered when checking the site for callrail. The callrail is either not working or not found\r\n" + //
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

System.out.println("callrail is not active");
		}
		

else
		{
			System.out.println("callrail is active");
		}
}

@Then("the callrail script should be working.")
public void the_callrail_script_should_be_working() {
    
}


}
