package cookies;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Authentication {
WebDriver chrome;

	
	@Test
	public void capture()throws InterruptedException, IOException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sobhit.kumar.sharma\\Downloads\\Jars & Drivers\\chromedriver.exe");
		chrome=new ChromeDriver();
		chrome.get("http://charternet:Chart3rn3t@engprod-spectrum.net");
		chrome.manage().window().maximize();
		chrome.findElement(By.xpath(".//*[@id='page-header']/div/div/div/div[1]/ul/li[1]/a")).click();
		/*CaptureCookies P=new CaptureCookies();
		P.capture(chrome);
		P.Savecapture(chrome);*/
		Thread.sleep(1000);
		chrome.findElement(By.xpath(".//*[@id='cc-username']")).sendKeys("vomnortel14");
		chrome.findElement(By.xpath(".//*[@id='cc-user-password']")).sendKeys("Testing01");
		
		chrome.findElement(By.xpath(".//*[@id='login-form-button']")).click();
		


	}
}
