package Day12_Frameworks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMTC2PIMPomPAge {
	WebDriver driver;
	public OrangeHRMTC2PIMPomPAge(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstName' and @placeholder='First name']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName' and @placeholder='Last Name']")
	private WebElement lasttname;
	
	@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::div[@class='oxd-input-group__label-wrapper']/following-sibling::div/descendant::input)[4]")
	private WebElement empid;
	
	@FindBy(xpath="(//div[@class='oxd-form-actions']/descendant::button)[1]")
	private WebElement savebtn;
	public void getSavebtn() {
		savebtn.click();
	}

	public void getFirstname(String value) throws InterruptedException {
		firstname.click();
		firstname.sendKeys(Keys.CONTROL,"a");
		firstname.sendKeys(Keys.BACK_SPACE);
		firstname.sendKeys(value);
	}

	public void getLasttname(String value) throws InterruptedException {
		lasttname.click();
		lasttname.sendKeys(Keys.CONTROL,"a");
		lasttname.sendKeys(Keys.BACK_SPACE);
		lasttname.sendKeys(value);
	}

	public void getEmpid(String value) throws InterruptedException {
		empid.click();
		empid.sendKeys(Keys.CONTROL,"a");
		empid.sendKeys(Keys.BACK_SPACE);
		empid.sendKeys(value);
	}
	
	
}
