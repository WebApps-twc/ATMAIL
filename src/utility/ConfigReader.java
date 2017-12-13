package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	

	Properties prp;
	public ConfigReader()
	{
		try {
				File src=new File("./Configuration/PumaConfig.property");
				FileInputStream fl= new FileInputStream(src);
				prp=new Properties();
				prp.load(fl);
			} 
		catch (Exception e) 
		{
				System.out.println(e.getMessage());
		}
	
	}
	public String getChromePath()
	{
		String path=prp.getProperty("ChromeDriver");
		return path;
	}
	
	public String getApplicationURl()
	{
		 return prp.getProperty("URL");
	}
	
}