package Day2_Assesment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class FacebookTestCase1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[aria-label=\"Create new account\"]")).click();
		
		Point firstname = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_")).getLocation();
		Point surname = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_")).getLocation();
		System.out.println(firstname);
		System.out.println(surname);
		if(firstname.getY()==surname.getY()) {
			System.out.println("Text Fields are Aligned at the same line");
		}else {
			System.out.println("Text Fields are not aligned at the same line");
		}
		
	}
}
