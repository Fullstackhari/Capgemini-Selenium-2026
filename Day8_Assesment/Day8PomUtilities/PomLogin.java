package Day8PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLogin {
	WebDriver driver;
	public PomLogin(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//username
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement un;
	
	//password
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement pwd;
	
	//login button
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement lgbutton;
	
	

	public void getLgbutton() {
		lgbutton.click();
	}
	
	public void getUn(String value) {
		un.sendKeys(value);
	}
	
	public void getPwd(String value) {
		pwd.sendKeys(value);
	}
}
