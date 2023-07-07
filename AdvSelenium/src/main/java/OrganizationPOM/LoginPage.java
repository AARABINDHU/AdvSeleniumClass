package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(name = "user_name")
	private WebElement userNameTextField;

	@FindBy(name = "user_password")
	private WebElement passWordTextFiled;

	 @FindBy(id="submitButton")
	 private WebElement loginButton;

//	@FindBys({ @FindBy(id="submitButton"),@FindBy(xpath = "(//input[@value='Login'])[2]")})
//	private WebElement loginBtn;
//	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "(//input[@value='Login'])[2]") })
//	private WebElement loginBtn1;

	// Getter methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPassWordTextFiled() {
		return passWordTextFiled;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	// Business Logics
	public void loginToApp(String UserName, String Password) {
		userNameTextField.sendKeys("UserName");
		passWordTextFiled.sendKeys("Password");
		loginButton.click();
	}

}
