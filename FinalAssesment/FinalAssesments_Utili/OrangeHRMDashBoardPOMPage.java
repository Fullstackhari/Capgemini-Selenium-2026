package FinalAssesments_Utili;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMDashBoardPOMPage {
	WebDriver driver;
	public OrangeHRMDashBoardPOMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/buzz/viewBuzz']")
	private WebElement buzbtn;
	public void getBuzbtn() {
		buzbtn.click();
	}
	
}
