package Day12_Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrangeHRMLoginPOMpage {
	WebDriver driver;
	public OrangeHRMLoginPOMpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[name='username']")
	private WebElement username;
	
	@FindBy(css="[name='password']")
	private WebElement password;
	
	@FindBy(css="[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	private WebElement loginbtn;
	
	@FindBy(css="[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	private WebElement dashboardvalidation;

	public void getUsername(String value) {
		username.sendKeys(value);;
	}

	public void getPassword(String value) {
		password.sendKeys(value);;
	}

	public void getLoginbtn() {
		loginbtn.submit();
	}
}
