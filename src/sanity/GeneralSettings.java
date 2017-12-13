package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GeneralSettings {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void GenSetting(WebDriver chrome)throws InterruptedException, IOException{
	try{
	Thread.sleep(2000);
	chrome.findElement(By.xpath(".//*[@id='tab-settings']")).click();
	log.info("Clicked on Settings tab");
	Thread.sleep(1000);
	boolean on=chrome.findElement(By.xpath(".//*[@class='toggle-slider-button charter-toggle-switch-on'][@id='display-email-images-toggle-slider']")).isDisplayed();
	if(on==true )
	{
		log.info("Default Status of Display email Images:ON");
		chrome.findElement(By.xpath(".//*[@id='display-email-images-toggle-slider']")).click();
		chrome.findElement(By.xpath(".//*[@id='save-settings']")).click();
		boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
		if(alert==true)
		{
			String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
			log.info("Alert message:"+savealert);
		}
		else
		{
			log.info("No Alert message");
		}
	}
} catch (Exception e) {

	log.info("Default Status of Display email Images:OFF");
	chrome.findElement(By.xpath(".//*[@id='display-email-images-toggle-slider']")).click();
	chrome.findElement(By.xpath(".//*[@id='save-settings']")).click();
	boolean alert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
	if(alert==true)
	{
		String savealert=chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
		log.info("Alert message:"+savealert+"to On");
	}
	else
	{
		log.info("No Alert message");
	}
}
}

}
