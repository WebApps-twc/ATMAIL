package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EditShareContacts {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void emailtcontact(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='tab-contacts']")).click();
	Thread.sleep(1000);
	boolean contactcheck=chrome.findElement(By.xpath(".//*[@id='contact-checkbox-c281']")).isDisplayed();
	if(contactcheck==true)
	{
		chrome.findElement(By.xpath(".//*[@id='contact-checkbox-c281']")).click();
			log.info("Contact has been selected");
			chrome.findElement(By.xpath(".//*[@id='email-contacts-button-label']")).click();
			log.info("Email has been clicked from main navigation");
		 boolean recipient=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).isDisplayed();
		 if(recipient==true)
		 {
			 String to=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).getText();
			 
			 chrome.findElement(By.xpath(".//*[@role='button'][@title='Close']")).click();
			 log.info("Closed reply email model"+ to +"Test Scenaio Passed");
			
		 }
		 else
		 {
			 log.info("Error Occured");
		 }
	}
		else
	{
			log.info("Test Scenario Failed: Error Occured ");	
	}
} catch (Exception e) {

	e.printStackTrace();
}
	}
	
	@Test
	public void ShareAllContact(WebDriver chrome)throws InterruptedException, IOException {
		try{
			Thread.sleep(2000);
			chrome.findElement(By.xpath(".//*[@id='tab-contacts']")).click();
			Thread.sleep(2000);
			chrome.findElement(By.xpath(".//*[@id='contact-list-checkbox-toggle']")).click();
			boolean contactcheck=chrome.findElement(By.xpath(".//*[@id='contact-list-checkbox-toggle']")).isSelected();
			if(contactcheck==true)
			{
				chrome.findElement(By.xpath(".//*[@id='share-contacts-button-label']")).click();
				boolean share=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).isDisplayed();
				if(share==true)
				{
					log.info("Test Scenario Passed");
				}
				else
				{
					log.info("Test Scenario Failed: Error Occured ");
				}
			}
				else
			{
				log.info("Test Scenario Failed: Error Occured ");	
			}
		} catch (Exception e) {

			log.info("Test Scenario Failed: Error Occured ");
			}
	}
}
