package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Delete_Email {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void ProcessOfDeletingAnEmail(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
	log.info(" Mails has beeen selected");
	chrome.findElement(By.xpath(".//*[@id='delete-mail-button-label']")).click();
	log.info(" Delete button has been clicked by Main Navigation");
	boolean popup=chrome.findElement(By.xpath("html/body/div[4]/div[3]/div/button[2]")).isDisplayed();
	if(popup==true)
	{
		log.info("Pop up model available");
		chrome.findElement(By.xpath("html/body/div[4]/div[3]/div/button[2]")).click();
		Thread.sleep(1000);
		boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(alert==true)
		{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Passed");
		}
		else
		{
			log.info("No alert message");
		}
		
	}
	else
	{
		log.info("Pop up model unavailable");
	}
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
	@Test
	public void FolderDeleteFunctionality(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	String folder=chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[68]")).getText();
	chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[68]/div[4]")).click();
	log.info(folder+"Folder Has been selected");
	chrome.findElement(By.xpath(".//*[@id='delete-folder-menuitem-70']")).click();
	log.info(" Deleting the"+folder);
	try{
		   //Wait 10 seconds till alert is present
		   WebDriverWait wait = new WebDriverWait(chrome, 10);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		   //Accepting alert.
		   alert.accept();
		   log.info("Accepted the alert successfully.");
		}catch(Throwable e){
		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}
	Thread.sleep(1000);
	boolean error=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
	if(error==true)
	{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Passed");
	}
		else
	{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Failed");
	}
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
	
}
