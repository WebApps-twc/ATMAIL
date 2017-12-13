package sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.GenerateData;

public class AddContact {
	Logger log=Logger.getLogger("ATMAIL");
	@Test
	public void AddContct(WebDriver chrome)throws InterruptedException, IOException{
		try {
			for(int i=0;i<5;i++)
			{
			GenerateData Cha=new GenerateData();
			chrome.findElement(By.xpath(".//*[@id='anchor-contacts']")).click();
			log.info("Click on Contact");
			chrome.findElement(By.xpath(".//*[@id='add-contact-button']")).click();
			log.info("Click on Add Contact");
			chrome.findElement(By.xpath(".//*[@id='firstName']")).sendKeys(Cha.Generate());
			log.info("Enter FirstName");
			chrome.findElement(By.xpath(".//*[@id='lastName']")).sendKeys(Cha.Generate());
			log.info("Enter LastName");
			chrome.findElement(By.xpath(".//*[@id='contact-UserEmail-ctrl']")).sendKeys(Cha.Generate()+"@"+Cha.Generate()+".com");
			log.info("Enter Email");
			chrome.findElement(By.xpath(".//*[@id='UserHomePhone']")).sendKeys(Cha.Mob());
			log.info("Enter HomePhone");
			chrome.findElement(By.xpath(".//*[@id='homeAddress']")).sendKeys(Cha.Generate()+"Street");
			log.info("Enter Street");
			chrome.findElement(By.xpath(".//*[@id='homeCity']")).sendKeys(Cha.Generate());
			log.info("Enter City");
			chrome.findElement(By.xpath(".//*[@id='homeState']")).sendKeys(Cha.Generate());
			log.info("Enter State");
			chrome.findElement(By.xpath(".//*[@id='homeZipCode']")).sendKeys(Cha.Zip());
			log.info("Enter ZipCode");
			chrome.findElement(By.xpath(".//*[@id='homeCountry']")).sendKeys(Cha.Generate());
			log.info("Enter FirstName");
			chrome.findElement(By.xpath(".//*[@id='save-contact-button']")).click();
			log.info("Click Save");
			boolean msg=chrome.findElement(By.xpath(".//*[@id='system-alert']")).isDisplayed();
			if(msg==true)
				{
				String system= chrome.findElement(By.xpath(".//*[@id='system-alert']")).getText();
				log.info(system+"Test Scenario Passed");	
					
				}
				else
				{
					log.info("Test Scenario Failed");
					boolean systemerr= chrome.findElement(By.xpath(".//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']")).isDisplayed();
					if(systemerr==true)
					{
						chrome.findElement(By.xpath(".//*[@id='contacts-directory']/div[3]/div[3]/div/button[1]")).click();
						log.info("Dont Save the changes");
						
					}
					else
					{
						log.info("No Pop up message.");
					}
					
				}
			}
			
			} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
