package sanity;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;




public class Sent_Email {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void ChangedSenderAddress(WebDriver chrome)throws InterruptedException, IOException{
	try{
	
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
	log.info("Compose email");
	chrome.findElement(By.xpath(".//*[@id='from-account-selection']/i")).click();
	log.info("Account selecting from dropdown");
	chrome.findElement(By.xpath(".//*[@id='from-account-selection']/div/div[2]")).click();
	log.info("Account has been selected");
	chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel14@charter.net");
	log.info("Added Reciptient");
	chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("ChangedSenderAdrress"); 
	log.info("Added subject");
	chrome.switchTo().frame(0);
	chrome.findElement(By.xpath("/html/body")).sendKeys("test"); 
	log.info("Text has been entered in body of the email");
	chrome.switchTo().defaultContent();
	chrome.findElement(By.xpath(".//div[@class='envelope-send-button'][@title='Send']")).click();
 	log.info("Clicked on Send");
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
	@Test
	public void CCAndBCCWhileComposing(WebDriver chrome)throws InterruptedException, IOException{
	try{
	
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
	log.info("Compose email");
	chrome.findElement(By.xpath(".//*[@id='envelope-header']/div[1]/div[1]/span[1]")).click();
	log.info("Adding CC");
	chrome.findElement(By.xpath(".//*[@id='envelope-header']/div[1]/div[1]/span[2]")).click();
	log.info("Adding BCC");
	chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel14@charter.net");
	chrome.findElement(By.xpath(".//*[@id='envelope-cc-input-text']")).sendKeys("34342we34@charter.net");
	chrome.findElement(By.xpath(".//*[@id='envelope-bcc-input-text']")).sendKeys("c-sobhit.sharma@charter.com");
	log.info("Added Reciptients");
	chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("verifyAbilityOfCCAndBCCWhileComposingMail"); 
	log.info("Added subject");
	chrome.switchTo().frame(0);
	chrome.findElement(By.xpath("/html/body")).sendKeys("test"); 
	log.info("Text has been entered in body of the email");
	chrome.switchTo().defaultContent();
	chrome.findElement(By.xpath(".//div[@class='envelope-send-button'][@title='Send']")).click();
 	log.info("Clicked on Send");
 	boolean error=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
	if(error==true)
	{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Passed");
	}
		else
	{
			String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info(systemerror+"Test Scenario Passed");
	}
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}

}
