package Product;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductWithWindowScroll {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.findElement(By.linkText("Products")).click();
	//driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("productname")).sendKeys("Bluetooth");
	 WebElement data = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
	Rectangle Val = data.getRect();
	System.out.println(Val.getX());
	System.out.println(Val.getY());
	JavascriptExecutor js = (JavascriptExecutor)driver;
	for(int i=0;i<4;i++)
	{
		js.executeScript("Window.scrollBy(0,229)");
		
	}
	
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}
