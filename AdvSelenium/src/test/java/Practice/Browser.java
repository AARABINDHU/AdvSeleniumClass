package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	/*	WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();*/

FileInputStream fis = new FileInputStream("src/test/resources/propertyfile.properties");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String Usename = pro.getProperty("username");
String Password = pro.getProperty("password");
driver.get("URL");
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.id("loginButton")).click();

	}

}
