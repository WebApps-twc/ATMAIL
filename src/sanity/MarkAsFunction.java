package sanity;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MarkAsFunction {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void Marking_Multiple_Emails_Unread(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
			log.info("Selected all mails");
			chrome.findElement(By.xpath(".//*[@id='mark-mail-dropdown-button']")).click();
			log.info("Clicl on Mark As ");
			chrome.findElement(By.xpath(".//a[@id='mark-mail-unread']")).click();
			log.info("click on Unread");
			boolean dot=chrome.findElement(By.xpath("//i[@class='icon-circle_fill']")).isDisplayed();
			if(dot==true)
			{
					log.info("Unread Mails are available: Test Scenario Passed");
					
			}
				else
			{
					log.info("Unread Mails are not available: Test Scenario Failed");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	@Test
	public void Unread_Read_through_MarkAs_function(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
			chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
			log.info("Selected all mails");
			chrome.findElement(By.xpath(".//*[@id='mark-mail-dropdown-button']")).click();
			log.info("Clicl on Mark As ");
			chrome.findElement(By.xpath(".//a[@id='mark-mail-read']")).click();
			log.info("click on Read");
			boolean dot=chrome.findElement(By.xpath("//i[@class='']")).isDisplayed();
			if(dot==true)
			{
				log.info("Unread Mails: Test Scenario Failed");
					
			}
				else
			{
				log.info("Mails has been read:Test Scenario Pass");
				chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
				log.info("Unchecked the emails");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	@Test
	public void verifyMarkingMultipleEmailsAsNotSpam(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='imap-folder-button-spam']")).click();
			log.info("clicked on Spam Folder");
			String count=chrome.findElement(By.xpath(".//*[@id='imap-folder-button-spam']")).getText();
			String zero="Spam 0";
			log.info("Checking Spam count");
			if(count==zero)
			{
				log.info("No Spam mails found in spam folder");
					
			}
				else
			{
					chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
					log.info("Selected All Spam Emails");
					chrome.findElement(By.xpath(".//*[@id='mark-mail-dropdown-button']")).click();
					log.info("Clicked on Mark as ");
					chrome.findElement(By.xpath(".//*[@id='mark-mail-not-spam']")).click();
					log.info("Clicked on Not as Spam option");
					chrome.switchTo().alert().accept();
					log.info("Spam mails has been marked Not As Spam: Test Passed");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
