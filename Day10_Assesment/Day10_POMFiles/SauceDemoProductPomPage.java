package Day10_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoProductPomPage {
	WebDriver driver;
	public SauceDemoProductPomPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement ProductAddtoCart;
	public void getProductAddtoCart() {
		ProductAddtoCart.click();
	}
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/descendant::span[text()='1']")
	private WebElement OneItemInProduct;
	public void getOneItemInProduct() {
		if(OneItemInProduct.getText().contains("1")) {
			System.out.println("Cart Conatins 1 Item");
		}else {
			System.out.println("Cart Doesn't Contains Items");
		}
	}
	
	
	@FindBy(id="shopping_cart_container")
	private WebElement AddTocartbtn;
	public void getAddTocartbtn() {
		AddTocartbtn.click();
	}
	
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private WebElement ThankyouMessage;
	public void getThankyouMessage() {
		if(ThankyouMessage.isDisplayed()) {
			System.out.println("Thank You Message is Displayed");
		}else {
			System.out.println("Thank You Message is not Displayed");
		}
	}

	
	
	
}
