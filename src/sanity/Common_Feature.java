package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Common_Feature {
	Logger log=Logger.getLogger("ATMAIL");
	@Test(priority=1)
	public void CommonFeature1(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='nav-container']/a/img")).click();
			
			boolean homepage=chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[2]/nav/div[2]")).isDisplayed();
			if(homepage==true)
			{
					log.info("Homepage Loaded: Test Scenario Passed");
			}
				else
			{
					log.info(" Test Scenario Failed");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void CommonFeature2(WebDriver chrome)throws InterruptedException, IOException{
		try {
			chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[3]/div/div/a/span")).click();
			Thread.sleep(3000);
			boolean signout=chrome.findElement(By.xpath(".//*[@id='signout-link']")).isDisplayed();
			if(signout==true)
			{
				chrome.findElement(By.xpath(".//*[@id='signout-link']")).click();
				log.info("Logging out");
				boolean checklogout=chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[1]/a")).isDisplayed();
				if(checklogout==true)
				{
					log.info("Logout Successful: Test Scenario Passed");
				}
				else
				{
					log.info("Logout Failed: Test Scenario Failed");
				}
				
			}
			else
			{
				log.info("Signout not available");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
}