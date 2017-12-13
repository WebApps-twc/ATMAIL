package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Contact_Group {
	Logger log=Logger.getLogger("ATMAIL");
	@Test(priority=1)
	public void CreationFolderSent(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='anchor-contacts']")).click();
	chrome.findElement(By.xpath(".//*[@id='add-new-group-button']")).click();
	log.info("Create new folder");
	boolean error=chrome.findElement(By.xpath("/html/body/div[4]")).isDisplayed();
	if(error==true)
	{
		chrome.findElement(By.xpath(".//input[@id='imap-folder-name-control'][@title='New Group']")).sendKeys("Some");
		log.info("Folder name entered");
		chrome.findElement(By.xpath("//span[contains(text(),'Create')][@class='ui-button-text']")).click();
		log.info("Click on Create");
		boolean error1=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(error1==true)
		{
				String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(systemerror+"Test Scenario Passed");
		}
			else
		{
				String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(systemerror+"Test Scenario Failed");
		}

	}
		else
	{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Failed");
	}
	
} catch (Exception e) {

	e.printStackTrace();
}
}
	@Test(priority=2)
	public void ExisitingContact(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='anchor-contacts']")).click();
			String msg= chrome.findElement(By.xpath(".//*[@access-next-tabindex='contactfolder-73']")).getText();
			log.info("Already created folder name is "+ msg);
			chrome.findElement(By.xpath(".//*[@id='add-new-group-button']")).click();
			log.info("Create existing folder");
			chrome.findElement(By.xpath(".//input[@id='imap-folder-name-control'][@title='New Group']")).sendKeys("Some");
			log.info("Folder name entered");
			chrome.findElement(By.xpath("//span[contains(text(),'Create')][@class='ui-button-text']")).click();
			log.info("Click on Create");
			boolean Message=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
			if(Message==true)
			{
					String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
					log.info(systemerror+"Test Scenario Passed");	
			}
				else
			{
					String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
					log.info(systemerror+" Test Scenario Failed");	
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
