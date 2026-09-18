package Day10_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckOutPompage {
	WebDriver driver;
	public SauceDemoCheckOutPompage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first-name")
	private WebElement checkoutFirstname;
	public void getCheckoutFirstname(String first) {
		checkoutFirstname.sendKeys(first);;
	}
	
	
	@FindBy(id="last-name")
	private WebElement checkoutLastname;
	public void getCheckoutLastname(String last) {
		checkoutLastname.sendKeys(last);
	}
	
	
	@FindBy(id="postal-code")
	private WebElement checkoutPostal;
	public void getCheckoutPostal(String zip) {
		checkoutPostal.sendKeys(zip);
	}
	
	
	@FindBy(id="continue")
	private WebElement Continue;
	public void getContinue() {
		Continue.submit();
	}
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	private WebElement Checkoutpagevalidation;
	public void getCheckoutpagevalidation() {
		if(Checkoutpagevalidation.isDisplayed()) {
			System.out.println("Checkout Overview Page Displayed Successfully");
		}else {
			System.out.println("CheckOut page is not Displayed");
		}
	}
	
	@FindBy(id="finish")
	private WebElement finishBtn;
	public void getFinishBtn() {
		finishBtn.click();
	}
	
	
}
