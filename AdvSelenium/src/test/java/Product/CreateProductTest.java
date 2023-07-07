package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import OrganizationPOM.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass {

	@Test(groups="regressionTest")
	public void createProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getStringKeyAndVAlue("browser");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		String URL = flib.getStringKeyAndVAlue("url");
		String USERNAME = flib.getStringKeyAndVAlue("username");
		String PASSWORD = flib.getStringKeyAndVAlue("password");

		/*
		 * FileInputStream fis = new
		 * FileInputStream("src/test/resources/AdvSel.properties"); Properties pro = new
		 * Properties(); pro.load(fis); String URL = pro.getProperty("url"); String
		 * USERNAME = pro.getProperty("username"); String PASSWORD =
		 * pro.getProperty("password");
		 */

		driver.get(URL);
		// driver.manage().window().maximize();
		LoginPage1 login=new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();

		wlib.maximizeScreen(driver);
		wlib.implicitwait(driver);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Products")).click();
		// driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("iphone");
		// Random r = new Random();
		// int data = r.nextInt(1000);

		/*
		 * FileInputStream fis1 = new
		 * FileInputStream("src/test/resources/AaraExcel.xlsx"); Workbook
		 * book=WorkbookFactory.create(fis1); Sheet sh = book.getSheet("Product"); Row
		 * row = sh.getRow(1); Cell cel = row.getCell(1); String ProductData =
		 * cel.getStringCellValue();
		 */

		// WebElement ProdName = driver.findElement(By.name("productname"));
		// ProdName.sendKeys("iphone" + data);

		WebElement data = driver.findElement(By.xpath("//input[@title='Save [Alt+S]'])[1]"));
		WebElement saveButton = driver.findElement(By.xpath("//input[@title='Save [Alt+S]'])[2]"));

		wlib.javaScriptExecutor(driver, saveButton);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView()", saveButton);
		saveButton.click();

		/*
		 * Rectangle val = data.getRect(); System.out.println(val.getX());
		 * System.out.println(val.getY()); JavascriptExecutor js = (JavascriptExecutor)
		 * driver; for (int i = 0; i < 4; i++) {
		 * js.executeScript("window.scrollBY(0,229)"); Thread.sleep(1000); }
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]'])[2]")).click();
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
