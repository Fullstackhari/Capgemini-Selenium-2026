package Day12_Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMRecruitmentPOMpage {
	WebDriver driver;
	
	public OrangeHRMRecruitmentPOMpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[class='oxd-topbar-body-nav-tab']")
	private WebElement vacanciebtn;
	public void getVacanciebtn() {
		vacanciebtn.click();
	}
	
	@FindBy(css="[class='oxd-icon bi-plus oxd-button-icon']")
	private WebElement addbtn;

	public void getAddbtn() {
		addbtn.click();
	}
	
}
