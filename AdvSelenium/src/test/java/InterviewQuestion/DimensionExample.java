package InterviewQuestion;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DimensionExample {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Dimension di=new Dimension(500, 600);
		driver.manage().window().setSize(di);
		
		Point point=new Point(300, 400);
		driver.manage().window().setPosition(point);
		
		

}
}