package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	// initialization
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement clickPlusImg;

	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(id = "phone")
	private WebElement orgPhone;

	@FindBy(id = "email1")
	private WebElement orgEmail;

	public WebElement getClickPlusImg() {
		return clickPlusImg;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getOrgPhone() {
		return orgPhone;
	}

	public WebElement getOrgEmail() {
		return orgEmail;
	}

	public void OrgData(String OrgName, String OrgPhone, String OrgEmail) {
		orgName.sendKeys(OrgName);
		orgPhone.sendKeys(OrgPhone);
		orgEmail.sendKeys(OrgEmail);

	}

}
