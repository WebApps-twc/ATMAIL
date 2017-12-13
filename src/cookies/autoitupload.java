package cookies;

import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class autoitupload {
	
	WebDriver chrome;

	@Test
	public void log()throws InterruptedException, IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sobhit.kumar.sharma\\Downloads\\Jars & Drivers\\chromedriver.exe");
		chrome=new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get("file:///C:/Users/sobhit.kumar.sharma/Desktop/upload.html");
		chrome.findElement(By.xpath("//*[@id='1']")).click();
		Runtime.getRuntime().exec("C:\\AutoIT\\upload.exe");
}
}
