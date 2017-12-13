package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Reading_Emails {

	
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void ProcessOfDeletingAnEmail(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	String count= chrome.findElement(By.xpath(".//span[@id='unread-inbox']")).getText();
	log.info("Unread email count is: "+count);
	boolean unread=chrome.findElement(By.xpath(".//*[@title='Unread Message']")).isDisplayed();
	if(unread==true)
	{
		log.info("Unread emails available"+ "Test Scenario passed for Black Dot");
		chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
		log.info("All unread emails has been selected");
		chrome.findElement(By.xpath(".//*[@id='mark-mail-dropdown-button']/i[2]")).click();
		log.info("Emails has been selected");
		chrome.findElement(By.xpath(".//*[@id='mark-mail-read']")).click();
		log.info("Email has been mark as read");
		chrome.findElement(By.xpath(".//*[@id='get-mail-button-label']")).click();
		String countafter= chrome.findElement(By.xpath(".//span[@id='unread-inbox']")).getText();
		log.info("Unread email count is: "+countafter);
		log.info("Test Scenario Passed for Select All function box");
	}
	else
	{
		log.info("Unread emails unavailable");
		chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
		log.info("All unread emails has been selected");
		chrome.findElement(By.xpath(".//*[@id='mark-mail-dropdown-button']/i[2]")).click();
		log.info("Emails has been selected");
		chrome.findElement(By.xpath(".//*[@id='mark-mail-unread']")).click();
		log.info("Email has been mark as Unread");
		chrome.findElement(By.xpath(".//*[@id='get-mail-button-label']")).click();
		String countafter= chrome.findElement(By.xpath(".//span[@id='unread-inbox']")).getText();
		log.info("Unread email count is: "+countafter);
		log.info("Test Scenario Passed for Select All function box");
	}
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
}
