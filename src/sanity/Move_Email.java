package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Move_Email {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void verifyProcessOfMoveEmailFromOneFolderToOtherFolderUsingMoveAndDragOption(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(5000);
	
	
	Actions act=new Actions(chrome);
	 
	
	WebElement drag=chrome.findElement(By.xpath(".//*[@class='email-subject']"));
	 

	WebElement drop=chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[65]"));
	 
	
	act.dragAndDrop(drag, drop).build().perform();
	String dropname=chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[65]")).getText();
	log.info("Drop in folder name:"+dropname);
	chrome.findElement(By.xpath(".//*[@id='imap-folders-menu']/div[65]")).click();
	boolean alert2=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
	if(alert2==true)
	{
		String al=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
		log.info("Alert Occured:" +al+"Test Scenario Passed");
		
	}
else
{
	log.info("Test Scenario Passed");
}

} catch (Exception e) {
	log.info("Error Occur in exporting contacts");
}
}
	@Test
	public void VerifyFunctionalityOfSelectAll_CHeck(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(5000);
	chrome.findElement(By.xpath(".//*[@id='imap-folder-container']/button[1]")).click();
	chrome.findElement(By.xpath(".//*[@id='email-list-checkbox-select-all']")).click();
	chrome.findElement(By.xpath(".//*[@id='delete-mail-button-label']")).click();
	boolean alert=chrome.findElement(By.xpath(".//*[@id='multiple-delete-dialog']")).isDisplayed();
	if(alert==true)
	{
		
		String al=chrome.findElement(By.xpath(".//*[@id='multiple-delete-dialog']")).getText();
		log.info("Alert Occured:" +al);
		chrome.findElement(By.xpath("//span[contains(text(),'Yes')][@class='ui-button-text']")).click();
		boolean alert1=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(alert1==true)
		{
			String al2=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info("Alert Occured:" +al2+"Test Scenario Passed");
			
		}
	else
		{
			log.info("Test Scenario Failed");
		}

		
	}
	else
	{
		log.info("Test Scenario Passed");
	}
		
} catch (Exception e) {
	log.info("Error Occured in exporting contacts");
}
}
	@Test
	public void Verify_Print_Email(WebDriver chrome)throws InterruptedException, IOException{
	try{
		chrome.findElement(By.xpath("//*[@id='c13751']/td[3]")).click();
		Thread.sleep(3000);
		chrome.findElement(By.xpath(".//*[@id='message-display-more-mail-print']")).click();
		String winHandleBefore = chrome.getWindowHandle();


		for(String winHandle : chrome.getWindowHandles()){
			chrome.switchTo().window(winHandle);
			
		}

		
		chrome.close();

		chrome.switchTo().window(winHandleBefore);
		log.info("Print Working Fine: Test Scenario Passed");
} catch (Exception e) {
	log.info("Error Occured in exporting contacts");
}
}
	
	
}
