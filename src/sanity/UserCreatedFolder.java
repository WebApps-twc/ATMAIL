package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UserCreatedFolder {
	Logger log=Logger.getLogger("ATMAIL");
	@Test(priority=1)
	public void CreationFolderSent(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='create-folder-label']")).click();
			log.info("Create new folder");
			chrome.findElement(By.xpath(".//*[@id='imap-folder-name-control'] [@title='New Folder Name']")).sendKeys("Sent");
			log.info("Folder name entered");
			chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[2]/button[2]")).click();
			log.info("Click on Create");
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
		
			e.printStackTrace();
		}
	}

	/*@Test(priority=2)
	public void CreatefolderSpecialCharac(WebDriver chrome)throws InterruptedException, IOException{
		chrome.findElement(By.xpath(".//*[@id='create-folder-label']")).click();
		log.info("Create new folder");
		chrome.findElement(By.xpath(".//*[@id='imap-folder-name-control'] [@title='New Folder Name']")).sendKeys("!Y#$%^");
		log.info("Folder name entered");
		chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[2]/button[2]")).click();
		log.info("Click on Create");
		boolean Message=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(Message==true)
		{
			String msg= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			
		}
	}*/
	@Test(priority=2)
	public void Exisitingfolder(WebDriver chrome)throws InterruptedException, IOException{
		try {
			String msg= chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[3]")).getText();
			log.info("Already created folder name is "+ msg);
			chrome.findElement(By.xpath(".//*[@id='create-folder-label']")).click();
			log.info("Create existing folder");
			chrome.findElement(By.xpath(".//*[@id='imap-folder-name-control'] [@title='New Folder Name']")).sendKeys(msg);
			log.info("Folder name entered");
			chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[2]/button[2]")).click();
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
	@Test(priority=3)
	public void Exisitingparentfolder(WebDriver chrome)throws InterruptedException, IOException{
	try {
		chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[6]")).click();
		String msg= chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[3]")).getText();
		log.info("Already created folder name is "+ msg);
		chrome.findElement(By.xpath(".//*[@id='create-folder-label']")).click();
		log.info("Creating child folder");
		chrome.findElement(By.xpath(".//*[@id='imap-folder-name-control'] [@title='New Folder Name']")).sendKeys(msg);
		log.info("Folder name entered");
		chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[6]/button[2]")).click();
		log.info("Click on Create");
		boolean Message=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(Message==false)
		{
				String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(systemerror+"Test Scenario Failed");	
		}
			else
		{
				log.info("Test Scenario Passed: Folder has been created ");	
		}
	} catch (Exception e) {

		e.printStackTrace();
	}

}
}
