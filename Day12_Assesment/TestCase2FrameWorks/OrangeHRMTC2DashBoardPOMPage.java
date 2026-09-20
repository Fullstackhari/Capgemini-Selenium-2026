package Day12_Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMTC2DashBoardPOMPage {
	WebDriver driver;
	public OrangeHRMTC2DashBoardPOMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/pim/viewMyDetails']")
	private WebElement Myinfobtn;
	public void getMyinfobtn() {
		Myinfobtn.click();
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
