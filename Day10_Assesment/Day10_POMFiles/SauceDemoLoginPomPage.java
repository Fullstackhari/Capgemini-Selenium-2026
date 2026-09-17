package Day10_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPomPage {
	WebDriver driver;
	public SauceDemoLoginPomPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login-button")
	private WebElement loginbtn;
	
	@FindBy(xpath="//div[text()='Swag Labs']")
	private WebElement productpage;
	
	public void getUsername(String value) {
		username.sendKeys(value);;
	}

	public void getPass(String value) {
		pass.sendKeys(value);;
	}

	public void getLoginbtn() {
		loginbtn.submit();
	}

	public void getProductpage() {
		if(productpage.isDisplayed()) {
			System.out.println("Product Page Displayed Successfully");
		}else {
			System.out.println("Product page is not diaplayed");
		}
	}
}
