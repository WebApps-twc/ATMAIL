package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Account_Settings {
	Logger log=Logger.getLogger("ATMAIL");
	String EmailImage=".//*[@id='display-email-images-label']";
	String folderupdate=".//*[@id='notifications-label']";
	String deletemessages=".//*[@id='delete-trash-label']";
	
	@Test
	public void Charterdetailsdisplayed_as_defaultAccount_Settings_tab(WebDriver chrome)throws InterruptedException, IOException{
	try {
		
			chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
			log.info("Settings");
			Thread.sleep(1000);
			boolean a=chrome.findElement(By.xpath(EmailImage)).isDisplayed();
			boolean b=chrome.findElement(By.xpath(folderupdate)).isDisplayed();
			boolean c=chrome.findElement(By.xpath(deletemessages)).isDisplayed();
			if(a==b==c)
			{
				log.info("Default Setting Loaded: Test Scenario Passed");
			}
			else
			{
				log.info("Default Setting Not Loading: Test Scenario Failed");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
								}

}
	
	
/*	@Test
	public void VerifyForwadingAddressInSettingsPage(WebDriver chrome)throws InterruptedException, IOException{
	try {
		
		chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
		chrome.findElement(By.xpath(".//*[@id='settings-account-button']")).click();
		log.info("Clicked on Accoutn Settings tab");
		Thread.sleep(1000);
		boolean on=chrome.findElement(By.xpath(".//div[@class='toggle-slider-button charter-toggle-switch-on'][@id='enable-forwarding-toggle-slider']")).isDisplayed();
		if(on==true )
		{
			log.info("Default Status of Enable Mail Forwarding:OFF");
			chrome.findElement(By.xpath(".//*[@id='enable-forwarding-toggle-slider']")).click();
			chrome.findElement(By.xpath(".//*[@id='forwarding-address']")).clear();
			chrome.findElement(By.xpath(".//*[@id='forwarding-address']")).sendKeys("34342we34@charter.net");
			chrome.findElement(By.xpath(".//*[@id='put-account-settings']")).click();
			boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
			if(alert==true)
			{
				String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info("Alert message:"+savealert);
				chrome.findElement(By.xpath(".//*[@id='anchor-email']")).click();
				Thread.sleep(1000);
				chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
				chrome.findElement(By.xpath(".//*[@id='settings-account-button']")).click();
				String forward=chrome.findElement(By.xpath(".//*[@id='forwarding-address']")).getText();
				log.info("Forwarded email address:"+forward+"Test Scenario Passed");
				
			}
			else
			{
				log.info("No Alert message");
			}
		}
		else
		{
			log.info("Default Status of Enable Mail Forwarding:On");
			String forward=chrome.findElement(By.xpath(".//*[@id='forwarding-address']")).getText();
			log.info("Forwarded email address:"+forward);
		}
		} catch (Exception e) {

			e.printStackTrace();
	}
}
	@Test
	public void VerifyReplyToAddressFieldInAccountSettingsPage(WebDriver chrome)throws InterruptedException, IOException{
	try {
		chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
		chrome.findElement(By.xpath(".//*[@id='settings-account-button']")).click();
		log.info("Clicked on Accoutn Settings tab");
		Thread.sleep(1000);
		boolean on=chrome.findElement(By.xpath(".//*[@id='account-reply-to-address']")).isDisplayed();
		String reply=chrome.findElement(By.xpath(".//*[@id='account-reply-to-address']")).getText();
		if(on==true && reply=="" )
		{
			chrome.findElement(By.xpath(".//*[@id='account-reply-to-address']")).sendKeys("vomnortel13@charter.net");
			chrome.findElement(By.xpath(".//*[@id='put-account-settings']")).click();
			boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
			if(alert==true)
			{
				String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info("Alert message:"+savealert);
			}
			else
			{

				log.info("Alert message:");
			}
					
		}
		else
		{
			String reply1=chrome.findElement(By.xpath(".//*[@id='account-reply-to-address']")).getText();
			log.info("Reply to Consists the emmail: "+reply1);
		}
			
		} catch (Exception e) {

			e.printStackTrace();
								}

}*/
	@Test
	public void PasswordSettingsAccountettingsUnified_inbox_accounts(WebDriver chrome)throws InterruptedException, IOException{
	try {
		
		chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
		chrome.findElement(By.xpath(".//*[@id='settings-account-button']")).click();
		log.info("Clicked on Accoutn Settings tab");
		Thread.sleep(1000);
		boolean on=chrome.findElement(By.xpath(".//*[@id='settings-menu']/button[4]")).isDisplayed();
		if(on==true )
		{
			chrome.findElement(By.xpath(".//*[@id='settings-menu']/button[4]")).click();
			boolean pwd=chrome.findElement(By.xpath(".//*[@id='account-password']")).isDisplayed();
			if(pwd==true)
			{
				log.info("Password Available for Unified Account");
			}
			else
			{
				log.info("Password unavailable for Unified Account");
			}
		}
		else
		{
			log.info("Password unavailable for Unified Account");
		}
		} catch (Exception e) {

			e.printStackTrace();
	}
}
	
}
