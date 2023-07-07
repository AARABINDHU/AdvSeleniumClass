package Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx1 {
	@Test(dataProvider = "getdata")
	public void m1(String orgName, String phonenum, String emailId) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phonenum);
		driver.findElement(By.id("email1")).sendKeys("emailId");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

	}

	@DataProvider
	public Object[][] getdata() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		Object[][] obj = new Object[3][3];
		obj[0][0] = "Aara";
		obj[0][1] = "4578912441";
		obj[0][2] = "abc@gmail.com";

		obj[1][0] = "Faizu";
		obj[1][1] = "464795741255";
		obj[1][2] = "efg@gmail.com";

		obj[2][0] = "Aarief";
		obj[2][1] = "258944854145";
		obj[2][2] = "mnb@gmail.com";
		return obj;

	}
}
