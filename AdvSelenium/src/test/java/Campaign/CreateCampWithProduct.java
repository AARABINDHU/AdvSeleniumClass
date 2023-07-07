package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import OrganizationPOM.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct {

	public static void main(String[] args) throws Throwable {
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
		wlib.implicitwait(driver);
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
		LoginPage1 login = new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);

		// driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		int ranNumber = jlib.getRandomNum();
		/*
		 * Random r = new Random(); // int data = r.nextInt(1000);
		 * 
		 * // Step1: Set the Path FileInputStream fis = new
		 * FileInputStream("src/test/resources/AaraExcel.xlsx");
		 * 
		 * // Step2:open workbook in read mode Workbook book =
		 * WorkbookFactory.create(fis);
		 * 
		 * // Step3: get the control to the sheet Sheet sh = book.getSheet("Product");
		 * 
		 * // Step4:get the control on the Row Row row = sh.getRow(1);
		 * 
		 * // Step5: get the control on the cell Cell cel = row.getCell(1);
		 * 
		 * // Step6:Fetch the data from the cell String ProductData =
		 * cel.getStringCellValue() + ranNumber;
		 */

		String campData = elib.getExcelDataUSingDataFormatter("Campaign", 1, 1) + ranNumber;
		driver.findElement(By.name("campData"));

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("Aara" + ranNumber);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		wlib.switchWindow(driver, "Products&action");
		/*
		 * Set<String> allwindows = driver.getWindowHandles(); Iterator<String> id =
		 * allwindows.iterator(); while (id.hasNext()) { String win = id.next();
		 * driver.switchTo().window(win); String title = driver.getTitle();
		 * 
		 * if (title.contains("Products&action")) {
		 * 
		 * break; } }
		 */
		driver.findElement(By.name("search_text")).sendKeys("ProductData");
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='" + ProductData + "']")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
