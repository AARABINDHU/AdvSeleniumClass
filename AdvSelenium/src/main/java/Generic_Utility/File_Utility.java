package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class File_Utility {

	public String getStringKeyAndVAlue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("src/test/resources/AdvSel.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
}
