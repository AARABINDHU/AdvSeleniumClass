package Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUp {

	public static void main(String[] args) {
		
  WebDriverManager.chromedriver().setup();
  WebDriver driver=new ChromeDriver();

  driver.get("https://www.goibibo.com/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  driver.findElement(By.xpath("//span[@role='presentation']")).click();
  driver.findElement(By.xpath("//span[text()='Departure']")).click();


	}

}
