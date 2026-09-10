package Day4_Assesment;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookTestCase1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		//fetching the tag name "input" for count of the text fields
		List<WebElement> text = driver.findElements(By.tagName("input"));
		//printing the size of the text fields
		System.out.println("No of Text Fields: "+text.size());
		//fetching the email id for the accessing the DOM Attribute
		WebElement email = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
		@Nullable
		String attr = email.getDomAttribute("name");
		//iterating through all the text fields to perform send Keys action in the email according to the DOM Attribute
		for(WebElement ele:text) {
			if(attr.contains("email")) {
				ele.sendKeys("hari@gmail.com");
				break;
			}
		}
	}

}
