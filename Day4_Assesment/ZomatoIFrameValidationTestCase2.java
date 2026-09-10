package Day4_Assesment;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZomatoIFrameValidationTestCase2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.zomato.com/bangalore/delivery");
		Thread.sleep(2000);
		//performing click action on the login button
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(1000);
		
		//fetching the login frame page details to switch to the login frame
		WebElement loginframe = driver.findElement(By.id("auth-login-ui"));
		//switching to the login page
		driver.switchTo().frame(loginframe);
		
		//performing sendKeys action on the phoneNo after switching to the login frame
		driver.findElement(By.cssSelector("[placeholder=\"Phone\"]")).sendKeys("8867554866");
		
		//switching back to the default main page
		driver.switchTo().defaultContent();
		
		//fetching the DOM Attribute of the search ele to perform the validation process
		WebElement search = driver.findElement(By.cssSelector("[class=\"sc-kDgGX jHMrsw\"]"));
		@Nullable
		String attr = search.getDomAttribute("placeholder");
		System.out.println(attr);
		
		//validating according to the DOMAttribute that is present in the main page to check it switched to the main page 
		if(attr.contains("Search for")) {
			System.out.println("Switched to the main page");
		}else {
			System.out.println("Did not switched back to main page");
		}
		
	}

}
