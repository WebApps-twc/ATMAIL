package configDemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class TestConfig {
	
	@Test
	public void testconfig() throws Exception
	{
		File src=new File("./Configuration/Config.property");
		FileInputStream fl= new FileInputStream(src);
		Properties prp=new Properties();
		prp.load(fl);
		String chromepath= prp.getProperty("ChromeDriver");
		System.out.println("Hey Path="+chromepath );
	}

}
