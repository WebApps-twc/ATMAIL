package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AllContacts {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void Reply_main_nav(WebDriver chrome)throws InterruptedException, IOException{
	try {
				chrome.findElement(By.xpath(".//*[@id='tab-contacts']")).click();
				log.info("Email has been selected");
				Thread.sleep(1000);
				boolean contacts=chrome.findElement(By.xpath(".//*[@role='checkbox']")).isDisplayed();
			 if(contacts==true)
			 {
				 log.info("All contacts available: Test Scenaio Passed");
			 }
			 else
			 {
				 log.info("Test Scenario Failed: Error Occured ");
			 }

	} catch (Exception e) {

		e.printStackTrace();
	}

}
}
