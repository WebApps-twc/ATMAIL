package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Create_link {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void link(WebDriver chrome)throws InterruptedException, IOException{
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
		else
			{
			log.info("Link not created:");
			}

}
}
}
