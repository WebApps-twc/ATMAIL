package sanity;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ImportExport {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void ImportExportAll(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='tab-contacts']")).click();
	
	chrome.findElement(By.xpath(".//*[@id='more-contacts-dropdown-button']/i[2]")).click();  
	chrome.findElement(By.xpath(".//*[@id='more-contacts-import']")).click();  
	log.info("Clicked on Import");
	WebElement upload = chrome.findElement(By.xpath(".//*[@id='vcard-file']"));
	upload.sendKeys("C:\\vcard.vcf");
	chrome.findElement(By.xpath("html/body/div[5]/div[11]/div/button[1]")).click();
		boolean contactalreadyadded=chrome.findElement(By.xpath("/html/body/div[3]")).isDisplayed();
		if(contactalreadyadded==true)
		{
			log.info("We noticed that there are duplicate contacts while importing.");
		}
		else
		{
			String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info("Alert message"+savealert);
		}
} catch (Exception e) {

}
}
	@Test
	public void ExportAll(WebDriver chrome)throws InterruptedException, IOException{
	try{
		Thread.sleep(2000);
		chrome.findElement(By.xpath(".//*[@id='tab-contacts']")).click();
		log.info("Contacts loading");
		Thread.sleep(4000);
		boolean contactcheck=chrome.findElement(By.xpath(".//*[@id='contact-checkbox-c381']")).isDisplayed();
		if(contactcheck==true)
		{
			chrome.findElement(By.xpath(".//*[@id='contact-list-checkbox-toggle']")).click();
			boolean selectedcontact=chrome.findElement(By.xpath(".//*[@id='contact-list-checkbox-toggle']")).isSelected();
			if(selectedcontact==true)
			{
				log.info("Contacts has been selected");
				chrome.findElement(By.xpath(".//*[@id='more-contacts-dropdown-button']/i[2]")).click();
				log.info("Clicked on More menu item");
				chrome.findElement(By.xpath(".//*[@access-tabindex='morecontacts-0']")).click();  
				log.info("Clicked Export Selected Contacts");
				boolean Error= chrome.findElement(By.xpath("html/body/center[1]/h1")).isDisplayed();
					if(Error==true)
					{
						String Er=chrome.findElement(By.xpath("html/body/center[1]/h1")).getText();
						log.info("Error Ocurred:" +Er);
					}
					else
					{
						boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
						if(alert==true)
						{
							String al=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
							log.info("Alert Occured:" +al);
						}
				else
					{
						log.info("Error Occured in exporting contacts");
					}
				
					}
			}
		else
		{
			String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info("Alert message"+savealert);
		}
		}
	}
		
 catch (Exception e) {
	 log.info("Test Scenario Failed");
}

	}
}
