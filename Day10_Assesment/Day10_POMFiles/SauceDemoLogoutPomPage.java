package Day10_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLogoutPomPage {
	
	WebDriver driver;
	public SauceDemoLogoutPomPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement Hamburgerbtn;
	public void getHamburgerbtn() {
		Hamburgerbtn.click();;
	}
	
	@FindBy(linkText = "Logout")
	private WebElement Logoutbtn;
	public void getLogoutbtn() {
		Logoutbtn.click();;
	}
	

}
