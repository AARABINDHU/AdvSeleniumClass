package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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

public class CreateProductAndDeleteProduct {

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
		wlib.implicitwait(driver);
		//driver.manage().window().maximize();
		LoginPage1 login=new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		int ranNumber = jlib.getRandomNum();
		// Random r = new Random();
		// int ranNum = r.nextInt(1000);
		/*
		 * FileInputStream fis1 = new
		 * FileInputStream("src/test/resources/AaraExcel.xlsx"); Workbook book =
		 * WorkbookFactory.create(fis1); Sheet sh = book.getSheet("Product"); Row row =
		 * sh.getRow(1); Cell cel = row.getCell(1); String ProductData =
		 * cel.getStringCellValue() + ranNumber;
		 */
		 String ProductData = elib.getExcelData("Product", 1, 1)+ranNumber;

		driver.findElement(By.linkText("Products")).sendKeys(ProductData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='" + ProductData
				+ "']/../preceding-sibling::td/input")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wlib.Alertaccept(driver);
		// Alert alt = driver.switchTo().alert();
		// alt.accept();

		List<WebElement> productlist = driver
				.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td[3])[]position()>1"));

		boolean flag = false;
		for (WebElement prdName : productlist) {
			String actData = prdName.getText();
			if (actData.contains("productData")) {
				flag = true;
				break;
			}

		}
		if (flag) {
			System.out.println("product data is deleted");
		} 
		else {
			System.out.println("product data is not deleted");
		}

	}

}
