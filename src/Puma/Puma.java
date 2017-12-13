package Puma;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class Puma {
	@Test
	public void puma(){	
	ConfigReader config=new ConfigReader();
	System.setProperty("webdriver.chrome.driver", config.getChromePath());
	ChromeDriver chrome=new ChromeDriver();
	chrome.get(config.getApplicationURl());
	String actualString = chrome.getTitle(); 
	Assert.assertTrue(actualString.contains("in.puma.com"));
	
		WebElement menu = chrome.findElement(By.xpath(".//*[@id='header-nav']/ul/li[1]/a"));

		//Initiate mouse action using Actions class
		Actions builder = new Actions(chrome);    

		// move the mouse to the earlier identified menu option
		builder.moveToElement(menu).build().perform();

		// wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
		WebDriverWait wait = new WebDriverWait(chrome, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='men-subnav']/div/div/div[2]/ul/li[2]/a")));  // until this submenu is found

		//identify menu option from the resulting menu display and click
		WebElement menuOption = chrome.findElement(By.xpath(".//*[@id='men-subnav']/div/div/div[2]/ul/li[2]/a"));
		menuOption.click();
		String secondshoe= chrome.findElement(By.xpath(".//*[@id='mp-pusher']/div/div[4]/div[2]/div[2]/div[2]/div/ul/li[2]/div[2]/h2/a")).getText();
		chrome.findElement(By.xpath(".//*[@id='mp-pusher']/div/div[4]/div[2]/div[2]/div[2]/div/ul/li[2]/div[2]/h2/a")).click();
		Select dropdown = new Select(chrome.findElement(By.id("size_label")));
		dropdown.selectByVisibleText("7");
	}
}
