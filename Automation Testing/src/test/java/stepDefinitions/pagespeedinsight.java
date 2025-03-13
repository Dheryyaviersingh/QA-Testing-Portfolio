package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;
import utils.DependIG;

public class pagespeedinsight {
	

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_FILE_PATH = "src/main/resources/credentials.json";
	//private static final String SERVICE_ACCOUNT_KEY_FILE_PATH = System.getProperty("user.dir")+"\\\\src\\main\\resources\\credentials.json";
   
    DependIG dependig;
	
	Base base;
	
	String hometitle;
	
	
	public pagespeedinsight(DependIG dependig)
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
	
	@Given("user will open the pagespeed website.")
	public void user_will_open_the_pagespeed_website() throws InterruptedException {
	 
	}

	@When("user will enter his url in the pagespeed website")
	public void user_will_enter_his_url_in_the_pagespeed_website() throws IOException, GeneralSecurityException, InterruptedException, EmailException {
		
		        

		dependig.base.driver.get("https://pagespeed.web.dev/");
			
		dependig.base.driver.manage().window().maximize();
			
			Thread.sleep(5000);
			

			dependig.base.driver.findElement(By.xpath("//input[@inputmode='url']")).sendKeys(dependig.base.Siteurl);
		
			dependig.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
			dependig.base.driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 c659ib']")).click();
		
			dependig.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Thread.sleep(20000);
		
		dependig.base.driver.findElement(By.xpath("//button[@id='mobile_tab']")).click();
				
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) dependig.base.driver;
        
		js.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(20000);
		
		// This method gets the mobile speed
		
		Boolean Display2= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='text'][1]")).isDisplayed();
		
		System.out.println("Mobile Speed Element is available:"+Display2+"\n");
		
	    String a= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='text'][1]")).getText();

		System.out.println("Mobile Speed:"+a+"\n");
		
		// This method gets the mobile core webvitals
		
        Boolean Display3= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Mobile FCP is available:"+Display3+"\n");
		
		String b= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")).getText();
		
		System.out.println("Mobile FCP is:"+b+"\n");
		
		Boolean Display4= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]")).isDisplayed();
			
		System.out.println("Mobile LCP is available:"+Display4+"\n");
			
		String c= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]")).getText();
			
		System.out.println("Mobile LCP is:"+c+"\n");
		
		Boolean Display5= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Mobile TBT is available:"+Display5+"\n");
			
		String d= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]")).getText();
			
		System.out.println("Mobile TBT is:"+d+"\n");
		
        Boolean Display6= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Mobile CLS is available:"+Display6+"\n");
			
		String e= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]")).getText();
			
		System.out.println("Mobile CLS is:"+e+"\n");
		
       Boolean Display7= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Mobile SI is available:"+Display7+"\n");
			
		String F= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[1]/div[2]")).getText();
			
		System.out.println("Mobile SI is:"+F+"\n");
		
		// This method gets the desktop core webvitals
		
		dependig.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dependig.base.driver.findElement(By.xpath("//button[@id='mobile_tab']")).click();
				
		Thread.sleep(10000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) dependig.base.driver;
        
		js1.executeScript("window.scrollBy(0,200)", "");
		
		dependig.base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		dependig.base.driver.findElement(By.xpath("//button[@id='desktop_tab']")).click();
		
		Thread.sleep(20000);
		
        Boolean Display8= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='text'][1]")).isDisplayed();
		
		System.out.println("Desktop Speed Element is available:"+Display8+"\n");
		
	    String g= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='text'][1]")).getText();

		System.out.println("Desktop Speed:"+g+"\n");
		
        Boolean Display9= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Desktop FCP is available:"+Display9+"\n");
		
		String h= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")).getText();
		
		System.out.println("Desktop FCP is:"+h+"\n");
		
		Boolean Display10= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Desktop LCP is available:"+Display10+"\n");
			
		String i= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]")).getText();
			
		System.out.println("Desktop LCP is:"+i+"\n");
		
	    Boolean Display11= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]")).isDisplayed();
		
		System.out.println("Desktop TBT is available:"+Display11+"\n");
			
		String j= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]")).getText();
			
		System.out.println("Desktop TBT is:"+j+"\n");
		
	    Boolean Display12= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]")).isDisplayed();
		
	    System.out.println("Desktop CLS is available:"+Display12+"\n");
				
		String k= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]")).getText();
				
		System.out.println("Desktop CLS is:"+k+"\n");
		
		Boolean Display13= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[1]/div[2]")).isDisplayed();
			
		System.out.println("Desktop SI is available:"+Display13+"\n");
					
		String l= dependig.base.driver.findElement(By.xpath("/html[1]/body[1]/c-wiz[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/span[1]/div[1]/div[2]/div[2]/div[1]/div[1]/article[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div[5]/div[1]/div[2]")).getText();
					
		System.out.println("Desktop SI is:"+l+"\n");

		int desktopspeed= Integer.parseInt(g);

		int mobilespeed= Integer.parseInt(a);

		if(desktopspeed<=80)
		{

			MultiPartEmail email = new MultiPartEmail();

email.setHostName("smtp.gmail.com");
email.setSSLCheckServerIdentity(true);
email.setSmtpPort(587);

email.setAuthenticator(new DefaultAuthenticator(
        "test@gmail.com",
        "oweh cngc vget test\n"));
email.setStartTLSRequired(true);
// email.setSSLOnConnect(true);
// email.setStartTLSEnabled(true);

email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");

email.addTo("test@test.net");
email.setFrom("test@gmail.com","Automation");
email.setSubject("[test]: Desktop Speed Performance Issues");
email.setMsg("Hi Test admin,\r\n" + //
"\r\n" + //
"We've observed a noticeable slowdown in the speed performance for our desktop platform.\r\n" + //
"\r\n" + //
"Page URL:"+dependig.base.driver.getCurrentUrl()+ //
"\r\n" + //
"Date & Time of Submission:"+java.time.LocalDate.now()+ //
"\r\n" + //
"Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
				"\r\n" + //
				"Regards,\r\n" + //
				"Test Automation Testing Team\r\n" + //
				"\r\n" + //
				"Note: This email is automatically generated by our system. \r\n" + //
				"Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
				"If you have received this email in error, please notify the sender immediately and delete this email from your system.");

// send the email
email.send();

		}

		else 

		{

		}

		if (mobilespeed<=70)
		{
			MultiPartEmail email = new MultiPartEmail();

			email.setHostName("smtp.gmail.com");
			email.setSSLCheckServerIdentity(true);
			email.setSmtpPort(587);
			
			email.setAuthenticator(new DefaultAuthenticator(
					"Test@gmail.com",
					"oweh cngc vget test\n"));
			email.setStartTLSRequired(true);
			// email.setSSLOnConnect(true);
			// email.setStartTLSEnabled(true);
			
			email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
			email.addTo("test@test.net");
			email.setFrom("test@gmail.com","Automation");
			email.setSubject("[Test]: Mobile Speed Performance Issues");
			email.setMsg("Hi Test admin,\r\n" + //
	        "\r\n" + //
	        "We've observed a noticeable slowdown in the speed performance for our mobile platform.\r\n" + //
	        "\r\n" + //
	        "Page URL:"+dependig.base.driver.getCurrentUrl()+ //
	        "\r\n" + //
	        "Date & Time of Submission:"+java.time.LocalDate.now()+ //
	        "\r\n" + //
	        "Kindly check once OR reach out your development/IT team to monitor the issue.\r\n" + //
	                        "\r\n" + //
	                        "Regards,\r\n" + //
	                        "Test Automation Testing Team\r\n" + //
	                        "\r\n" + //
	                        "Note: This email is automatically generated by our system. \r\n" + //
	                        "Any information or content contained in this email is provided solely for the intended recipient and may be confidential or privileged. \r\n" + //
	                        "If you have received this email in error, please notify the sender immediately and delete this email from your system.");
			
			// send the email
			email.send();
		}

		else{

		}
	    
	      // Build a new authorized API client service.
			Sheets service = getSheetsService();
	       // Define the ID of the spreadsheet and the range to update
	       String spreadsheetId = "1WsaJNNEDSg9xjCpL4Lcyg3HipGuYF5reBUhYvJCAL6g"; // Replace with your spreadsheet ID
	       String range = "Sheet4!A2:M"; // Replace with your desired range
	       
	       List<List<Object>> newValues = Collections.singletonList(
	               List.of(dependig.base.Siteurl,b, c, d, e, F, a, h, i, j, k, l, g)
	       );
	       
	       ValueRange body = new ValueRange()
	               .setValues(newValues);
	       
	       service.spreadsheets().values()
	       .append(spreadsheetId, range, body)
	       .setValueInputOption("RAW")
	       .setInsertDataOption("INSERT_ROWS")
	       .execute();
	       
	       System.out.println("New data has been added.");
	     
		
	  
	}

	@Then("website speed should be display and data should be moved in google sheet")
	public void website_speed_should_be_display_and_data_should_be_moved_in_google_sheet() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
		

}
