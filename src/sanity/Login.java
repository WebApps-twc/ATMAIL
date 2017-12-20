package sanity;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.ConfigReader;
import utility.GenerateData;

public class Login {
WebDriver chrome;
Logger log=Logger.getLogger("ATMAIL");
ConfigReader config;
GenerateData FirstName;



	@BeforeSuite
	public void log()throws InterruptedException{
		
		ConfigReader config=new ConfigReader();
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		chrome=new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get(config.getApplicationURl());
		log.info("URL Entered");
		
	}

@Test
public void I_enter_valid_username_and_valid_password() throws Throwable {
	chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[1]/a")).click();
	log.info("Clicked on SignIn");
	Thread.sleep(1000);
	chrome.findElement(By.xpath(".//*[@id='cc-username']")).sendKeys("vomnortel14");
	log.info("Username entered");
	chrome.findElement(By.xpath(".//*[@id='cc-user-password']")).sendKeys("Testing01");
	log.info("Password entered");
	Thread.sleep(8000);
	chrome.findElement(By.xpath(".//*[@id='login-form-button']")).click();
	log.info("Submit Login");
}

@Test
public void user_should_be_able_to_naviagte_to_spectrum_portal() throws Throwable {
	Thread.sleep(5000);
	boolean atmail= chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[3]/div/div/a/span")).isDisplayed();
	if(atmail==true)
		{
		String atmailcount= chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[3]/div/div/a/span")).getText();
		log.info("Atmail Link Available and contains:"+ atmailcount);
		chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[3]/div/div/a/span")).click();
		Thread.sleep(3000);
		boolean email=chrome.findElement(By.xpath(".//*[@id='imap-folder-container']/button[1]")).isDisplayed();
			if (email==true)
			{
				log.info("Inbox Loaded");
				AddContact con=new AddContact();
				con.AddContct(chrome);
				
			}	
			else
			{
				log.info("Inbox not loading");
			}
		}
	else
		{
			log.info("Atmail Link not Available");
		}

}

/*@Test
	public void capture()throws InterruptedException, IOException{
		
		try {
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			log.info("return");
		}
		
	}*/
	
/*@AfterSuite
	public void flush_out() throws InterruptedException{
		
		Thread.sleep(1000);
		chrome.quit();
		log.info( "Firefox has been closed");
		
	

}

*/
}
