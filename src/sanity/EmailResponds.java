package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EmailResponds {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void Reply_main_nav(WebDriver chrome)throws InterruptedException, IOException{
	try {
		Thread.sleep(2000);
		boolean email=chrome.findElement(By.xpath(".//*[@role='checkbox']")).isDisplayed();
		if(email==true)
		{
				chrome.findElement(By.xpath(".//*[@role='checkbox']")).click();
				log.info("Email has been selected");
				chrome.findElement(By.xpath(".//*[@id='reply-mail-button-label']")).click();
				log.info("Reply email clicked from main navigation");
			 boolean recipient=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).isDisplayed();
			 if(recipient==true)
			 {
				 String to=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).getText();
				 
				 chrome.findElement(By.xpath(".//*[@role='button'][@title='Close']")).click();
				 log.info("Closed reply email model");
				 chrome.findElement(By.xpath("html/body/div[3]/div[3]/div/button[2]")).click();
				 log.info("Delete the email");
				 log.info(to+"Test Scenaio Passed");
			 }
			 else
			 {
				 log.info("Error Occured");
			 }
		}
			else
		{
				log.info("Test Scenario Failed: Error Occured ");	
		}
	} catch (Exception e) {

		e.printStackTrace();
	}

}
	@Test
	public void ReplyAll_main_nav(WebDriver chrome)throws InterruptedException, IOException{
	try {
		Thread.sleep(2000);
		boolean email=chrome.findElement(By.xpath(".//*[@role='checkbox']")).isDisplayed();
		if(email==true)
		{
				chrome.findElement(By.xpath(".//*[@role='checkbox']")).click();
				log.info("Email has been selected");
				chrome.findElement(By.xpath(".//*[@id='reply-all-mail-button-label']")).click();
				log.info("ReplyALL email clicked from main navigation");
				Thread.sleep(1000);
			 boolean recipient=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).isDisplayed();
			 if(recipient==true)
			 {
				 String to=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).getText();
				
				 chrome.findElement(By.xpath(".//*[@role='button'][@title='Close']")).click();
				 log.info("Closed reply email model");
				 chrome.findElement(By.xpath("html/body/div[3]/div[3]/div/button[2]")).click();
				 log.info("Delete the email");
				 log.info(to+"Test Scenaio Passed");
			 }
			 else
			 {
				 log.info("Error Occured");
			 }
		}
			else
		{
				log.info("Test Scenario Failed: Error Occured ");	
		}
	} catch (Exception e) {

		e.printStackTrace();
	}

}
	@Test
	public void forward_main_nav(WebDriver chrome)throws InterruptedException, IOException{
	try {
		Thread.sleep(2000);
		boolean email=chrome.findElement(By.xpath(".//*[@role='checkbox']")).isDisplayed();
		if(email==true)
		{
				chrome.findElement(By.xpath(".//*[@role='checkbox']")).click();
				log.info("Email has been selected");
				chrome.findElement(By.xpath(".//*[@id='reply-all-mail-button-label']")).click();
				log.info("Forward email clicked from main navigation");
				Thread.sleep(1000);
			 boolean recipient=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).isDisplayed();
			 if(recipient==true)
			 {
				 String to=chrome.findElement(By.xpath(".//*[@id='envelope-header']")).getText();
				 
				 chrome.findElement(By.xpath(".//*[@role='button'][@title='Close']")).click();
				 log.info("Closed reply email model");
				 chrome.findElement(By.xpath("html/body/div[3]/div[3]/div/button[2]")).click();
				 log.info("Delete the email");
				 log.info(to+"Test Scenaio Passed");
			 }
			 else
			 {
				 log.info("Error Occured");
			 }
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
