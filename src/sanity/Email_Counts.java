package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Email_Counts {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void UnreadEmailNotificationCounter(WebDriver chrome)throws InterruptedException, IOException{
	try{
	
	Thread.sleep(2000);
	String count= chrome.findElement(By.xpath(".//span[@id='unread-inbox']")).getText();
	log.info("Unread email count is: "+count);
	log.info("Test Scenario Passed");
} catch (Exception e) {
 	log.info("Test scenario Failed");
}
}

}
