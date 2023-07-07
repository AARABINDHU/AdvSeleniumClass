package Oraganization;

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
import OrganizationPOM.HomePage;
import OrganizationPOM.LoginPage;
import OrganizationPOM.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {
   
	@Test(groups= "smokeTest")
	public void createOrganizationTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
//
//		String BROWSER = flib.getStringKeyAndVAlue("browser");
//
//		WebDriver driver;
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}

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
		wlib.maximizeScreen(driver);
		// calling from POM
		LoginPage1 login=new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//driver.findElement(By.id("submitButton")).click();

		// HomePage home=new HomePage(driver);
		// home.OrganizationLink();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		int ranNumber = jlib.getRandomNum();
		/*
		 * Random r=new Random(); // int ranNum = r.nextInt(1000);
		 * 
		 * // FileInputStream fis = new
		 * FileInputStream("src/test/resources/AaraExcel.xlsx" // ); // step2:open
		 * workbook in read mode // Workbook book = WorkbookFactory.create(fis); //
		 * step3:get the control to the sheet // Sheet sh =book.getSheet("sheet1"); //
		 * step4:get the control to the row // Row row = sh.getRow(0); // step5:get the
		 * control to the cell // Cell cel = row.getCell(0); // step6: fetch the data
		 * from the cell
		 */

		String Orgname = elib.getExcelData("Organaization", 2, 1) + ranNumber;
		driver.findElement(By.name("accountname")).sendKeys(Orgname);
		String PhoneNum = elib.getExcelDataUSingDataFormatter("Organaization", 3, 1);
		driver.findElement(By.id("phone")).sendKeys(PhoneNum);
		String Email = elib.getExcelDataUSingDataFormatter("Organaization", 3, 0);
		driver.findElement(By.id("email1")).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	/*	String actData = driver.findElement(By.xpath("//span[]@class='dvHeaderText'")).getText();
		{
			if (actData.contains(Orgname)) {
				System.out.println("pass");
			}
			else{
				System.out.println("fail");
			}
		}*/
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.ActionsMoveToElement(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
