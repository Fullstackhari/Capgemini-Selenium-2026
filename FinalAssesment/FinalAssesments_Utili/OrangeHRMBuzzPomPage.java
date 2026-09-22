package FinalAssesments_Utili;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMBuzzPomPage {
	WebDriver driver;
	public OrangeHRMBuzzPomPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textarea[@placeholder=\"What's on your mind?\"]")
	private WebElement Buzztextfield;
	public void getBuzztextfield(String value) {
		Buzztextfield.sendKeys(value);
	}
	
	@FindBy(xpath="//div[@class='oxd-buzz-post-slot']/descendant::button[text()=' Post ']")
	private WebElement Postbtn;
	public void getPostbtn() {
		Postbtn.click();
	}
	
}
