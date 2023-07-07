package OrganizationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	public LoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

@FindBy(name="user_name")
private WebElement userNameTextField;

@FindBy(name="user_password")
private WebElement passWordTextField;

@FindBy(id="submitButton")
private WebElement loginButton;

public WebElement getUserNameTextField() {
	return userNameTextField;
}

public WebElement getPassWordTextField() {
	return passWordTextField;
}

public WebElement getLoginButton() {
	return loginButton;
}

public void loginToApp(String username,String password)
{
	userNameTextField.sendKeys("admin");
	passWordTextField.sendKeys("admin");
	loginButton.click();
	}
}

