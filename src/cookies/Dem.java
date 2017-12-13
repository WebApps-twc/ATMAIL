package cookies;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class Dem {
	@Test
	public void Setup()
	{
		ConfigReader config=new ConfigReader();
		System.setProperty("webdriver.chrome.driver", config.getChromePath());
		ChromeDriver chrome=new ChromeDriver();
		chrome.get(config.getApplicationURl());
	}

}
