package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Compose_Draft {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void formatbody(WebDriver chrome)throws InterruptedException, IOException{
		try{
			
			Thread.sleep(2000);
			chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
			log.info("Compose email");
			chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel14@charter.net");
			log.info("Added Reciptient");
			chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("Format"); 
			log.info("Added subject");
			chrome.switchTo().frame(0);
			chrome.findElement(By.xpath("/html/body")).sendKeys("test"); 
			log.info("Text has been entered in body of the email");
			chrome.findElement(By.xpath("/html/body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			chrome.switchTo().defaultContent();
			chrome.findElement(By.xpath(".//*[@title='Toggle Format Bar']")).click();
			boolean Formatbar=chrome.findElement(By.xpath(".//div[@class='envelope-format-bar unselectable active']")).isDisplayed();
			if(Formatbar==true)
			{
				log.info("Fortmat Bar Available");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button bold']")).click();
				log.info("Selected text changed Bold");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button italic']")).click();
				log.info("Selected text changed Italic");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button underline']")).click();
				log.info("Selected text changed Underline");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Justify']")).click();
				log.info("Selected text checking for Alignment");
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Right']")).click();
				log.info("Selected text moving to Right");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Justify']")).click();
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Center']")).click();
				log.info("Selected text moving to Center");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Justify']")).click();
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Left']")).click();
				log.info("Selected text moving to Left");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button indent'][@title='Indent']")).click();
				log.info("Selected text checking for Indent");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button outdent'][@title='Outdent']")).click();
				log.info("Selected text checking for Outdent");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Font Size']")).click();
				log.info("Selected text changing size");
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Huge']")).click();
				log.info("Selected text changing size to Huge");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Font Size']")).click();
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Large']")).click();
				log.info("Selected text changing size to Large");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Font Size']")).click();
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Normal']")).click();
				log.info("Selected text changing size to Normal");
				chrome.findElement(By.xpath(".//div[@class='button wide'][@title='Font Size']")).click();
				chrome.findElement(By.xpath(".//div[@class='format-button'][@title='Small']")).click();
				log.info("Selected text changing size to Small");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button ordered-list'][@title='Insert Ordered List']")).click();
				log.info("Selected text changing to Number series");
				chrome.findElement(By.xpath(".//div[@class='button-icon format-button unordered-list'][@title='Insert Unordered List']")).click();
				log.info("Selected text changing to Bullet point");
				chrome.findElement(By.xpath(".//div[@class='button-icon dialog-open-button anchor-button'][@title='Create Link']")).click();
				log.info("Selected text changing to Link");
				boolean link=chrome.findElement(By.xpath(".//*[@id='link-url']")).isDisplayed();
				if(link==true)
				{
					chrome.findElement(By.xpath(".//*[@id='link-url']")).sendKeys("www.google.com");
					chrome.findElement(By.xpath("//span[contains(text(),'Create')][@class='ui-button-text']")).click();
					chrome.switchTo().frame(0);
					chrome.findElement(By.xpath("/html/body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
					chrome.switchTo().defaultContent();
					chrome.findElement(By.xpath(".//*[@title='Toggle Format Bar']")).click();
					chrome.findElement(By.xpath(".//*[@class='button-icon format-button remove-format'][@title='Remove Format']")).click();
					log.info("Remove link to plain text");
				}
			}
				else
				{
						log.info("Fortmat Bar Unavailable");
				}
			chrome.findElement(By.xpath(".//div[@class='envelope-send-button'][@title='Send']")).click();
		 	log.info("Clicked on Send");
		 	
		} catch (Exception e) {
		 	log.info("Test scenario Failed:");
		}
		}
	@Test
	public void Fetch_longsubject_AddRep(WebDriver chrome)throws InterruptedException, IOException{
	try{
	log.info("Checking for fetch recipient, Long Sujbect and Add recipiet scenarios");
	Thread.sleep(5000);
	chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
	log.info("Compose email");
	chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("v");
	log.info("Added Reciptient");
	Thread.sleep(1000);
	boolean to=chrome.findElement(By.xpath(".//div[@class='autocomplete-template-div']")).isDisplayed();
	if(to==true)
	{
		chrome.findElement(By.xpath(".//*[@access-next-tabindex='to-autocomplete-1']")).click();
		String rep=chrome.findElement(By.xpath(".//li[@class='auto-email envelope-attr envelope-attr-pill info']")).getText();
		log.info("Rep: "+rep);
		log.info("Adding more than one recipient and long subject");
		chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("c-sobhit.sharma@charter.com");
		chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("ChangedSenderAdrresssssssssssssssssssssssseeeeeeeeeeeeeeeddddddddddddddddddeeeeeeeeeeeeeeesddddddddddddddd"); 
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
		
	}
		else
	{
			log.info("Test Scenario Failed");
	}
 	
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
	@Test
	public void Errormessage_When_Sending_A_Email_Without_Subjectandbody(WebDriver chrome)throws InterruptedException, IOException{
	try{
	log.info("Checking for fetch recipient, Long Sujbect and Add recipiet scenarios");
	Thread.sleep(5000);
	chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
	log.info("Compose email");
	chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel13@charter.net");
	log.info("Added Reciptient");
	chrome.findElement(By.xpath(".//div[@class='envelope-send-button'][@title='Send']")).click();
	Thread.sleep(1000);
	boolean to=chrome.findElement(By.xpath(".//*[@id='subject-dialog']/p")).isDisplayed();
	if(to==true)
	{
		String rep=chrome.findElement(By.xpath(".//*[@id='subject-dialog']/p")).getText();
		log.info("Rep: "+rep);
		chrome.findElement(By.xpath(".//button[@class='ui-button'][@access-tabindex='addsubjectpopup-2']")).click();
		log.info("Test Scenario Pass");
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
		
	}
		else
	{
			log.info("Test Scenario Failed");
	}
 	
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
	@Test
	public void VerifyEmailFunctionalityWhenBodyOfMailContainsSpecialCharacters(WebDriver chrome)throws InterruptedException, IOException{
	try{
		Thread.sleep(2000);
		chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
		log.info("Compose email");
		chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel14@charter.net");
		log.info("Added Reciptient");
		chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("MailContainsSpecialCharacters"); 
		log.info("Added subject");
		chrome.switchTo().frame(0);
		chrome.findElement(By.xpath("/html/body")).sendKeys("!#$%^&*()>?|~\';:</"); 
		log.info("Special characters has been entered in body of the email");
		chrome.findElement(By.xpath("/html/body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
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
	public void VerifyMulitpleSameAttachmentSenderSide(WebDriver chrome)throws InterruptedException, IOException{
	try{
		Thread.sleep(2000);
		chrome.findElement(By.xpath(".//*[@id='compose-mail-button-label']")).click();
		log.info("Compose email");
		chrome.findElement(By.xpath(".//*[@id='envelope-to-input-text']")).sendKeys("vomnortel14@charter.net");
		log.info("Added Reciptient");
		chrome.findElement(By.xpath(".//*[@id='envelope-subject-input-text']")).sendKeys("MulitpleSameAttachmentSenderSide"); 
		log.info("Added subject");
		chrome.switchTo().frame(0);
		chrome.findElement(By.xpath("/html/body")).sendKeys("test"); 
		log.info("text has been entered");
		chrome.switchTo().defaultContent();
		chrome.findElement(By.xpath(".//*[@id='attachment-file-label']")).sendKeys("C:\\vcard.vcf");
		Thread.sleep(1000);
		WebElement upload2 = chrome.findElement(By.xpath(".//*[@id='attachment-file-label']"));
		upload2.sendKeys("C:\\Users\\sobhit.kumar.sharma\\Documents\\Charter\\Automation\\cookies\\Attach\\text.txt");
		Thread.sleep(1000);
		WebElement upload3 = chrome.findElement(By.xpath(".//*[@id='attachment-file-label']"));
		upload3.sendKeys("C:\\Users\\sobhit.kumar.sharma\\Documents\\Charter\\Automation\\cookies\\Attach\\doc.docx");
		Thread.sleep(1000);
		WebElement upload4 = chrome.findElement(By.xpath(".//*[@id='attachment-file-label']"));
		upload4.sendKeys("C:\\Users\\sobhit.kumar.sharma\\Documents\\Charter\\Automation\\cookies\\Attach\\pdf.pdf");
		Thread.sleep(1000);
		WebElement upload5 = chrome.findElement(By.xpath(".//*[@id='attachment-file-label']"));
		upload5.sendKeys("C:\\Users\\sobhit.kumar.sharma\\Documents\\Charter\\Automation\\cookies\\Attach\\pic.png");
		Thread.sleep(1000);
		WebElement upload6 = chrome.findElement(By.xpath(".//*[@id='attachment-file-label']"));
		upload6.sendKeys("C:\\Users\\sobhit.kumar.sharma\\Documents\\Charter\\Automation\\cookies\\Attach\\spreed.xlsx");
		String BeforeSentAttachmentCount= chrome.findElement(By.xpath(".//*[@id='attachment-file-label']")).getText();
		log.info("Number of Attachmenets:"+BeforeSentAttachmentCount);
		chrome.findElement(By.xpath(".//div[@class='envelope-send-button'][@title='Send']")).click();
	 	log.info("Clicked on Send");
	 	boolean error=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(error==true)
		{
				String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(systemerror);
				chrome.findElement(By.xpath(".//*[@id='imap-folder-button-sent']")).click();
				chrome.findElement(By.xpath(".//*[@id='c15864']/td[3]/div")).click();
				String AfterSentAttachmentCount= chrome.findElement(By.xpath(".//*[@id='message-display-attachments']")).getText();
				log.info("Number of Attachmenets after send are:"+AfterSentAttachmentCount);
				if(BeforeSentAttachmentCount==AfterSentAttachmentCount)
				{
					log.info("Number of Attachments matching with Sent Mail");
				}
				else
				{
					log.info("Number of Attachments Not matching with Sent Mail");
				}
				
		}
			else
		{
				String systemerror= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(systemerror);
		}
	} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}
}
