package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import OrganizationPOM.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuite() {
		System.out.println("DataBase Connecton");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void beforeTest() {
		System.out.println("Parallel Execution");
	}

	public WebDriver driver;
//	@Parameters("Browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void beforeClass() throws Throwable {
		File_Utility flib = new File_Utility();

     String BROWSER = flib.getStringKeyAndVAlue("browser");
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
		System.out.println("Launching Browser");
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void beforeMethod() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();

		wlib.implicitwait(driver);
		String URL = flib.getStringKeyAndVAlue("url");
		String USERNAME = flib.getStringKeyAndVAlue("username");
		String PASSWORD = flib.getStringKeyAndVAlue("password");
		driver.get(URL);
		wlib.maximizeScreen(driver);

		// calling from POM
		LoginPage1 login = new LoginPage1(driver);
		login.loginToApp(USERNAME, PASSWORD);

		System.out.println("Login the Application");

	}

	@AfterMethod(groups = { "smokeTest", "regessionTest" })
	public void afterMethod() {
		System.out.println("Logout the Application");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void afterClass() {
		System.out.println("Close the Browser");

	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void afterTest() {
		System.out.println("Parallel Execution done");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		System.out.println("DataBase Close");
	}

}
