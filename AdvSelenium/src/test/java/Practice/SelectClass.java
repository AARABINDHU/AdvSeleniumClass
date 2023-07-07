package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		Thread.sleep(1000);
		WebElement dateList = driver.findElement(By.id("day"));
		Select sel = new Select(dateList);
		sel.selectByIndex(5);

		WebElement monthList = driver.findElement(By.id("month"));
		Select sel1 = new Select(monthList);
		sel1.selectByIndex(2);
		Thread.sleep(2000);
		WebElement yearList = driver.findElement(By.id("year"));
		Select sel2 = new Select(yearList);
		sel2.selectByIndex(5);

	}

}
