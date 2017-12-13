package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.*;

import java.util.Set;

import org.testng.annotations.Test;

public class CaptureCookies {
	WebDriver chrome;

	
	@Test
	public void capture(WebDriver chrome)throws InterruptedException, IOException{

		Set <Cookie> cookies=chrome.manage().getCookies();		
		for(Cookie cookie:cookies)
		{
			System.out.println("Cookies as follows:"+cookie.getName()+":"+cookie.getValue());
		}
		System.out.println("Size of the cookies: "+cookies.size());
	}
	@Test
	public void Savecapture(WebDriver chrome)throws InterruptedException, IOException{

		Path cookiesFile = Paths.get("C:\\Temp\\cookies.txt");

		// save the cookies to a file for the current domain
		try (PrintWriter file = new PrintWriter(cookiesFile.toFile(), "UTF-8")) {
		    for (Cookie c : chrome.manage().getCookies()) {
		        file.println(c.toString());
		    }
		}
	}
	

}
