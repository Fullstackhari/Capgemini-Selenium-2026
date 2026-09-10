package Day4_Assesment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketTestCase3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		driver.get("https://www.bigbasket.com/pb/boss/");
		Thread.sleep(4000);
		//Searching for the item named Apple in the searchbar
		driver.findElement(By.xpath("(//input[@placeholder=\"Search for Products...\"])[2]")).sendKeys("Apple");
		Thread.sleep(2000);
		//selecting the specific item name "Apple Red Delicious" according to suggestion and performing click action
		List<WebElement> sugg = driver.findElements(By.xpath("//li[@class=\"sc-cXPBUD gVNfkF\"]/descendant::span[@class=\"Label-sc-15v1nk5-0 sc-iLLODe jnBJRV jHHKMq\"]"));
		for(WebElement apple:sugg) {
			if(apple.getText().contains("Red Delicious")) {
				apple.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//switching the child window to add the selected item in the basket
		String ss="";
		Set<String> s = driver.getWindowHandles();
		for(String ele :s) {
			if(driver.getWindowHandle()!=ele) {
				ss=ele;
			}
		}
		driver.switchTo().window(ss);
		Thread.sleep(3000);
		
		//performing click action on the Add to Basket Button
		driver.findElement(By.cssSelector("[class=\"Button-sc-1dr2sn8-0 sc-fBWQRz dEdziT eAwMMF\"]")).click();
		
		//validating whether the item is added to basket or no using popup message after that poppus after clicking on the add to basket
		WebElement added=driver.findElement(By.xpath("//p[normalize-space(text())='An item has been added to your basket successfully']"));
 		System.out.println(added.getText());
 		System.out.println("-----------------------------------------------");
		if(added.getText().contains("An item has been added")) {
			System.out.println("Item added to the Basket successfully");
		}else {
			System.out.println("Item is not added to the Basket");
		}

	}

}
