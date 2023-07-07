package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.hpsf.Property;

public class InsertingDataToProperty_File {

	public static void main(String[] args) throws Throwable {
		Properties pro=new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url","http://localhost:8888/" );
		pro.setProperty("username","admin");
		pro.setProperty("password","admin");
		
		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/CommonData.properties/");
		pro.store(fout, "Common Data");
		fout.close();
	}

}
