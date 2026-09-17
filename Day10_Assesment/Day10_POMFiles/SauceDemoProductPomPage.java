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
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private WebElement ThankyouMessage;
	public void getThankyouMessage() {
		if(ThankyouMessage.isDisplayed()) {
			System.out.println("Thank You Message is Displayed");
		}else {
			System.out.println("Thank You Message is not Displayed");
		}
	}
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement Hamburgerbtn;
	public void getHamburgerbtn() {
		Hamburgerbtn.click();;
	}
	
	@FindBy(linkText = "Logout")
	private WebElement Logoutbtn;
	public void getLogoutbtn() {
		Logoutbtn.click();;
	}
	

	
	
	
}
