package Campaign;
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
import OrganizationPOM.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createCampaignTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
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

		wlib.implicitwait(driver);
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver=new ChromeDriver();

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
		LoginPage1 login = new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);

		// driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();

		HomePage home = new HomePage(driver);
		home.CampaignLink();

		// driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		int ranNumber = jlib.getRandomNum();
		// Random ran=new Random();
		// int ranNum = ran.nextInt(1000);

		/*
		 * FileInputStream fis1 = new
		 * FileInputStream("src/test/resources/AaraExcel.xlsx"); Workbook book =
		 * WorkbookFactory.create(fis1); Sheet sh = book.getSheet("Campaign"); Row row =
		 * sh.getRow(1); Cell cel = row.getCell(1); String OrgName =
		 * cel.getStringCellValue() + ranNum;
		 */
		Thread.sleep(2000);
		String campData = elib.getExcelData("Campaign", 1, 1) + ranNumber;
		driver.findElement(By.name("campaignname")).sendKeys(campData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.ActionsMoveToElement(driver, ele);

		driver.findElement(By.linkText("Sign Out")).click();

	}

}
