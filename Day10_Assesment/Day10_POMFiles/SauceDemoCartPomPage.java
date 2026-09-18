package Day10_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCartPomPage {
	WebDriver driver;
	public SauceDemoCartPomPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@id='item_4_title_link']/descendant::div[text()='Sauce Labs Backpack']")
	private WebElement ProductNameVerification;
	public void getProductNameVerification() {
		if(ProductNameVerification.isDisplayed()) {
			System.out.println("SauceLabs BackPack is Displayed");
		}else {
			System.out.println("SauceLabs BackPack is not Displayed");
		}
	}
	
	@FindBy(id="checkout")
	private WebElement CheckOutBtn;
	public void getCheckOutBtn() {
		CheckOutBtn.click();
	}
	
}
