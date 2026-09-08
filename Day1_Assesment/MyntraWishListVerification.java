package Day1_Assesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraWishListVerification {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("[class='wishlistLogin-button']")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("[class='form-control mobileNumberInput']")).sendKeys("8867554866");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[type='checkbox']")).click();
		driver.findElement(By.cssSelector("[class='submitBottomOption']")).click();
		Thread.sleep(50000);
		driver.findElement(By.cssSelector("[class='submitBottomOption']")).click();
		Thread.sleep(50000);
		driver.findElement(By.cssSelector("[class=\"wishlistEmpty-button\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Shirts");
		Thread.sleep(2000);
		List<WebElement> sugg1 = driver.findElements(By.cssSelector("[class='desktop-group']"));
		Thread.sleep(1000);
		for(WebElement ele:sugg1) {
			if(ele.getText().contains("Men Casual")) {
				ele.click();
			}
		}
		Thread.sleep(2000);
		WebElement products1 = driver.findElement(By.cssSelector("[class=\"results-base\"]"));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(products1,20,30).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='product-wishlistFlex product-actionsButton product-wishlist '])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		Thread.sleep(10000);
		List<WebElement> wishlistProducts =
		        driver.findElements(By.className("itemcard-removeIcon"));

		if (wishlistProducts.size() > 0) {
		    System.out.println("PASS: Product is added to Wishlist");
		} else {
		    System.out.println("FAIL: Product is NOT added to Wishlist");
		}

	}

}
