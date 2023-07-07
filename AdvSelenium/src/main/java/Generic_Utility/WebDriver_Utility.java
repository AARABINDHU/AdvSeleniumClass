package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public void minimizeScreen(WebDriver driver) {
		driver.manage().window().minimize();

	}

	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void switchWindow(WebDriver driver, String PartialText) {
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();

			if (title.contains(PartialText)) {
				break;
			}

		}

	}

	public void ActionsMoveToElement(WebDriver driver, WebElement ele) {
		{
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();

		}
	}

	public void javaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void Alertaccept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}


	public void AlertDismiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
}

