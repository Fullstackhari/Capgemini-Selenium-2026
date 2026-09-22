package FinalAssesments_Utili;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmLogoutPOMPage {
	WebDriver driver;
	public OrangeHrmLogoutPOMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='oxd-topbar-header-userarea']/descendant::i")
	private WebElement Logoudropdowntbtn;
	public void getLogoudropdowntbtn() {
		Logoudropdowntbtn.click();
	}
	
	@FindBy(xpath="(//div[@class='oxd-topbar-header-userarea']/descendant::ul[@class='oxd-dropdown-menu']/descendant::a)[4]")
	private WebElement logoutChoice;
	public void getLogoutChoice() {
		logoutChoice.click();
	}
}
