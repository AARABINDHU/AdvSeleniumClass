package OrganizationPOM;

import java.awt.Desktop.Action;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class HomePage {

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLink;

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement OrganizationLink;

	@FindBy(linkText = "Products")
	private WebElement ProductLink;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement Productlink1;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminstrator;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;

	// Getter method
	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getProductlink1() {
		return Productlink1;
	}

	public WebElement getAdminstrator() {
		return Adminstrator;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	// Business Logics
	public void CampaignLink() {
		CampaignLink.click();
	}

	public void OrganizationLink() {
		OrganizationLink.click();

	}

	public void ProductLink() {
		ProductLink.click();
	}

	public void Productlink1() {
		Productlink1.click();
	}

	public  void logout(WebDriver driver) {
		 WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.ActionsMoveToElement(driver, Adminstrator);
		//Actions act = new Action(driver);
		//act.moveToElement(Adminstrator).perform();
		signOut.click();
	}

}
